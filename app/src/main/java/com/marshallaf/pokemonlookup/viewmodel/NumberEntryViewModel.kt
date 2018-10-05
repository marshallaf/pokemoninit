package com.marshallaf.pokemonlookup.viewmodel

import android.arch.lifecycle.ViewModel
import com.marshallaf.pokemonlookup.data.PokemonRepository
import com.marshallaf.pokemonlookup.data.PokemonRepository.Companion.ERROR_POKEMON
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import javax.inject.Inject

class NumberEntryViewModel @Inject constructor(
        private val repository: PokemonRepository
) : ViewModel() {

  private val resultSubject: Subject<SearchResult> = PublishSubject.create()
  private var disposable: Disposable? = null

  companion object {
    enum class SearchResult {
      SUCCESS,
      FAILURE
    }
  }

  fun searchPokemonNumber(number: Int) {
    disposable = repository.getPokemonInformation(number)
        .map {
          when (it) {
            ERROR_POKEMON -> SearchResult.FAILURE
            else -> SearchResult.SUCCESS
          }
        }
        .subscribe(resultSubject::onNext)
  }

  fun getSearchResult(): Observable<SearchResult> = resultSubject

  override fun onCleared() {
    disposable?.dispose()

    super.onCleared()
  }
}