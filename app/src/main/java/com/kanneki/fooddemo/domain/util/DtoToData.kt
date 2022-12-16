package com.kanneki.fooddemo.domain.util

import com.kanneki.fooddemo.data.dto.ProductDataDto
import com.kanneki.fooddemo.data.dto.ProductTypeDataDto
import com.kanneki.fooddemo.domain.model.ProductData
import com.kanneki.fooddemo.domain.model.ProductTypeData

fun ProductDataDto.toProductData() = ProductData(
    id = id,
    name = name ?: "",
    desc = desc ?: "",
    price = price ?: 0,
    count = 0,
    image = image ?: "",
    typeId = type
)

fun ProductTypeDataDto.toProductTypeData() = ProductTypeData(
    name = name ?: "",
    typeId = typeId
)