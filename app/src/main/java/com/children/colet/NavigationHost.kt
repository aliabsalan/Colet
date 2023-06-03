package com.children.colet

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.children.colet.screens.greeting.GreetingScreen
import com.children.colet.screens.HomeScreen
import com.children.colet.screens.NavigationScreen
import com.children.colet.screens.Screen
import com.children.colet.screens.cartoon.CartoonScreen
import com.children.colet.screens.greeting.checkGreetingPassed
import com.children.colet.viewModel.MainViewModel

@Composable
fun NavigationHost(navHostController: NavHostController, mainViewModel: MainViewModel) {
    val context = LocalContext.current
    val startDestination = if (checkGreetingPassed(context)) Screen.Home.rout else Screen.Greeting.rout
NavHost(navController = navHostController, startDestination = startDestination){
    composable(Screen.Greeting.rout){
        GreetingScreen(navHostController)
    }
    composable(Screen.Home.rout){
        HomeScreen(navHostController)
    }
    composable(Screen.NavigationScreen.rout){
        NavigationScreen(navHostController)
    }
    composable(Screen.Cartoons.rout){
        CartoonScreen(navHostController , mainViewModel)
    }

}
}


