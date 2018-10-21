package com.common.daggertest.repo

import com.common.daggertest.repo.util.DataResource

/**
 * Created by Kirill Stoianov on 20/10/2018.
 */
interface Repository<T, R> {

    fun add(item: T)
    fun remove(item: T)
    fun update(item: T)

    fun query(specification: Specification<R>): DataResource<List<T>>
}
