package com.kanneki.fooddemo.data.dto

import com.google.gson.annotations.SerializedName

data class ProductTypeDataDto(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Name")
    val name: String?,
    @SerializedName("TypeId")
    val typeId: Int
)
