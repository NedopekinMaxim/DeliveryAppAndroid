package com.example.deliveryappandroid.mainscreens

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.deliveryappandroid.screens.NavItem
import com.example.deliveryappandroid.screens.NavigationScreens
import com.example.deliveryappandroid.ui.theme.BackgroundColor
import com.example.deliveryappandroid.ui.theme.MinorGrayColor
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
        NavItem.Main, NavItem.Cart, NavItem.Profile, NavItem.History
    )


    Scaffold(bottomBar = {
        BottomNavigation(backgroundColor = BackgroundColor, contentColor = TittleColor) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach() { items ->
                BottomNavigationItem(
                    modifier = Modifier.clip(
                            RoundedCornerShape(
                                topStart = 20.dp,
                                topEnd = 20.dp
                            )
                        ),
                    alwaysShowLabel = true,
                    selected = currentRoute == items.route,
                    selectedContentColor = SecondaryColor,
                    unselectedContentColor = MinorGrayColor,
                    label = { Text(text = items.title, fontWeight = FontWeight.Bold) },
                    icon = { Icon(imageVector = items.icon, contentDescription = items.route) },
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
                )
            }
        }


    }) {
        NavigationScreens(navController = navController)
    }
}