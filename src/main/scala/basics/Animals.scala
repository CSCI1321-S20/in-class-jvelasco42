package basics

abstract class Animals(val age: Int, val weight: Double) {
    def sound(): String
}

class Cow(a: Int, w: Double) extends Animals(a, w){
    def sound() = "moo"
}

trait Animals2 {
    val age: Int
    val weight: Double
    def sound(): String
}

class Giraffe(val age: Int, val weight: Double) extends Animals2 {
    def sound() = "bleet"
}