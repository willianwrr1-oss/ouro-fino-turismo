package com.willian.ourofino.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val OuroClaro = Color(0xFFF3E3B3)

val HeroBrush: Brush = Brush.verticalGradient(
    listOf(Color(0xFF2B1D08), Color(0xFF6B4508), Color(0xFFB8860B))
)

private val LightColors = lightColorScheme(
    primary = Color(0xFF8A5A00),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFF6E6BD),
    onPrimaryContainer = Color(0xFF3A2500),
    secondary = Color(0xFF2F5D50),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFF0DFAE),
    onSecondaryContainer = Color(0xFF3A2500),
    background = Color(0xFFFBF7EE),
    onBackground = Color(0xFF201B12),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF201B12),
    surfaceVariant = Color(0xFFEFE8D8),
    onSurfaceVariant = Color(0xFF5A5240),
    outline = Color(0xFF8D8570),
    outlineVariant = Color(0xFFD9D0BB)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFE8B84A),
    onPrimary = Color(0xFF3A2500),
    primaryContainer = Color(0xFF5C3F00),
    onPrimaryContainer = Color(0xFFFFE9B8),
    secondary = Color(0xFF8EC5B2),
    onSecondary = Color(0xFF00382C),
    secondaryContainer = Color(0xFF4A3A10),
    onSecondaryContainer = Color(0xFFFFE9B8),
    background = Color(0xFF17140E),
    onBackground = Color(0xFFEDE4D0),
    surface = Color(0xFF1F1B13),
    onSurface = Color(0xFFEDE4D0),
    surfaceVariant = Color(0xFF3A3426),
    onSurfaceVariant = Color(0xFFCFC6B0),
    outline = Color(0xFF988F7A),
    outlineVariant = Color(0xFF4A4333)
)

private val Serif = FontFamily.Serif

private val OuroTypography = Typography(
    headlineLarge = TextStyle(fontFamily = Serif, fontWeight = FontWeight.Bold, fontSize = 36.sp, lineHeight = 42.sp),
    headlineMedium = TextStyle(fontFamily = Serif, fontWeight = FontWeight.Bold, fontSize = 28.sp, lineHeight = 34.sp),
    headlineSmall = TextStyle(fontFamily = Serif, fontWeight = FontWeight.SemiBold, fontSize = 22.sp, lineHeight = 28.sp),
    titleLarge = TextStyle(fontFamily = Serif, fontWeight = FontWeight.SemiBold, fontSize = 20.sp, lineHeight = 26.sp),
    titleMedium = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp, lineHeight = 22.sp),
    bodyLarge = TextStyle(fontSize = 16.sp, lineHeight = 25.sp),
    bodyMedium = TextStyle(fontSize = 14.sp, lineHeight = 21.sp),
    labelLarge = TextStyle(fontWeight = FontWeight.Medium, fontSize = 14.sp),
    labelSmall = TextStyle(fontWeight = FontWeight.Medium, fontSize = 11.sp, letterSpacing = 0.6.sp)
)

@Composable
fun OuroFinoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) DarkColors else LightColors,
        typography = OuroTypography,
        content = content
    )
}
