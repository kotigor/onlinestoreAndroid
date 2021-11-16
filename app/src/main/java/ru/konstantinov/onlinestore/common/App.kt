package ru.konstantinov.onlinestore.common

import android.app.Application
import ru.konstantinov.onlinestore.MainRouter

class App : Application() {
    lateinit var mainRouter: MainRouter
    override fun onCreate() {
        super.onCreate()
    }
}