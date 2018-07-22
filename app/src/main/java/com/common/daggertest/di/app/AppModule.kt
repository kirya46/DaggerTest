package com.common.daggertest.di.app

import android.content.Context
import android.util.Log
import com.common.daggertest.AppController
import com.common.daggertest.util.AppPreferences
import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
@Module(includes = [AndroidSupportInjectionModule::class])
class AppModule(var app: AppController) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return app.applicationContext
    }

    @Provides
    @Singleton
    fun provideAppPreferences(): AppPreferences = AppPreferences(app)
}