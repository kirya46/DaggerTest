package com.common.daggertest.mvp

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
interface MainContract {
    interface View {
        fun showUser(user: Any)
    }

    interface Presenter{

    }
}