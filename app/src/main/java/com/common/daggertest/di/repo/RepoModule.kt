package com.common.daggertest.di.repo

import com.common.daggertest.api.ApiService
import com.common.daggertest.db.AppDataBase
import com.common.daggertest.repo.message.MessageDBRepository
import com.common.daggertest.repo.message.MessageNetworkRepository
import com.common.daggertest.repo.user.UserDBRepo
import com.common.daggertest.repo.user.UserNetworkRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Kirill Stoianov on 21/10/2018.
 */
@Module
class RepoModule {

    @Provides
    @Singleton
    fun provideMessageDBRepository(apiService: ApiService, dataBase: AppDataBase) = MessageDBRepository()

    @Provides
    @Singleton
    fun provideMessageNetworkRepository(apiService: ApiService, dataBase: AppDataBase) = MessageNetworkRepository(apiService)

    @Provides
    @Singleton
    fun provideUserDBRepo() = UserDBRepo()

    @Provides
    @Singleton
    fun provideUserNetworkRepo() = UserNetworkRepo()

}