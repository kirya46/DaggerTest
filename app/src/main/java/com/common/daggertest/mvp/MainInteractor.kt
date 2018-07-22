package com.common.daggertest.mvp

import com.common.daggertest.api.ApiService
import com.common.daggertest.di.scope.ActivityScope
import com.common.daggertest.entity.User
import javax.inject.Inject

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
@ActivityScope
class MainInteractor @Inject constructor(var apiService: ApiService) : MainContract.Interactor {

    override fun fetchUser(): User {
        return apiService.fetchUser()
    }

}