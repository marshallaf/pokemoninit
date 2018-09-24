package com.marshallaf.pokemonlookup.network

import com.marshallaf.pokemonlookup.data.PokemonData
import java.util.regex.Pattern
import javax.inject.Inject

class NetworkPokemonMapper @Inject constructor() {

  fun toPokemonData(pokemonResponse: PokemonResponse): PokemonData {
    val name = pokemonResponse.name
        ?.split(Pattern.compile("\\s"))
        ?.joinToString(" ") { it.capitalize() } ?: ""
    val type = pokemonResponse.types
        ?.joinToString(", ") { it.typeSubresponse?.name.toString() } ?: ""
    return PokemonData(name, pokemonResponse.images?.imageUrl ?: "", type, pokemonResponse.weight, pokemonResponse.height)
  }
}
