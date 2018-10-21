package com.common.daggertest.repo


import com.common.daggertest.repo.util.DataResource

/**
 * Created by Kirill Stoianov on 20/10/2018.
 */
interface BaseDBSpecification<R> : Specification<R> {
    fun dbQuery(): DataResource<R>
}