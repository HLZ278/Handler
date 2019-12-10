package com.example.handler

import java.lang.RuntimeException

class Looper {
    var mQueue:MessageQueue? = null
    init {
        this.mQueue=MessageQueue()
    }
    companion object{

        val sThreadLocal = ThreadLocal<Looper>()
        fun prepare(){
            if (sThreadLocal.get()!=null){
                throw RuntimeException("error")
            }
            sThreadLocal.set(Looper())
        }
        fun myLooper(): Looper? {
            return sThreadLocal.get()
        }
        fun loop(){
            val me = myLooper()
            if(me == null){
                throw RuntimeException("error1")
            }
            val queue = me.mQueue
            while (true){
                val msg = queue?.next()
                if(msg ==  null){
                    continue
                }
                msg.target?.dispatchMessage(msg)


            }
        }
    }

}