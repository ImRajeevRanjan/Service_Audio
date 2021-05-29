package com.rajeev.service

import android.app.Service
import android.content.Intent
import android.content.res.AssetManager
import android.media.MediaPlayer
import android.os.IBinder
import java.io.FileInputStream

class MyService : Service() {

    lateinit var player:MediaPlayer

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer()

        val assets:AssetManager = getAssets()
        player = MediaPlayer.create(this, R.raw.music)
   //    player.prepare()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        player.start()
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }
}