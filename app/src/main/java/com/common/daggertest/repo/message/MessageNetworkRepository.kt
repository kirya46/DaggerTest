package com.common.daggertest.repo.message

import com.common.daggertest.api.ApiService
import com.common.daggertest.entity.Message
import com.common.daggertest.repo.BaseNetworkSpecification
import com.common.daggertest.repo.Repository
import com.common.daggertest.repo.Specification
import com.common.daggertest.repo.util.DataResource


/**
 * Created by Kirill Stoianov on 20/10/2018.
 */
class MessageNetworkRepository(private val apiService: ApiService) : Repository<Message, List<Message>> {

    override fun add(item: Message) {
        apiService.add(item)
    }

    override fun remove(item: Message) {
        apiService.remove(item)
    }

    override fun update(item: Message) {
        apiService.update(item)
    }

    override fun query(specification: Specification<List<Message>>): DataResource<List<Message>> {
        return (specification as BaseNetworkSpecification).apiRequest()
    }
}
