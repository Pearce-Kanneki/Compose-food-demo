package com.kanneki.fooddemo.data.repository

import com.kanneki.fooddemo.data.dto.ProductDataDto
import com.kanneki.fooddemo.data.util.FakeDataUtil
import com.kanneki.fooddemo.domain.repository.GetProductsRepository
import com.kanneki.fooddemo.domain.util.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductRepositoryImp @Inject constructor() : GetProductsRepository {

    override fun getProducts(): Flow<Resource<List<ProductDataDto>>> {
        return flow {
            emit(Resource.Loading())
            try {
                delay(1500) // 模擬延遲
                emit(Resource.Success(FakeDataUtil.fakeProductList))
            } catch (e: Exception) {
                emit(Resource.Error("因一些原因暫時取不到資料"))
            }
        }
    }

    override fun getProduct(id: Int): Flow<Resource<ProductDataDto>> {
        return flow {
            emit(Resource.Loading())
            try {
                delay(800) // 模擬延遲
                FakeDataUtil.fakeProductList.find { it.id == id }?.also { data ->
                    emit(Resource.Success(data))
                } ?: kotlin.run {
                    emit(Resource.Error("查無此商品"))
                }
            } catch (e: Exception) {
                emit(Resource.Error("因一些原因暫時取不到資料"))
            }
        }

    }
}