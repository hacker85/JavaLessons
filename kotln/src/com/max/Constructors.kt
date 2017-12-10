package com.max

fun main(args: Array<String>) {
//    var v = User2()
//    v.name = "Mike"
//    print(v.name)
    var k = Client("Max", 1)
    print(k)
}

class Student(name: String)

class Student2 constructor(_name: String = "Max") {
    val name: String
    init {
        name = _name
    }
}
class Student3(_nickname: String)
{ val nickname = _nickname}

open class Student4 (val nickname: String)
class Student5(nickname: String) : Student4(nickname)

open class Student6
class Student7: Student6()

class Student8 private constructor()

open class Student9 {
    constructor()
    constructor(i: Int)
}

//class Student10: Student9() {
class Student10: Student9 {
//    constructor()
    constructor(): this(5)
    constructor(i: Int): super(5) {}
}

/////////////////
interface User1 {
    abstract val name: String
    val nickname: String get() = name.substringBefore(' ')
}
class PrivateUser(override val name: String) : User1
class SubscribingUser(val famiryName: String) : User1 {
    override val name: String get() = famiryName.substringBefore(' ')
}
class User2 {
    private var name: String = "Max"
        get() = field
        private set(value: String) {
            field = value
        }
}
///////////////
data class Client(val name: String, val postalCode: Int) {
//    override fun toString() = "Client(name=$name, postalCode=$postalCode)"
//    override fun equals(other: Any?): Boolean {
//        if (other == null || other !is Client)
//            return false
//        return name == other.name && postalCode == other.postalCode
//    }
//    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
//    fun copy(name: String = this.name, postalCode: Int = this.postalCode) = Client(name, postalCode)
}
///////////
class DelegatingCollection<T>(innerList: Collection<T> = ArrayList<T>()): Collection<T> by innerList {}
////////////////