package com.example.deliveryappandroid.screens.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.deliveryappandroid.api.model.responses.DishResponse
import com.example.deliveryappandroid.screens.cart.cartList
import com.example.deliveryappandroid.ui.theme.ItemColor
import com.example.deliveryappandroid.ui.theme.orderColor

@Composable
fun Order(item: orderItem) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp)
            .clip(RoundedCornerShape(19.dp))
            .background(orderColor)
            .height(100.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(20.dp))
            Column() {
                Text(text = item.data, fontWeight = FontWeight.Normal, fontSize = 15.sp)
                Text(text = item.address, fontWeight = FontWeight.Normal, fontSize = 15.sp)
                Text(text = "${item.count} блюд в заказе", fontWeight = FontWeight.Normal, fontSize = 15.sp)
                Text(text = "${item.price} ₽", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }
        }
    }
}