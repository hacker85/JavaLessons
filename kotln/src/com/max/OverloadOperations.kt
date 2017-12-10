package com.max

import java.math.BigDecimal

fun main(args: Array<String>) {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2)
    var point = Point(1, 2)
    point += Point(3, 4)
    println(point)

    val list = arrayListOf(1, 2)
    list += 3
    val newList = list + listOf(4, 5)
    println(list)
    println(newList)

    val p = Point(10, 20)
    println(-p)

    /////compare
    print(Point(0,0) == Point(0,0))
    print(Point(0,0) === Point(0,0))
    print(Point(0,0).equals(Point(0,0)))

    print(Point(0,0) > (Point(0,0)))

    ////collections and arrays
    println(p[1])
    println(5 in Point(20, 30))

    //destructing declaration
//    val (x, y) = p
//    println(x)
//    println(y)
}
data class Point(val x: Int, val y: Int) : Comparable<Point> {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
    operator fun unaryMinus(): Point {
        return Point(-x, -y)
    }
//    operator fun inc(): Point {
//        return Point(--x, --y)
//    }
    override fun compareTo(other: Point): Int {
        return compareValuesBy(this, other, Point::x, Point::y)
    }
    operator fun get(index: Int): Int {
        return when(index) {0 -> x 1 -> y else -> throw IndexOutOfBoundsException("Invalid coordinate $index") }
    }
    operator fun contains(i: Int): Boolean {
        return i in this.x until this.y
    }
//    operator fun component1() = x
//    operator fun component2() = y
}
operator fun BigDecimal.inc() = this + BigDecimal.ONE