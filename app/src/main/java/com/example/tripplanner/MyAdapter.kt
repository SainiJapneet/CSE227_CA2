package com.example.tripplanner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.storage

class MyAdapter(var ctx: Context,var list: ArrayList<MyModel>):RecyclerView.Adapter<MyAdapter.DataHolder>() {
    lateinit var storage: FirebaseStorage
    lateinit var storageReference: StorageReference
    class DataHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txtDestination: TextView = itemView.findViewById(R.id.txtDestination)
        var imgDestination: ImageView = itemView.findViewById(R.id.imgDestination)
        var txtPrice: TextView = itemView.findViewById(R.id.txtPrice)
        var txtView: TextView = itemView.findViewById(R.id.textView3)
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
        holder.txtPrice.text = data.price

        storage = Firebase.storage
        storageReference = storage.reference
        val imgRef = storageReference.child(data.img)
        imgRef.downloadUrl.addOnSuccessListener { uri ->
            Glide.with(ctx).load(uri).into(holder.imgDestination)
        }
    }
}