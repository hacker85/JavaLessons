package com.max

import kotlin.reflect.KFunction
import kotlin.reflect.full.memberProperties

fun main(args: Array<String>) {
    val person = Person33("Alice", 29)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    kClass.memberProperties.forEach { println(it.name) }

    val kFunction = ::foo22
    kFunction.call(42)

    val kFunction2 = ::sum22
    println(kFunction2.invoke(1, 2) + kFunction2(3, 4))

    val kProperty = ::counter
    kProperty.setter.call(21)
    println(kProperty.get())

    val memberProperty = Person33::age
    println(memberProperty.get(person))
}

class Person33(val name: String, val age: Int)

fun foo22(x: Int) = println(x)
fun sum22(x: Int, y: Int) = x + y

var counter = 0