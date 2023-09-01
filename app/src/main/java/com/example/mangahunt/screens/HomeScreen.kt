package com.example.mangahunt.screens

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mangahunt.R
import com.example.mangahunt.components.Card
import com.example.mangahunt.components.NavigationBar

@Composable
fun HomeScreen(
    navController: NavController,
) {
    val mangas by remember {
        mutableStateOf(listOf("1", "2", "3", "4", "5", "6", "7", "8"))
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            NavigationBar()
            Spacer(modifier = Modifier.height(36.dp))
            Text(text = stringResource(id = R.string.newest))
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow() {
                items(mangas) { manga ->
                    Card(manga)
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
            Spacer(modifier = Modifier.height(26.dp))
            Text(text = stringResource(id = R.string.popular))
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow() {
                items(mangas) { manga ->
                    Card(manga)
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
            Spacer(modifier = Modifier.height(36.dp))
            Text(text = stringResource(id = R.string.top_ten_italy))
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow() {
                items(mangas) { manga ->
                    Card(manga)
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
            Spacer(modifier = Modifier.height(36.dp))
        }
    }
}