package com.common.daggertest.di.activity

import com.common.daggertest.di.factory.FactoryModule
import dagger.Module

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
@Module(includes = [FactoryModule::class])
abstract class MainFragmentModule