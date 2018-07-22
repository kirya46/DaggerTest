package com.common.daggertest.di.activity

import com.common.daggertest.di.factory.FactoryModule
import com.common.daggertest.di.scope.ActivityScope
import com.common.daggertest.di.scope.FragmentScope
import com.common.daggertest.ui.activity.MainActivity
import com.common.daggertest.ui.fragment.MainFragment
import com.common.daggertest.ui.fragment.SecondaryFragment
import com.common.daggertest.mvp.router.impl.MainRouter
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by Kirill Stoianov on 21/07/18.
 */
@Module
abstract class MainActivityModule {

    @ActivityScope
    @Binds
    abstract fun bindsMainActivityToMainView(mainActivity: MainActivity): MainRouter

    @FragmentScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun bindMainFragment(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [FactoryModule::class])
    abstract fun bindSecondaryFragment(): SecondaryFragment
}