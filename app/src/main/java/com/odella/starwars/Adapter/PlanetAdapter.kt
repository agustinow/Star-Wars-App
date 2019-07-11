package com.odella.starwars.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import com.odella.starwars.R
import com.odella.starwars.POJO.Planet

class PlanetAdapter(var context: Context, var planets: List<Planet>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val personView: View
        val holder: ViewHolder

        if(convertView == null){
            personView = LayoutInflater.from(context).inflate(R.layout.element_list, null)
            holder = ViewHolder()
            holder.name = personView.findViewById(R.id.btnItem)
            personView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            personView = convertView
        }

        val person = planets[position]
        holder.name?.text = person.name
        return personView

    }

    override fun getItem(position: Int): Any {
        return planets[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return planets.count()
    }

    private class ViewHolder(){
        var name: Button? = null
    }
}