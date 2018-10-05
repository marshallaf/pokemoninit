package com.marshallaf.pokemonlookup.viewmodel

import android.arch.lifecycle.ViewModel
import com.marshallaf.pokemonlookup.data.PokemonData
import com.marshallaf.pokemonlookup.data.PokemonRepository
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import javax.inject.Inject

class NumberEntryViewModel @Inject constructor(
        private val repository: PokemonRepository
) : ViewModel() {

  private val resultSubject: Subject<PokemonData> = PublishSubject.create()
  private var disposable: Disposable? = null

  fun searchPokemonNumber(number: Int) {
    disposable = repository.getPokemonInformation(number)
        .subscribe(resultSubject::onNext)
  }

  fun getSearchResult(): Observable<PokemonData> = resultSubject

  override fun onCleared() {
    disposable?.dispose()

    super.onCleared()
  }
}