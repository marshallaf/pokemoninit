package com.marshallaf.pokemonlookup.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface PokemonApi {

  @GET("pokemon/{number}")
  fun getPokemonInfo(@Path("number") number: Int): Single<PokemonResponse>
}
