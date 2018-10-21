package com.common.daggertest.repo


/**
 * Created by Kirill Stoianov on 20/10/2018.
 */
interface BaseCachedSpecification<R> : Specification<R> {
    fun accept(item: R): Boolean
}