package com.children.colet.screens.cartoon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.children.colet.R
import com.children.colet.data.Cartoon
import com.children.colet.topBarTitle
import com.children.colet.ui.theme.iranSansFont
import com.children.colet.viewModel.MainViewModel

@Composable
fun CartoonScreen(navController: NavController, mainViewModel: MainViewModel) {
    topBarTitle.value = "کارتونها"

    val context = LocalContext.current
    val cartoons by mainViewModel.cartoons.collectAsState()

    LaunchedEffect(key1 = Unit) {
        mainViewModel.onShowCartoons(context)
    }

    Column {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Row(Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Icon(painter = painterResource(id = R.drawable.ic_no_internet),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color.Gray)
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "برای اینکه بتونی عکس هارو ببینی به اینترنت وصل شو",
                    fontFamily = iranSansFont,
                    fontSize = 12.sp,
                    color = Color.Gray)
            }
            Spacer(modifier = Modifier.height(10.dp))
            LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                items(items = cartoons) { cartoon ->
                    CartoonItem(cartoon, onClick = {

                    })
                }
            }
        }
    }
}

@Composable
fun CartoonItem(cartoon: Cartoon, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = rememberAsyncImagePainter(model = cartoon.imageUrl),
            contentDescription = null,
            modifier = Modifier.size(120.dp, 180.dp))
//    Spacer(modifier = Modifier.height(5.dp))
//    Text(text = cartoon.name.toString() , fontFamily = iranSansFont, fontSize = 12.sp , color = Color.Black)
    }
}