package com.kanneki.fooddemo.presentation.products.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.kanneki.fooddemo.R
import com.kanneki.fooddemo.data.util.FakeDataUtil
import com.kanneki.fooddemo.domain.model.ProductData
import com.kanneki.fooddemo.domain.model.ProductTypeData
import com.kanneki.fooddemo.domain.util.toProductData
import com.kanneki.fooddemo.presentation.products.components.ProductItem

@Composable
fun ProductsListScreen(
    tabIndex: Int,
    tabs: List<ProductTypeData>,
    products: List<ProductData>,
    changeTabIndex: (Int) -> Unit,
    changeDetailScreen: (Int) -> Unit
) {

    Column(modifier = Modifier.fillMaxSize()) {
        ScrollableTabRow(
            selectedTabIndex = tabIndex,
            edgePadding = 0.dp,
            backgroundColor = Color.White,
            divider = {
                TabRowDefaults.Divider(
                    thickness = 3.dp,
                    color = Color.LightGray
                )
            },
            indicator = { tabPosition ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPosition[tabIndex]),
                    height = 3.dp,
                    color = colorResource(id = R.color.purple_500)
                )
            }
        ) {
            tabs.forEachIndexed { index, data ->
                Tab(
                    selected = tabIndex == index,
                    onClick = { changeTabIndex(index) },
                    text = { Text(text = data.name) }
                )
            }
        }

        if (products.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {

                products.forEach { data ->
                    item {
                        ProductItem(
                            data = data,
                            onClick = { id ->
                                changeDetailScreen(id)
                            }
                        )
                    }
                }
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubcomposeAsyncImage(
                    model = "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/cactus.png",
                    contentDescription = "empty",
                    loading = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(modifier = Modifier.size(50.dp))
                        }
                    },
                    modifier = Modifier.size(200.dp)
                )
                Text(
                    text = stringResource(id = R.string.empty_products),
                    style = MaterialTheme.typography.h6
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsListScreenPreview() {
    ProductsListScreen(
        0,
        listOf(
            ProductTypeData("Test A", 1),
            ProductTypeData("Test B", 1),
            ProductTypeData("Test C", 1),
            ProductTypeData("Test D", 1),
            ProductTypeData("Test E", 1)
        ),
        FakeDataUtil.fakeProductList.subList(0, 4).map { it.toProductData() },
        {},
        {}
    )
}