package com.common.daggertest.db

import android.content.Context
import com.common.daggertest.entity.User

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
class AppDataBase constructor(context: Context) {

    val dbName = "db-" + context.packageName
    fun saveUser(user: User): Boolean = true
}