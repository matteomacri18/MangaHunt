package com.example.mangahunt.models

class Mangas : ArrayList<MangasItem>()

data class MangasItem(
    val aired_on: String,
    val members: Int,
    val myanimelist_id: Int,
    val myanimelist_url: String,
    val picture_url: String,
    val rank: Int,
    val score: Double,
    val title: String,
    val type: String
)