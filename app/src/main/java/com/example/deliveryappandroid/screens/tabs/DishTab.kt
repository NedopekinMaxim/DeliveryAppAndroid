package com.example.deliveryappandroid.screens.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.deliveryappandroid.R
import com.example.deliveryappandroid.api.model.responses.DishResponse
import com.example.deliveryappandroid.ui.theme.BackgroundColor
import com.example.deliveryappandroid.view.ViewModelDishes

@Composable
fun DishTab(dish: ViewModelDishes) {
    val item by dish.todoItems.observeAsState()
    LaunchedEffect(key1 = true) {
        dish.getList()
    }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(BackgroundColor)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxHeight()
        ) {
            /*itemsIndexed(listOf(
                DishResponse(R.drawable.pizza, "Foods", "Пицца", "200."),
                DishResponse(R.drawable.pizza, "Foods", "Пицца", "200"),
                DishResponse(R.drawable.pizza, "Foods", "Пицца", "200")
            )) { _, item ->
                Dish(item = item)

            }*/
             itemsIndexed(items = item!!)
            { _, item: DishResponse ->
                if (item.category == "Dishes") {
                    Dish(item = item)
                }
            }
        }
    }
}

