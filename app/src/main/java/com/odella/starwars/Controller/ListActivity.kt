package com.odella.starwars.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odella.starwars.Adapter.PersonAdapter
import com.odella.starwars.Constants.EXTRA_SELECTED_TYPE
import com.odella.starwars.POJO.Base
import com.odella.starwars.POJO.UsersFeed
import com.odella.starwars.R
import com.odella.starwars.Services.DataService
import com.odella.starwars.Services.PersonsService
import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListActivity : AppCompatActivity() {

    lateinit var adapter: PersonAdapter
    var type = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        type = intent.getStringExtra(EXTRA_SELECTED_TYPE)

        when(type){
            "persons" -> {
                adapter = PersonAdapter(this, DataService.persons)
            }
            "planets" -> {
                adapter = PersonAdapter(this, DataService.persons)
            }
            "starships" -> {
                adapter = PersonAdapter(this, DataService.persons)
            }

        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.co/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(PersonsService::class.java)
        val call = service.getPeople()
        call.enqueue(object : Callback<List<UsersFeed>> {
            override fun onResponse(call: Call<List<UsersFeed>>, response: Response<List<UsersFeed>>) {
                if (response.code() == 200) {
                    //Good
                    val UsersFeed = response.body()!!
                    for (user in UsersFeed){
                        print(user.name)
                    }
                }
            }

            override fun onFailure(call: Call<List<UsersFeed>>, t: Throwable) {

            }
        })

        adapter = PersonAdapter(this, DataService.persons)
        list.adapter = adapter

    }
}
