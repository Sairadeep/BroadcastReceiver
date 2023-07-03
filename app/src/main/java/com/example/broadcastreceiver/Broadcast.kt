package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Broadcast : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        // When the device switches to a airplane mode, show a toast system after the class
        // knowing it from the system using the broadcast.

        val isAirPlaneMode: Boolean = intent!!.getBooleanExtra(
            // Parameter 1 -> KeyWord
            // Parameter 2 -> Default value i.e., false
            "state",
            false
        // !! -> non - null assertion, if the device switches from the 'normal' mode to the 'airplane mode', system will send 'true'.
        // if the device switches from the 'airplane' mode to the 'normal mode' -> system will send 'false'.
        )

        if (isAirPlaneMode) {
            Toast.makeText(
                context,
                "The device is currently in Airplane mode.",
                Toast.LENGTH_LONG
            ).show()
        }
        else{
            Toast.makeText(
                context,
                "The device is currently in Normal mode.",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}