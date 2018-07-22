package com.common.daggertest.ui.base

import com.common.daggertest.api.ApiService
import com.common.daggertest.db.AppDataBase
import com.common.daggertest.util.AppPreferences
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created by Kirill Stoianov on 21/07/18.
 */
open class BaseFragment : DaggerFragment() {

    @Inject
    lateinit var appDataBase: AppDataBase

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var appPreferences: AppPreferences
}
