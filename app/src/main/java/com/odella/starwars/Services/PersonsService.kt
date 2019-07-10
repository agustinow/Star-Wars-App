package com.odella.starwars.Services

import com.odella.starwars.POJO.UsersFeed
import retrofit2.Call
import retrofit2.http.GET

interface PersonsService {
    @GET("people")
    fun getPeople(): Call<List<UsersFeed>>
}