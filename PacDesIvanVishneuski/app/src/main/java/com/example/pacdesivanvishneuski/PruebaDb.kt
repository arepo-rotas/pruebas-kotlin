package com.example.pacdesivanvishneuski

import android.content.Context
//import android.content.Entity
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(
    entities = [EjemploEntity::class],
    version = 1,
    exportSchema = false)
    abstract class PruebaDb : RoomDatabase() {
    abstract val dao: PruebaDao
    companion object {
        @Volatile
        private var INSTANCE: PruebaDb? = null

        fun getDatabase(context:Context): PruebaDb {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val NAME = "ejemplo.db"
                val instance = Room.databaseBuilder(context, PruebaDb::class.java, NAME)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }


    }


}