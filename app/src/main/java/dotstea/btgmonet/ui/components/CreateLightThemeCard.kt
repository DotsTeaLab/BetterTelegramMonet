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
import dotstea.btgmonet.ui.theme.LightTheme
import java.io.File
import androidx.compose.material3.MaterialTheme.colorScheme as monet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateLightThemeCard(shareTheme: () -> Unit, application: Application, applicationContext: Context) {
    var createLightThemeState by remember { mutableStateOf(false) }

    LightTheme() {
        if (!createLightThemeState)
            createLightThemeState =! createLightThemeState
            else
                createLightTheme(shareTheme, application, applicationContext)
    }

    Card(
        Modifier
            .padding(32.dp)
            .fillMaxWidth(), RoundedCornerShape(32.dp)) {
        Button(onClick = { createLightThemeState =! createLightThemeState }) {
            Text(text = "Create Light Theme")
        }
    }
}

@Composable
private fun createLightTheme(shareTheme: () -> Unit, application: Application, applicationContext: Context) {
    val lightMonetFile = "monet_light.attheme"
    val lightThemeImport = application.assets.open(lightMonetFile).bufferedReader().readText()
    val themeString = changeText(lightThemeImport, applicationContext)
    val fileName = "Light Theme.attheme"

    File(applicationContext.cacheDir, fileName).writeText(text = themeString)
    shareTheme()
}

