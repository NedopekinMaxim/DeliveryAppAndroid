package com.example.deliveryappandroid

import android.content.Context
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.deliveryappandroid.mainscreens.MainScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalPagerApi
@Composable
fun Navigation(context: Context) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SplashScreen") {
        composable("SplashScreen") {
            SplashScreen(navController = navController)
        }
        composable("OnBoardingScreen") {
            OnBoardingScreen(navController = navController)
        }

        composable("AuthScreen") {
            AuthScreen(navController = navController)
        }
        composable("SignInScreen") {
            SignInScreen(navController = navController, context)
        }
        composable("SignUpScreen") {
            SignUpScreen(navController = navController, context)
        }
        composable("MainScreen") {
            MainScreen()
        }
    }
}
