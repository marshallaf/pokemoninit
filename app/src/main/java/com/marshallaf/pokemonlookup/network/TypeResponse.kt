package com.marshallaf.pokemonlookup.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class TypeResponse(
    @Json(name = "type") val typeSubresponse: TypeSubresponse?
)
