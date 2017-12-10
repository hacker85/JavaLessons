package com.max

fun main(args: Array<String>) {
//    lookForAlice(people)
}

fun lookForAlice(people: List<Person>) {
    people.forEach label@{
        if (it.name == "Alice") return@label
    }
    println("Alice might be somewhere")
}

fun lookForAlice2(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return@forEach
        }
    }
    println("Alice is not found")
}