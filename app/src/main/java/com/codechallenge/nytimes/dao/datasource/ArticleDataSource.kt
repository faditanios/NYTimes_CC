package com.codechallenge.nytimes.dao.datasource

import com.codechallenge.commonlib.api.RetrofitAPIClient
import com.codechallenge.nytimes.BuildConfig
import com.codechallenge.nytimes.domain.Result
import com.codechallenge.nytimes.model.ArticleResult
import com.codechallenge.nytimes.util.api.RetrofitAPIInterface

class ArticleDataSource
{
    private val apiService =
        RetrofitAPIClient.buildService(RetrofitAPIInterface::class.java, BuildConfig.API_URL)

    suspend fun getArticlesList(): Result<ArticleResult>
    {
        val response = apiService.getArticleResult(
            BuildConfig.section,
            BuildConfig.period,
            BuildConfig.API_KEY
        )
        return if (response.isSuccessful)
            Result.Success(response.body() as ArticleResult)
        else
            Result.Failure(Exception("Bad request/response"))
    }
}