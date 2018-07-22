package com.common.daggertest.di.activity

import com.common.daggertest.di.scope.FragmentScope
import com.common.daggertest.ui.fragment.DetailsFragment
import com.common.daggertest.ui.fragment.UserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
@Module
abstract class MainFragmentModule{

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindUserFragment(): UserFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindDetailsFragment(): DetailsFragment
}