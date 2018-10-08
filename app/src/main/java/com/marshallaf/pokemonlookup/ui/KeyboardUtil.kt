package com.marshallaf.pokemonlookup.ui

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager


object KeyboardUtil {

  fun hide(activity: Activity) {
    val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    val view: View = activity.findViewById(android.R.id.content)
    imm.hideSoftInputFromWindow(view.rootView.windowToken, 0)
  }
}