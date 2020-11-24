package com.example.pacdesivanvishneuski

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*

class Consultar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)
        val consulta = findViewById<TextView>(R.id.texto)

//uso de corutina para poder llamar a la función suspendida getTabla()
        lifecycleScope.launch {

            val dao = PruebaDb.getDatabase(application).dao
            val recibir = dao.getTabla()
            consulta.text = recibir.toString()
        }

    }
}