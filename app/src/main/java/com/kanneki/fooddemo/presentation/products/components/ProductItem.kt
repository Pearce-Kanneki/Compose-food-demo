package com.kanneki.fooddemo.presentation.products.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.kanneki.fooddemo.domain.model.ProductData
import com.kanneki.fooddemo.R

@Composable
fun ProductItem(data: ProductData, onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .size(150.dp)
            .clickable { onClick(data.id) },
        elevation = 5.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(contentAlignment = Alignment.BottomCenter) {
            SubcomposeAsyncImage(
                model = data.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                loading = {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(modifier = Modifier.size(30.dp))
                    }
                },
                error = {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = stringResource(id = R.string.error_image))
                    }
                },
                modifier = Modifier.fillMaxSize()
            )

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "$:${data.price}",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Red,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .background(Color.LightGray.copy(alpha = .7f))
                        .clip(RoundedCornerShape(12.dp))
                )
                Text(
                    text = data.name,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(25.dp)
                        .background(Color.Black.copy(alpha = .4f)),
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductItem(
        ProductData(
            1,
            "test",
            "",
            100,
            2,
            "http://fakeimg.pl/300x300",
            1
        ),
        onClick = {

        }
    )
}