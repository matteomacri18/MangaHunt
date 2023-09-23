package com.example.mangahunt.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Card(
    title: String,
    cover: String
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp, 0.dp)
            .shadow(8.dp)
            .offset(0.dp, 0.dp)
    ) {
        Box(
            modifier = Modifier
                .size(140.dp, 170.dp)
                .background(Color.White, shape = RoundedCornerShape(12.dp))

        ) {
            GlideImage(model = cover, contentDescription = null)
            Text(text = title)
        }
    }
}