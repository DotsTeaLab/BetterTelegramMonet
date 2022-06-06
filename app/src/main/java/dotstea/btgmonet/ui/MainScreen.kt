package dotstea.btgmonet.ui

import android.app.Application
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import dotstea.btgmonet.ui.components.CreateDarkThemeCard
import dotstea.btgmonet.ui.components.CreateLightThemeCard

@Composable
fun MainScreen(
    application: Application,
    applicationContext: Context,
    shareDarkTheme: () -> Unit,
    shareLightTheme: () -> Unit
) {
    Column {
        CreateDarkThemeCard(shareDarkTheme, application, applicationContext)
        CreateLightThemeCard(shareLightTheme, application, applicationContext)
    }
}