package com.max

fun main(args: Array<String>) {
    val i: Int = 1
    val j: Int? = null
    val l: Long = i.toLong()
    val list: List<Int> = listOf(1, 2, 3)
    l.toInt() in list
    var any: Any = 5
    var any2: Any = "Str"
    var any3: Any? = null
    var unit: Unit
}
fun f(): Unit { }
fun fail(): Nothing {
//    return Nothing()
    throw IllegalStateException()
}