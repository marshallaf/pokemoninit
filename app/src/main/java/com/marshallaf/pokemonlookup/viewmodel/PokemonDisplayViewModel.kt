package com.marshallaf.pokemonlookup.viewmodel

import android.arch.lifecycle.ViewModel
import com.marshallaf.pokemonlookup.data.PokemonData
import com.marshallaf.pokemonlookup.data.PokemonRepository
import io.reactivex.Single
import javax.inject.Inject

class PokemonDisplayViewModel @Inject constructor(val pokemonRepository: PokemonRepository) : ViewModel() {

  fun getPokemonInformation(number: Int): Single<PokemonData> {
    return pokemonRepository.getPokemonInformation(number)
  }
}