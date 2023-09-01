package com.example.mangahunt.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationBar() {
    var text by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(100.dp)),
        contentAlignment = Alignment.CenterEnd
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth()
        )

        Icon(
            Icons.Rounded.Search,
            contentDescription = "search_icon",
            modifier = Modifier
                .padding(0.dp, 0.dp, 8.dp, 0.dp)
                .clickable {
                    // TODO: call api
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationBarPreview() {
    NavigationBar()
}