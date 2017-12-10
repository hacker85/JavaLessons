package com.max

fun main(args: Array<String>) {
//    Bar.i = 6
//    Bar.printI()
//    Bar2.Foo
//    Bar2.getI()
    var bar = Bar2.getBar()
    var runnable = object : Runnable {
        override fun run() {
            //new thread
        }
    }
}

object Bar {
    var i = 5
    fun printI() {
        print(i)
    }
    object Foo {}
}

class Bar2 {
    private constructor()
    companion object Foo {
        fun getBar() {
            Bar2()
        }
    }
}