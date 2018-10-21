package com.common.daggertest.api

import com.common.daggertest.entity.Message
import com.common.daggertest.entity.User
import com.common.daggertest.util.AppPreferences

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
class ApiService(var baseUrl: String, var appPreferences: AppPreferences) {


    fun fetchUser(userId: Long): User {

        val user = User()
        appPreferences.saveLastSync(user.lastSync)

        return user
    }

    fun fetchMessage(): ApiResponse<List<Message>> {
        val apiResponse = ApiResponse<List<Message>>()
        apiResponse.body = arrayListOf(Message(), Message(), Message())
        return apiResponse
    }

    fun add(item: Message) {
        //do something
    }

    fun update(item: Message) {
        //do something
    }

    fun remove(item: Message) {
        //do something
    }

    override fun toString(): String {
        return "ApiService(baseUrl='$baseUrl')"
    }

}
