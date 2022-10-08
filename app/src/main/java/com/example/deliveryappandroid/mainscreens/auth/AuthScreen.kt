package com.example.deliveryappandroid

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.deliveryappandroid.ui.theme.BackgroundColor
import com.example.deliveryappandroid.ui.theme.SecondaryColor
import com.example.deliveryappandroid.ui.theme.TittleColor


@Composable
fun AuthScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "Logo"
            )

            Spacer(modifier = Modifier.height(70.dp))

            Button(
                onClick = { navController.navigate("SignInScreen") },
                modifier = Modifier
                    .width(250.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = SecondaryColor)
            ) {
                Text(text = "Login", style = MaterialTheme.typography.button)
            }

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = { navController.navigate("SignUpScreen") },
                modifier = Modifier
                    .width(250.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
            ) {
                Text(text = "Sign Up", style = MaterialTheme.typography.button, color = TittleColor)
            }

            Spacer(modifier = Modifier.height(25.dp))

            TextButton(onClick = { navController.navigate("MainScreen") }) {
                Text(
                    text = "Skip",
                    style = MaterialTheme.typography.h2,
                    color = SecondaryColor,
                    modifier = Modifier.padding(end = 15.dp)


                )
            }


        }
    }
}

