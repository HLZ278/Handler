package com.example.handler

import android.util.Log

open class Handler {

    private var mQueue:MessageQueue? = null
    private var mLooper:Looper?=null
    init {
        mLooper = Looper.myLooper()
        this.mQueue = mLooper?.mQueue
    }

    fun sendMessage(msg:Message){
        msg.target=this

        mQueue?.enqueueMessage(msg)


    }
    open fun handleMessage(msg:Message){

    }

    fun dispatchMessage(msg:Message){
        handleMessage(msg)
    }
}