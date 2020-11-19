package com.codechallenge.nytimes.util.api

import com.codechallenge.nytimes.model.ArticleResult
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitAPIInterface
{
    @GET("svc/mostpopular/v2/mostviewed/{section}/{period}.json")
    suspend fun getArticleResult(
        @Path("section") section: String,
        @Path("period") period: String,
        @Query("api-key") apiKey: String
    ): Response<ArticleResult>

}