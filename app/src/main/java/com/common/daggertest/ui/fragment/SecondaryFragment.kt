package com.common.daggertest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.common.daggertest.R
import com.common.daggertest.ui.base.BaseFragment
import com.common.daggertest.util.AnyFactory
import kotlinx.android.synthetic.main.fragment_secondary.*
import javax.inject.Inject

/**
 * Created by Kirill Stoianov on 21/07/18.
 */
class SecondaryFragment : BaseFragment() {


    @Inject
    lateinit var anyFactory: AnyFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_secondary,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvContent.text = String.format("%s %s",SecondaryFragment::class.java.simpleName,anyFactory.getMessage())
    }

}