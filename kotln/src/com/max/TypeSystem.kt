package com.max

fun main(args: Array<String>) {
    var n: String?
    n = ""
//    n = null
    strLen(n)
    val x: String? = null
//    var y: String = x
    strLen2(x)
    strLen2(x ?: "")//if null set ""

    var str = n as? String
    val sNotNull: String = str!!//null pointer exception

    val s: String? = ""
//    strLen(s)
    s?.let { s -> strLen(s)}
}
fun strLen(s: String) = s.length
fun strLen2(s: String?) = if (s != null) s.length else 0
fun strLen3(s: String?) = s?.length
class TypeSystem {
    private lateinit var myString: String
}
fun String?.isNullOrBlank(): Boolean =
        this == null || this.isBlank()