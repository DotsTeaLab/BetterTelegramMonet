package dotstea.btgmonet

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.core.content.FileProvider
import dotstea.btgmonet.ui.MainScreen
import dotstea.btgmonet.ui.theme.BTGMonetTheme
import java.io.File


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val darkThemeFileName = "Dark Theme.attheme"
        val darkThemeName = "Dark"
        val lightThemeFileName = "Light Theme.attheme"
        val lightThemeName = "Light"


        setContent {
            BTGMonetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        application,
                        applicationContext,
                        { shareTheme(darkThemeName, darkThemeFileName) },
                        { shareTheme(lightThemeName, lightThemeFileName) }
                    )
                }
            }
        }
    }

    private fun shareTheme(theme: String, file_name: String) {
        val file = File(applicationContext.cacheDir, file_name)
        val uri = FileProvider.getUriForFile(
            applicationContext,
            "${BuildConfig.APPLICATION_ID}.provider",
            file
        )
        val intent = Intent(Intent.ACTION_SEND)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        intent.type = "*/attheme"
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(Intent.createChooser(intent, theme))
    }
}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    BTGMonetTheme {
//        MainScreen {
//
//        }
//    }
//}