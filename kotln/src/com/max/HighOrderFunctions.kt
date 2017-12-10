package com.max

fun main(args: Array<String>) {
    val sum = { x: Int, y: Int -> x + y }
    val action = { println(42) }
    val sum2: (Int, Int) -> Int = { x, y -> x + y }
    val action2: () -> Unit = { println(42) }

    twoAndThree { a, b -> a + b }
    twoAndThree { a, b -> a * b }
}
fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}
fun toString(transform: (it: Int) -> String? = { it.toString() }) {}

fun getShippingCostCalculator(bool: Boolean): (i: Int) -> Double {
    if (bool) {
        return { i -> i * 1.5 }
    }
    return { i -> i * 1.3 }
}