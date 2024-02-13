package com.example.tripplanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {
    lateinit var imgSplash: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        imgSplash = findViewById(R.id.imgSplash)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        imgSplash.setImageResource(R.drawable.tripplanner)
        val anim = AnimationUtils.loadAnimation(this, R.anim.bounce_anim)
        imgSplash.startAnimation(anim)
        Handler().postDelayed({
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
            finish()
        },3000)

    }
}