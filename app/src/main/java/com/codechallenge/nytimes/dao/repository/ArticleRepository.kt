package com.codechallenge.nytimes.dao.repository

import com.codechallenge.nytimes.model.ArticleResult
import com.codechallenge.nytimes.domain.Result

interface ArticleRepository
{
    suspend fun getArticlesList(): Result<ArticleResult>
}