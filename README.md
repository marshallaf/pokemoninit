# Pokémon Lookup

A simple demonstration of clean architecture in an Android application. Look up a Pokemon by number and see a very grainy sprite and some simple stats, powered by [PokéAPI](https://pokeapi.co)!


<img src="https://github.com/marshallaf/pokemoninit/blob/master/docs/number_entry_screen.png" alt="image of pokemon number entry screen" width="300"> <img src="https://github.com/marshallaf/pokemoninit/blob/master/docs/pokemon_display_screen.png" alt="image of pokemon display screen" width="300">

## Architecture
There are three main separations of responsibilities in this app: **data**, **UI**, and **network**.

The data layer is concerned only with data retrieval and serving. It has no knowledge of the other layers' implementations - it only knows that there are consumers and providers of its data.

The UI layer depends on the data layer and is primarily responsible for displaying data to the user. In addition to this, other Android-specific responsibilities are handled within this layer, such as Activity/Fragment lifecycle and navigation.

The network layer also depends on the data layer and is responsible for fetching data from the internet.

Since the UI layer and network layer are not dependencies of other layers, if the APIs of Android or the PokéAPI were updated, only the corresponding layer would need to change. In most cases, the other layers could remain untouched. This allows the application's code to easily adapt to changing externalities, without restructuring the entire application.

Note that while the "layers" in this application are not actually separated into distinct modules, their current dependency structure would allow them to be without major changes to the source.

## Technologies used
* [Kotlin](https://kotlinlang.org/)
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [Dagger 2](https://google.github.io/dagger/)
* [RxJava 2](https://github.com/ReactiveX/RxJava)
* [Retrofit](https://square.github.io/retrofit/)
* [Moshi](https://github.com/square/moshi)
* [Glide](https://bumptech.github.io/glide/)
