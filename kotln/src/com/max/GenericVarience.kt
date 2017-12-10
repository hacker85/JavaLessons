package com.max

fun main(args: Array<String>) {
    var list :List<Animal> = ArrayList<Cat>()
    var producer :Producer<Animal> = Producer<Cat>()
    var producer2 :Producer2<Cat> = Producer2<Animal>()
    var producer3 :Producer<*> = Producer<Animal>()
    var producer4 :Producer2<*> = Producer2<Animal>()
}
class Producer<out T> {
//    operator fun invoke():T
}
class Producer2<in T> {
    fun produce(t: T) {}
}
class Producer3<in T, out R> {
//    operator fun invoke(t: T): R
}
open class Animal {}
class Cat : Animal() {}