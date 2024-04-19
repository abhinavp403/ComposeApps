package dev.abhinav.composeapps.jetnews

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsetAwareTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = 4.dp
) {
    Surface(
        color = backgroundColor,
        tonalElevation = elevation,
        modifier = modifier
    ) {
        TopAppBar(
            title = title,
            navigationIcon = navigationIcon!!,
            actions = actions,
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = backgroundColor,
                titleContentColor = contentColor
            ),
            modifier = Modifier.statusBarsPadding()
        )
    }
}
