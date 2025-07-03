package id.co.brainy.data.repository

import id.co.brainy.data.model.UserProfile
import id.co.brainy.data.network.FirebaseService
import javax.inject.Inject

class AuthRepository @Inject constructor(
		private val firebaseService: FirebaseService
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
				firebaseService.login(email, password, onResult)
		}

}