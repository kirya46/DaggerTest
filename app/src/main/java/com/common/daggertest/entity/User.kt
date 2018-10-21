package com.common.daggertest.entity

import com.common.daggertest.db.AppDataBase
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel
import java.io.Serializable
import java.util.*

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
@Table(database = AppDataBase::class)
class User : BaseModel(), Serializable {
    @Column
    @PrimaryKey
    var id: Long = Random().nextLong()

    @Column
    var lastSync: Long = System.currentTimeMillis()

    override fun toString(): String {
        return "User[id = $id, lastSync = $lastSync]"
    }
}