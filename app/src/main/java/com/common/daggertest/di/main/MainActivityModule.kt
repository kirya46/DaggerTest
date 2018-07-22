package com.common.daggertest.di.main

import com.common.daggertest.di.factory.FactoryModule
import com.common.daggertest.di.scope.FragmentScope
import com.common.daggertest.ui.fragment.MainFragment
import com.common.daggertest.ui.fragment.SecondaryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.common.daggertest.viper.MainRouter
import dagger.Binds
import com.common.daggertest.di.scope.ActivityScope
import com.common.daggertest.ui.activity.MainActivity
import com.common.daggertest.viper.Router


/**
 * Created by Kirill Stoianov on 21/07/18.
 */
@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun bindMainFragment(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [FactoryModule::class])
    abstract fun bindSecondaryFragment(): SecondaryFragment
}