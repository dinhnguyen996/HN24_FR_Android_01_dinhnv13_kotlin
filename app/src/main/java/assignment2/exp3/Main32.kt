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
    }while (n<1)


    val sumUpto={num: Int->
        var sum=0
        for (i in 1..num){
            sum+=i
        }
        sum //trả về
    }

    val result = sumUpto(n)
    println("Tổng các số tự nhiên nhỏ hơn hoặc bằng $n là: $result")
}