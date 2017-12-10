package com.max

//import CallFunction.lastChar as last

var i = 5;
fun main(args: Array<String>) {
    print(message = i)
    def()
//    print("ho".lastChar())
//    print("String".lastChar)
    print("Hello " concat  "world!" )
    print(arrayOf(1,2,3).size)

    //lot of code
    print(i + 1)
    //more code

    //lot of code
    print(i + 2)
    //more code
    fun prnt(j: Int) {
        //lot of code
        print(i + j)
        //more code
    }
    prnt(i + 1)
    prnt(i + 2)
}
fun def(s: String = "hello") {
    print(s)
}
//fun String.lastChar(): Char = get(length - 1)//don't work on inheritance
//fun String.lastChar(): Char = this.get(this.length - 1)
//val String.lastChar: Char get() = get(length - 1)
infix fun String.concat(other: String) = this + other

fun arrayOf(vararg vals: Int): IntArray {
    val array = IntArray(vals.size)
    for(i in 0..vals.size - 1) {
        array.set(i, vals[i])
    }
    return array
}
