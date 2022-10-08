package com.example.deliveryappandroid.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryappandroid.screens.cart.cartList
import com.example.deliveryappandroid.screens.history.Order
import com.example.deliveryappandroid.screens.history.historyList
import com.example.deliveryappandroid.screens.tabs.Dish
import com.example.deliveryappandroid.ui.theme.BackgroundColor

@Composable
fun HistoryScreen() {
    Column(modifier = Modifier
        .background(BackgroundColor)
        .fillMaxSize()) {
        TopAppBar(
            modifier = Modifier.height(55.dp),
            backgroundColor = BackgroundColor,
            contentColor = Color.White
        ) {
            Text("История заказов", style = MaterialTheme.typography.body1)
        }

        LazyColumn(
            modifier = Modifier.fillMaxHeight()
        ) {
            itemsIndexed(
                historyList
            ) { _, item ->
                Order(item = item)

            }

        }

    }
}