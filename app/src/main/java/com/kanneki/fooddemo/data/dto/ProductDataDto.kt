package com.kanneki.fooddemo.data.dto

import com.google.gson.annotations.SerializedName

data class ProductDataDto(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Name")
    val name: String?,
    @SerializedName("Desc")
    val desc: String?,
    @SerializedName("Price")
    val price: Int?,
    @SerializedName("Type")
    val type: Int,
    @SerializedName("Image")
    val image: String?
)
