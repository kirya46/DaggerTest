package com.common.daggertest.di

import android.app.Application
import com.common.daggertest.AppController
import com.common.daggertest.di.activity.ActivityBuilder
import com.common.daggertest.di.app.AppModule
import com.common.daggertest.di.db.DataBaseModule
import com.common.daggertest.di.network.NetworkModule
import com.common.daggertest.di.repo.RepoModule
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
    AppModule::class, ActivityBuilder::class,NetworkModule::class,DataBaseModule::class,
    RepoModule::class
])
interface AppComponent : AndroidInjector<AppController> {

    override fun inject(instance: AppController)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun appModule(appModule: AppModule):Builder
        fun networkModule(networkModule: NetworkModule):Builder
        fun repoModule(repoModule: RepoModule):Builder

        fun build(): AppComponent
    }

}