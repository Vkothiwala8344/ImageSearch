package com.example.imagesearch.model

import com.google.gson.annotations.SerializedName

data class Rgb(

    @SerializedName("red")
    var red: Int = -1,

    @SerializedName("green")
    var green: Int = -1,

    @SerializedName("blue")
    var blue: Int = -1
)
