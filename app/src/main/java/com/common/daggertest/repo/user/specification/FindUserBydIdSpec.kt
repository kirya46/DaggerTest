package com.common.daggertest.repo.user.specification

import com.common.daggertest.api.ApiService
import com.common.daggertest.entity.User
import com.common.daggertest.entity.User_Table
import com.common.daggertest.repo.BaseDBSpecification
import com.common.daggertest.repo.BaseNetworkSpecification
import com.common.daggertest.repo.util.DataResource
import com.raizlabs.android.dbflow.sql.language.SQLite

/**
 * Created by Kirill Stoianov on 21/10/2018.
 */
class FindUserBydIdSpec(private val userId: Long, private val apiService: ApiService) : BaseDBSpecification<List<User>>, BaseNetworkSpecification<List<User>> {

    override fun dbQuery(): DataResource<List<User>> {
        val queryResult = SQLite.select().from(User::class.java).where(User_Table.id.eq(userId)).queryList()
        return DataResource.success(queryResult)
    }

    override fun apiRequest(): DataResource<List<User>> {
        val fetchUser = apiService.fetchUser(userId)
        return DataResource.success(arrayListOf(fetchUser))
    }
}