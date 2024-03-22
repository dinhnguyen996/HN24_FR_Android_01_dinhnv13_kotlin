package assignment5.exp1

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import java.util.Scanner

suspend fun calculateFibonacci(n: Int): Int = coroutineScope {
        var a = 0
        var b = 1
        var result = 0

        // Tính Fibonacci với vòng lặp
        for (i in 2..n) {
            result = a + b
            a = b
            b = result
        }

        return@coroutineScope result
    }

    fun main() = runBlocking {
        var scanner=Scanner(System.`in`)
        var n:Int=0
        println("Nhập số N")
       var checkN=false
        while (!checkN){
            if (scanner.hasNextInt()){
                n=scanner.nextInt()
                if (n>1){
                    checkN=true
                }else{
                    println("Nhập n lớn hơn 1")
                }
            }else{
                println("Nhập sai kiểu dữ liệu,hãy nhập lại")
                scanner.next()
            }
        }
        val result = calculateFibonacci(n)
        println("Số Fibonacci thứ $n là: $result")
    }
