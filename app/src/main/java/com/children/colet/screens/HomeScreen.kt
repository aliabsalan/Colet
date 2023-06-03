package com.children.colet.screens


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.children.colet.isTopBarShowing
import com.children.colet.ui.theme.iranSansFont
import com.children.colet.R
import com.children.colet.topBarTitle

@Composable
fun HomeScreen(navController: NavController) {
    isTopBarShowing.value = true
    topBarTitle.value = "خوش آمدید"

    Column(Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {


        //categories
        Spacer(modifier = Modifier.height(30.dp))
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            val verticalSpace = 20.dp
            val horizontalSpace = 30.dp
            Row(Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.Center) {
                CategoryItem(icon =R.drawable.ic_english , label = "انگلیسی") {

                }
                Spacer(modifier = Modifier.width(horizontalSpace))
                CategoryItem(icon = R.drawable.ic_paint, label = "نقاشی") {

                }
            }
            Spacer(modifier = Modifier.height(verticalSpace))
            Row(Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.Center) {
                CategoryItem(icon =R.drawable.ic_animal , label = "حیوانات") {

                }
                Spacer(modifier = Modifier.width(horizontalSpace))
                CategoryItem(icon = R.drawable.ic_wallpaper, label = "تصویر زمینه") {

                }
            }
            Spacer(modifier = Modifier.height(verticalSpace))
            Row(Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.Center) {
                CategoryItem(icon =R.drawable.ic_ringtone , label = "صدای تماس") {

                }
                Spacer(modifier = Modifier.width(horizontalSpace))
                CategoryItem(icon = R.drawable.ic_cartoon, label = "کارتون") {
                    navController.navigate(Screen.Cartoons.rout)
                }
            }
            Spacer(modifier = Modifier.height(verticalSpace))
            Row(Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.Center) {
                CategoryItem(icon =R.drawable.ic_number , label = "آموزش اعداد") {

                }
                Spacer(modifier = Modifier.width(horizontalSpace))
                CategoryItem(icon = R.drawable.ic_children_s_song, label = "آهنگ کودکانه") {

                }
            }
            Spacer(modifier = Modifier.height(verticalSpace))
            Row(Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.Center) {
                CategoryItem(icon =R.drawable.ic_lullaby , label = "لالایی") {

                }
                Spacer(modifier = Modifier.width(horizontalSpace))
                CategoryItem(icon = R.drawable.ic_story, label = "داستان") {

                }
            }
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryItem(@DrawableRes icon: Int, label: String, onClick: () -> Unit) {
    val sizeWidth = 140.dp
    val sizeHeight = 55.dp
    val iconSize = 35.dp
    val fontSize = 11.sp
    Card(modifier = Modifier.size(sizeWidth, sizeHeight),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick ,
    elevation = 0.dp) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(10.dp))
                Image(painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.size(iconSize))
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = label, fontSize = fontSize, fontFamily = iranSansFont, color = Color.Black)

            }
        }
    }


}

@Preview
@Composable
fun CategoryPreview() {
    CategoryItem(icon = R.drawable.ic_colet_logo, label = "کولت") {}
}

@Preview(backgroundColor = 0xFFFFFDE7 , showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen(navController = rememberNavController())
}