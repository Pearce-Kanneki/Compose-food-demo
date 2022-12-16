package com.kanneki.fooddemo.presentation.productdetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kanneki.fooddemo.R
import com.kanneki.fooddemo.data.util.FakeDataUtil
import com.kanneki.fooddemo.domain.model.ProductData
import com.kanneki.fooddemo.domain.util.toProductData

@Composable
fun ProductDetailScreen(
    nav: NavHostController,
    id: Int,
    data: ProductData?,
    viewModel: ProductDetailViewModel = hiltViewModel(),
    onAddCar: (ProductData) -> Unit
) {

    viewModel.setProductData(id, data)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp)
    ) {
        ProductDetailHead(
            Modifier.fillMaxHeight(.35f),
            viewModel.valueData?.image ?: "",
            onClick = {
                nav.popBackStack()
            }
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Remove,
                contentDescription = "remove",
                modifier = Modifier
                    .size(32.dp)
                    .shadow(2.dp)
                    .clickable {
                        viewModel.modifyProductCount(-1)
                    }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = viewModel.productCount.toString(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "add",
                modifier = Modifier
                    .size(32.dp)
                    .shadow(2.dp)
                    .clickable {
                        viewModel.modifyProductCount(1)
                    }
            )
        }
        Text(
            text = viewModel.valueData?.name ?: "",
            style = MaterialTheme.typography.h6,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = viewModel.valueData?.desc ?: "",
            modifier = Modifier
                .fillMaxHeight(.79f)
                .fillMaxWidth()
        )

        Text(
            text = "$${viewModel.valueData?.price}",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.End
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            onClick = {
                if (viewModel.valueData != null) {
                    onAddCar(viewModel.valueData!!.copy(count = viewModel.productCount))
                }
                nav.popBackStack()
            }
        ) {
            Text(text = stringResource(id = R.string.add_car))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailScreenPreview() {
    val nav = rememberNavController()
    ProductDetailScreen(
        nav,
        1,
        FakeDataUtil.fakeProductList[0].toProductData(),
        onAddCar = {}
    )
}