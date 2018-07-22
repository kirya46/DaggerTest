package com.common.daggertest.di.app

import android.app.Application
import com.common.daggertest.AppController
import com.common.daggertest.di.activity.ActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * Created by Kirill Stoianov on 21/07/18.
 */
@Singleton
@Component(modules = [
    AndroidInjectionModule::class, AndroidSupportInjectionModule::class,
    AppModule::class, ActivityModule::class
])
interface AppComponent : AndroidInjector<AppController> {

    override fun inject(instance: AppController)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}