package id.co.brainy.ui.screen.notif

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import id.co.brainy.ui.components.CardMyTask
import id.co.brainy.ui.components.CardTaskItem
import id.co.brainy.ui.theme.BrainyTheme


@Composable
fun NotifScreen(navController: NavController) {

    Scaffold(

    ) { innerPading ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPading)
                .padding(horizontal = 16.dp),
        ) {

            HeaderNotif("Notification")
            Spacer(modifier = Modifier.height(0.dp))
            CardMyTask(
                title = "Tugas harian",
                category = "Academy",
                desc = "Menyala tugas",
                time = "10 hours"
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
//        Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 16.dp),
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
                Text(
                    text = "See All",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                    ),
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}

@Composable
fun HeaderNotif(user: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                //navController.popBackStack()
            },
            modifier = Modifier
                .clip(RoundedCornerShape(18.dp))
                .background(color = Color.LightGray)
                .align(Alignment.CenterVertically)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }
        Text(
            text = user,
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 36.sp,
                ),
            modifier = Modifier
                .weight(1f)
                .align(alignment = Alignment.CenterVertically)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun NotifScreenPreview() {
    BrainyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            NotifScreen(navController = navController)
        }
    }
}