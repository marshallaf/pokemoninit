package com.marshallaf.pokemonlookup.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import com.marshallaf.pokemonlookup.R
import com.marshallaf.pokemonlookup.di.ViewModelFactory
import com.marshallaf.pokemonlookup.viewmodel.NumberEntryViewModel
import dagger.android.support.AndroidSupportInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_number_entry.*
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

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    number_entry.setOnEditorActionListener { editText, actionId, _ ->
      when (actionId) {
        EditorInfo.IME_ACTION_SEARCH -> {
          viewModel.searchPokemonNumber(editText.text.toString().toInt())
          true
        }
        else -> false
      }
    }
  }

  override fun onStart() {
    super.onStart()

    disposable = viewModel.getSearchResult()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { (activity as MainActivity).navigateToPokemonDisplay(it.number) }
  }

  override fun onStop() {
    disposable?.dispose()

    super.onStop()
  }

}
