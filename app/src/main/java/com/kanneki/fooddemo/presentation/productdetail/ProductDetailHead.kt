package com.kanneki.fooddemo.presentation.productdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProductDetailHead(modifier: Modifier,imageUrl: String, onClick:() -> Unit) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxWidth()
        )
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "close",
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .padding(top = 16.dp, end = 16.dp)
                .clip(CircleShape)
                .background(Color.Black.copy(alpha = .6f))
                .clickable { onClick() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailHeadPreview() {
    ProductDetailHead(Modifier.height(300.dp),"http://fakeimg.pl/300x300"){}
}