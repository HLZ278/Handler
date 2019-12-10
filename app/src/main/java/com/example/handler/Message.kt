package com.example.handler


class Message {
    var target:Handler?=null
    var what: Int = 0
    var obj: Any? = null
    override fun toString(): String {
        return obj.toString()
    }

}