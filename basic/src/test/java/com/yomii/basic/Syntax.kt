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

        //maxOf()
        //maybeNull()
        //useWhen()
        //useFor()
        useWhile()
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
        //字符串中可以通过'$'符号引用变量, ${}作为函数
        println("sum of $a and $b is ${a + b}")
    }

    /**
     * 使用条件表达式的推断返回值类型写法
     */
    fun maxOf(a: Int, b: Int) = if (a > b) a else b


    /**
     * 使用条件表达式赋值并判断非空
     */
    fun maybeNull() {
        val intArray = IntArray(5, { i -> i })
        var a: Int?
        for (number in intArray) {
            a = if (number % 2 == 0) {
                println("双数, 赋值")
                number
            } else {
                println("单数, null")
                null
            }

            if (a != null)
                println(a * 5)
        }
    }


    fun useWhen() {

        val a = 5;
        val validNumbers = listOf<Int>(1, 2, 3, 4, 5)
        when (a) {
            is Int -> println("x is Int")
            in 1..10 -> println("x is in the range 1 to 10")
            !in 10..20 -> println("x is outside the range 10 to 20")
            in validNumbers -> println("x is valid")
            else -> println("none of the above")
        }

        for (x in 2..10 step 2) {
            println(x)
        }

        /*每个 `->` 代表一个分支, 如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔*/
        when (a) {
            0, 1 -> println("a == 0 or a == 1")
            else -> println("otherwise")
        }


        /*如果其他分支都不满足条件将会求值 else 分支(类似原来的default)。 如果 when 作为一个表达式使用，则必须有 else 分支， 除非编译器能够检测出所有的可能情况都已经覆盖了。*/
        fun hasPrefix(x: Any) = when (x) {
            is String -> x.startsWith("prefix")
            else -> false
        }

        val str = "prefix-Something"
        if (hasPrefix(str))
            println("$str has prefix")

        /*如果不提供参数，所有的分支条件都是简单的布尔表达式，而当一个分支的条件为真时则执行该分支*/
        when {
            a > 0 -> println("a > 0")
            a == 0 -> println("a == 0")
            else -> println("a < 0")
        }

    }

    fun useFor() {

        val list = listOf<Int>(1, 2, 3, 4, 5)
        //类似Java的增强For, 使用迭代器, **对于数组的for会自动编译为使用索引的循环**
        for (item in list) print(item)
        println()
        //如果你想要通过索引遍历一个数组或者一个 list, 使用如下格式
        for (i in list.indices) {
            print(list[i])
        }
        println()
        //或者可以用库函数 withIndex
        for ((index, value) in list.withIndex()) {
            println("the element at $index is $value")
        }
    }


    fun useWhile() {

        // while 正常使用

        var x = 3

        while (x-- > 0) {
            print(x)
        }

        fun retrieveData() = x++

        do {
            val y = retrieveData()
            print(y)
        } while (y < 3) // y 在此处可见
    }
}
