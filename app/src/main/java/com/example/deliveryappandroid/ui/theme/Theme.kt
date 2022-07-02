package com.example.deliveryappandroid.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = BackgroundColor,
    primaryVariant = BackgroundColor,
    secondary = SecondaryColor
)

@SuppressLint()
private val LightColorPalette = lightColors(
    primary = BackgroundColor,
    primaryVariant = BackgroundColor,
    secondary = SecondaryColor,

    // Other default colors to override
    background = BackgroundColor,
    surface = BackgroundColor,
    onPrimary = TittleColor,
    onSecondary = Color.White,
    onBackground = TittleColor,
    onSurface = TittleColor,

)


@Composable
fun DeliveryAppAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (darkTheme) BackgroundColor else BackgroundColor
        )
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
