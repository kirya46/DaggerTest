package com.common.daggertest.repo.util

/**
 * Created by Kirill Stoianov on 20/10/2018.
 */
class DataResource<T> private constructor(val status: Status, val data: T?, val error: Throwable?) {


    val isSuccess: Boolean
        get() = this.status == Status.SUCCESS

    override fun toString(): String {
        return "Resource{" +
                "status=" + status +
                ", data=" + data +
                ", error=" + error +
                '}'.toString()
    }

    companion object {

        private val TAG = DataResource::class.java.simpleName

        fun <T> success(data: T): DataResource<T> {
            return DataResource(Status.SUCCESS, data, null)
        }

        fun <T> error(error: Throwable): DataResource<T> {
            return DataResource<T>(Status.ERROR, null, error)
        }

        fun <T> empty(): DataResource<T> {
            return DataResource<T>(Status.EMPTY, null, null)
        }

        fun <T> loading(data: T?): DataResource<T> {
            return DataResource(Status.LOADING, data, null)
        }
    }
}