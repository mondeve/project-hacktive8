package id.co.brainy.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.co.brainy.data.utils.UserPreferences
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel@Inject constructor(
   private val pref: UserPreferences
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _startDestination = MutableStateFlow("login")
    val startDestination: StateFlow<String> = _startDestination

    init {
        viewModelScope.launch {
            delay(3000L)
            val token = pref.getToken.first() // mengambil token sekali
            _startDestination.value = if (token.isNullOrEmpty()) "login" else "home"
            _isLoading.value = false
        }
    }


}