package com.max

fun main(args: Array<String>) {
    val authors = listOf("Dmitry", "Svetlana")
    val authors2 = listOf("Dmitry", 2)
    val authors3: List<String> = listOf("Dmitry", "Sveta")
//    val authors4: List = listOf("Dmitry", "Sveta")
}

fun <T> gen(t: T, predicate: (T) -> T): T {
    return t
}
interface MyList<T> {
    operator fun get(t: T): T = t
}
class StringList: MyList<String> {
}
class GenericList<T>: MyList<T> {
}
fun <T : Number> oneHalf(value: T): Double {
    return value.toDouble() / 2.0
}