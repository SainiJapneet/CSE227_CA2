package com.example.tripplanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText
    lateinit var txtSignUp: TextView
    lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        txtSignUp = findViewById(R.id.txtSignUp)
        btnSignUp = findViewById(R.id.btnSignUp)

        btnSignUp.setOnClickListener{
            var email = edtEmail.text.trim().toString()
            var pass= edtPassword.text.trim().toString()
            auth?.createUserWithEmailAndPassword(email,pass)?.addOnSuccessListener {
                Toast.makeText(this,"User Created",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
            }
        }
        txtSignUp.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

    }
}