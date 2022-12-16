package com.kanneki.fooddemo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kanneki.fooddemo.R
import com.kanneki.fooddemo.presentation.message.MessageScreen
import com.kanneki.fooddemo.presentation.productdetail.ProductDetailScreen
import com.kanneki.fooddemo.presentation.products.ProductsScreen
import com.kanneki.fooddemo.presentation.shoppingcar.ShoppingCarScreen
import com.kanneki.fooddemo.presentation.ui.theme.FoodDemoTheme
import com.kanneki.fooddemo.presentation.util.ScreenTag
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FoodDemoTheme {
                val viewModel: MainViewModel = hiltViewModel()
                val navController = rememberNavController()

                viewModel.getTypes()
                viewModel.getProducts()

                NavHost(
                    navController = navController,
                    startDestination = ScreenTag.SCREEN_PRODUCTS
                ) {
                    composable(ScreenTag.SCREEN_PRODUCTS) {
                        ProductsScreen(navController, viewModel)
                    }
                    composable(ScreenTag.SCREEN_PRODUCT_DETAIL) {
                        MessageScreen(message = stringResource(id = R.string.null_product))
                    }
                    composable(
                        "${ScreenTag.SCREEN_PRODUCT_DETAIL}/{id}",
                        arguments = listOf(
                            navArgument("id") {
                                type = NavType.IntType
                                nullable = false
                            }
                        )
                    ) {
                        val id = it.arguments?.getInt("id")
                        if (id != null) {
                            ProductDetailScreen(
                                navController,
                                id = id,
                                data = viewModel.products.find { data -> data.id == id },
                                onAddCar = { data ->
                                    viewModel.setProductListData(data)
                                }
                            )
                        } else {
                            MessageScreen(message = stringResource(id = R.string.null_product))
                        }
                    }
                    composable(ScreenTag.SCREEN_SHOPPING_CAR) {
                        ShoppingCarScreen(
                            nav = navController,
                            viewModel.getOrderList(),
                            onChange = {
                                viewModel.setNewOrderList(it)
                            }
                        )
                    }
                }
            }
        }
    }
}

