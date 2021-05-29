package com.rajeev.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rajeev.service.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    lateinit var activityMainBinding: ActivityMainBinding
    var num:Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setTitle("Bawasir Gana")
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(activityMainBinding.root)



        activityMainBinding.startStopButton.setOnClickListener(View.OnClickListener {

            playsong()



        })


    }

    private fun playsong() {
        if(num == false) {
            activityMainBinding.pauseButton.visibility = View.GONE
            activityMainBinding.playButton.visibility = View.VISIBLE
            startService(Intent(this, MyService::class.java))
            activityMainBinding.startStopButton.text = "stop"
            num = true

        }
        else
        {
            activityMainBinding.pauseButton.visibility = View.VISIBLE
            activityMainBinding.playButton.visibility = View.GONE
            stopService(Intent(this,MyService::class.java))
            activityMainBinding.startStopButton.text = "Start"
            num = false

        }
    }


}