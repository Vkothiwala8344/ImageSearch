package com.example.imagesearch.model

import android.graphics.ColorSpace.Rgb
import com.example.imagesearch.Hsv
import com.google.gson.annotations.SerializedName

data class Image(

    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("userName")
    var userName: String? = null,

    @SerializedName("numViews")
    var numViews: Int = 0,

    @SerializedName("numVotes")
    var numVotes: Int = 0,

    @SerializedName("numComments")
    var numComments: Int = 0,

    @SerializedName("numHearts")
    var numHearts: Int = 0,

    @SerializedName("rank")
    var rank: Int = 0,

    @SerializedName("dateCreated")
    var dateCreated: String? = null,

    @SerializedName("hex")
    var hex: String? = null,

    @SerializedName("rgb")
    var rgb: Rgb? = null,

    @SerializedName("hsv")
    var hsv: Hsv? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("imageUrl")
    var imageUrl: String? = null,

    @SerializedName("badgeUrl")
    var badgeUrl: String? = null,

    @SerializedName("apiUrl")
    var apiUrl: String? = null
)

