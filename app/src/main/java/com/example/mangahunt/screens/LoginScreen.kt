package com.example.mangahunt.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mangahunt.navigation.Screen

@Composable
fun LoginScreen(
    navController: NavHostController
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
    ) {
        Column {
            // Logo Image

            Button(
                onClick = {
                    navController.navigate(route = Screen.Home.route)
                }
            ) {
                Text(
                    text = "Login"
                )
            }
        }
    }
}