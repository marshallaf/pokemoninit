package com.marshallaf.pokemonlookup.data

import com.marshallaf.pokemonlookup.network.PokemonClient
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    private val client: PokemonClient
) {

  companion object {
    val ERROR_POKEMON = PokemonData(-1, "", "", "", -1, -1)
  }

  private var cachedPokemon: PokemonData? = null

  private fun fetchPokemonInformation(number: Int): Single<PokemonData> {
    return client.getPokemonInformation(number)
        .doOnSuccess { cachedPokemon = it }
  }

  fun getPokemonInformation(number: Int): Single<PokemonData> {
    return if (cachedPokemon?.number == number) {
      Single.just(cachedPokemon)
    } else {
      fetchPokemonInformation(number)
    }
  }
}