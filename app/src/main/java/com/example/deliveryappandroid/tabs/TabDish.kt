package com.example.deliveryappandroid.tabs

import androidx.compose.runtime.Composable
import com.example.deliveryappandroid.view.ViewModelDishes

typealias ComposableFun = @Composable () -> Unit

sealed class TabDish(var title: String, var screen: ComposableFun) {
    object Dishes : TabDish("Блюда", { DishTab(dish = ViewModelDishes()) })
    object Sauces : TabDish("Соусы", { SaucesTab(dish = ViewModelDishes()) })
    object Snacks : TabDish("Закуски", { SnacksTab(dish = ViewModelDishes()) })
    object Drinks : TabDish("Напитки", { DrinksTab(dish = ViewModelDishes()) })
}