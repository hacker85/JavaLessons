package com.max
fun main(args: Array<String>) {
    val set = setOf(1, 1, 2)
    val list = listOf(1, 2, 3)
    val map = mapOf(1 to "one", 2 to "two")
    print(set.first())
    print(set.last())
    print(set.size)
    print(set.max())
    print(set.average())
    print(set)
}
