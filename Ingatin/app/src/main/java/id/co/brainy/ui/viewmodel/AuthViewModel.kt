package id.co.brainy.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.co.brainy.data.model.UserProfile
import id.co.brainy.data.repository.AuthRepository
import id.co.brainy.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
		private val authRepository: AuthRepository
): ViewModel() {

		private val _registerState = MutableStateFlow<UiState<UserProfile>>(UiState.Loading)
		val registerState: StateFlow<UiState<UserProfile>> = _registerState

		private val _loginState = MutableStateFlow<UiState<UserProfile>>(UiState.Loading)
		val loginState: StateFlow<UiState<UserProfile>> = _loginState

		fun login(email: String, password: String) {
				_loginState.value = UiState.Loading
				authRepository.login(email, password) { result ->
						result
								.onSuccess { user ->
										_loginState.value = UiState.Success(user)
								}
								.onFailure { e ->
										_loginState.value = UiState.Error(e.message ?: "Terjadi kesalahan")
								}
				}
		}

		fun register(email: String, password: String, name: String) {
				_registerState.value = UiState.Loading
				authRepository.createAccount(email, password, name) { result ->
						result
								.onSuccess { user ->
										_registerState.value = UiState.Success(user)
								}
								.onFailure { e ->
										_registerState.value = UiState.Error(e.message ?: "Terjadi kesalahan")
								}
				}
		}


}