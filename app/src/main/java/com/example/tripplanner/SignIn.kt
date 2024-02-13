package com.example.tripplanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth

class SignIn : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var edtEmail1: EditText
    lateinit var edtPassword1: EditText
    lateinit var btnSignIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        auth = FirebaseAuth.getInstance()

        edtEmail1 = findViewById(R.id.edtEmail1)
        edtPassword1 = findViewById(R.id.edtPassword1)
        btnSignIn = findViewById(R.id.btnSignIn)

        btnSignIn.setOnClickListener {
            var email = edtEmail1.text.trim().toString()
            var pass = edtPassword1.text.trim().toString()
            auth?.signInWithEmailAndPassword(email,pass)?.addOnSuccessListener {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}