package com.odella.starwars.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.odella.starwars.Constants.EXTRA_SELECTED_TYPE
import com.odella.starwars.R
import kotlinx.android.synthetic.main.activity_select.*

class SelectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)
    }

    fun buttonClicked(view: View){
        var intent = Intent(this, ListActivity::class.java)
        when(view){
            btnPeople -> {
                intent.putExtra(EXTRA_SELECTED_TYPE, "persons")
            }
            btnPlanets -> {
                intent.putExtra(EXTRA_SELECTED_TYPE, "planets")
            }
            btnStarships -> {
                intent.putExtra(EXTRA_SELECTED_TYPE, "starships")
            }
            else -> {
                Toast.makeText(this, "Invalid option", Toast.LENGTH_SHORT)
            }
        }
        startActivity(intent)
    }
}
