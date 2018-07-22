package com.common.daggertest.mvp

import com.common.daggertest.di.scope.ActivityScope
import com.common.daggertest.entity.User
import java.io.Serializable
import javax.inject.Inject

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
@ActivityScope
class MainPresenter @Inject constructor(
        private var view: MainContract.View,
        private var interactor: MainInteractor,
        private var router: MainContract.Router
) : MainContract.Presenter, MainContract.InteractorCallback, Serializable {

    override fun fetchUser() {
        val u = interactor.fetchUser()
        onSuccess(u)
    }

    override fun openUserDetails(user: User) {
        router.openUserDetailsScreen(user)
    }

    override fun onSuccess(user: User) {
        view.showUser(user)
    }

    override fun onError(throwable: Throwable) {
        view.showError(throwable)
    }

}