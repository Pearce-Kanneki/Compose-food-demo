package com.kanneki.fooddemo.presentation.productdetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kanneki.fooddemo.domain.model.ProductData
import com.kanneki.fooddemo.domain.repository.GetProductsRepository
import com.kanneki.fooddemo.domain.util.Resource
import com.kanneki.fooddemo.domain.util.toProductData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productsRepository: GetProductsRepository
): ViewModel() {

    /**
     * 產品資料
     */
    var valueData by mutableStateOf<ProductData?>(null)

    /**
     * 產品購買數量
     */
    var productCount by mutableStateOf(1)

    fun setProductData(id: Int, data: ProductData?) {
        data?.let {
            valueData = it
        } ?: run {
            getProduct(id)
        }
    }

    /**
     * 增加/減少商品數量
     */
    fun modifyProductCount(value: Int) {
        if (productCount + value !in 1..99) return
        productCount += value
    }

    /**
     * 取得[id]商品資料
     */
    private fun getProduct(id: Int) {
        viewModelScope.launch {
            productsRepository.getProduct(id).collect{
                when(it) {
                    is Resource.Loading -> Unit
                    is Resource.Success -> {
                        valueData = it.data?.toProductData()
                    }
                    is Resource.Error -> {}
                }
            }
        }
    }
}