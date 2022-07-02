package com.example.deliveryappandroid

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun Navigation() {
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
            SignInScreen()
        }
        composable("SignUpScreen") {
            SignUpScreen()
        }
    }
}
