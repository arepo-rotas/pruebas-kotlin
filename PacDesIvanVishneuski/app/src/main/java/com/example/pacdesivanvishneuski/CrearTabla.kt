package com.example.pacdesivanvishneuski

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.*
import android.widget.Toast
import android.content.Context
import android.content.Intent
import android.widget.Button
import androidx.room.Database
import android.widget.ImageButton

class CrearTabla : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_tabla)

        Toast.makeText(this, "La tabla Ejemplo se ha creado", Toast.LENGTH_LONG).show()
        val btnVolver2 = findViewById<ImageButton>(R.id.btnVolver2)

        btnVolver2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}
  