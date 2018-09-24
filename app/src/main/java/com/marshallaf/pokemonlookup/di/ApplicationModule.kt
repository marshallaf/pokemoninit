package com.marshallaf.pokemonlookup.di

import android.app.Application
import android.content.Context
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
abstract class ApplicationModule {

  @Binds abstract fun bindsContext(application: Application): Context

  @Provides fun providesRetrofit(okHttp: OkHttpClient, moshi: Moshi): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        // converter and adapter
        .client(okHttp)
        .build()
  }
}