package com.marshallaf.pokemonlookup.network

import com.marshallaf.pokemonlookup.data.PokemonData
import timber.log.Timber
import java.util.regex.Pattern
import javax.inject.Inject

class NetworkPokemonMapper @Inject constructor() {

  fun toPokemonData(pokemonResponse: PokemonResponse): PokemonData {
    Timber.d("Mapping pokemon response:\n-- name: %s\n-- id: %s\n-- sprite: %s\n-- type[0]: %s",
        pokemonResponse.name,
        pokemonResponse.number,
        pokemonResponse.images?.imageUrl,
        pokemonResponse.types?.get(0)?.typeSubresponse?.name)
    val name = pokemonResponse.name
        ?.split(Pattern.compile("\\s"))
        ?.joinToString(" ") { it.capitalize() } ?: ""
    val type = pokemonResponse.types
        ?.joinToString(", ") { it.typeSubresponse?.name.toString() } ?: ""
    return PokemonData(pokemonResponse.number, name, pokemonResponse.images?.imageUrl ?: "", type, pokemonResponse.weight, pokemonResponse.height)
  }
}
