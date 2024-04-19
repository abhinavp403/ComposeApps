package dev.abhinav.composeapps.jetnews

import android.content.Context

interface AppContainer {
    val postsRepository: PostsRepository
    val interestsRepository: InterestsRepository
}

class AppContainerImpl(private val applicationContext: Context) : AppContainer {

    override val postsRepository: PostsRepository by lazy {
        PostsRepository()
    }

    override val interestsRepository: InterestsRepository by lazy {
        InterestsRepository()
    }
}
