package com.example.mangahunt.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mangahunt.R
import com.example.mangahunt.api.RetrofitClient
import com.example.mangahunt.components.Card
import com.example.mangahunt.components.NavigationBar
import com.example.mangahunt.models.Mangas

private const val TAG = "HomeScreen"

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
) {
    val scrollBehavior = TopAppBarDefaults
        .enterAlwaysScrollBehavior(rememberTopAppBarState())

    var topManga by remember {
        mutableStateOf(Mangas())
    }

    var popularManga by remember {
        mutableStateOf(Mangas())
    }

    var favoritedManga by remember {
        mutableStateOf(Mangas())
    }

    // Run the api call when the screen is mounted
    LaunchedEffect(key1 = true) {
        topManga = fetchTopManga()
        popularManga = fetchPopularManga()
        favoritedManga = fetchFavoriteManga()
    }

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .padding(0.dp, 8.dp),
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
                    items(topManga) { manga ->
                        Card(manga.title, manga.picture_url)
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }

                Spacer(modifier = Modifier.height(26.dp))
                Text(text = stringResource(id = R.string.popular))
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow() {
                    items(popularManga) { manga ->
                        Card(manga.title, manga.picture_url)
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }

                Spacer(modifier = Modifier.height(36.dp))
                Text(text = stringResource(id = R.string.top_ten_italy))
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow() {
                    items(favoritedManga) { manga ->
                        Card(manga.title, manga.picture_url)
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }
                Spacer(modifier = Modifier.height(36.dp))
            }
        }
    }
}

suspend fun fetchFavoriteManga(): Mangas {
    return try {
        val client = RetrofitClient.getRetrofitClient()
        val response = client.getFavoriteManga()
        response
    } catch (e: Exception) {
        throw e
    }
}

suspend fun fetchPopularManga(): Mangas {
    return try {
        val client = RetrofitClient.getRetrofitClient()
        val response = client.getPopularManga()
        response
    } catch (e: Exception) {
        throw e
    }
}

suspend fun fetchTopManga(): Mangas {
    return try {
        val client = RetrofitClient.getRetrofitClient()
        val response = client.getTopManga()
        response
    } catch (e: Exception) {
        throw e
    }
}