package com.codechallenge.nytimes.ui.articles.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codechallenge.commonlib.base.BaseViewModel
import com.codechallenge.nytimes.domain.usecases.GetArticlesListUseCase
import com.codechallenge.nytimes.model.ArticleResult
import com.codechallenge.nytimes.util.api.Data
import com.codechallenge.nytimes.util.api.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.codechallenge.nytimes.domain.Result

class ArticlesListViewModel(val getArticlesList: GetArticlesListUseCase) : BaseViewModel()
{
    private var mutableMainState: MutableLiveData<Data<ArticleResult>> = MutableLiveData()

    val mainState: LiveData<Data<ArticleResult>>
        get()
        {
            return mutableMainState
        }


    fun search() = launch {
        mutableMainState.value = Data(responseType = Status.LOADING)
        when (val result = withContext(Dispatchers.IO) { getArticlesList() })
        {
            is Result.Failure ->
            {
                mutableMainState.value = Data(responseType = Status.ERROR, error = result.exception)
            }
            is Result.Success ->
            {
                mutableMainState.value = Data(responseType = Status.SUCCESSFUL, data = result.data)
            }
        }
    }


    init
    {
        search()
    }

}