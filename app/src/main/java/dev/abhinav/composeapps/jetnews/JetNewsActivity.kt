package dev.abhinav.composeapps.jetnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import dev.abhinav.composeapps.ui.theme.ComposeAppsTheme

class JetNewsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val appContainer = (application as JetnewsApplication).container
        setContent {
            ComposeAppsTheme {
                JetnewsApp(appContainer)
            }
        }
    }
}
