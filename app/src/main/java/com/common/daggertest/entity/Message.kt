package com.common.daggertest.entity

import com.common.daggertest.db.AppDataBase
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel
import java.util.*

/**
 * Created by Kirill Stoianov on 20/10/2018.
 */
@Table(database = AppDataBase::class)
class Message : BaseModel() {
    @Column
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()

    @Column
    var content: String? = null
}