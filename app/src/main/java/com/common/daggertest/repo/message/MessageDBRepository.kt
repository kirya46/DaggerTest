package com.common.daggertest.repo.message

import com.common.daggertest.entity.Message
import com.common.daggertest.repo.BaseDBSpecification
import com.common.daggertest.repo.Repository
import com.common.daggertest.repo.Specification
import com.common.daggertest.repo.util.DataResource

/**
 * Created by Kirill Stoianov on 20/10/2018.
 */
class MessageDBRepository : Repository<Message, List<Message>> {
    override fun add(item: Message) {
        item.save()
    }

    override fun remove(item: Message) {
        item.delete()
    }

    override fun update(item: Message) {
        item.exists().takeIf { it.not() }.apply { item.save() }
        item.update()
    }

    override fun query(specification: Specification<List<Message>>): DataResource<List<Message>> {
        return (specification as BaseDBSpecification).dbQuery()
    }
}

