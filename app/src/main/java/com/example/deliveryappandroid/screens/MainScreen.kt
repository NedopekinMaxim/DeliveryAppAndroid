package com.example.deliveryappandroid.mainscreens

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.deliveryappandroid.screens.NavItem
import com.example.deliveryappandroid.screens.NavigationScreens
import com.example.deliveryappandroid.ui.theme.SecondaryColor
import com.example.deliveryappandroid.ui.theme.TittleColor
import com.google.accompanist.pager.ExperimentalPagerApi

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun MainScreen() {
    var navController = rememberNavController()
    val items = listOf(
        NavItem.Main,
        NavItem.Cart,
        NavItem.Profile,
        NavItem.History
    )
    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = SecondaryColor, contentColor = TittleColor) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach() { items ->
                    BottomNavigationItem(
                        alwaysShowLabel = true,
                        selected = currentRoute == items.route,
                        selectedContentColor = Color.White,
                        unselectedContentColor = TittleColor,
                        onClick = {
                            navController.navigate(items.route) {
                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = { Text(text = items.title, fontWeight = FontWeight.Bold) },
                        icon = { Icon(imageVector = items.icon, contentDescription = items.route) }
                    )
                }
            }


        }
    ) {
        NavigationScreens(navController = navController)
    }
}