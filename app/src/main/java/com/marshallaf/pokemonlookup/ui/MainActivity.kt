package com.marshallaf.pokemonlookup.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (savedInstanceState == null) {
      val fragmentManager = supportFragmentManager
      fragmentManager.beginTransaction()
          .replace(android.R.id.content, NumberEntryFragment())
          .commit()
    }
  }

  fun navigateToPokemonDisplay(number: Int) {
    val fragment = PokemonDisplayFragment.newInstance(number)
    supportFragmentManager.beginTransaction()
        .replace(android.R.id.content, fragment)
        .commit()
  }
}
