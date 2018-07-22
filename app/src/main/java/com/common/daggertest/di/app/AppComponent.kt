package com.common.daggertest.di.app

import android.app.Application
import com.common.daggertest.AppController
import com.common.daggertest.di.main.MainActivityBindingModule
import com.common.daggertest.di.main.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule


/**
 * Created by Kirill Stoianov on 21/07/18.
 */
@Component(modules = [AndroidSupportInjectionModule::class, MainActivityBindingModule::class, MainActivityModule::class])
interface AppComponent : AndroidInjector<AppController> {

    override fun inject(instance: AppController)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}