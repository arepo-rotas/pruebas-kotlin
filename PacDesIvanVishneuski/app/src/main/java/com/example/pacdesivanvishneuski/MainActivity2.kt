package com.example.pacdesivanvishneuski

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.FileObserver.*
import android.widget.Button
import android.widget.Toast
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import androidx.room.*



class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Toast.makeText(getApplicationContext(), "Entramos en la Activity 2", Toast.LENGTH_LONG).show()
        val btnActivity1 = findViewById<Button>(R.id.btnActivity1)
        val btnCrearTabla = findViewById<Button>(R.id.btnCrearTabla)
        val btnInsertar = findViewById<Button>(R.id.btnInsertar)
        val btnConsultar = findViewById<Button>(R.id.btnConsultar)

        btnActivity1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnCrearTabla.setOnClickListener {
            Toast.makeText(this, "La tabla Ejemplo se ha creado", Toast.LENGTH_LONG).show()
            val intent = Intent(this, CrearTabla::class.java)
            startActivity(intent)

        }
        btnInsertar.setOnClickListener {
            val intent = Intent(this, InsertarDatos::class.java)
            startActivity(intent)
        }
        btnConsultar.setOnClickListener {
            val intent = Intent(this, Consultar::class.java)
            startActivity(intent)
        }

    }
}
