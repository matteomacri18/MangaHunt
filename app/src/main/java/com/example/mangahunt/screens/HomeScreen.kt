package com.example.mangahunt.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mangahunt.R
import com.example.mangahunt.components.Card
import com.example.mangahunt.components.NavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
) {
    val scrollBehavior = TopAppBarDefaults
        .enterAlwaysScrollBehavior(rememberTopAppBarState())

    val mangas by remember {
        mutableStateOf(listOf("1", "2", "3", "4", "5", "6", "7", "8"))
    }

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .padding(10.dp, 8.dp),
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .padding(0.dp, 0.dp, 20.dp, 0.dp)
                    ) {
                        NavigationBar()
                    }
                },
                actions = {
                    Icon(
                        Icons.Rounded.ShoppingCart,
                        contentDescription = "shoppingCart_icon",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
                                // TODO
                            }
                    )
                },
                scrollBehavior = scrollBehavior,
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(4.dp, 0.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
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
}