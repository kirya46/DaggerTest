package com.common.daggertest.ui.base

import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector

/**
 * Created by Kirill Stoianov on 21/07/18.
 */
abstract class BaseActivity : DaggerAppCompatActivity(), HasSupportFragmentInjector