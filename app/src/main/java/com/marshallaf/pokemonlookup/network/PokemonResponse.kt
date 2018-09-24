package com.marshallaf.pokemonlookup.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonResponse(
    @Json(name = "name") val name: String?,
    @Json(name = "height") val height: Int,
    @Json(name = "weight") val weight: Int,
    @Json(name = "types") val types: List<TypeResponse>?,
    @Json(name = "sprites") val images: Sprites?
)
