package com.common.daggertest.di.activity

import com.common.daggertest.di.db.DataBaseModule
import com.common.daggertest.di.scope.ActivityScope
import com.common.daggertest.di.scope.FragmentScope
import com.common.daggertest.mvp.MainContract
import com.common.daggertest.mvp.MainPresenter
import com.common.daggertest.ui.activity.MainActivity
import com.common.daggertest.ui.fragment.UserFragment
import com.common.daggertest.ui.fragment.DetailsFragment
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
    abstract fun bindsMainActivityToMainRouter(mainActivity: MainActivity): MainContract.Router

    @ActivityScope
    @Binds
    abstract fun bindsMainActivityToMainView(mainActivity: MainActivity): MainContract.View

    @FragmentScope
    @ContributesAndroidInjector(modules = [UserFragmentModule::class])
    abstract fun bindMainFragment(): UserFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [DataBaseModule::class])
    abstract fun bindSecondaryFragment(): DetailsFragment
}