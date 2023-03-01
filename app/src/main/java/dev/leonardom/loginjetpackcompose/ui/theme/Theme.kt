package dev.leonardom.loginjetpackcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import dev.leonardom.loginjetpackcompose.R

val Poppins = FontFamily(
    Font(R.font.poppins_thin, weight = FontWeight.Thin),
    Font(R.font.poppins_light, weight = FontWeight.Light),
    Font(R.font.poppins_regular, weight = FontWeight.Normal),
    Font(R.font.poppins_medium, weight = FontWeight.Medium),
    Font(R.font.poppins_semibold, weight = FontWeight.SemiBold),
    Font(R.font.poppins_bold, weight = FontWeight.Bold),
    Font(R.font.poppins_extrabold, weight = FontWeight.ExtraBold),
    Font(R.font.poppins_black, weight = FontWeight.Black)
)
val Poppins_Italic = FontFamily(
    Font(R.font.poppins_thinitalic, weight = FontWeight.Thin),
    Font(R.font.poppins_lightitalic, weight = FontWeight.Light),
    Font(R.font.poppins_italic, weight = FontWeight.Normal),
    Font(R.font.poppins_mediumitalic, weight = FontWeight.Medium),
    Font(R.font.poppins_semibolditalic, weight = FontWeight.SemiBold),
    Font(R.font.poppins_bolditalic, weight = FontWeight.Bold),
    Font(R.font.poppins_extrabolditalic, weight = FontWeight.ExtraBold),
    Font(R.font.poppins_blackitalic, weight = FontWeight.Black)
)

private val DarkColorPalette = darkColors(
    primary =   BLUE900,
    primaryVariant = BLUE950,
    secondary = CYAN900,
    secondaryVariant = CYAN800,
    background = BLUEGREY900,
    surface = BLUEGREY800,
    error = RED800,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.White
)

private val LightColorPalette = lightColors(
    primary =   Blue500,
    primaryVariant = BLUE800,
    secondary = CYAN500,
    secondaryVariant = CYAN700,
    background = LIGHTBLUE50,
    surface = Color.White,
    error = RED600,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.Black
)

@Composable
fun LoginJetpackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
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