package com.example.deliveryappandroid.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryappandroid.ui.theme.BackgroundColor

@Composable
fun HistoryScreen() {
    Column(modifier = Modifier
        .background(BackgroundColor)
        .fillMaxSize()) {
        TopAppBar(
            modifier = Modifier.height(55.dp),
            backgroundColor = BackgroundColor,
            contentColor = Color.White
        ) {
            Text("История заказов", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
        Text(text = "здесь сейчас будут заказы", fontSize = 15.sp)
    }
}