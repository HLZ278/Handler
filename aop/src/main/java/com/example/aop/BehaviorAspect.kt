package com.example.aop

import android.util.Log
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature
import java.text.SimpleDateFormat
import java.util.*


@Aspect
class BehaviorAspect {
    val TAG = "ssssssssss"
    //切点
    /**
     * 定义切点，标记切点为所有被@BehaviorTrace注解的方法
     */
    @Pointcut("execution(@com.example.aop.BehaviorTrace * *(..))")//**(..)表示任何方法任何参数
    fun annoBehavior(){

    }
    //切面 定义一个切面方法，包裹切点方法
    @Around("methodAnnotated()")
    @Throws(Throwable::class)
    fun dealPoint(point: ProceedingJoinPoint):Object{
        //方法执行前
        val methodSignature:MethodSignature = point.signature as MethodSignature
        // 获取注解
        val behaviorTrace = methodSignature.method.getAnnotation(BehaviorTrace::class.java)
        val contextType:String = behaviorTrace.value
        Log.i(TAG,"s"+contextType)
        Log.i(TAG, contextType+"开始时间"+ SimpleDateFormat().format(Date()))
        var begin = System.currentTimeMillis()
        //方法执行时
        // 执行原方法体
        val proceed :Object = point.proceed() as Object



        //方法执行完
        Log.i(TAG, "消耗时间:"+(System.currentTimeMillis()-begin)+"ms")
        return proceed
    }
}