package com.codechallenge.nytimes.domain

import androidx.lifecycle.LiveData
import com.codechallenge.commonlib.base.BaseDomain
import com.codechallenge.nytimes.dao.repository.ArticleRepository

class ArticleDomain(val repository: ArticleRepository): BaseDomain(repository)
{
    override fun getResultLiveData(): LiveData<*>?
    {
        return repository.getResultLiveData()
    }

    override suspend fun search()
    {
        repository.search()
    }
}