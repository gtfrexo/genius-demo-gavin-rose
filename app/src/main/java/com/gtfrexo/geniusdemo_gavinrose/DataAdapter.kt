package com.gtfrexo.geniusdemo_gavinrose

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.user_data.view.*

/**
 * Created by gtfre on 5/1/2018.
 */
class DataAdapter(val firstName: ArrayList<String>, val lastName: ArrayList<String>, val avatar: ArrayList<String>,
                  val context: Context): RecyclerView.Adapter<ViewHolder>(){

    //Gets number of people
    override fun getItemCount(): Int {
        return firstName.size
    }

    //Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        //
    }

    //Binds data to views
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        //
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    //Holds data for first name, last name, and avatar values.
    val dataFirstName = view.firstNameTV
    val dataLastName = view.lastNameTV
    val dataAvatar = view.avatarIV
}