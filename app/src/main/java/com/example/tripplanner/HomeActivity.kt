package com.example.tripplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.storage

class HomeActivity : AppCompatActivity() {
    var list = ArrayList<MyModel>()
    lateinit var rcyView: RecyclerView
    lateinit var storage: FirebaseStorage
    lateinit var storageReference: StorageReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        rcyView = findViewById(R.id.rcyView)

        storage = Firebase.storage
        storageReference = storage.getReference("/trip")

        list.add(MyModel("Goa","/trip/goa.jpg","11500"))
        list.add(MyModel("Himachal","/trip/himachal.jpg","5500"))
        list.add(MyModel("Kashmir","/trip/kashmir.jpg","6500"))
        list.add(MyModel("Rajasthan","/trip/rajasthan.jpg","4500"))
        list.add(MyModel("Mumbai","/trip/mumbai.jpg","9500"))
        var layoutManager = LinearLayoutManager(this)
        rcyView.layoutManager = layoutManager
        val adapter = MyAdapter(this,list)
        rcyView.adapter = adapter
    }
}