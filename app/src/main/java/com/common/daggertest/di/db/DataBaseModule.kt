package com.common.daggertest.di.db

import android.content.Context
import com.common.daggertest.db.AppDataBase
import com.common.daggertest.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by Kirill Stoianov on 21/07/18.
 */
@Module
class DataBaseModule {

    @Provides
    fun provideAppDatabase(context: Context): AppDataBase = AppDataBase(context)
}