package com.common.daggertest.ui

import android.os.Bundle
import android.widget.Toast
import com.common.daggertest.R
import com.common.daggertest.ui.base.BaseActivity
import com.common.daggertest.util.AnyFactory
import javax.inject.Inject


class MainActivity : BaseActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container,MainFragment()).commit()

    }
}
