package dotstea.btgmonet.ui

import android.app.Application
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import dotstea.btgmonet.ui.components.DarkThemeCard
import dotstea.btgmonet.ui.components.changeText
import dotstea.btgmonet.ui.components.createDarkTheme
import java.io.File

@Composable
fun MainScreen(application: Application, applicationContext: Context, shareTheme: () -> Unit) {
    Column {
        DarkThemeCard(shareTheme, application, applicationContext)
    }
}