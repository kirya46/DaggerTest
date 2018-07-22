package com.common.daggertest.entity

import java.io.Serializable
import java.util.*

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
class User : Serializable {
    var id: String = UUID.randomUUID().toString()
    var lastSync: Long = System.currentTimeMillis()

    override fun toString(): String {
        return "User[id = $id, lastSync = $lastSync]"
    }
}