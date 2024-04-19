package dev.abhinav.composeapps.jetnews

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class PostsRepository {
    // for now, keep the favorites in memory
    private val favorites = MutableStateFlow<Set<String>>(setOf())

    /**
     * Get a specific JetNews post.
     */
    fun getPost(postId: String?): Post? {
        return posts.find { it.id == postId }
    }

    /**
     * Get JetNews posts.
     */
    fun getPosts(): List<Post> {
        return posts
    }

    /**
     * Observe the current favorites
     */
    fun observeFavorites(): Flow<Set<String>> = favorites

    /**
     * Toggle a postId to be a favorite or not.
     */
    fun toggleFavorite(postId: String) {
        val set = favorites.value.toMutableSet()
        set.addOrRemove(postId)
        favorites.value = set
    }
}
