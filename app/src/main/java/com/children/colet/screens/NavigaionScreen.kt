package com.children.colet.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.children.colet.isTopBarShowing
import com.children.colet.ui.theme.darkerPrimaryColor
import com.children.colet.ui.theme.iranSansFont
import com.children.colet.ui.theme.primaryColor

@Composable
fun NavigationScreen(navController: NavController) {
    isTopBarShowing.value = false
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Box(Modifier.fillMaxSize()) {
            Icon(painter = painterResource(id = R.drawable.ic_close),
                contentDescription = null,
                tint = primaryColor,
                modifier = Modifier
                    .padding(30.dp)
                    .size(20.dp)
                    .align(Alignment.TopStart)
                    .clickable {
                        navController.popBackStack()
                    })
            Column(horizontalAlignment = Alignment.Start, modifier = Modifier
                .padding(start = 60.dp, top = 70.dp)
                .align(Alignment.TopStart)) {
                Text(text = "تنظیمات",
                    fontSize = 25.sp,
                    fontFamily = iranSansFont,
                    color = darkerPrimaryColor,
                    fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "خروج",
                    fontSize = 25.sp,
                    fontFamily = iranSansFont,
                    color = darkerPrimaryColor ,
                fontWeight = FontWeight.Bold)

            }

        }
    }
}

@Preview
@Composable
fun NavigationMenuPreview() {
    NavigationScreen(rememberNavController())
}