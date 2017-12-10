package com.max

import java.util.concurrent.locks.Lock

fun main(args: Array<String>) {
    println(people.filter { it.age < 30 })
}
inline fun <T> synchronized(lock: Lock, noinline action: () -> T): T {
    lock.lock()
    try {
        test(action)
        return action()
    }
    finally {
        lock.unlock()
    }
}
fun <T> test(action: () -> T) {}

fun foo(l: Lock) {
    println("Before sync")
    synchronized(l) {
        println("Action")
    }
    println("Action")
}
///////////collections
data class Person2(val name: String, val age: Int)
val people = listOf(Person2("Alice", 29), Person2("Bob", 31))

