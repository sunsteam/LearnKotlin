package com.yomii.basic

import org.junit.Test

/**
 * 基础语法
 *
 * 结尾不需要分号
 */
class Syntax {


    @Test
    fun main() {
        print("打印函数sum(3,5), 结果: ")
        println(sum(3, 5))

        println("打印函数sum1(3,5), 结果: ${sum1(3, 5)}")

        printSum(3, 5)

        //definingLocalVariables()
        //equals()
        arrays()
    }

    /**
     * 两个Int 相加 返回 Int
     */
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * 自动推断参数类型和返回结果的写法
     */
    fun sum1(a: Int, b: Int) = a + b

    /**
     *
     * 标准写法, 无返回值类型时, : Unit 可以省略
     *
     * fun printSum(a: Int, b: Int): Unit {
     *   println("sum of $a and $b is ${a + b}")
     * }
     */
    fun printSum(a: Int, b: Int) {
        println("sum of $a and $b is ${a + b}")
    }


    fun definingLocalVariables() {
        /*
         * var 代表可变变量, val代表不可变变量(只读)
         *
         * 在直接赋值时, 类型可自动推断, 无需写类型
         *
         */
        var a: Int = 5

        var b: Int

        if (a == 5)
            b = 6
        else
            b = 1

        val c = 999

        println("a = $a, b = ${++b}, c = $c")

    }

    fun equals() {
        val a: Int = 10000
        println(a === a) // 输出“true”
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a
        println(boxedA == anotherBoxedA)
        println(boxedA === anotherBoxedA) // ！！！输出“false”！！！
    }

    fun arrays(){

        /*我们可以使用库函数 arrayOf() 来创建一个数组并传递元素值给它，这样 arrayOf(1, 2, 3) 创建了 array [1, 2, 3]。
        或者，库函数 arrayOfNulls() 可以用于创建一个指定大小、元素都为空的数组。*/

        val arrayOf = arrayOf(1, 2, 3)
        val arrayOfNulls = arrayOfNulls<Int>(5)

        /*该构造第一个参数是size, 第二个参数是一个lamb函数, 入参 i 代表数组index
         *返回给定index的每个元素初始值
         */
        val arr = Array(3,{i -> i })

        for (i in arr) {
            println(i)
        }
    }
}
