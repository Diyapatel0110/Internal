package com

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


import com.example.sqlitedatabase.Fruit
import com.example.sqlitedatabase.R

import kotlinx.android.synthetic.main.card.view.*




class FruitAdapter(val context:Context,var myarr:ArrayList<Fruit>)
    :RecyclerView.Adapter<FruitAdapter.PersonViewHolde>()

{


    class PersonViewHolde(var view:View):RecyclerView.ViewHolder(view)
    {
        fun bind(p:Fruit)
        {
            view.tvFrName.setText(p.fr_name)
            view.tvFrDesc.setText(p.fr_desc)
            view.tvFrPrice.setText(p.fr_price.toString())

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolde {

        var inflater=LayoutInflater.from(parent.context)
        var view= inflater.inflate(R.layout.card,parent,false)
        return PersonViewHolde(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolde, position: Int) {
        holder.bind(myarr[position])
    }

    override fun getItemCount(): Int {
        return  myarr.size
    }
}