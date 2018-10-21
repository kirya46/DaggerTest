package com.common.daggertest.db

import android.content.Context
import com.common.daggertest.db.AppDataBase.Companion.DB_NAME
import com.common.daggertest.db.AppDataBase.Companion.DB_VERSION
import com.raizlabs.android.dbflow.annotation.Database
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowManager


/**
 * Created by Kirill Stoianov on 22/07/18.
 */
@Database(name = DB_NAME, version = DB_VERSION)
class AppDataBase(context: Context) {

    init {
        FlowManager.init(FlowConfig.Builder(context).build())
    }

    companion object {
        const val DB_NAME = "db-dagger-test-app"
        const val DB_VERSION = 1
    }
}
