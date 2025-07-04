package id.co.brainy.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.co.brainy.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
		private val authRepository: AuthRepository
): ViewModel() {

		private val _logoutState = MutableStateFlow(false)
		val logoutState: StateFlow<Boolean> = _logoutState


		fun logout() {
				viewModelScope.launch {
						try {
								authRepository.logout()
								_logoutState.value = true
						} catch (e: Exception) {
								_logoutState.value = false
						}
				}
		}



}