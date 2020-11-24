package com.example.pacdesivanvishneuski

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Handler
import android.os.IBinder
import android.widget.Toast


class Service: Service() {
    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable

    override fun onBind(intent: Intent): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {

        Toast.makeText(this, "Servicio Iniciado", Toast.LENGTH_LONG).show()

        mHandler = Handler()
        mRunnable = Runnable { playMusic() }
        mHandler.postDelayed(mRunnable, 5000)

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Servicio Destruido", Toast.LENGTH_LONG).show()
        mHandler.removeCallbacks(mRunnable)
    }


    private fun playMusic() {
        var player: MediaPlayer? = null
        player = MediaPlayer.create(this, R.raw.junio)
        player!!.isLooping = true
        mHandler.postDelayed(mRunnable, 5000)
    }
}











