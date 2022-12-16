package com.kanneki.fooddemo.domain.repository

import com.kanneki.fooddemo.data.dto.ProductDataDto
import com.kanneki.fooddemo.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface GetProductsRepository {

    /**
     * 獲取全部商品
     */
    fun getProducts(): Flow<Resource<List<ProductDataDto>>>

    /**
     * 查詢[id]商品資料
     */
    fun getProduct(id: Int): Flow<Resource<ProductDataDto>>
}