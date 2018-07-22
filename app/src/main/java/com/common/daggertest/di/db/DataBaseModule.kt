package com.common.daggertest.di.db

import android.content.Context
import com.common.daggertest.db.AppDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Kirill Stoianov on 21/07/18.
 */
@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDataBase = AppDataBase(context)
}