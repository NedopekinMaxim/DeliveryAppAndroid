package com.example.deliveryappandroid.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryappandroid.screens.tabs.TabDish
import com.example.deliveryappandroid.screens.tabs.Tabs
import com.example.deliveryappandroid.screens.tabs.TabsContent
import com.example.deliveryappandroid.ui.theme.BackgroundColor
import com.example.deliveryappandroid.ui.theme.MinorGrayColor
import com.example.deliveryappandroid.ui.theme.TittleColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlin.text.Typography

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen(){

    val tabs = listOf(
        TabDish.Dishes,
        TabDish.Sauces,
        TabDish.Snacks,
        TabDish.Drinks
    )

    val pagerState = rememberPagerState()

    var address by remember {
        mutableStateOf("")
    }


    Column {
        TopAppBar(
            modifier = Modifier.height(60.dp),
            backgroundColor = BackgroundColor,
            contentColor = TittleColor
        ) {

            Row(modifier = Modifier.fillMaxWidth()){
                TextField(
                    value = address,
                    onValueChange = {address = it},
                    placeholder = { Text(text = "Ваш адрес доставки")},
                    leadingIcon = { Icons.Default.Navigation },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                    )
                )

                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxSize()
                ){
                    Icons.Default.Search
                }


            }
        }
        Tabs(tabs = tabs, pagerState = pagerState)
        TabsContent(tabs = tabs, pagerState = pagerState)
    }
}


