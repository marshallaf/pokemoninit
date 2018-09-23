package com.marshallaf.pokemonlookup.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Lazy
import javax.inject.Inject

class ViewModelFactory<T : ViewModel> @Inject constructor(
    private val viewModel: Lazy<T>
) : ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>) = viewModel.get() as T

}
