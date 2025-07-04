package id.co.brainy

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.co.brainy.data.utils.UserPreferences
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

		@Provides
		@Singleton
		fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

		@Provides
		@Singleton
		fun provideUserPreference(
				@ApplicationContext context: Context
		): UserPreferences = UserPreferences(context)

}