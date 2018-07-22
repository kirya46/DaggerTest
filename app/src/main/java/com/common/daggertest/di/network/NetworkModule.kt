package com.common.daggertest.di.network

import com.common.daggertest.AppController
import com.common.daggertest.R
import com.common.daggertest.api.ApiService
import com.common.daggertest.db.AppDataBase
import com.common.daggertest.entity.User
import com.common.daggertest.util.AppPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
@Module
class NetworkModule(var app: AppController) {

    @Provides
    @Singleton
    fun provideApiService(appPreferences: AppPreferences): ApiService =
            ApiService(baseUrl = app.getString(R.string.apiBaseUrl), appPreferences = appPreferences)
}