package com.marshallaf.pokemonlookup

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
}
