package com.marshallaf.pokemonlookup.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TypeSubresponse(
    @Json(name = "name") val name: String?
)
