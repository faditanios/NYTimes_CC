package com.codechallenge.commonlib.base

import androidx.lifecycle.LiveData

abstract class BaseDomain
{
    abstract suspend fun search()

    abstract fun getResultLiveData(): LiveData<*>?
}