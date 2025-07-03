package id.co.brainy.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import id.co.brainy.R
import id.co.brainy.ui.components.CardMyTask
import id.co.brainy.ui.components.CardTaskItem
import id.co.brainy.ui.components.FilterTask
import id.co.brainy.ui.theme.BrainyTheme


@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        floatingActionButton = {
            LargeFloatingActionButton(
                onClick = {
                    navController.navigate("task")
                },
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = Color.Black
            ) {
                Icon(Icons.Filled.Add, "Tambah Tugas Baru")
            }
        }
    ) { innerPading ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPading)
                .padding(horizontal = 16.dp),
        ) {
            HeaderHome("Hi Mondo", navController)
            Spacer(modifier = Modifier.height(20.dp))
            CardTaskItem(
                title = "Task",
                count = 10,
                modifier = Modifier
                    .clickable {
                        navController.navigate("MyTask")
                    }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CardTaskItem(
                    title = "Work",
                    count = 5,
                    modifier = Modifier
                        .weight(1f)
                        .clickable {

                        }
                )
                CardTaskItem(
                    title = "Academy",
                    count = 5,
                    modifier = Modifier
                        .weight(1f)
                        .clickable {

                        }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "On Going",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                )
//                Text(
//                    text = "See All",
//                    style = MaterialTheme.typography.bodyMedium.copy(
//                        fontSize = 14.sp,
//                    ),
//                    textDecoration = TextDecoration.Underline,
//                )
                FilterTask()
            }

            CardMyTask(
                title = "Tugas harian",
                category = "Academy",
                desc = "Menyala tugas",
                time = "10 hours",
                modifier = Modifier
                    .clickable {
                        navController.navigate("DetailTask")
                    }
            )


        }
    }
}

@Composable
fun HeaderHome(user: String, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = user,
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 36.sp,

                ),
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = painterResource(R.drawable.baseline_notifications_none_32),
            contentDescription = "Notifications Icon",
            modifier = Modifier
                .clickable {
                    navController.navigate("Notif")
                }
        )
        Spacer(modifier = Modifier.width(14.dp))
        Icon(
            imageVector = Icons.Default.ExitToApp,
            contentDescription = "Logout Icon",
            modifier = Modifier
                .size(32.dp)
                .clickable {

                }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    BrainyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            HomeScreen(
                navController = navController
            )
        }
    }
}