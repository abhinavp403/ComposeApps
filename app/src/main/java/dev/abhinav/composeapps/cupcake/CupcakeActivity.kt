package dev.abhinav.composeapps.cupcake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import dev.abhinav.composeapps.cupcake.CupcakeApp
import dev.abhinav.composeapps.ui.theme.ComposeAppsTheme

class CupcakeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ComposeAppsTheme {
                CupcakeApp()
            }
        }
    }
}