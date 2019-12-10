package com.example.aop

import java.lang.annotation.ElementType

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class BehaviorTrace(val value:String)