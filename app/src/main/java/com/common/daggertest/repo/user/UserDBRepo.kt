package com.common.daggertest.repo.user

import com.common.daggertest.entity.User
import com.common.daggertest.repo.BaseDBSpecification
import com.common.daggertest.repo.Repository
import com.common.daggertest.repo.Specification
import com.common.daggertest.repo.util.DataResource

/**
 * Created by Kirill Stoianov on 21/10/2018.
 */
class UserDBRepo:Repository<User,List<User>>{
    override fun add(item: User) {
        item.save()
    }

    override fun remove(item: User) {
        item.delete()
    }

    override fun update(item: User) {
        item.exists().takeIf { it.not() }.apply { item.save() }
        item.update()
    }

    override fun query(specification: Specification<List<User>>): DataResource<List<User>> {
        return (specification as BaseDBSpecification).dbQuery()
    }
}