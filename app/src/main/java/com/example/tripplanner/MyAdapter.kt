package com.example.tripplanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var list: ArrayList<MyModel>):RecyclerView.Adapter<MyAdapter.DataHolder>() {
    class DataHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txtDestination: TextView = itemView.findViewById(R.id.txtDestination)
        var imgDestination: ImageView = itemView.findViewById(R.id.imgDestination)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.custom_layout,parent,false)
        return DataHolder(inflater)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val data = list[position]
        holder.txtDestination.text = data.destination
        holder.imgDestination.setImageBitmap(data.img)
    }
}