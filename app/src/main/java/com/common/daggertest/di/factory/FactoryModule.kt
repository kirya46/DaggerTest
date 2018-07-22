package com.common.daggertest.di.factory

import com.common.daggertest.util.AnyFactory
import dagger.Module
import dagger.Provides

/**
 * Created by Kirill Stoianov on 21/07/18.
 */
@Module
 class FactoryModule {

    @Provides
    fun bindAnyFactory(): AnyFactory = AnyFactory()
}