package com.odella.starwars.Controller

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.BaseAdapter
import android.widget.Toast
import com.odella.starwars.Adapter.PersonAdapter
import com.odella.starwars.Adapter.PlanetAdapter
import com.odella.starwars.Adapter.StarshipAdapter
import com.odella.starwars.Constants.EXTRA_SELECTED_TYPE
import com.odella.starwars.POJO.PersonFeed
import com.odella.starwars.POJO.PlanetFeed
import com.odella.starwars.POJO.StarshipFeed
import com.odella.starwars.R
import com.odella.starwars.Services.Service
import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListActivity : AppCompatActivity() {

    lateinit var adapter: BaseAdapter
    var page = 1
    var type = ""
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://swapi.co/api/")
        .build()
    var service = retrofit.create(Service::class.java)

    //FUNCS

    fun showToast(str: String?){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    fun onNextPageClick(view: View){
        page++
        showContentPage(type, page, this)
    }

    fun onPrevPageClick(view: View){
        page--
        showContentPage(type, page, this)
    }

    fun showContentPage(type: String, page: Int, context: Context){
        progressBar.visibility = View.VISIBLE
        window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        when(type) {
            "persons" -> {
                val call = service.getPeople(page)
                call.enqueue(object : Callback<PersonFeed>{

                    override fun onResponse(call: Call<PersonFeed>, response: Response<PersonFeed>) {
                        if(response.code() == 200){
                            val data = response.body()
                            if(data != null){
                                if(data.people!!.count() > 0) {
                                    adapter = PersonAdapter(context, data.people!!)
                                    list.adapter = adapter
                                    if(data.next == null) btnNextPage.visibility = View.INVISIBLE
                                    else btnNextPage.visibility = View.VISIBLE
                                    if(data.previous == null) btnPrevPage.visibility = View.INVISIBLE
                                    else btnPrevPage.visibility = View.VISIBLE
                                } else {
                                    showToast("There is no data to display")
                                }
                            } else {
                                showToast("No data!")
                            }
                        } else {
                            showToast("Error code:" + response.code().toString())
                        }
                        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        progressBar.visibility = View.INVISIBLE
                    }

                    override fun onFailure(call: Call<PersonFeed>, t: Throwable) {
                        showToast(t.message)
                        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        progressBar.visibility = View.INVISIBLE
                    }
                })
            }
            "planets" -> {
                val call = service.getPlanets(page)
                call.enqueue(object : Callback<PlanetFeed>{

                    override fun onResponse(call: Call<PlanetFeed>, response: Response<PlanetFeed>) {
                        if(response.code() == 200){
                            val data = response.body()
                            if(data != null){
                                if(data.planets!!.count() > 0) {
                                    adapter = PlanetAdapter(context, data.planets!!)
                                    list.adapter = adapter
                                    if(data.next == null) btnNextPage.visibility = View.INVISIBLE
                                    else btnNextPage.visibility = View.VISIBLE
                                    if(data.previous == null) btnPrevPage.visibility = View.INVISIBLE
                                    else btnPrevPage.visibility = View.VISIBLE
                                } else {
                                    showToast("There is no data to display")
                                }
                            } else {
                                showToast("No data!")
                            }
                        } else {
                            showToast("Error code:" + response.code().toString())
                        }
                        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        progressBar.visibility = View.INVISIBLE
                    }

                    override fun onFailure(call: Call<PlanetFeed>, t: Throwable) {
                        showToast(t.message)
                        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        progressBar.visibility = View.INVISIBLE
                    }
                })
            }
            "starships" -> {
                val call = service.getStarships(page)
                call.enqueue(object : Callback<StarshipFeed>{

                    override fun onResponse(call: Call<StarshipFeed>, response: Response<StarshipFeed>) {
                        if(response.code() == 200){
                            val data = response.body()
                            if(data != null){
                                if(data.starships!!.count() > 0) {
                                    adapter = StarshipAdapter(context, data.starships!!)
                                    list.adapter = adapter
                                    if(data.next == null) btnNextPage.visibility = View.INVISIBLE
                                    else btnNextPage.visibility = View.VISIBLE
                                    if(data.previous == null) btnPrevPage.visibility = View.INVISIBLE
                                    else btnPrevPage.visibility = View.VISIBLE
                                } else {
                                    showToast("There is no data to display")
                                }
                            } else {
                                showToast("No data!")
                            }
                        } else {
                            showToast("Error code:" + response.code().toString())
                        }
                        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        progressBar.visibility = View.INVISIBLE
                    }

                    override fun onFailure(call: Call<StarshipFeed>, t: Throwable) {
                        showToast(t.message)
                        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        progressBar.visibility = View.INVISIBLE
                    }
                })
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        if(intent.getStringExtra(EXTRA_SELECTED_TYPE) == null) finish()
        else type = intent.getStringExtra(EXTRA_SELECTED_TYPE)!!
        showContentPage(type, 1, this)
    }
}
