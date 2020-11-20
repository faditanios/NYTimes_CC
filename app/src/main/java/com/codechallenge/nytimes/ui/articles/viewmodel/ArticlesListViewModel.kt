package com.codechallenge.nytimes.ui.articles.viewmodel

import androidx.lifecycle.viewModelScope
import com.codechallenge.commonlib.base.BaseViewModel
import com.codechallenge.nytimes.domain.ArticleDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticlesListViewModel(articleDomain: ArticleDomain) : BaseViewModel(articleDomain)
{
    init
    {
        result = articleDomain?.getResultLiveData()
        viewModelScope.launch(Dispatchers.IO) { articleDomain.search() }

    }

}