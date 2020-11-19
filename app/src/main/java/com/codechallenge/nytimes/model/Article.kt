package com.codechallenge.nytimes.model

import android.widget.ImageView
import com.google.gson.annotations.SerializedName
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import java.io.Serializable
import java.util.*

// codebeat:disable[TOO_MANY_IVARS]
class Article : Serializable
{
    @SerializedName("uri")
    var uri: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("id")
    var id: String? = null

    @SerializedName("asset_id")
    var assetId: String? = null

    @SerializedName("source")
    var source: String? = null

    @SerializedName("published_date")
    var publishedDate: String? = null

    @SerializedName("updated")
    var updated: String? = null

    @SerializedName("section")
    var section: String? = null

    @SerializedName("subsection")
    var subsection: String? = null

    @SerializedName("nytdsection")
    var nytdsection: String? = null

    @SerializedName("adx_keywords")
    var adxKeywords: String? = null

    @SerializedName("column")
    var column: String? = null

    @SerializedName("byline")
    var byline: String? = null

    @SerializedName("type")
    var type: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("abstract")
    var abstractText: String? = null

    @SerializedName("des_facet")
    var lstDesFacet: ArrayList<String>? = null

    @SerializedName("org_facet")
    var lstOrgFacet: ArrayList<String>? = null

    @SerializedName("per_facet")
    var lstPerFacet: ArrayList<String>? = null

    @SerializedName("media")
    var lstMedia: ArrayList<Media>? = null

    @SerializedName("eta_id")
    var etaId: String? = null

    // important code for loading image here
    fun loadMedia(imageView: ImageView, defaultDrawable: Int)
    {
        val url = getMediaURL()
        if (url!!.length > 0) Picasso.with(imageView.context).load(url)
            .transform(CropCircleTransformation())
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(imageView) else Picasso.with(imageView.context).load(defaultDrawable)
            .transform(CropCircleTransformation())
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).into(imageView)
    }

    fun getMediaURL(): String?
    {
        var mediaUrl: String? = null
        if (lstMedia!!.size > 0)
        {
            val media = lstMedia!![0]
            if (media.lstMediaMetadata != null && media.lstMediaMetadata!!.size > 0)
            {
                val mm: MediaMetadata = media.lstMediaMetadata!![0]
                mediaUrl = mm.url
            }
        }
        return mediaUrl
    }



}