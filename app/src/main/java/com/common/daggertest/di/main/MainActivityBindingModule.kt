package com.common.daggertest.di.main

import android.app.Activity
import com.common.daggertest.ui.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap


/**
 * Created by Kirill Stoianov on 21/07/18.
 */

@Module(subcomponents = [MainActivitySubComponent::class])
abstract class MainActivityBindingModule {

//    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
//    abstract fun mainActivity(): MainActivity

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindMainActivityInjectorFactory(builder: MainActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>
}