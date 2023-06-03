package com.children.colet.screens.greeting

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.children.colet.R
import com.children.colet.screens.Screen
import com.children.colet.ui.theme.darkerPrimaryColor
import com.children.colet.ui.theme.iranSansFont
import com.children.colet.ui.theme.primaryColor
import com.children.colet.ui.theme.secondColor
import kotlinx.coroutines.delay

@Composable
fun GreetingScreen(navController: NavController) {
    val context = LocalContext.current
    Box(Modifier
        .fillMaxSize()
        .background(secondColor)) {
        val localConfig = LocalConfiguration.current

        var isGettingInputStarted by remember { mutableStateOf(false) }
        var isLogoOutStarted by remember { mutableStateOf(false) }

        val logoAnimDuration = 1500
        val logoSize by animateDpAsState(targetValue = if (isLogoOutStarted) 90.dp else 160.dp,
            animationSpec = tween(logoAnimDuration))
        val logoOffsetX by animateDpAsState(targetValue = if (isLogoOutStarted) 30.dp else (localConfig.screenWidthDp / 2).dp - (logoSize / 2),
            animationSpec = tween(logoAnimDuration))
        val logoOffsetY by animateDpAsState(targetValue = if (isLogoOutStarted) 30.dp else (localConfig.screenHeightDp / 2).dp - (logoSize / 2),
            animationSpec = tween(logoAnimDuration))
        LaunchedEffect(key1 = Unit) {
            delay(1000)
            isLogoOutStarted = true
            delay(500)
            isGettingInputStarted = true
        }
        //1 - logo
        Image(
            painter = painterResource(id = R.drawable.ic_colet_logo),
            contentDescription = null,
            modifier = Modifier
                .size(logoSize)
                .offset(logoOffsetX, logoOffsetY)
        )


        //2 - input
        AnimatedVisibility(visible = isGettingInputStarted,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()) {
            var name by remember { mutableStateOf("") }
            Box(modifier = Modifier.fillMaxSize()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.Center)) {
                    Text(text = "اسمت چیه؟",
                        fontSize = 25.sp,
                        color = darkerPrimaryColor,
                        fontFamily = iranSansFont,
                        fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(15.dp))
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                        TextField(value = name,
                            onValueChange = { name = it },
                            placeholder = { Text(text = "مثلا علی", fontFamily = iranSansFont) },
                            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent),
                            shape = RoundedCornerShape(15.dp))

                    }
                }
                Button(onClick = {
                    //save in SharedPreferences
                    setGreetingPassed(context, name)

                    //navigate to home screen
                    navController.navigate(Screen.Home.rout)
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = primaryColor),
                    modifier = Modifier
                        .padding(20.dp)
                        .align(Alignment.BottomEnd)) {
                    Text(text = "ادامه دادن", color = Color.White, fontFamily = iranSansFont)
                }

            }


        }

    }
}

@Preview
@Composable
fun GreetingPreview() {
    GreetingScreen(rememberNavController())
}