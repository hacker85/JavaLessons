package com.max

import java.util.*
import javax.xml.ws.Service

fun main(args: Array<String>) {
    var value: List<Int> = ArrayList<Int>()
    check(value)

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())
}
fun check(value: Any) {
//    value is List<String>
    value is List<*>
}
//fun <T> isA(value: Any) = value is T
inline fun <reified T> isA(value: Any) = value is T