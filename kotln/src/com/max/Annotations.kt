package com.max

fun main(args: Array<String>) {

}
const val message = ""
@Deprecated(message)
@MyAnnotation("")
fun test() {}

@Target(AnnotationTarget.PROPERTY, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class MyAnnotation(val name: String)