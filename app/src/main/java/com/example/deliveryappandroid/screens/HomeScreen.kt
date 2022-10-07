package com.example.deliveryappandroid.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryappandroid.tabs.TabDish
import com.example.deliveryappandroid.tabs.Tabs
import com.example.deliveryappandroid.tabs.TabsContent
import com.example.deliveryappandroid.ui.theme.BackgroundColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen(){
    val tabs = listOf(
        TabDish.Dishes,
        TabDish.Sauces,
        TabDish.Snacks,
        TabDish.Drinks
    )
    val pagerState = rememberPagerState()
    Column {
        TopAppBar(
            modifier = Modifier.height(55.dp),
            backgroundColor = BackgroundColor,
            contentColor = Color.White
        ) {
            Text("Delivery House", fontSize = 16.sp)
        }
        Tabs(tabs = tabs, pagerState = pagerState)
        TabsContent(tabs = tabs, pagerState = pagerState)
    }
}
