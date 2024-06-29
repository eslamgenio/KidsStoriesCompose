package com.example.kidsstoriscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kidsstoriscompose.ui.theme.KidsStorisComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KidsStorisComposeTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainContent(navController) }
        composable("story/{storyId}") { backStackEntry ->
            val storyId = backStackEntry.arguments?.getString("storyId")?.toIntOrNull() ?: 0
            StoryScreen(storyId = storyId, navController = navController)
        }
    }
}

@Composable
fun MainContent(navController: NavController) {
    Column {
        Button(onClick = { navController.navigate("story/1") }) {
            Text(text = "Story 1")
        }
        Button(onClick = { navController.navigate("story/2") }) {
            Text(text = "Story 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KidsStorisComposeTheme {
        MainScreen()
    }
}
