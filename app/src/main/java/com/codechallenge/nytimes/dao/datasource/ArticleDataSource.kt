package com.codechallenge.nytimes.dao.datasource

import com.codechallenge.nytimes.BuildConfig
import com.codechallenge.nytimes.domain.Result
import com.codechallenge.nytimes.model.ArticleResult
import com.codechallenge.nytimes.util.api.RetrofitAPIInterface
import retrofit2.Retrofit

class ArticleDataSource(private val retrofit: Retrofit)
{
    private val apiService = retrofit.create(RetrofitAPIInterface::class.java)

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