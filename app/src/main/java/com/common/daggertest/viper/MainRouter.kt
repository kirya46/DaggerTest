package com.common.daggertest.viper

import com.common.daggertest.R
import com.common.daggertest.di.scope.ActivityScope
import com.common.daggertest.ui.activity.MainActivity
import com.common.daggertest.ui.fragment.SecondaryFragment
import javax.inject.Inject

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
@ActivityScope
class MainRouter @Inject constructor(val activity: MainActivity) : Router {

    override fun nextStep() {
        activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, SecondaryFragment())
                .commit()
    }
}