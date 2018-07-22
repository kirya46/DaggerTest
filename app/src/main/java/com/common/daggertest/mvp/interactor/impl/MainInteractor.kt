package com.common.daggertest.mvp.interactor.impl

import com.common.daggertest.api.ApiService
import com.common.daggertest.di.scope.ActivityScope
import com.common.daggertest.mvp.interactor.Interactor
import javax.inject.Inject

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
@ActivityScope
class MainInteractor @Inject constructor(var apiService: ApiService) : Interactor {

    fun fetchUser(): Any {
        return apiService.fetchUser()
    }
}