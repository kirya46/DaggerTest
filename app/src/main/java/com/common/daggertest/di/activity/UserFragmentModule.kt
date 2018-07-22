package com.common.daggertest.di.activity

import com.common.daggertest.di.db.DataBaseModule
import dagger.Module

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
@Module(includes = [DataBaseModule::class])
abstract class UserFragmentModule