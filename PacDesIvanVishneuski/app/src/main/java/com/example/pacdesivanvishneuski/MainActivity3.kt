package com.example.pacdesivanvishneuski
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val btnVolver1 = findViewById<Button>(R.id.btnVolver1)
        val btnIniciar = findViewById<Button>(R.id.btnIniciar)
        val btnDetener = findViewById<Button>(R.id.btnDetener)
        val serviceClass = Service::class.java




        btnVolver1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnDetener.setOnClickListener {
            if (isServiceRunning(serviceClass)) {
                stopService(intent)
                Toast.makeText(this, "Servicio detenido", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Servicio ya detenido", Toast.LENGTH_LONG).show()
            }
        }

        btnIniciar.setOnClickListener {
            val intent = Intent(this, control::class.java)
            startActivity(intent)


            }

        }
    // Funcion para comprobar el estado del servicio
    private fun isServiceRunning(serviceClass: Class<*>): Boolean {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        for (service in activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                return true
            }
        }
        return false
    }

}