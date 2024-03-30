package com.example.servicelearning

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat

class MusicForegroundService : Service() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var notificationManager: NotificationManager

    override fun onCreate() {
        super.onCreate()

        notificationManager =
            application.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(
                NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_Name,
                    NotificationManager.IMPORTANCE_DEFAULT
                )
            )
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer.start()

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                    .setContentTitle("Đường về nhà - Đen, Zephyr")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setOngoing(true)
                    .setSilent(true)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setCategory(Notification.CATEGORY_SERVICE)
                    .addAction(
                        0,
                        "Turn off",
                        PendingIntent.getActivity(
                            this,
                            100,
                            Intent(this, MainActivity::class.java).apply {
                                this.putExtra("status", "off")
                            },
                            PendingIntent.FLAG_MUTABLE
                        )
                    )

                this.startForeground(100, builder.build())
            } else {
                Toast.makeText(
                    this,
                    "This feature isn't compatible with this device.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } catch (e: Exception) {
            Log.e(TAG, "startForeground: " + e.message)
        }

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }
}