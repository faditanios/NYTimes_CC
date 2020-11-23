package com.codechallenge.nytimes.ui.articles.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.codechallenge.commonlib.base.BaseViewModel
import com.codechallenge.nytimes.domain.usecases.GetArticlesListUseCase
import com.codechallenge.nytimes.model.ArticleResult
import com.codechallenge.nytimes.util.api.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.codechallenge.nytimes.domain.Result
import com.codechallenge.nytimes.util.api.State

class ArticlesListViewModel(val getArticlesList: GetArticlesListUseCase) : BaseViewModel()
{
    private var mutableResult: MutableLiveData<State<ArticleResult>> = MutableLiveData()

    val result: LiveData<State<ArticleResult>>
        get()
        {
            return mutableResult
        }

    init
    {
        search()
    }

    fun search()
    {
        viewModelScope.launch {
            mutableResult.value = State(responseType = Status.LOADING)
            when (val result = withContext(Dispatchers.IO) { getArticlesList() })
            {
                is Result.Failure ->
                {
                    mutableResult.value =
                        State(responseType = Status.ERROR, error = result.exception)
                }
                is Result.Success ->
                {
                    mutableResult.value = State(responseType = Status.SUCCESSFUL, data = result.data)
                }
            }
        }
    }

}