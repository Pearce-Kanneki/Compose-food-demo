package com.kanneki.fooddemo.presentation.shoppingcar.components

sealed class ShoppingItemEvent {
    data class Add(val count: Int = 1) : ShoppingItemEvent()
    data class Reduce(val count: Int = -1) : ShoppingItemEvent()
    object Remove : ShoppingItemEvent()
}
