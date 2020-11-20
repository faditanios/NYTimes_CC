package com.codechallenge.nytimes.ui.articles.viewmodel

import com.codechallenge.commonlib.base.BaseRepository
import com.codechallenge.commonlib.base.BaseViewModel
import com.codechallenge.nytimes.dao.repository.ArticleRepository

class ArticlesListViewModel(repository: ArticleRepository) : BaseViewModel(repository)
{
    init
    {
        result = repository?.getResultLiveData()
        search()
    }

}