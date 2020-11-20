package com.codechallenge.commonlib.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel(val repository: BaseRepository) : ViewModel()
{
    protected var result: LiveData<*>? = null

    fun search()
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository?.search()
        }
    }

    fun getResultLiveData(): LiveData<*>?
    {
        return result
    }
}