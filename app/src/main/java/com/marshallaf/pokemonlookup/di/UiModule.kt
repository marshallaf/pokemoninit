package com.marshallaf.pokemonlookup.di

import com.marshallaf.pokemonlookup.ui.NumberEntryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

  @ContributesAndroidInjector abstract fun contributesNumberEntryFragment(): NumberEntryFragment
}