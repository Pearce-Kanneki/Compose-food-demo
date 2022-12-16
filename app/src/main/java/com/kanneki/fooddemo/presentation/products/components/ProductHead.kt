package com.kanneki.fooddemo.presentation.products.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kanneki.fooddemo.R
import com.kanneki.fooddemo.presentation.util.ScreenTag

@Composable
fun ProductHead(
    initKeyWord: String,
    onSearchCallBack: (String) -> Unit,
    onChangeScreen: (String) -> Unit
) {
    var searchText by remember {
        mutableStateOf(initKeyWord)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
                onSearchCallBack(it)
            },
            modifier = Modifier
                .fillMaxWidth(.85f),
            shape = RoundedCornerShape(32.dp),
            singleLine = true,
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "search")
            },
            trailingIcon = {
                if (searchText.isNotBlank()) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "clear",
                        modifier = Modifier.clickable {
                            searchText = ""
                            onSearchCallBack("")
                        }
                    )
                }
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "shopping car",
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(colorResource(id = R.color.teal_200))
                .padding(7.dp)
                .clickable {
                    onChangeScreen(ScreenTag.SCREEN_SHOPPING_CAR)
                }
        )
        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ProductHeadPreview() {
    ProductHead(
        "",
        onChangeScreen = {},
        onSearchCallBack = {}
    )
}