package com.common.daggertest.ui.activity

import android.os.Bundle
import com.common.daggertest.R
import com.common.daggertest.ui.base.BaseActivity
import com.common.daggertest.ui.fragment.MainFragment
import com.common.daggertest.ui.fragment.SecondaryFragment
import com.common.daggertest.mvp.router.impl.MainRouter


class MainActivity : BaseActivity(), MainRouter {
    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment()).commit()
    }

    override fun nextStep() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, SecondaryFragment())
                .commit()
    }
}
