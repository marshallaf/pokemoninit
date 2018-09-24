package com.marshallaf.pokemonlookup.network

import com.marshallaf.pokemonlookup.data.PokemonData
import com.marshallaf.pokemonlookup.data.PokemonRepository.Companion.ERROR_POKEMON
import io.reactivex.Single
import javax.inject.Inject


class PokemonClient @Inject constructor(val api: PokemonApi, val mapper: NetworkPokemonMapper) {

  fun getPokemonInformation(number: Int): Single<PokemonData> {
    return api.getPokemonInfo(number)
        .map { mapper.toPokemonData(it) }
        .onErrorReturn { _ -> ERROR_POKEMON }
  }
}