package com.hanchang97.starbucks

import android.app.Application
import com.hanchang97.starbucks.di.*
import com.hanchang97.starbucks.di.databaseModule
import com.hanchang97.starbucks.di.remoteModule
import com.hanchang97.starbucks.di.repositoryModule
import com.hanchang97.starbucks.di.useCaseModule
import com.hanchang97.starbucks.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class StarBucksApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@StarBucksApplication)

            modules(remoteModule)
            modules(repositoryModule)
            modules(useCaseModule)
            modules(viewModelModule)
            modules(databaseModule)
        }
    }
}