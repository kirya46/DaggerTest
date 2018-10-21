package com.common.daggertest.mvp

import com.common.daggertest.entity.User

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
interface MainContract {
    interface View {
        fun showUser(user: User)
        fun showError(throwable: Throwable)
    }

    interface Presenter {
        fun fetchUser()
        fun openUserDetails(user: User)
    }

    interface Interactor {
        fun fetchUser(success: (user: User) -> Unit, error: (exception: Exception) -> Unit)
    }

    interface InteractorCallback {
        fun onSuccess(user: User)
        fun onError(throwable: Throwable)
    }

    interface Router {
        fun openUserDetailsScreen(user: User)
    }
}