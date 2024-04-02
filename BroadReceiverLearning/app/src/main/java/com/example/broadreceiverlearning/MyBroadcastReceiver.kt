package com.example.broadreceiverlearning

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.util.Log
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("MyBroadcastReceiver", "onReceive: " + intent?.action)

        val wifiState =
            intent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_DISABLED)

        if (wifiState == WifiManager.WIFI_STATE_DISABLED) {
            Toast.makeText(context, "Turn off wifi...", Toast.LENGTH_SHORT).show()
        }
    }
}