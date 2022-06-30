package com.example.deliveryappandroid.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = BackgroundColor,
    primaryVariant = BackgroundColor,
    secondary = SurfaceColor
)

@SuppressLint()
private val LightColorPalette = lightColors(
    primary = BackgroundColor,
    primaryVariant = BackgroundColor,
    secondary = SurfaceColor,

    // Other default colors to override
    background = BackgroundColor,
    surface = SurfaceColor,
    onPrimary = TittleColor,
    onSecondary = Color.White,
    onBackground = TittleColor,
    onSurface = Color.White,

)

@Composable
fun DeliveryAppAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}