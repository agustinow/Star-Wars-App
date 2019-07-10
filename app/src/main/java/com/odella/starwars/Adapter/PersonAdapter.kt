package com.odella.starwars.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import com.odella.starwars.Model.Person
import com.odella.starwars.R


class PersonAdapter(context: Context, persons: List<Person>) : BaseAdapter() {

    val context = context
    val persons = persons

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val personView: View
        val holder: ViewHolder

        if(convertView == null){
            personView = LayoutInflater.from(context).inflate(R.layout.element_list, null)
            holder = ViewHolder()
            holder.personName = personView.findViewById(R.id.btnPerson)
            personView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            personView = convertView
        }

        val person = persons[position]
        holder.personName?.text = person.name
        return personView

    }

    override fun getItem(position: Int): Any {
        return persons[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return persons.count()
    }

    private class ViewHolder(){
        var personName: Button? = null
    }
}