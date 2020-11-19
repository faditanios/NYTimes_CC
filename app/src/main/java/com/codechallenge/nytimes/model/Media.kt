package com.codechallenge.nytimes.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

// codebeat:disable[TOO_MANY_IVARS]
class Media : Serializable
{
    @SerializedName("type")
    var type: String? = null

    @SerializedName("subtype")
    var subtype: String? = null

    @SerializedName("caption")
    var caption: String? = null

    @SerializedName("copyright")
    var copyright: String? = null

    @SerializedName("approved_for_syndication")
    var approvedForSyndication = 0

    @SerializedName("media-metadata")
    var lstMediaMetadata: ArrayList<MediaMetadata>? = null
}