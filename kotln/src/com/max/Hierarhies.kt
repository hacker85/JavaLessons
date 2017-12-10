package com.max

fun main(args: Array<String>) {
    var b: Clickable
    b = Button(5)
}
interface Clickable{
    fun click();
    fun showOff() = println("I'm clickable!")
}
interface Focusable {
    fun showOff() = println("focus")
}

class Button(i:Int) : Clickable, Focusable {
    override fun click() = println("I was clicked")
    override fun showOff() = println("I'm Button!")
}

open class RichButton : Clickable {
    final override fun click() {}
}

abstract class Animated {
    abstract fun animate()
    open fun stopAnimating() {}
    private fun animateTwice() {}
}

internal open class TalkativeButton : Focusable
{ private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}
var two = One().Two();
class One {
    inner class Two{}
}

sealed class Expr {
    class Num(val value: Int) : Expr() {}
}
class Sum() : Expr() {}