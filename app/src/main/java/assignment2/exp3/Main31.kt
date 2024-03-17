package assignment2.exp3

import java.util.Scanner

fun main() {

    val scanner=Scanner(System.`in`)
    var n:Int
    do {
        println("Nhập vào số nguyên lớn hơn 0")
        while (!scanner.hasNextInt()){
            println("Nhập sai kiểu dữ liệu, nhập số nguyên dương")
            scanner.next()
        }
        n=scanner.nextInt()
    }while (n<0)
    // Hàm higher-order function
    fun sumNaturalNumbers(n: Int, action: (Int) -> Int):Int {
        return action(n)
    }

    // Hàm đệ quy để tính tổng các số từ 1 đến n
    fun sumUpToN(num: Int): Int {
        var sum=0
        for (i in 1..num){
            sum+=i
        }
        return sum
    }

    val result = sumNaturalNumbers(n, ::sumUpToN)
    println("Tổng các số tự nhiên nhỏ hơn hoặc bằng $n là: $result")
}