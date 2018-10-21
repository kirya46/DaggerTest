package com.common.daggertest.repo.message.specifiction

import com.common.daggertest.api.ApiService
import com.common.daggertest.entity.Message
import com.common.daggertest.repo.BaseDBSpecification
import com.common.daggertest.repo.BaseNetworkSpecification
import com.common.daggertest.repo.util.DataResource
import com.raizlabs.android.dbflow.sql.language.SQLite


/**
 * Created by Kirill Stoianov on 20/10/2018.
 */
class FindAllMessagesSpecification(private val apiService: ApiService) : BaseDBSpecification<List<Message>>, BaseNetworkSpecification<List<Message>> {

    override fun dbQuery(): DataResource<List<Message>> {
        val queryResult = SQLite.select().from(Message::class.java).queryList()
        return DataResource.success(queryResult)
    }

    override fun apiRequest(): DataResource<List<Message>> {
        val apiResponse = apiService.fetchMessage()
        val success = apiResponse.isSuccess
        return if (success) {
            apiResponse.body.let { body ->
                if (body == null) return@let DataResource.success<List<Message>>(ArrayList())
                else return@let DataResource.success(body)
            }
        } else {
            DataResource.error(Throwable(apiResponse.error ?: ""))
        }
    }
}