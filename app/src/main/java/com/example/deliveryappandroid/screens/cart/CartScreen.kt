package com.example.deliveryappandroid.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.deliveryappandroid.R
import com.example.deliveryappandroid.api.model.requests.LoginRequest
import com.example.deliveryappandroid.api.model.responses.DishResponse
import com.example.deliveryappandroid.api.retrofit.RetrofitClient
import com.example.deliveryappandroid.api.servieces.RetrofitService
import com.example.deliveryappandroid.screens.cart.cartList
import com.example.deliveryappandroid.screens.cart.getPrice
import com.example.deliveryappandroid.screens.tabs.Dish
import com.example.deliveryappandroid.signUp
import com.example.deliveryappandroid.ui.theme.BackgroundColor
import com.example.deliveryappandroid.ui.theme.SecondaryColor
import com.example.deliveryappandroid.ui.theme.TittleColor
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun CartScreen() {

    var address by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .background(BackgroundColor)
            .fillMaxSize()
    ) {
        TopAppBar(
            modifier = Modifier.height(60.dp),
            backgroundColor = BackgroundColor,
            contentColor = Color.White
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    "Корзина",
                    style = MaterialTheme.typography.body1
                )

                IconButton(
                    modifier = Modifier
                        .border(BorderStroke(1.dp, TittleColor)),
                    onClick = { cartList.removeAll(cartList) }) {
                    Icon(Icons.Filled.Refresh, contentDescription = "Refresh")
                }

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = SecondaryColor),
                    enabled = cartList.isNotEmpty(),
                ) {
                    Text(
                        text = "${getPrice(cartList)} ₽ Заказать",
                        style = MaterialTheme.typography.button
                    )
                }


            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxHeight()
        ) {
            itemsIndexed(
                cartList
            ) { _, item ->
                Dish(item = item)

            }

        }
    }
}


/*
fun signIn(email: String, password: String, context: Context, navController: NavController) {

    val retIn = RetrofitClient.getRetrofitInstance().create(RetrofitService::class.java)
    val loginInfo = LoginRequest(email, password)
    retIn.loginUser(loginInfo).enqueue(object : Callback<ResponseBody> {
        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            Toast.makeText(
                context,
                t.message,
                Toast.LENGTH_SHORT
            ).show()
        }

        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
            if (response.code() == 200) {
                Toast.makeText(context, "Успешный вход!", Toast.LENGTH_SHORT).show()
                navController.navigate("MainScreen")
            } else {
                Toast.makeText(context, "Неправильный пароль или email", Toast.LENGTH_SHORT).show()
            }
        }
    })

}

 */