package com.example.mangahunt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mangahunt.navigation.SetupNavGraph
import com.example.mangahunt.ui.theme.MangaHuntTheme

class MainActivity : ComponentActivity() {

    // navigation controller
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MangaHuntTheme(darkTheme = false) {
                navController = rememberNavController()
                // Navigation Component containing routes
                SetupNavGraph(navController = navController)
            }
        }
    }
}