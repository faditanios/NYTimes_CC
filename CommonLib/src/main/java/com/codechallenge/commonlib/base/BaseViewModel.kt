package com.codechallenge.commonlib.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel(val domain: BaseDomain) : ViewModel()
{
    protected var result: LiveData<*>? = null

    fun getResultLiveData(): LiveData<*>?
    {
        return result
    }
}