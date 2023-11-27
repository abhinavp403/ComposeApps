package dev.abhinav.composeapps.di

import android.content.Context
import dev.abhinav.composeapps.inventory.InventoryDatabase
import dev.abhinav.composeapps.inventory.ItemsRepository
import dev.abhinav.composeapps.inventory.OfflineItemsRepository

interface AppContainer {
    val itemsRepository: ItemsRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    override val itemsRepository: ItemsRepository by lazy {
        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
    }
}