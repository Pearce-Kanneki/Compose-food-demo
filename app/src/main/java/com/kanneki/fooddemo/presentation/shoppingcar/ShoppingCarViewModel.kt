package com.kanneki.fooddemo.presentation.shoppingcar

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.kanneki.fooddemo.domain.model.ProductData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShoppingCarViewModel @Inject constructor(): ViewModel() {

    var state = mutableStateListOf<ProductData>()
        private set

    /**
     * [state] 設定初始值
     */
    fun initState(value: List<ProductData>) {
        state.clear()
        state.addAll(value)
    }

    /**
     * 總和
     */
    fun stateSum(): Int {
        return state.sumOf { it.price * it.count }
    }

    /**
     * 修改數量
     *
     * @param index 位置
     * @param count 增加/減少數量
     */
    fun modifyStateData(index: Int, count: Int) {
        if (state[index].count + count !in 1..99) return
        state[index] = state[index].copy(count = state[index].count + count)
    }

    /**
     *  刪除特定資料
     *
     *  @param index 位置
     */
    fun removeStateItem(index: Int) {
        state.removeAt(index)
    }
}