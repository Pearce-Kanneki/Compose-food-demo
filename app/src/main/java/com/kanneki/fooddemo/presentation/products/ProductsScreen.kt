package com.kanneki.fooddemo.presentation.products

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kanneki.fooddemo.data.repository.GetProductRepositoryImp
import com.kanneki.fooddemo.data.repository.GetProductTypeRepositoryImp
import com.kanneki.fooddemo.presentation.MainViewModel
import com.kanneki.fooddemo.presentation.products.components.ProductHead
import com.kanneki.fooddemo.presentation.products.screen.LoadingScreen
import com.kanneki.fooddemo.presentation.products.screen.ProductsListScreen
import com.kanneki.fooddemo.presentation.util.ScreenTag

@Composable
fun ProductsScreen(nav: NavHostController, mainViewModel: MainViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        ProductHead(
            mainViewModel.keyWord,
            onSearchCallBack = {
                mainViewModel.setNewKeyWord(it)
            },
            onChangeScreen = { screenTag ->
                nav.navigate(screenTag)
            }
        )
        Spacer(modifier = Modifier.height(8.dp))

        if (mainViewModel.isLoading) {
            LoadingScreen()
        } else {
            ProductsListScreen(
                mainViewModel.tabIndex,
                mainViewModel.types,
                mainViewModel.findProducts,
                changeTabIndex = {
                    mainViewModel.setNewTabIndex(it)
                },
                changeDetailScreen = {
                    nav.navigate("${ScreenTag.SCREEN_PRODUCT_DETAIL}/$it")
                }
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProductsScreenPreview() {
    val nav = rememberNavController()
    val viewModel: MainViewModel = hiltViewModel()
    ProductsScreen(nav, viewModel)
}