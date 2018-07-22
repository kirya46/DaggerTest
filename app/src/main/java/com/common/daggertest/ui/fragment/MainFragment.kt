package com.common.daggertest.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.common.daggertest.R
import com.common.daggertest.mvp.interactor.impl.MainInteractor
import com.common.daggertest.ui.base.BaseFragment
import com.common.daggertest.mvp.router.impl.MainRouter
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

/**
 * Created by Kirill Stoianov on 21/07/18.
 */
class MainFragment : BaseFragment() {

    companion object {
        val TAG: String = MainFragment::class.java.simpleName
    }

    @Inject
    lateinit var router: MainRouter

    @Inject
    lateinit var interactor: MainInteractor


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvContent.text = "Last sync: ${appPreferences.getLastSync()}\nFetch user: ${interactor.fetchUser()}"

        Handler().postDelayed({ router.nextStep() }, 3000)
    }

}