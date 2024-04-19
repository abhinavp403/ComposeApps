package dev.abhinav.composeapps.jetnews

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.abhinav.composeapps.jetnews.MainDestinations.ARTICLE_ID_KEY
import kotlinx.coroutines.launch

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val INTERESTS_ROUTE = "interests"
    const val ARTICLE_ROUTE = "post"
    const val ARTICLE_ID_KEY = "postId"
}

@Composable
fun JetnewsNavGraph(
    appContainer: AppContainer,
    navController: NavHostController = rememberNavController(),
    scaffoldState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    startDestination: String = MainDestinations.HOME_ROUTE
) {
    val actions = remember(navController) { MainActions(navController) }
    val coroutineScope = rememberCoroutineScope()
    val openDrawer: () -> Unit = { coroutineScope.launch { scaffoldState.open() } }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.HOME_ROUTE) {
            HomeScreen(
                postsRepository = appContainer.postsRepository,
                navigateToArticle = actions.navigateToArticle,
                openDrawer = openDrawer
            )
        }
        composable(MainDestinations.INTERESTS_ROUTE) {
            InterestsScreen(
                interestsRepository = appContainer.interestsRepository,
                openDrawer = openDrawer
            )
        }
        composable("${MainDestinations.ARTICLE_ROUTE}/{$ARTICLE_ID_KEY}") { backStackEntry ->
            ArticleScreen(
                postId = backStackEntry.arguments?.getString(ARTICLE_ID_KEY),
                onBack = actions.upPress,
                postsRepository = appContainer.postsRepository
            )
        }
    }
}

class MainActions(navController: NavHostController) {
    val navigateToArticle: (String) -> Unit = { postId: String ->
        navController.navigate("${MainDestinations.ARTICLE_ROUTE}/$postId")
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
