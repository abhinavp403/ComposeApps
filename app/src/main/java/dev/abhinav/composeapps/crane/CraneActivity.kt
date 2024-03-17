package dev.abhinav.composeapps.crane

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import dev.abhinav.composeapps.ui.theme.ComposeAppsTheme

@AndroidEntryPoint
class CraneActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            ComposeAppsTheme {
                MainScreen(onExploreItemClicked = {
                    launchDetailsActivity(
                        context = this,
                        item = it
                    )
                })
            }
        }
    }
}

@Composable
private fun MainScreen(onExploreItemClicked: OnExploreItemClicked) {
    Surface(color = MaterialTheme.colorScheme.primary) {
        CraneHome(onExploreItemClicked = onExploreItemClicked)
    }
}