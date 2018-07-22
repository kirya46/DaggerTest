package com.common.daggertest.util

import android.content.Context
import android.content.SharedPreferences
import com.common.daggertest.AppController

/**
 * Created by Kirill Stoianov on 22/07/18.
 */
class AppPreferences constructor(appController: AppController) {

    var mPrefs: SharedPreferences = appController.getSharedPreferences(appController.packageName, Context.MODE_PRIVATE)


    fun saveLastSync(timeStamp: Long) {
        mPrefs.edit().putLong("timeStamp", timeStamp).apply()
    }

    fun getLastSync(): Long {
        return mPrefs.getLong("timeStamp", -1)
    }
}