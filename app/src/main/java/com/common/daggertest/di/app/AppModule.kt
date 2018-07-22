package com.common.daggertest.di.app

import android.content.Context
import com.common.daggertest.AppController
import com.common.daggertest.di.activity.ActivityModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: AppController): Context {
        return app.applicationContext
    }
}