package com.common.daggertest.api

import com.common.daggertest.entity.User
import com.common.daggertest.util.AppPreferences
import java.util.*

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
class ApiService(var baseUrl: String, var appPreferences: AppPreferences) {


    fun fetchUser(): User {

        val user = User()
        appPreferences.saveLastSync(user.lastSync)

        return user
    }

    override fun toString(): String {
        return "ApiService(baseUrl='$baseUrl')"
    }
}
