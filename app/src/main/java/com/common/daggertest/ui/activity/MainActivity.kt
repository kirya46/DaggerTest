package com.common.daggertest.ui.activity

import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.common.daggertest.R
import com.common.daggertest.ui.base.BaseActivity
import com.common.daggertest.ui.fragment.MainFragment
import com.common.daggertest.viper.MainRouter
import javax.inject.Inject


class MainActivity : BaseActivity() {
    companion object {
        val TAG:String = MainActivity::class.java.simpleName
    }

    @Inject lateinit var router: MainRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment()).commit()

        Log.wtf(TAG, router.hashCode().toString())

//        Handler().postDelayed({router.nextStep()},3000)
    }
}
