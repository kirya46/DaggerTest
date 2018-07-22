package com.common.daggertest.di.activity

import com.common.daggertest.di.scope.ActivityScope
import com.common.daggertest.mvp.MainContract
import com.common.daggertest.ui.activity.MainActivity
import dagger.Binds
import dagger.Module


/**
 * Created by Kirill Stoianov on 21/07/18.
 */
@Module(includes = [MainFragmentModule::class])
abstract class MainActivityModule {

    @ActivityScope
    @Binds
    abstract fun bindsMainActivityToMainRouter(mainActivity: MainActivity): MainContract.Router

    @ActivityScope
    @Binds
    abstract fun bindsMainActivityToMainView(mainActivity: MainActivity): MainContract.View
}