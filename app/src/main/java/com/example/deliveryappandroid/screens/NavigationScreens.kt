package com.example.deliveryappandroid.screens

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun NavigationScreens(navController: NavHostController) {
    NavHost(navController, startDestination = NavItem.Main.route) {
        composable(NavItem.Main.route) {
            HomeScreen()
        }
        composable(NavItem.Cart.route) {
            CartScreen()
        }
        composable(NavItem.Profile.route) {
            ProfileScreen()
        }
        composable(NavItem.History.route) {
            HistoryScreen()
        }
    }
}