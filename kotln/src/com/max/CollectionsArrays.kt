package com.max

fun main(args: Array<String>) {
    val result = ArrayList<Int?>()
    /////
    val arr1 = arrayOf(1,2,3)
    val arr2 = arrayOfNulls<Int>(10)
    val arr3 = Array(26) { i -> ('a' + i).toString() }
    val arr4 = IntArray(5)
    val arr5 = intArrayOf(0, 0, 0, 0, 0)
    val arr6 = IntArray(5) { i -> (i+1) * (i+1) }
}
fun arrays(numbers: List<Int?>) {}
fun arrays2(numbers: List<Int?>?) {}
fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>, list: List<T>, mutableList: MutableList<T>) {}