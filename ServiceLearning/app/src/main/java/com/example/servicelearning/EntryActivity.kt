package com.example.servicelearning

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EntryActivity : AppCompatActivity() {
    private lateinit var service: MyBoundService
    private var mBound = false

    private var connection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, binder: IBinder?) {
            service = (binder as MyBoundService.MyBinder).getService()
            mBound = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            mBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        findViewById<Button>(R.id.btnCalculate).setOnClickListener {
            if (mBound) {
                val edtFirstNum = findViewById<EditText>(R.id.edtFirstNumber).text
                val edtSecondNum = findViewById<EditText>(R.id.edtSecondNumber).text

                if (edtFirstNum.isNullOrEmpty() || edtSecondNum.isNullOrEmpty()) {
                    Toast.makeText(this, "Enter two numbers!!!", Toast.LENGTH_SHORT).show()
                }

                val result = service.sum(
                    edtFirstNum.toString().toDouble(),
                    edtSecondNum.toString().toDouble()
                )
                findViewById<TextView>(R.id.tvResult).text = "Result: $result"
            }
        }
    }

    override fun onStart() {
        super.onStart()
        bindService(
            Intent(this, MyBoundService::class.java),
            connection,
            Context.BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
        mBound = false
    }
}