package com.common.daggertest.repo.user

import com.common.daggertest.entity.User
import com.common.daggertest.repo.BaseNetworkSpecification
import com.common.daggertest.repo.Repository
import com.common.daggertest.repo.Specification
import com.common.daggertest.repo.util.DataResource

/**
 * Created by Kirill Stoianov on 21/10/2018.
 */
class UserNetworkRepo : Repository<User, List<User>> {
    override fun add(item: User) {
        //todo
    }

    override fun remove(item: User) {
        //todo
    }

    override fun update(item: User) {
        //todo
    }

    override fun query(specification: Specification<List<User>>): DataResource<List<User>> {
        return (specification as BaseNetworkSpecification).apiRequest()
    }
}