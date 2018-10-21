package com.common.daggertest


import com.common.daggertest.di.AppComponent
import com.common.daggertest.di.DaggerAppComponent
import com.common.daggertest.di.app.AppModule
import com.common.daggertest.di.db.DataBaseModule
import com.common.daggertest.di.network.NetworkModule
import com.common.daggertest.di.repo.RepoModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by Kirill Stoianov on 21/07/18.
 */
class AppController : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent: AppComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this@AppController))
                .networkModule(NetworkModule(this@AppController))
                .repoModule(RepoModule())
                .application(this)
                .build()
        appComponent.inject(this@AppController)
        return appComponent
    }

}