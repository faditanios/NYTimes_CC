package com.codechallenge.nytimes.dao.repository

import android.util.Log
import com.codechallenge.commonlib.api.RetrofitAPIClient
import com.codechallenge.commonlib.base.BaseRepository
import com.codechallenge.nytimes.BuildConfig
import com.codechallenge.nytimes.util.api.RetrofitAPIInterface

class ArticleRepository : BaseRepository()
{
    val TAG = "NYT"
    private val apiService =
        RetrofitAPIClient.buildService(RetrofitAPIInterface::class.java, BuildConfig.API_URL)

    override suspend fun search()
    {
        val response = apiService.getArticleResult(
            BuildConfig.section,
            BuildConfig.period,
            BuildConfig.API_KEY
        )
        if (response.isSuccessful)
        {
            result.postValue(response.body()!!)
        }
    }
}