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
    private var player: MediaPlayer? = null

    override fun onBind(intent: Intent): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer.create(this, R.raw.junio)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {

        Toast.makeText(this, "Servicio Iniciado", Toast.LENGTH_LONG).show()

        mHandler = Handler()
        mRunnable = Runnable { player?.start() } //hay que darle al play al player cuando el servicio arranca
        mHandler.postDelayed(mRunnable, 1000)

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.stop() // hay que darle stop cuando el servicio para
        Toast.makeText(this, "Servicio Destruido", Toast.LENGTH_LONG).show()
        mHandler.removeCallbacks(mRunnable)
    }


//    private fun playMusic() {
//        println("playMusic")
//        var player = MediaPlayer.create(this, R.raw.junio)
//        player.start()
////        val mediaPlayer: MediaPlayer? = MediaPlayer.create(this, R.raw.junio)
////        mediaPlayer?.start() // no need to call prepare(); create() does that for you
//        player!!.isLooping = true
////        mHandler.postDelayed(mRunnable, 5000)
//    }
}











