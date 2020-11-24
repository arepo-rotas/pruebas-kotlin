package com.example.pacdesivanvishneuski

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class control : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control)

        val serviceClass = Service::class.java

        val intent = Intent(this, serviceClass)
        val btnStart =findViewById<Button>(R.id.btnStart)
        val btnStop =findViewById<Button>(R.id.btnStop)
        val btnStatus =findViewById<Button>(R.id.btnStatus)

        btnStart.setOnClickListener {

            if (!isServiceRunning(serviceClass)) {
                startService(intent)
            } else {
                Toast.makeText(this, "Servicio ya iniciado", Toast.LENGTH_LONG).show()
            }
        }

        btnStop.setOnClickListener {
            if (isServiceRunning(serviceClass)) {
                stopService(intent)
            } else {
                Toast.makeText(this, "Servicio ya detenido", Toast.LENGTH_LONG).show()
            }
        }

        btnStatus.setOnClickListener {
            if (isServiceRunning(serviceClass)) {
                Toast.makeText(this, "Status: Servicio iniciado", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Status: Servicio detenido", Toast.LENGTH_LONG).show()
            }
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
