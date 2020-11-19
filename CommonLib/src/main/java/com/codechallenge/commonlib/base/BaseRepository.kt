package com.codechallenge.commonlib.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class BaseRepository
{
    protected var result = MutableLiveData<Any?>()

    fun getResultLiveData(): LiveData<*>?
    {
        return result
    }

    abstract suspend fun search()

}