package com.codechallenge.nytimes.model

import com.google.gson.annotations.SerializedName

class ArticleResult
{
    @SerializedName("status")
    val status: String? = null

    @SerializedName("copyright")
    val copyright: String? = null

    @SerializedName("num_results")
    val numResults = 0

    @SerializedName("results")
    val lstResults: ArrayList<Article>? = null
}