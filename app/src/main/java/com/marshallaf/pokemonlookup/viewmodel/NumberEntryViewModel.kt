package com.marshallaf.pokemonlookup.viewmodel

import android.arch.lifecycle.ViewModel
import io.reactivex.Single
import javax.inject.Inject

class NumberEntryViewModel @Inject constructor() : ViewModel() {

  fun testViewModel(): Single<Int> {
    return Single.just(77)
  }
}