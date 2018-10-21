package com.common.daggertest.repo

import com.common.daggertest.repo.util.DataResource

/**
 * Created by Kirill Stoianov on 20/10/2018.
 */
interface BaseNetworkSpecification<R> : Specification<R> {
    fun apiRequest(): DataResource<R>
}