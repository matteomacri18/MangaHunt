package com.example.mangahunt.navigation

sealed class Screen(
    val route: String
){
    object Login: Screen(route = "login_screen")
    object Home: Screen(route = "home_screen")
}
