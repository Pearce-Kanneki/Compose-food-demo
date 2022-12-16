package com.kanneki.fooddemo.domain.repository

import com.kanneki.fooddemo.data.dto.ProductTypeDataDto
import com.kanneki.fooddemo.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface GetProductTypeRepository {

    /**
     * 取得商品分類名稱
     */
    fun getProductType(): Flow<Resource<List<ProductTypeDataDto>>>
}