package com.children.colet.screens

sealed class Screen(val rout: String) {
    object Greeting : Screen("Greeting")
    object Home : Screen("Home")
    object NavigationScreen : Screen("NavigationScreen")
    object Settings : Screen("Settings")

    object Cartoons : Screen("Cartoons")
    object Paint : Screen("Paint")
    object English : Screen("English")
    object ChildrenMusic : Screen("ChildrenMusic")
    object Lullaby : Screen("Lullaby")
    object Animals : Screen("Animals")
    object Ringtone : Screen("Ringtone")
    object LearnNumber : Screen("LearnNumber")
    object Story : Screen("Story")

}
