package com.children.colet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.children.colet.ui.theme.ColetTheme
import com.children.colet.ui.theme.backgroundColor
import com.children.colet.ui.theme.primaryColor
import com.children.colet.viewModel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navHostController = rememberNavController()
            ColetTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    App(navHostController = navHostController)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun App(navHostController: NavHostController) {
    Scaffold(
        backgroundColor = backgroundColor,
        topBar = {
            TopBar(navHostController)
        }
    ) {
        val mainViewModel = viewModel<MainViewModel>()
        NavigationHost(navHostController = navHostController, mainViewModel = mainViewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColetTheme {
        val navHostController = rememberNavController()
        App(navHostController)
    }
}