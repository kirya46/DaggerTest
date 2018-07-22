package com.common.daggertest.ui

import android.os.Bundle
import android.widget.Toast
import com.common.daggertest.ui.base.BaseFragment
import com.common.daggertest.util.AnyFactory
import javax.inject.Inject

/**
 * Created by Kirill Stoianov on 21/07/18.
 */
class MainFragment : BaseFragment() {


    @Inject
    lateinit var anyFactory: AnyFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(context, anyFactory.getMessage(), Toast.LENGTH_LONG).show()

    }

}