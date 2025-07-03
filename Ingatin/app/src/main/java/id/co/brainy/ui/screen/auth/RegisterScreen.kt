package id.co.brainy.ui.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
fun RegisterScreen(
		navController: NavController,
		viewModel: AuthViewModel = hiltViewModel()
) {

		var email by remember { mutableStateOf("") }
		var password by remember { mutableStateOf("") }
		var username by remember { mutableStateOf("") }

		val registerState by viewModel.registerState.collectAsState()

		LaunchedEffect(registerState) {
				when (registerState) {
						is UiState.Success -> {
								navController.navigate("login")

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
								.padding(horizontal = 24.dp, vertical = 16.dp),
						horizontalAlignment = Alignment.CenterHorizontally
				) {
						IconButton(
								onClick = {
										navController.popBackStack()
								},
								modifier = Modifier
										.clip(RoundedCornerShape(18.dp))
										.background(color = Color.LightGray)
										.align(Alignment.Start)
						) {
								Icon(
										imageVector = Icons.Default.ArrowBack,
										contentDescription = "Back"
								)
						}
						Spacer(modifier = Modifier.height(24.dp))
						Text(
								text = "Create an account",
								style = MaterialTheme.typography.titleLarge.copy(
										fontWeight = FontWeight.ExtraBold
								),
								modifier = Modifier.align(Alignment.CenterHorizontally)
						)
						Text(
								text = "Complete this a field to create a new account",
								textAlign = TextAlign.Center,
								style = MaterialTheme.typography.bodySmall.copy(
										fontSize = 14.sp
								)
						)
						Spacer(modifier = Modifier.height(45.dp))
						CustomTextField(
								values = username,
								onValueChange = {
										username = it
								},
								placeholder = "username",
								icon = Icons.Default.AccountCircle,
								contentDescription = "username Icon",
								keyboardType = KeyboardType.Text,
						)
						Spacer(modifier = Modifier.height(24.dp))
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
										viewModel.register(email, password, username)
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
										text = "Sign Up",
										style = MaterialTheme.typography.titleSmall.copy(
												fontWeight = FontWeight.SemiBold
										),
										color = Color.White,
										modifier = Modifier.padding(6.dp),
								)
						}
				}


		}

		@Preview(showBackground = true)
		@Composable
		fun RegisterScreenPreview() {
				BrainyTheme {
						Surface(
								modifier = Modifier.fillMaxSize(),
								color = MaterialTheme.colorScheme.background
						) {
								val navController = rememberNavController()
								RegisterScreen(navController = navController)
						}
				}
		}
