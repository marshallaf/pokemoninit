package com.marshallaf.pokemonlookup.ui

import android.arch.lifecycle.ViewModelProviders
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.marshallaf.pokemonlookup.R
import com.marshallaf.pokemonlookup.data.PokemonData
import com.marshallaf.pokemonlookup.di.GlideApp
import com.marshallaf.pokemonlookup.di.ViewModelFactory
import com.marshallaf.pokemonlookup.viewmodel.PokemonDisplayViewModel
import dagger.android.support.AndroidSupportInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.fragment_pokemon_display.*
import timber.log.Timber
import javax.inject.Inject

class PokemonDisplayFragment : Fragment() {

  companion object {
    private const val KEY_NUMBER = "key_number"

    fun newInstance(number: Int): PokemonDisplayFragment {
      val instance = PokemonDisplayFragment()
      val args = Bundle().apply {
        putInt(KEY_NUMBER, number)
      }
      return instance.apply { arguments = args }
    }
  }

  private var number: Int = -1
  @Inject lateinit var viewModelFactory: ViewModelFactory<PokemonDisplayViewModel>
  private lateinit var viewModel: PokemonDisplayViewModel
  private var disposable: Disposable? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidSupportInjection.inject(this)
    super.onCreate(savedInstanceState)

    number = arguments?.getInt(KEY_NUMBER, number) ?: number
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(PokemonDisplayViewModel::class.java)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_pokemon_display, container, false)
  }

  override fun onStart() {
    super.onStart()

    disposable = viewModel.getPokemonInformation(number)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            Consumer<PokemonData> { populateData(it) }
        )
  }

  private fun populateData(pokemon: PokemonData) {
    name.text = pokemon.name
    type.text = pokemon.type
    weight.text = getString(R.string.weight_kilograms, pokemon.weight)
    height.text = getString(R.string.height_meters, pokemon.height)
    GlideApp.with(this)
        .load(pokemon.imageUrl)
        .listener(object : RequestListener<Drawable> {
          override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
            Timber.d("Loading image unsuccessful for imageUrl: %s", pokemon.imageUrl)
            return false
          }

          override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
            Timber.d("Loading image successful")
            return false
          }

        })
        .into(sprite)
  }

  override fun onStop() {
    super.onStop()

    disposable?.dispose()
  }

}
