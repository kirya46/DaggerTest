package com.common.daggertest.api

import com.common.daggertest.util.AppPreferences
import java.util.*

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
class ApiService(var baseUrl: String, var appPreferences: AppPreferences) {


    fun fetchUser(): Any {

        val user = object {
            var id: String = UUID.randomUUID().toString()
            var lastSync: Long = System.currentTimeMillis()

            override fun toString(): String {
                return "User[id = $id, lastSync = $lastSync]"
            }
        }

        appPreferences.saveLastSync(user.lastSync)

        return user
    }

    override fun toString(): String {
        return "ApiService(baseUrl='$baseUrl')"
    }
}
