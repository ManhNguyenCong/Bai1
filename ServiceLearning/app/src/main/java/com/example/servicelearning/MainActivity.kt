package com.example.servicelearning

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentToBackService = Intent(this, MusicBackgroundService::class.java)
        val intentToForeService = Intent(this, MusicForegroundService::class.java)

        findViewById<Button>(R.id.btnBackgroundService).setOnClickListener {
            // Stop all service
            stopService(intentToBackService)
            stopService(intentToForeService)

            // Start background service
            startService(intentToBackService)
        }

        findViewById<Button>(R.id.btnForegroundService).setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // Stop all service
                stopService(intentToBackService)
                stopService(intentToForeService)

                // Start foreground service
                startForegroundService(intentToForeService)
            } else {
                Toast.makeText(
                    this,
                    "This feature isn't compatible with this device.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Stop foreground service when click to turn off in notification
        if (intent.getStringExtra("status") == "off") {
            stopService(intentToForeService)
        }

        // Navigate to entry activity
        findViewById<Button>(R.id.btnBoundService).setOnClickListener {
            startActivity(Intent(this, EntryActivity::class.java))
        }
    }
}