package com.marshallaf.pokemonlookup.network

import com.squareup.moshi.Json

data class TypeSubresponse(
    @Json(name = "name") val name: String?
)
