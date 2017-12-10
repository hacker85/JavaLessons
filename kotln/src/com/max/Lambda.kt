package com.max

fun main(args: Array<String>) {
    val sum = { x: Int, y: Int -> x + y }
    sum(1,2);
    { println(42) }()
    run { println(42) };
    { x: Int, y: Int -> print(x + y); print("" + x + y) }(1,2)
    val getAge = { person: P -> person.age() }
    val getAge2 = P::age
    fun salute() = println("Salute!")
    run(::salute)
//    val action = { s: String, integer: Int ->
//        two(s, integer)
//    }
//    val nextAction = ::two
    val personContructor = ::P
    val person = personContructor()
    person.age()

    fun P.isAdult() = age() >= 21
    val predicate = P::isAdult
    person.isAdult()
}
//fun two(s: String, integer: Int){}
class P() {
    fun age(): Int = 5
}
//////////////////////
class Person(var name: String, var age: Int)
fun collection() {
    val list = listOf(1, 2, 3, 4)
    list.filter { it % 2 == 0 }
    list.map { it * it }

    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    people.map { it.age > 30 }
    people.map(Person::name)

    people.filter { it.age > 30 }.map(Person::name)
    people.asSequence().filter { it.age > 30 }.map(Person::name).toList()

    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toUpperCase() })

    val canBeInClub27 = { p: Person -> p.age <= 27 }
    println(people.all(canBeInClub27))
    println(people.any(canBeInClub27))
    println(!people.any(canBeInClub27))
    println(people.count(canBeInClub27))
    println(people.find(canBeInClub27))//first matching or null
    println(people.groupBy { it.age })
}