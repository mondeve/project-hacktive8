package id.co.brainy.data.utils

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore("user_prefs")

class UserPreferences @Inject constructor(
		@ApplicationContext private val context: Context
) {

		companion object {
				val TOKEN_KEY = stringPreferencesKey("auth_token")
		}

		suspend fun saveToken(token: String) {
				context.dataStore.edit { it[TOKEN_KEY] = token }
		}

		val getToken: Flow<String?> = context.dataStore.data.map { it[TOKEN_KEY] }

		suspend fun clearToken() {
				context.dataStore.edit { it.remove(TOKEN_KEY) }
		}
}