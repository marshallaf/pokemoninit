package com.marshallaf.pokemonlookup.network

import com.squareup.moshi.Json

data class Sprites(
    @Json(name = "front_default") val imageUrl: String?
)
