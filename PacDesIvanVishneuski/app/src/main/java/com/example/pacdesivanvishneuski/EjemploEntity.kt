package com.example.pacdesivanvishneuski

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.room.*

@Entity(tableName = "Ejemplo")
data class EjemploEntity(
    @PrimaryKey val id: String,
    val nombre: String,
    val edad: String)