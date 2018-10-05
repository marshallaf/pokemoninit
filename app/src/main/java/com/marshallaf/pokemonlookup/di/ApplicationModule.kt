package com.marshallaf.pokemonlookup.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {

  @Binds abstract fun bindsContext(application: Application): Context
}