package com.example.foodai


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodai.screen.GetStarted
import com.example.foodai.screen.ProfileScreen
import com.example.foodai.screen.auth.SignupScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Replace with your actual theme name
            MaterialTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "get_started") {
        // 1. Get Started Screen
        composable("get_started") {
            // Pass the navigation action to your screen
            GetStarted()
        }

        // 2. Signup Screen
        composable("signup") {
            SignupScreen(navController)
        }

        // 3. Main Screen (Contains Bottom Bar)
        composable("main_home") {
            MainContainer()
        }
    }
}

@Composable
fun MainContainer() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Home", "Search", "Profile")
    val icons = listOf(Icons.Default.Home, Icons.Default.Search, Icons.Default.Person)

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(icons[index], contentDescription = item) },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            // Logic to switch between screens based on bottom nav
            when (selectedItem) {
                0 -> Text("Home News Feed", modifier = Modifier.padding(16.dp))
                1 -> Text("Search News", modifier = Modifier.padding(16.dp))
                2 -> ProfileScreen() // Your previously created Profile Screen
            }
        }
    }
}