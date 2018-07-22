package com.common.daggertest.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import com.common.daggertest.R
import com.common.daggertest.entity.User
import com.common.daggertest.mvp.MainContract
import com.common.daggertest.mvp.MainPresenter
import com.common.daggertest.ui.base.BaseActivity
import com.common.daggertest.ui.fragment.UserFragment
import com.common.daggertest.ui.fragment.DetailsFragment
import javax.inject.Inject


class MainActivity : BaseActivity(), MainContract.View, MainContract.Router {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState==null)presenter.fetchUser()
    }


    override fun showUser(user: User) {
        supportFragmentManager.beginTransaction().replace(R.id.container, UserFragment.newInstance(user)).commit()
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(this@MainActivity, throwable.message, Toast.LENGTH_LONG).show()
    }

    override fun openUserDetailsScreen(user: User) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, DetailsFragment.newInstance(user))
                .commit()
    }

}
