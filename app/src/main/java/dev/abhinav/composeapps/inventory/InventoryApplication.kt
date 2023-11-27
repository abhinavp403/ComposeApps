package dev.abhinav.composeapps.inventory

import android.app.Application
import dev.abhinav.composeapps.di.AppContainer
import dev.abhinav.composeapps.di.AppDataContainer


class InventoryApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}