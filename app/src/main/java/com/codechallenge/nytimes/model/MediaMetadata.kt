package com.codechallenge.nytimes.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MediaMetadata : Serializable
{
    @SerializedName("url")
    val url: String? = null

    @SerializedName("format")
    val format: String? = null

    @SerializedName("height")
    val height = 0

    @SerializedName("width")
     val width = 0
}