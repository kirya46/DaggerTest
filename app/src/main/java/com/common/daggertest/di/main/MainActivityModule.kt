package com.common.daggertest.di.main

import com.common.daggertest.di.factory.FactoryModule
import com.common.daggertest.ui.MainFragment
import com.common.daggertest.di.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Kirill Stoianov on 21/07/18.
 */

@Module(includes = [FactoryModule::class])
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment
}