package com.codechallenge.nytimes.dao.repository

import com.codechallenge.nytimes.dao.datasource.ArticleDataSource
import com.codechallenge.nytimes.domain.Result
import com.codechallenge.nytimes.model.ArticleResult

class ArticleRepositoryImpl(private val articleDataSource: ArticleDataSource) : ArticleRepository
{
    override suspend fun getArticlesList(): Result<ArticleResult> = articleDataSource.getArticlesList()

}