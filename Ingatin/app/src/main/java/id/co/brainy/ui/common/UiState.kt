package id.co.brainy.ui.common

import id.co.brainy.data.model.UserProfile

sealed class UiState<out T: Any?> {

    object Loading: UiState<Nothing>()

    data class Success<out T: Any>(val data: UserProfile?) : UiState<T>()

    data class Error(val errorMessage: String): UiState<Nothing>()
}