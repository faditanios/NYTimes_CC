package com.codechallenge.nytimes.ui.articles.viewmodel

import com.codechallenge.commonlib.base.BaseViewModel
import com.codechallenge.nytimes.dao.repository.ArticlesRepository

class ArticlesListViewModel : BaseViewModel()
{
    init
    {
        repository = ArticlesRepository()
        result = repository!!.getResultLiveData()
    }

}