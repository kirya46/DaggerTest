package com.common.daggertest.ui.base

import com.common.daggertest.api.ApiService
import com.common.daggertest.db.AppDataBase
import com.common.daggertest.util.AppPreferences
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by Kirill Stoianov on 21/07/18.
 */
abstract class BaseActivity : DaggerAppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var appPreferences: AppPreferences

    //can be declared in AppComponent or with scope Singleton in DataBaseModule
//    @Inject
//    lateinit var appDataBase: AppDataBase
}