package com.codechallenge.commonlib.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope
{
    //    protected var result: LiveData<*>? = null
//
//    fun getResultLiveData(): LiveData<*>?
//    {
//        return result
//    }
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + SupervisorJob()

    override fun onCleared()
    {
        super.onCleared()
        coroutineContext.cancel()
    }
}