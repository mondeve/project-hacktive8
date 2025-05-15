package id.co.brainy.ui.screen.notif

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import id.co.brainy.ui.components.CardTaskNotif
import id.co.brainy.ui.components.headerTask
import id.co.brainy.ui.theme.BrainyTheme


@Composable
fun NotifScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 16.dp),

        ) {
            headerTask(
                titleHeader = "Notification",
                navController = navController
            )
            Spacer(modifier = Modifier.height(31.dp))
            TitleText("Yesterday")
            CardTaskNotif(
                title = "Tugas RPLK",
                category = "Academy",
                navController = navController,
            )
            TimeText("21 Apr","13:00")
            Spacer(modifier = Modifier.height(16.dp))
        }
    }



@Composable
fun TitleText(title: String) {
    Text(
        text = title, style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.tertiary
        ), modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
    )
}
@Composable
fun TimeText(date: String, time: String) {
    Row(
        modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$date, ",
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.tertiary
            )
        )
        Text(
            text = time,
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.tertiary
            )
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