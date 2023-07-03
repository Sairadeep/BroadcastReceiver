package com.example.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    // Create an object for the broadcast class
    var broadcast = Broadcast()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        // Create an object of intent filter class
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        this.registerReceiver(
            // Parameter 1 -> Object of the broadcast receiver class
            // Parameter 2 -> Object of the Intent filter class
            broadcast,
            filter
        )
    }

    override fun onStop() {
        // As the application is stopped, we don't need the broadcast messages.
        super.onStop()
        // Create an object of intent filter class
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        this.unregisterReceiver(
            // Parameter 1 -> Object of the broadcast receiver class
            broadcast
        )
    }
}