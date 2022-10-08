package com.example.deliveryappandroid.screens.tabs

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.deliveryappandroid.api.model.responses.DishResponse
import com.example.deliveryappandroid.screens.cart.cartList
import com.example.deliveryappandroid.ui.theme.SecondaryColor


@Composable
fun Dish(item: DishResponse) {

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data("http://food.madskill.ru/up/images/${item.icon}").build()
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp)
            .clip(RoundedCornerShape(19.dp))
            .background(Color())
            .height(100.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painter,
                contentDescription = "${item.icon}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(3.dp)
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Column() {
                Text(text = item.nameDish, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = "${item.price} рублей", fontWeight = FontWeight.Light, fontSize = 10.sp)
            }
        }
        IconButton(modifier = Modifier.padding(3.dp), onClick = { cartList.add(item)}) {
            Icon(Icons.Filled.Add, contentDescription = "add to cart")

        }
    }
}



