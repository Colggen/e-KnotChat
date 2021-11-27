package com.example.e_knotchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bt: Button = findViewById(R.id.nextBt)
        var ed:TextInputEditText = findViewById(R.id.adress)

        val myRef = FirebaseDatabase.getInstance().reference.child("Peoples")


        bt.setOnClickListener {

            if(!ed.text.toString().isNullOrEmpty()){
                myRef.push().setValue(ed.text.toString())
                val intent = Intent(this,SecondActivity::class.java)
                intent.putExtra("adress",ed.text.toString())
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Пожалуйста, введите ваш адресс",Toast.LENGTH_SHORT).show()
            }
        }
    }
}