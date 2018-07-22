package com.common.daggertest.di.activity

import com.common.daggertest.di.main.MainActivityModule
import com.common.daggertest.ui.activity.MainActivity
import com.common.daggertest.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivityInjector(): MainActivity
}