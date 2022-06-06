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
    val themeString = changeText(darkThemeImport, applicationContext)
    val fileName = "Dark Monet Theme.attheme"

    File(applicationContext.cacheDir, fileName).writeText(text = themeString)
    shareTheme()
}

@Composable
fun changeText(file: String, applicationContext: Context): String {
    val monetList = mapOf(
        "surface" to monet.surface,
        "surfaceTint" to monet.surfaceTint,
        "inverseOnSurface" to monet.inverseOnSurface,
        "surfaceVariant" to monet.surfaceVariant,
        "" to monet.onSurface,
        "" to monet.onSurfaceVariant,
        "" to monet.primary,
        "" to monet.primaryContainer,
        "" to monet.inversePrimary,
        "" to monet.onPrimary,
        "" to monet.onPrimaryContainer,
        "" to monet.secondary,
        "" to monet.secondaryContainer,
        "" to monet.onSecondary,
        "" to monet.onSecondaryContainer,
        "" to monet.tertiary,
        "" to monet.tertiaryContainer,
        "" to monet.onTertiary,
        "" to monet.onTertiaryContainer,
        "" to monet.error,
        "" to monet.errorContainer,
        "" to monet.onError,
        "" to monet.onErrorContainer,
        "" to monet.outline,
        "none" to Color.Transparent,
    )
    var themeText = file.replace("\$", "")
    monetList.forEach {
        themeText = themeText.replace(it.key, it.value.toString())
    }
    return themeText
}