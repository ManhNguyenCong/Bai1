package com.example.fragmentlearning

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Other activity")

        setContentView(R.layout.activity_other)

        // Add third fragment and fourth fragment
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<ThirdFragment>(R.id.fragmentContainerView1)
            add<FourthFragment>(R.id.fragmentContainerView2)
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Other activity")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Other activity")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Other activity")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Other activity")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: Other activity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Other activity")
    }
}