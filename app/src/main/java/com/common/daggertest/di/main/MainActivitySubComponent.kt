package com.common.daggertest.di.main

import com.common.daggertest.ui.activity.MainActivity
import com.common.daggertest.di.scope.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
@ActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivitySubComponent : AndroidInjector<MainActivity> {

    @ActivityScope
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}