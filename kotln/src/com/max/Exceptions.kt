package com.max

import java.io.IOException

fun main(args: Array<String>) {
    var i = try {
        throw IOException("hello")
        throw Exception("hello")
        1
    } catch (e: Exception) {
        print("catch")
        2
    } finally {
        print("finaly")
        3
    }
    print(i as Int)
}