package com.max
fun main(args: Array<String>) {
    var i = 1..10
    for(j in i)
        print(j)
    for(i in 10 downTo 1 step 1)
        print(i)
    for(i in 1..10)
        print(i)
    for(i in 1 until 10)
        print(i)
    for(j in i)
        if(j !in 5..10) print(j)
}
