package com.mungaicodes.rickymortyapi.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = ColorPrimary,
    background = Color.DarkGray,
    onBackground = TextWhite,
    onPrimary = Color.DarkGray
)

@Composable
fun RickyMortyApiTheme(
    content: @Composable () -> Unit
) {
    val colors = DarkColorPalette


    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}