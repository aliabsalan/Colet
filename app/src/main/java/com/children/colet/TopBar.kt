package com.children.colet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.children.colet.screens.Screen
import com.children.colet.screens.greeting.checkGreetingPassed
import com.children.colet.ui.theme.backgroundColor
import com.children.colet.ui.theme.iranSansFont
import com.children.colet.ui.theme.primaryColor


val topBarTitle  =  mutableStateOf("خوش آمدید")
val isTopBarShowing = mutableStateOf(false)

@Composable
fun TopBar(navController: NavController) {

    val context = LocalContext.current
    isTopBarShowing.value = checkGreetingPassed(context)

    val title by remember {
        topBarTitle
    }
    val isShowing by remember {
        isTopBarShowing
    }
    if (isShowing){
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            TopAppBar(modifier = Modifier.padding(start = 15.dp, top = 15.dp),
                backgroundColor = backgroundColor,
                elevation = 0.dp,
                contentColor = primaryColor,
                navigationIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_navigation),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                            .clickable(
                                onClick = {
                                navController.navigate(Screen.NavigationScreen.rout)
                                },
                                interactionSource = MutableInteractionSource(),
                                indication = rememberRipple(bounded = false, radius = 35.dp, color = primaryColor)
                            )
                    )
                },
                title = {
                    Text(text = title , fontFamily = iranSansFont)
                })
        }
    }
}