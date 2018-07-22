package com.common.daggertest.util

import javax.inject.Inject

/**
 * Created by Kirill Stoianov on 21/07/18.
 */
class AnyFactory @Inject constructor(){
    fun getMessage():String = "Some text"
}