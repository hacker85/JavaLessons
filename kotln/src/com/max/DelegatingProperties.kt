package com.max

import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    val foo = Foo()
    print(foo.p)
    foo.p = 6
    print(foo.p)
}
class Foo {
    var p: Int by Delegate(5)
}

class Delegate(var value: Int) {
    operator fun getValue(foo: Foo, kProperty: KProperty<*>) :Int { return value  }
    operator fun setValue(foo: Foo, kProperty: KProperty<*>, value: Int) { this.value = value }
}