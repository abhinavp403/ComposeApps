package dev.abhinav.composeapps.jetnews

import android.annotation.SuppressLint
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.abhinav.composeapps.ui.theme.ComposeAppsTheme
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun JetnewsApp(
    appContainer: AppContainer
) {
    ComposeAppsTheme() {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
        }

        val navController = rememberNavController()
        val coroutineScope = rememberCoroutineScope()
        // This top level scaffold contains the app drawer, which needs to be accessible
        // from multiple screens. An event to open the drawer is passed down to each
        // screen that needs it.
        val scaffoldState = rememberDrawerState(DrawerValue.Closed)

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: MainDestinations.HOME_ROUTE
        Scaffold(
            //scaffoldState = scaffoldState,
            content = {
//                AppDrawer(
//                    currentRoute = currentRoute,
//                    navigateToHome = { navController.navigate(MainDestinations.HOME_ROUTE) },
//                    navigateToInterests = { navController.navigate(MainDestinations.INTERESTS_ROUTE) },
//                    closeDrawer = { coroutineScope.launch { scaffoldState.close() } }
//                )
                JetnewsNavGraph(
                    appContainer = appContainer,
                    navController = navController,
                    scaffoldState = scaffoldState
                )
            }
        )
    }
}
