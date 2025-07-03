package id.co.brainy.data.network

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.userProfileChangeRequest
import id.co.brainy.data.model.UserProfile
import javax.inject.Inject

class FirebaseService @Inject constructor(
		private val firebaseAuth: FirebaseAuth
) {

		fun createAccount(
				email: String,
				password: String,
				name: String,
				onResult: (Result<UserProfile>) -> Unit
		) {
				firebaseAuth.createUserWithEmailAndPassword(email, password)
						.addOnCompleteListener { task ->
								if (task.isSuccessful) {
										val user = task.result.user

										val profileUpdates = userProfileChangeRequest {
												displayName = name
										}
										user?.let {
												it.updateProfile(profileUpdates)
														.addOnCompleteListener { task ->
																if (task.isSuccessful) {
																		val profile = UserProfile(
																				name = name,
																				email = email,
																				uId = it.uid
																		)
																		onResult(Result.success(profile))
																		Log.d(TAG, "User profile berhasil diperbarui\n$profile.")
																} else {
																}
														}
										}
								} else {
										val exception = task.exception ?: Exception("Registrasi gagal")
										onResult(Result.failure(exception))
								}
						}
		}

		fun login(
				email: String,
				password: String,
				onResult: (Result<UserProfile>) -> Unit
		) {
				firebaseAuth.signInWithEmailAndPassword(email, password)
						.addOnCompleteListener { task ->
								if (task.isSuccessful) {
										val user = task.result.user
										if (user != null) {
												val profile = UserProfile(
														name = user.displayName ?: "",
														email = user.email ?: "",
														uId = user.uid
												)
												onResult(Result.success(profile))
										} else {
												val exception = task.exception ?: Exception("Login gagal")
												onResult(Result.failure(exception))
										}
								}
						}
		}

		companion object {
				private const val TAG = "EmailPassword"
		}


}