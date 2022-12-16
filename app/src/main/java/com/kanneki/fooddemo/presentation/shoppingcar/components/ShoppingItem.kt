package com.kanneki.fooddemo.presentation.shoppingcar.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.kanneki.fooddemo.domain.model.ProductData

@Composable
fun ShoppingItem(
    data: ProductData,
    modifier: Modifier = Modifier,
    heightDp: Dp = 120.dp,
    onClick: (ShoppingItemEvent) -> Unit
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(heightDp),
        elevation = 2.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(modifier = Modifier.fillMaxWidth(.76f)) {
                AsyncImage(
                    model = data.image,
                    contentDescription = "product icon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(heightDp)
                        .padding(3.dp)
                        .clip(RoundedCornerShape(5.dp))
                )
                Spacer(modifier = Modifier.width(5.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Text(
                        text = data.name,
                        style = MaterialTheme.typography.subtitle1
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "$${data.price}",
                        style = MaterialTheme.typography.body1
                    )
                }
            }

            Column(
                modifier = Modifier.height(heightDp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = "close",
                    modifier = Modifier
                        .width(30.dp)
                        .padding(top = 8.dp, end = 8.dp)
                        .clip(CircleShape)
                        .clickable {
                            onClick(ShoppingItemEvent.Remove)
                        }
                )

                Row(
                    modifier = Modifier.padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Remove,
                        contentDescription = "remove",
                        modifier = Modifier.clickable {
                            onClick(ShoppingItemEvent.Reduce())
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = data.count.toString(),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "add",
                        modifier = Modifier.clickable {
                            onClick(ShoppingItemEvent.Add())
                        }
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingItemPreview() {
    ShoppingItem(
        ProductData(
            1,
            "name",
            "",
            100,
            12,
            "",
            1
        ),
        onClick = {}
    )
}