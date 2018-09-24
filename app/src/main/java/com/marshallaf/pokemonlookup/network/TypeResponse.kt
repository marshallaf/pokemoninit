package com.marshallaf.pokemonlookup.network

import com.squareup.moshi.Json

class TypeResponse(
    @Json(name = "type") val typeSubresponse: TypeSubresponse?
)
