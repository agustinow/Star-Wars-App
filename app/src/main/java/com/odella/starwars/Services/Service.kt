package com.odella.starwars.Services

import com.odella.starwars.POJO.PersonFeed
import com.odella.starwars.POJO.PlanetFeed
import com.odella.starwars.POJO.StarshipFeed
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("people")
    fun getPeople(@Query("page") page: Int): Call<PersonFeed>

    @GET("planets")
    fun getPlanets(@Query("page") page: Int): Call<PlanetFeed>

    @GET("starships")
    fun getStarships(@Query("page") page: Int): Call<StarshipFeed>
}