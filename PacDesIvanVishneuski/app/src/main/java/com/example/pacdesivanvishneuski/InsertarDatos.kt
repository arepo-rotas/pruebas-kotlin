package com.example.pacdesivanvishneuski

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch


class InsertarDatos : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar_datos)
        val editId = findViewById<EditText>(R.id.editId)
        val editNombre = findViewById<EditText>(R.id.editNombre)
        val editEdad = findViewById<EditText>(R.id.editEdad)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        btnGuardar.setOnClickListener {
            var id = editId.text.toString()
            var Nombre = editNombre.text.toString()
            var Edad = editEdad.text.toString()
//uso de corutina para poder llamar a la función suspendida addEntrada()
            lifecycleScope.launch {
                val dao = PruebaDb.getDatabase(application).dao
                dao.addEntrada(EjemploEntity(id, Nombre, Edad))
            }


            finish()

        }
    }
}