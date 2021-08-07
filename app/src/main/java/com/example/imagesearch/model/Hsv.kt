package com.example.imagesearch

import com.google.gson.annotations.SerializedName

data class Hsv(

    @SerializedName("hue")
    var hue: Int = 0,

    @SerializedName("saturation")
    var saturation: Int = 0,

    @SerializedName("value")
    var value: Int = 0
)