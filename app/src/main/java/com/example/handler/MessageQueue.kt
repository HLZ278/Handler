package com.example.handler

import android.util.Log
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class MessageQueue {
    val TAG = "sssssssss"
    var putIndex:Int = 0
    var takeIndex:Int = 0
    var count:Int = 0
    private var lock: Lock? = null
    private var notEmpty: Condition? = null
    private var notFull: Condition? = null
    var items:Array<Message?>
    init {
        items = Array(20, {null})
        this.lock = ReentrantLock()
        this.notEmpty = (lock as ReentrantLock).newCondition()
        this.notFull = (lock as ReentrantLock).newCondition()
    }

    fun enqueueMessage(msg:Message) {
        try {
            lock?.lock()

            while (count == items.size){
                notFull?.await()

            }
            Log.i("22222222","22222222")
            items?.set(putIndex, msg)
            putIndex = if (++putIndex == items?.size) 0 else putIndex
            count++
            notEmpty?.signalAll()
        }finally {
            lock?.unlock()
        }

    }
    fun next():Message?{
        var msg: Message? = null
        try {
            lock?.lock()
            while (count==0){
                notEmpty?.await()
            }
            items.let {
                msg = it?.get(takeIndex)
                it?.set(takeIndex, null)
                takeIndex = if (++takeIndex == items?.size) 0 else takeIndex
                count--
                notFull?.signalAll()
            }
        }finally {
            lock?.unlock()
        }
        return  msg;
    }
}