package com.kanneki.fooddemo.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kanneki.fooddemo.domain.model.ProductData
import com.kanneki.fooddemo.domain.model.ProductTypeData
import com.kanneki.fooddemo.domain.repository.GetProductTypeRepository
import com.kanneki.fooddemo.domain.repository.GetProductsRepository
import com.kanneki.fooddemo.domain.util.Resource
import com.kanneki.fooddemo.domain.util.toProductData
import com.kanneki.fooddemo.domain.util.toProductTypeData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val productsRepository: GetProductsRepository,
    private val typeRepository: GetProductTypeRepository,
) : ViewModel() {

    /**
     * 全部商品資料
     */
    var products = mutableStateListOf<ProductData>()
        private set

    /**
     * 篩選後的商品資料
     */
    var findProducts = mutableStateListOf<ProductData>()
        private set

    /**
     * Tab列資料
     */
    var types = mutableStateListOf<ProductTypeData>()
        private set

    /**
     * 訂單資料
     */
    private var orderProduct = mutableListOf<ProductData>()

    var isLoading by mutableStateOf(false)
        private set

    /**
     * tab選中的Index
     */
    var tabIndex by mutableStateOf(0)
        private set

    var keyWord by mutableStateOf("")
        private set

    /**
     * 取得商品列表
     */
    fun getProducts() {
        viewModelScope.launch {
            productsRepository.getProducts().collect { result ->
                isLoading = (result is Resource.Loading)
                when (result) {
                    is Resource.Loading -> Unit
                    is Resource.Success -> {
                        products.clear()
                        result.data?.map { it.toProductData() }?.let(products::addAll)
                        getTypeProducts()
                    }
                    is Resource.Error -> {}
                }
            }
        }
    }

    /**
     * 取得商品類別
     */
    fun getTypes() {
        viewModelScope.launch {
            typeRepository.getProductType().collect { result ->
                when (result) {
                    is Resource.Loading -> Unit
                    is Resource.Success -> {
                        types.clear()
                        result.data?.map { it.toProductTypeData() }?.let(types::addAll)
                    }
                    is Resource.Error -> {
                    }
                }
            }
        }
    }

    /**
     * 取得特定類別商品
     */
    private fun getTypeProducts() {
        findProducts.clear()
        when {
            tabIndex == 0 && keyWord.trim().isBlank() -> products
            tabIndex == 0 -> products.filter { it.name.indexOf(keyWord.trim()) >= 0 }
            tabIndex != 0 && keyWord.trim().isBlank() -> {
                products.filter { it.typeId == types[tabIndex].typeId }
            }
            else -> {
                products.filter {
                    it.typeId == types[tabIndex].typeId &&
                            it.name.indexOf(keyWord.trim()) >= 0
                }
            }
        }.also(findProducts::addAll)
    }

    /**
     * 訂單商品資料寫入
     */
    fun setProductListData(data: ProductData) {
        orderProduct.find { it.id == data.id }?.let {
            orderProduct.remove(it)
            if (data.count != 0) {
                orderProduct.add(data)
            }
        } ?: run {
            orderProduct.add(data)
        }
    }

    /**
     * 更新訂單資料
     */
    fun setNewOrderList(list: MutableList<ProductData>) {
        orderProduct = list
    }

    /**
     * 取得訂單資料
     */
    fun getOrderList() = orderProduct

    /**
     * 儲存新的Tab Index
     */
    fun setNewTabIndex(index: Int) {
        tabIndex = index
        getTypeProducts()
    }

    /**
     * 設定新的Keyword
     */
    fun setNewKeyWord(value: String) {
        keyWord = value
        getTypeProducts()
    }
}