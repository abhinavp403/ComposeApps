package dev.abhinav.composeapps.jetnews

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import dev.abhinav.composeapps.R
import dev.abhinav.composeapps.ui.theme.ComposeAppsTheme

@Suppress("DEPRECATION")
@Composable
fun ArticleScreen(
    postId: String?,
    postsRepository: PostsRepository,
    onBack: () -> Unit
) {
    val postData = postsRepository.getPost(postId)!!

    ArticleScreen(
        post = postData,
        onBack = onBack
    )
}

@Composable
fun ArticleScreen(
    post: Post,
    onBack: () -> Unit
) {

    var showDialog by rememberSaveable { mutableStateOf(false) }
    if (showDialog) {
        FunctionalityNotAvailablePopup { showDialog = false }
    }

    Scaffold(
        topBar = {
            InsetAwareTopAppBar(
                title = {
                    Text(
                        text = "Published in: ${post.publication?.name}",
                        style = MaterialTheme.typography.displayMedium,
                        color = LocalContentColor.current
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.cd_navigate_up)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        PostContent(
            post = post,
            modifier = Modifier
                // innerPadding takes into account the top and bottom bar
                .padding(innerPadding)
                // center content in landscape mode
                .supportWideScreen()
        )
    }
}

@Composable
private fun FunctionalityNotAvailablePopup(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        text = {
            Text(
                text = "Functionality not available \uD83D\uDE48",
                style = MaterialTheme.typography.bodyMedium
            )
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "CLOSE")
            }
        }
    )
}

@Preview("Article screen")
@Preview("Article screen (dark)", uiMode = UI_MODE_NIGHT_YES)
@Preview("Article screen (big font)", fontScale = 1.5f)
@Preview("Article screen (large screen)", device = Devices.PIXEL_C)
@Composable
fun PreviewArticle() {
    ComposeAppsTheme {
        ArticleScreen(PostsRepository().getPost(post3.id)!!) {}
    }
}
