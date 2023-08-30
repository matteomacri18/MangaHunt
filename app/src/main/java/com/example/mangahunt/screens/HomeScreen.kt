package com.example.mangahunt.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mangahunt.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavController
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row {
            Text(
                text = "Home Screen",
                modifier = Modifier
                    .clickable {
                        navController.navigate(route = Screen.Login.route)
                    }
            )
        }
    }
}