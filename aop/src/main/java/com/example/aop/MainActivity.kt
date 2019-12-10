package com.example.aop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    val TAG = "ssssssssss"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @BehaviorTrace("摇一摇")
    fun mShake(view: View) {
        val run = run {
            SystemClock.sleep(3000)
            Log.i(TAG, "摇一摇")
            "g"
        }
    }

    fun mAudio(view: View) {


    }
    fun mText(view: View) {}
}
