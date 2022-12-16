package com.kanneki.fooddemo.data.repository

import com.kanneki.fooddemo.data.dto.ProductTypeDataDto
import com.kanneki.fooddemo.data.util.FakeDataUtil
import com.kanneki.fooddemo.domain.repository.GetProductTypeRepository
import com.kanneki.fooddemo.domain.util.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductTypeRepositoryImp @Inject constructor() : GetProductTypeRepository {

    override fun getProductType(): Flow<Resource<List<ProductTypeDataDto>>> {
        return flow {
            emit(Resource.Loading())
            try {
                delay(300) // 延遲模擬
                emit(Resource.Success(FakeDataUtil.fakeProductTypeList))
            } catch (e: Exception) {
                emit(Resource.Error("因一些原因暫時取不到資料"))
            }
        }
    }
}