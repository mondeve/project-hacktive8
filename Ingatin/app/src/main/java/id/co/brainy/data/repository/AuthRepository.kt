package id.co.brainy.data.repository

import id.co.brainy.data.model.UserProfile
import id.co.brainy.data.network.FirebaseService
import id.co.brainy.data.utils.UserPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthRepository @Inject constructor(
		private val firebaseService: FirebaseService,
		private val pref: UserPreferences
){

		fun createAccount(
				email: String,
				password: String,
				name: String,
				onResult: (Result<UserProfile>) -> Unit
		) {
				firebaseService.createAccount(email, password, name, onResult)
		}

		fun login(
				email: String,
				password: String,
				onResult: (Result<UserProfile>) -> Unit
		) {
				firebaseService.login(email, password){ result ->
						result
								.onSuccess { (user, token) ->
										CoroutineScope(Dispatchers.IO).launch {
												pref.saveToken(token)
										}
										onResult(Result.success(user))
								}
								.onFailure {
										onResult(Result.failure(it))
								}
				}
		}

		suspend fun logout() {
				pref.clearToken()
		}

		fun getToken() = pref.getToken
}