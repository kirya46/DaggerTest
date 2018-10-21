package com.common.daggertest.mvp

import com.common.daggertest.api.ApiService
import com.common.daggertest.di.scope.ActivityScope
import com.common.daggertest.entity.User
import com.common.daggertest.repo.message.MessageDBRepository
import com.common.daggertest.repo.message.MessageNetworkRepository
import com.common.daggertest.repo.user.UserDBRepo
import com.common.daggertest.repo.user.UserNetworkRepo
import com.common.daggertest.repo.user.specification.FindUserBydIdSpec
import com.common.daggertest.repo.util.DataResource
import com.common.daggertest.repo.util.Status
import java.util.*
import javax.inject.Inject

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
@ActivityScope
class MainInteractor @Inject constructor(
        var apiService: ApiService,
        var userNetworkRepo: UserNetworkRepo, var userDBRepo: UserDBRepo,
        var messageNetworkRepository: MessageNetworkRepository, var messageDBRepository: MessageDBRepository
) : MainContract.Interactor {

    private val isNetwork: Boolean = true

    override fun fetchUser(success: (user: User) -> Unit, error: (exception: Exception) -> Unit) {

        val spec = FindUserBydIdSpec(Random().nextLong()/*use real id*/, apiService)

        val dataResource: DataResource<List<User>> = when (isNetwork) {
            true -> userNetworkRepo.query(spec)
            false -> userDBRepo.query(spec)
        }

        when (dataResource.status) {
            Status.SUCCESS -> dataResource.data?.firstOrNull()?.apply { success.invoke(this) }
            Status.ERROR -> error.invoke(Exception(dataResource.error?.message ?: ""))
        }
    }

}