@Composable
private fun changeText(file: String, applicationContext: Context): String {
    val monetList = mapOf(
        "background" to monet.background.toArgb(),
        "onBackground" to monet.onBackground.toArgb(),
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

        "a1_0" to ContextCompat.getColor(applicationContext, R.color.system_accent1_0),
        "a1_200" to ContextCompat.getColor(applicationContext, R.color.system_accent1_200),
        "a1_300" to ContextCompat.getColor(applicationContext, R.color.system_accent1_300),
        "a1_400" to ContextCompat.getColor(applicationContext, R.color.system_accent1_400),
        "a1_500" to ContextCompat.getColor(applicationContext, R.color.system_accent1_500),
        "a1_600" to ContextCompat.getColor(applicationContext, R.color.system_accent1_600),
        "a1_700" to ContextCompat.getColor(applicationContext, R.color.system_accent1_700),
        "a1_800" to ContextCompat.getColor(applicationContext, R.color.system_accent1_800),
        "a1_900" to ContextCompat.getColor(applicationContext, R.color.system_accent1_900),
        "a1_1000" to ContextCompat.getColor(applicationContext, R.color.system_accent1_1000),
        "a1_100" to ContextCompat.getColor(applicationContext, R.color.system_accent1_100),
        "a1_10" to ContextCompat.getColor(applicationContext, R.color.system_accent1_10),
        "a1_50" to ContextCompat.getColor(applicationContext, R.color.system_accent1_50),
        "a2_0" to ContextCompat.getColor(applicationContext, R.color.system_accent2_0),
        "a2_200" to ContextCompat.getColor(applicationContext, R.color.system_accent2_200),
        "a2_300" to ContextCompat.getColor(applicationContext, R.color.system_accent2_300),
        "a2_400" to ContextCompat.getColor(applicationContext, R.color.system_accent2_400),
        "a2_500" to ContextCompat.getColor(applicationContext, R.color.system_accent2_500),
        "a2_600" to ContextCompat.getColor(applicationContext, R.color.system_accent2_600),
        "a2_700" to ContextCompat.getColor(applicationContext, R.color.system_accent2_700),
        "a2_800" to ContextCompat.getColor(applicationContext, R.color.system_accent2_800),
        "a2_900" to ContextCompat.getColor(applicationContext, R.color.system_accent2_900),
        "a2_1000" to ContextCompat.getColor(applicationContext, R.color.system_accent2_1000),
        "a2_100" to ContextCompat.getColor(applicationContext, R.color.system_accent2_100),
        "a2_10" to ContextCompat.getColor(applicationContext, R.color.system_accent2_10),
        "a2_50" to ContextCompat.getColor(applicationContext, R.color.system_accent2_50),
        "a3_0" to ContextCompat.getColor(applicationContext, R.color.system_accent3_0),
        "a3_200" to ContextCompat.getColor(applicationContext, R.color.system_accent3_200),
        "a3_300" to ContextCompat.getColor(applicationContext, R.color.system_accent3_300),
        "a3_400" to ContextCompat.getColor(applicationContext, R.color.system_accent3_400),
        "a3_500" to ContextCompat.getColor(applicationContext, R.color.system_accent3_500),
        "a3_600" to ContextCompat.getColor(applicationContext, R.color.system_accent3_600),
        "a3_700" to ContextCompat.getColor(applicationContext, R.color.system_accent3_700),
        "a3_800" to ContextCompat.getColor(applicationContext, R.color.system_accent3_800),
        "a3_900" to ContextCompat.getColor(applicationContext, R.color.system_accent3_900),
        "a3_1000" to ContextCompat.getColor(applicationContext, R.color.system_accent3_1000),
        "a3_100" to ContextCompat.getColor(applicationContext, R.color.system_accent3_100),
        "a3_10" to ContextCompat.getColor(applicationContext, R.color.system_accent3_10),
        "a3_50" to ContextCompat.getColor(applicationContext, R.color.system_accent3_50),
        "n1_0" to ContextCompat.getColor(applicationContext, R.color.system_neutral1_0),
        "n1_200" to ContextCompat.getColor(applicationContext, R.color.system_neutral1_200),
        "n1_300" to ContextCompat.getColor(applicationContext, R.color.system_neutral1_300),
        "n1_400" to ContextCompat.getColor(applicationContext, R.color.system_neutral1_400),
        "n1_500" to ContextCompat.getColor(applicationContext, R.color.system_neutral1_500),
        "n1_600" to ContextCompat.getColor(applicationContext, R.color.system_neutral1_600),
        "n1_700" to ContextCompat.getColor(applicationContext, R.color.system_neutral1_700),
        "n1_800" to ContextCompat.getColor(applicationContext, R.color.system_neutral1_800),
        "n1_900" to ContextCompat.getColor(applicationContext, R.color.system_neutral1_900),
        "n1_1000" to ContextCompat.getColor(applicationContext, R.color.system_neutral1_1000),
        "n1_100" to ContextCompat.getColor(applicationContext, R.color.system_neutral1_100),
        "n1_10" to ContextCompat.getColor(applicationContext, R.color.system_neutral1_10),
        "n1_50" to ContextCompat.getColor(applicationContext, R.color.system_neutral1_50),
        "n2_0" to ContextCompat.getColor(applicationContext, R.color.system_neutral2_0),
        "n2_200" to ContextCompat.getColor(applicationContext, R.color.system_neutral2_200),
        "n2_300" to ContextCompat.getColor(applicationContext, R.color.system_neutral2_300),
        "n2_400" to ContextCompat.getColor(applicationContext, R.color.system_neutral2_400),
        "n2_500" to ContextCompat.getColor(applicationContext, R.color.system_neutral2_500),
        "n2_600" to ContextCompat.getColor(applicationContext, R.color.system_neutral2_600),
        "n2_700" to ContextCompat.getColor(applicationContext, R.color.system_neutral2_700),
        "n2_800" to ContextCompat.getColor(applicationContext, R.color.system_neutral2_800),
        "n2_900" to ContextCompat.getColor(applicationContext, R.color.system_neutral2_900),
        "n2_1000" to ContextCompat.getColor(applicationContext, R.color.system_neutral2_1000),
        "n2_100" to ContextCompat.getColor(applicationContext, R.color.system_neutral2_100),
        "n2_10" to ContextCompat.getColor(applicationContext, R.color.system_neutral2_10),
        "n2_50" to ContextCompat.getColor(applicationContext, R.color.system_neutral2_50)
    )

    var themeText = file.replace("\$", "")
    monetList.forEach {
        themeText = themeText.replace(it.key, it.value.toString())
    }

    return themeText
}