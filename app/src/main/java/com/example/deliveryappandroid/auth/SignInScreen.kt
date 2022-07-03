package com.example.deliveryappandroid

import android.graphics.Paint
import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.deliveryappandroid.ui.theme.MinorGrayColor
import com.example.deliveryappandroid.ui.theme.SecondaryColor



@Composable
fun SignInScreen(navController: NavController) {

    val focusManager = LocalFocusManager.current


    var email by remember {
        mutableStateOf("")
    }


    var password by remember {
        mutableStateOf("")
    }


    val isEmailValid by derivedStateOf {
        Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    val isPasswordValid by derivedStateOf {
        password.length > 7
    }


    var isPasswordVisible by remember {
        mutableStateOf(false)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Column(
            modifier = Modifier.fillMaxWidth()
        ) {


            Text(
                text = "Приветствуем вас! " + "👋",
                style = MaterialTheme.typography.body1,
                color = Color.Black,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(start = 15.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Enter Email", color = MinorGrayColor)},
                placeholder = { Text(text = "abc@domain.com") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp),
                isError = !isEmailValid,
                trailingIcon = {
                    if (email.isNotBlank()) {
                        IconButton(onClick = { email = "" }) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = "Clear email"
                            )
                        }
                    }
                }

            )


            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Enter Password", color = MinorGrayColor)},
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp),
                isError = !isPasswordValid,
                trailingIcon = {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            imageVector = if (isPasswordVisible)
                                                Icons.Default.Visibility
                                            else
                                                Icons.Default.VisibilityOff,
                            contentDescription = "Toggle password visibility"
                        )

                    }
                },
                visualTransformation = if (isPasswordVisible)
                                            VisualTransformation.None
                                        else
                                            PasswordVisualTransformation()


            )

        }


        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = "Forgotten password?",
                    style = MaterialTheme.typography.h2,
                    color = SecondaryColor,
                    modifier = Modifier.padding(end = 15.dp)


                )
            }
        }


        Button(
            onClick = {/*TODO*/},
            modifier = Modifier
                .width(250.dp)
                .height(60.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = SecondaryColor),
            enabled = isEmailValid && isPasswordValid,
        ) {
            Text(
                text = "Войти",
                style = MaterialTheme.typography.button
            )
        }

        Spacer(modifier = Modifier.height(80.dp))

        TextButton(onClick = {navController.navigate("SignUpScreen")} ) {
            Text(
                text = "Create account",
                style = MaterialTheme.typography.h2,
                color = SecondaryColor,
                modifier = Modifier.padding(end = 15.dp)


            )
        }
    }
}
