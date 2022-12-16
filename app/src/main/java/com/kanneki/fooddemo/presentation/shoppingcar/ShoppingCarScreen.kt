package com.kanneki.fooddemo.presentation.shoppingcar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.SubcomposeAsyncImage
import com.kanneki.fooddemo.R
import com.kanneki.fooddemo.domain.model.ProductData
import com.kanneki.fooddemo.presentation.shoppingcar.components.ShoppingItem
import com.kanneki.fooddemo.presentation.shoppingcar.components.ShoppingItemEvent

@Composable
fun ShoppingCarScreen(
    nav: NavHostController,
    orderList: MutableList<ProductData>,
    viewModel: ShoppingCarViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    onChange: (MutableList<ProductData>) -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.initState(orderList.map { it.copy(count = if (it.count > 99) 99 else it.count) })
    }

    DisposableEffect(Unit) {

        onDispose {
            onChange(viewModel.state)
        }
    }

    Column(modifier = modifier.fillMaxSize()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(.08f)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "arrow back",
                modifier = Modifier
                    .size(64.dp)
                    .padding(16.dp)
                    .clip(CircleShape)
                    .clickable { nav.popBackStack() }
            )
            Text(
                text = stringResource(id = R.string.shopping_car),
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        if (viewModel.state.isNotEmpty()) {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 5.dp, vertical = 5.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp),
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.92f)
            ) {

                viewModel.state.forEachIndexed { index, productData ->
                    item {
                        ShoppingItem(
                            data = productData,
                            onClick = { event ->
                                when (event) {
                                    is ShoppingItemEvent.Add -> {
                                        viewModel.modifyStateData(index, event.count)
                                    }
                                    is ShoppingItemEvent.Reduce -> {
                                        viewModel.modifyStateData(index, event.count)
                                    }
                                    is ShoppingItemEvent.Remove -> {
                                        viewModel.removeStateItem(index)
                                    }
                                }
                            }
                        )
                    }
                }
            }
            Row(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.LightGray.copy(alpha = .4f)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.count_number, viewModel.stateSum()),
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Button(
                    modifier = Modifier.padding(end = 16.dp),
                    onClick = {
                        viewModel.initState(mutableListOf())
                        nav.popBackStack()
                    }
                ) {
                    Text(text = stringResource(id = R.string.checkout))
                }
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                SubcomposeAsyncImage(
                    model = "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/whale.png",
                    contentDescription = "no",
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
                    text = stringResource(id = R.string.shopping_car_empty),
                    style = MaterialTheme.typography.h6
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingCarScreenPreview() {
    val nav = rememberNavController()
    ShoppingCarScreen(nav = nav, mutableListOf(), onChange = {})
}