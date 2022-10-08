package com.example.deliveryappandroid.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavItem(val route: String, val icon: ImageVector, val title: String) {
    object Main : NavItem("main", Icons.Default.Home, "Меню")
    object Cart : NavItem("cart", Icons.Default.ShoppingCart, "Корзина")
    object Profile : NavItem("profile", Icons.Default.Person, "Профиль")
    object History : NavItem("history", Icons.Default.History, "История")

}