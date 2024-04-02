package com.example.fragmentlearning

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Main activity")

        setContentView(R.layout.activity_main)

        // Add fragment A
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<FirstFragment>(R.id.fragmentContainerView)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Main activity")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Main activity")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Main activity")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Main activity")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: Main activity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Main activity")
    }
}