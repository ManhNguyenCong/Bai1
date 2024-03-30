package com.example.servicelearning

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MyBoundService: Service() {
    inner class MyBinder: Binder() {
        fun getService(): MyBoundService {
            return this@MyBoundService
        }
    }

    override fun onBind(p0: Intent?): IBinder {
        return MyBinder()
    }

    fun sum(num1: Double, num2: Double): Double {
        return num1 + num2
    }
}