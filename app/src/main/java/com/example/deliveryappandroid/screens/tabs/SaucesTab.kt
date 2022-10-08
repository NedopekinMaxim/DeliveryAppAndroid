package com.example.deliveryappandroid.screens.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.deliveryappandroid.api.model.responses.DishResponse
import com.example.deliveryappandroid.ui.theme.BackgroundColor
import com.example.deliveryappandroid.ui.theme.SecondaryColor
import com.example.deliveryappandroid.ui.theme.TittleColor
import com.example.deliveryappandroid.view.ViewModelDishes

@Composable
fun SaucesTab(dish: ViewModelDishes) {
    val item by dish.todoItems.observeAsState()
    LaunchedEffect(key1 = true) {
        dish.getList()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxHeight()
        ) {
            itemsIndexed(items = item!!)
            { _, item: DishResponse ->
                if (item.category == "Sauces") {
                    Dish(item = item)
                }
            }
        }
    }
}