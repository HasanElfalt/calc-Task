package com.example.calculator

class Stack {

    val MAX = 1000
    var top = 0
    var a = ArrayList<Model>(MAX)

    fun Stack() {
        top = -1
    }

    fun isEmpty(): Boolean {
        return top < 0
    }

    fun push(x: Model): Boolean {
        return if (top >= MAX - 1) {
            println("Stack overflow")
            false
        } else {
            top++
            a[top] = x
            println("$x pushed into stack")
            true
        }
    }

    fun pop(): Model? {
        return if (top < 0) {
            println("Stack Underflow")
            null
        } else {
            val x = a[top]
            top--
            println("$x popped from stack")
            x
        }
    }

    fun peek(): Model? {
        return if (top < 0) {
            println("Stack Underflow")
            null
        } else {
            a[top]
        }
    }
}