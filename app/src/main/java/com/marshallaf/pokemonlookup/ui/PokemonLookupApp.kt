package com.marshallaf.pokemonlookup.ui

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import com.marshallaf.pokemonlookup.BuildConfig
import com.marshallaf.pokemonlookup.di.DaggerApplicationComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject

class PokemonLookupApp : Application(), HasActivityInjector, HasSupportFragmentInjector {

  @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>
  @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

  override fun activityInjector() = activityInjector
  override fun supportFragmentInjector() = fragmentInjector

  override fun onCreate() {
    super.onCreate()

    DaggerApplicationComponent
        .create()
        .inject(this)

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }
}