package com.marshallaf.pokemonlookup.di

import com.marshallaf.pokemonlookup.ui.PokemonLookupApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
  AndroidInjectionModule::class,
  ApplicationModule::class,
  UiModule::class
])
interface ApplicationComponent {

  fun inject(application: PokemonLookupApp)

}