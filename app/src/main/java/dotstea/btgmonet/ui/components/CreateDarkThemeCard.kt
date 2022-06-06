package dotstea.btgmonet.ui.components

import android.app.Application
import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import dotstea.btgmonet.R
import java.io.File
import androidx.compose.material3.MaterialTheme.colorScheme as monet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DarkThemeCard(shareTheme: () -> Unit,  application: Application, applicationContext: Context) {
    var createDarkThemeState by remember { mutableStateOf(false) }
    if (!createDarkThemeState) else createDarkTheme(shareTheme, application, applicationContext)

    Card(Modifier.padding(32.dp).fillMaxWidth(), RoundedCornerShape(32.dp)) {
        Button(onClick = { createDarkThemeState =! createDarkThemeState }) {
            Text(text = "Create Dark Theme")
        }
    }
}

@Composable
fun createDarkTheme(shareTheme: () -> Unit, application: Application, applicationContext: Context) {
    val darkMonetFile = "monet_dark.attheme"
    val darkThemeImport = application.assets.open(darkMonetFile).bufferedReader().readText()
    val themeString = changeText(darkThemeImport)
    val fileName = "Dark Monet Theme.attheme"

    File(applicationContext.cacheDir, fileName).writeText(text = themeString)
    shareTheme()
}

@Composable
fun changeText(file: String): String {
    val monetList = mapOf(
        "surface" to monet.surface.toArgb(),
        "surfaceTint" to monet.surfaceTint.toArgb(),
        "inverseOnSurface" to monet.inverseOnSurface.toArgb(),
        "surfaceVariant" to monet.surfaceVariant.toArgb(),
        "onSurface" to monet.onSurface.toArgb(),
        "onSurfaceVariant" to monet.onSurfaceVariant.toArgb(),
        "primary" to monet.primary.toArgb(),
        "primaryContainer" to monet.primaryContainer.toArgb(),
        "inversePrimary" to monet.inversePrimary.toArgb(),
        "onPrimary" to monet.onPrimary.toArgb(),
        "onPrimaryContainer" to monet.onPrimaryContainer.toArgb(),
        "secondary" to monet.secondary.toArgb(),
        "secondaryContainer" to monet.secondaryContainer.toArgb(),
        "onSecondary" to monet.onSecondary.toArgb(),
        "onSecondaryContainer" to monet.onSecondaryContainer.toArgb(),
        "tertiary" to monet.tertiary.toArgb(),
        "tertiaryContainer" to monet.tertiaryContainer.toArgb(),
        "onTertiary" to monet.onTertiary.toArgb(),
        "onTertiaryContainer" to monet.onTertiaryContainer.toArgb(),
        "error" to monet.error.toArgb(),
        "errorContainer" to monet.errorContainer.toArgb(),
        "onError" to monet.onError.toArgb(),
        "onErrorContainer" to monet.onErrorContainer.toArgb(),
        "outline" to monet.outline.toArgb(),
        "none" to Color.Transparent.toArgb(),
    )

    var themeText = file.replace("\$", "")
    monetList.forEach {
        themeText = themeText.replace(it.key, it.value.toString())
    }

    return themeText
}