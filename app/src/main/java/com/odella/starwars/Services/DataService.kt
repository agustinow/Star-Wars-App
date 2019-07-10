package com.odella.starwars.Services

import com.odella.starwars.Model.Person
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.odella.starwars.Services.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataService {



    var persons = listOf(
            Person("Luke Skywalker", 172, 77, "blond", "fair", "blue", "19BBY", "male", "https://swapi.co/api/planets/1/"),
            Person("C-3PO", 167, 75, "n/a", "gold", "yellow", "112BBY", "n/a", "https://swapi.co/api/planets/1/"),
            Person("R2-D2", 172, 77, "blond", "fair", "blue", "19BBY", "male", "https://swapi.co/api/planets/1/"),
            Person("Anti Juan", 167, 75, "n/a", "gold", "yellow", "112BBY", "n/a", "https://swapi.co/api/planets/1/"),
            Person("Persona de Ejemplo", 172, 77, "blond", "fair", "blue", "19BBY", "male", "https://swapi.co/api/planets/1/"),
            Person("Marito Baracus", 167, 75, "n/a", "gold", "yellow", "112BBY", "n/a", "https://swapi.co/api/planets/1/")
    )
}