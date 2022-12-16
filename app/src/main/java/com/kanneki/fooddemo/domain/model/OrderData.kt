package com.kanneki.fooddemo.domain.model

data class OrderData(
    /**
     * 訂單編號
     */
    val id:Int = 0,
    /**
     * 日期
     */
    val date: String = "",
    /**
     * 總金額
     */
    val total: Int = 0,
    /**
     * 備註
     */
    val desc: String = "",
    /**
     * 選擇商品
     */
    val products: List<ProductData> = listOf(),
    /**
     * 進度
     */
    val type: Int = 0
)
