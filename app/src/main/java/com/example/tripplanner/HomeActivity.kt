package com.example.tripplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    var list = ArrayList<MyModel>()
    lateinit var rcyView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        rcyView = findViewById(R.id.rcyView)

        var layoutManager = LinearLayoutManager(this)
        rcyView.layoutManager = layoutManager
    }
}