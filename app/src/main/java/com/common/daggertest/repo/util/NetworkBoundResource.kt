//package com.common.daggertest.repo
//
//import android.annotation.SuppressLint
//import android.arch.lifecycle.LiveData
//import android.os.AsyncTask
//import android.support.annotation.MainThread
//import android.support.annotation.WorkerThread
//import com.common.daggertest.repo.util.Resource
//
///**
// * Created by Kirill Stoianov on 20/10/2018.
// */
//abstract class NetworkBoundResource<ResultType, RequestType> @MainThread
//protected constructor() {
//
//    private val result = MediatorLiveData()
//
//    private val compositeDisposable = CompositeDisposable()
//
//    //        Log.wtf(TAG, "getAsLiveData() called");
//    //clear composite disposable
//    val asLiveData: LiveData<Resource<ResultType>>
//        get() {
//            compositeDisposable.clear()
//
//            return result
//        }
//
//    // Called to save the result of the API response into the database
//    @WorkerThread
//    protected abstract fun saveCallResult(data: RequestType)
//
//    // Called with the data in the database to decide whether it should be
//    // fetched from the network.
//    @MainThread
//    protected abstract fun shouldFetch(data: ResultType?): Boolean
//
//    // Called to get the cached data from the database
//    @MainThread
//    protected abstract fun loadFromDb(): LiveData<ResultType>
//
//    // Called to create the API call.
//    @MainThread
//    protected abstract fun createCall(): LiveData<Observable<Response<RequestType>>>
//
//    // Called when the fetch fails. The child class may want to reset components
//    // like rate limiter.
//    @MainThread
//    protected abstract fun onFetchFailed(throwable: Throwable)
//
//
//    init {
//        result.setValue(Resource.loading<Any>(null))
//        val dbSource = loadFromDb()
//
//        result.addSource(dbSource, { data ->
//            result.removeSource(dbSource)
//
//            if (shouldFetch(data)) {
//                fetchFromNetwork(dbSource)
//            } else {
//                result.addSource(dbSource,
//                        //                        newData -> result.setValue(Resource.success(newData)));  original code line
//                        { newData ->
//                            if (newData == null) {
//                                this@NetworkBoundResource.result.setValue(Resource.empty<Any>())
//                            } else {
//                                this@NetworkBoundResource.result.setValue(Resource.success(newData))
//                            }
//                        })
//            }
//        })
//    }
//
//    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
//        //        Log.wtf(TAG, "fetchFromNetwork() called with: dbSource = [" + dbSource + "]");
//        val apiResponse = createCall()
//        // we re-attach dbSource as a new source,
//        // it will dispatch its latest value quickly
//        result.addSource(dbSource, { newData -> result.setValue(Resource.loading(newData)) })
//        result.addSource(apiResponse, { observer ->
//
//            result.removeSource(apiResponse)
//            result.removeSource(dbSource)
//
//            //return if observable is null
//            if (observer == null) {
//                result.setValue(Resource.error<Any>(Throwable("Api response observer is null.")))
//                return@result.addSource
//            }
//
//            observer!!
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .unsubscribeOn(Schedulers.io())
//                    .doOnSubscribe({ disposable -> compositeDisposable.add(disposable) })
//                    .subscribe(
//                            ???({ this.saveResultAndReInit(it) }),
//            { throwable ->
//                onFetchFailed(throwable)
//                //original string
//                //result.addSource(dbSource, newData -> result.setValue(Resource.error(throwable)));
//
//                //put error to result
//                result.setValue(Resource.error(throwable))
//
//                //put cached data to result if it exist
//                result.addSource(dbSource, { newData ->
//                    if (newData == null) {
//                        result.setValue(Resource.empty<Any>())
//                    } else {
//                        result.setValue(Resource.success(newData))
//                    }
//                })
//            }
//            )
//        })
//    }
//
//    @MainThread
//    private fun saveResultAndReInit(response: Response<RequestType>) {
//        //        Log.wtf(TAG, "saveResultAndReInit() called with: response = [" + response + "]");
//        UpdateAsync(response).dbQuery()
//    }
//
//    @SuppressLint("StaticFieldLeak")
//    internal inner class UpdateAsync(private val response: Response<RequestType>) : AsyncTask<Void, Void, Void>() {
//
//        override fun doInBackground(vararg voids: Void): Void? {
//            val body = response.body()
//            if (body != null) this@NetworkBoundResource.saveCallResult(body!!)
//            return null
//        }
//
//        override fun onPostExecute(aVoid: Void) {
//            // we specially request a new live data,
//            // otherwise we will get immediately last cached value,
//            // which may not be updated with latest results received from network.
//
//            //if database value is null just send empty result
//            //otherwise return existing value
//            val resultTypeLiveData = loadFromDb()
//
//            this@NetworkBoundResource.result.addSource(resultTypeLiveData,
//                    { newData ->
//                        if (newData == null) {
//                            this@NetworkBoundResource.result.setValue(Resource.empty<Any>())
//                        } else {
//                            this@NetworkBoundResource.result.setValue(Resource.success(newData))
//                        }
//                    })
//        }
//    }
//
//    companion object {
//
//        private val TAG = NetworkBoundResource<*, *>::class.java.simpleName
//    }
//}