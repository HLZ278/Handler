package com.example.handler

import android.app.IntentService
import android.content.Context
import android.content.SyncStatusObserver
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.IntegerRes
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Looper.prepare()

        val handler:Handler = object :Handler(){
            override fun handleMessage(msg: Message) {
                System.out.println(Thread.currentThread().name+",received:"+msg.toString())
            }
        }
        for (i in 1..5){
            Thread(object :Runnable{
                override fun run() {
                    val msg = Message()
                    msg.what = 1
                   //
                    Log.i("1111111","1333333")
                    synchronized(UUID::class.java){
                        msg.obj = Thread.currentThread().name+"ssssssssssssssssssss "
                        Log.i("1111111","11111111")
                    }
                    handler.sendMessage(msg)
                    //Log.i("22222222","22222222")
                    System.out.println("哈哈"+ msg)
                    try {
                        Thread.sleep(1000)
                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                }

            }).start()

        }

        Looper.loop()
    }



}
