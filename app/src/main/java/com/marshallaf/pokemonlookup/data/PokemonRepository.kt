package com.marshallaf.pokemonlookup.data

import com.marshallaf.pokemonlookup.network.PokemonClient
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    val client: PokemonClient
) {

  companion object {
    val ERROR_POKEMON = PokemonData("", "", "", -1, -1)
  }

  lateinit var pokemonData: PokemonData

  fun getPokemonInformation(number: Int): Single<PokemonData> {
    return client.getPokemonInformation(number)
        .doOnSuccess { pokemonData = it }
  }
}