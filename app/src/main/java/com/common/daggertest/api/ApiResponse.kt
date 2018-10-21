package com.common.daggertest.api

/**
 * Created by Kirill Stoianov on 20/10/2018.
 */
class ApiResponse<T> {
    var isSuccess: Boolean = (System.currentTimeMillis() % 2 == 0L)
    var error: String? = null
    var body: T? = null
}