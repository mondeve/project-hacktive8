package id.co.brainy

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.HiltAndroidApp
import id.co.brainy.ui.screen.auth.LoginScreen
import id.co.brainy.ui.screen.auth.RegisterScreen
import id.co.brainy.ui.screen.home.HomeScreen
import id.co.brainy.ui.screen.notif.NotifScreen
import id.co.brainy.ui.screen.task.DetailTaskScreen
import id.co.brainy.ui.screen.task.MyTaskScreen
import id.co.brainy.ui.screen.task.TaskScreen

@Composable
fun BrainyNav(){

    val navController = rememberNavController()

    NavHost(navController, startDestination = "login"){
        composable("login"){
            LoginScreen(navController)
        }
        composable("register"){
            RegisterScreen(navController)
        }
        composable("home"){
            HomeScreen(navController)
        }
        composable("task"){
            TaskScreen(navController)
        }
        composable("DetailTask") {
            DetailTaskScreen(navController)
        }
        composable("Notif") {
            NotifScreen(navController)
        }
        composable("MyTask") {
            MyTaskScreen(navController)
        }

    }

}


@HiltAndroidApp
class BrainyApp : Application()