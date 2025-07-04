package id.co.brainy.ui.screen.auth

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import id.co.brainy.ui.common.UiState
import id.co.brainy.ui.components.CustomTextField
import id.co.brainy.ui.theme.BrainyTheme
import id.co.brainy.ui.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val loginState by viewModel.loginState.collectAsState()

    LaunchedEffect(loginState) {
        when (loginState){
            is UiState.Success -> {
                Log.d("LoginScreen", "Email: $email, Password: $password")
                navController.navigate("home")
            }
            is UiState.Error -> {

            }
            is UiState.Loading ->{

            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Sign In",
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 40.sp, fontWeight = FontWeight.ExtraBold
            ),
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = "enter your email and password",
            style = MaterialTheme.typography.titleSmall,
        )
        Spacer(modifier = Modifier.height(40.dp))
        CustomTextField(
            values = email,
            onValueChange = {
                email = it
            },
            placeholder = "email",
            icon = Icons.Default.Email,
            contentDescription = "Email Icon",
            keyboardType = KeyboardType.Email,
        )
        Spacer(modifier = Modifier.height(24.dp))
        CustomTextField(
            values = password,
            onValueChange = {
                password = it
            },
            placeholder = "password",
            icon = Icons.Default.Lock,
            contentDescription = "Password Icon",
            keyboardType = KeyboardType.Password,
            isPasswordField = true
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                if (email.isNotBlank() && password.isNotBlank()) {
                    viewModel.login(email, password)
                } else {
                    Log.d("LoginScreen", "Email atau password tidak boleh kosong")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = "Sign In",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = Color.White,
                modifier = Modifier.padding(6.dp),
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text(
                text = "No Account? Sign up ", style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                )
            )
            Text(text = "Here",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
                textDecoration = TextDecoration.Underline,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.clickable {
                    navController.navigate("register")
                })
        }
    }


}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    BrainyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            LoginScreen(navController = navController)
        }
    }
}