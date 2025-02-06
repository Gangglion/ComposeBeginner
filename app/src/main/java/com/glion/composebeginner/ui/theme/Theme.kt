package com.glion.composebeginner.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.glion.composebeginner.Chapter
import com.glion.composebeginner.RunChapper

private val DarkColorScheme = when(RunChapper.running) {
    Chapter.Chapter1 -> {
        darkColorScheme(
            primary = Purple200,
            secondary = Purple700,
            tertiary = Teal200
        )
    }
    else -> { // 프로젝트 생성 시 기본값
        darkColorScheme(
            primary = Purple80,
            secondary = PurpleGrey80,
            tertiary = Pink80
        )
    }
}

private val LightColorScheme = when(RunChapper.running) {
    Chapter.Chapter1 -> {
        lightColorScheme(
            primary = Purple500,
            secondary = Purple700,
            tertiary = Teal200
        )
    }
    else -> { // 프로젝트 생성 시 기본값
        lightColorScheme(
            primary = Purple40,
            secondary = PurpleGrey40,
            tertiary = Pink40
        )
    }
}

/* Other default colors to override
background = Color(0xFFFFFBFE),
surface = Color(0xFFFFFBFE),
onPrimary = Color.White,
onSecondary = Color.White,
onTertiary = Color.White,
onBackground = Color(0xFF1C1B1F),
onSurface = Color(0xFF1C1B1F),
*/

@Composable
fun ComposeBeginnerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = when(RunChapper.running) {
            Chapter.Chapter1 -> {
                birthdayCardShape
            }
            else -> {
                // 기본값 넣어주어야 할것 같음
                birthdayCardShape
            }
        },
        content = content
    )
}