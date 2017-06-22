package com.yomii.basic

import org.junit.Test

/**
 * Created by Yomii on 2017/6/22.
 */

class Types{


    @Test
    fun main() {


        definingLocalVariables()
        equals()
        arrays()
        string()

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

    fun arrays() {

        /*我们可以使用库函数 arrayOf() 来创建一个数组并传递元素值给它，这样 arrayOf(1, 2, 3) 创建了 array [1, 2, 3]。
        或者，库函数 arrayOfNulls() 可以用于创建一个指定大小、元素都为空的数组。*/

        val arrayOf = arrayOf(1, 2, 3)
        val arrayOfNulls = arrayOfNulls<Int>(5)

        /*该构造第一个参数是size, 第二个参数是一个lamb函数, 入参 i 代表数组index
         *返回给定index的每个元素初始值
         */
        val arr = Array(3, { i -> i })

        for (i in arr) {
            println(i)
        }
    }

    fun string() {
        //"""包裹的String可以保留格式
        val text = """
            for (c in "foo")
                print(c)
        """

        println(text)
        println("after trimMargin\n")

        /*'|'符号在"""包裹的内容中起到标记行初始位置的作用, 需要配合trimMargin方法使用*/
        val text1 = """
            |for (c in "foo")
            |    print(c)
        """
        println(text1.trimMargin())

        /*$符号不能直接使用反斜杠转义, 需要使用下列语法*/
        val price = """
            |${'$'}9.99
        """

        println(price.trimMargin())
    }
}
