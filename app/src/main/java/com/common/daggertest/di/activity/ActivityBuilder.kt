package com.common.daggertest.di.activity

import com.common.daggertest.di.scope.ActivityScope
import com.common.daggertest.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by Kirill Stoianov on 22/07/18.
 */
@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivityInjector(): MainActivity
}