package com.kanneki.fooddemo.domain.model

data class ProductData(
    /**
     * 商品ID
     */
    val id: Int,
    /**
     * 商品名稱
     */
    val name: String,
    /**
     * 商品說明
     */
    val desc: String,
    /**
     * 商品價錢
     */
    val price: Int,
    /**
     * 商品購買數量
     */
    val count: Int,
    /**
     * 商品圖片
     */
    val image: String,
    /**
     * 商品類別
     */
    val typeId: Int

)
