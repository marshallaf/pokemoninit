package com.marshallaf.pokemonlookup.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marshallaf.pokemonlookup.R
import com.marshallaf.pokemonlookup.di.ViewModelFactory
import com.marshallaf.pokemonlookup.viewmodel.NumberEntryViewModel
import dagger.android.support.AndroidSupportInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class NumberEntryFragment : Fragment() {

  @Inject lateinit var viewModelFactory: ViewModelFactory<NumberEntryViewModel>
  private lateinit var viewModel: NumberEntryViewModel
  private var disposable: Disposable? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidSupportInjection.inject(this)
    super.onCreate(savedInstanceState)

    viewModel = ViewModelProviders.of(this, viewModelFactory).get(NumberEntryViewModel::class.java)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_number_entry, container, false)
  }

  override fun onStart() {
    super.onStart()

    disposable = viewModel.getSearchResult()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { Log.d("NumberEntryFragment", "result is ${it.name}") }
  }

  override fun onStop() {
    disposable?.dispose()

    super.onStop()
  }

}
