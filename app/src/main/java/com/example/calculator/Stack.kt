package com.example.calculator

class Stack {

    private var top = 0
    var a = ArrayList<Model>()

    fun isEmpty(): Boolean {
        return top < 0
    }

    fun push(x: Model): Boolean {
        return when {
            top > a.size -> {
                println("Stack overflow")
                false
            }
            top < a.size -> {
                a[top] = x
                true

            }
            else -> {
                top++
                a.add(x)
                println("$x pushed into stack")
                true
            }
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