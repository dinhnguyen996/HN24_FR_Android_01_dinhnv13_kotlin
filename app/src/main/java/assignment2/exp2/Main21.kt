package assignment2.exp2

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var a:Int
    var b:Int
    do {
        println("Nhập số ngyên a:")
        while (!scanner.hasNextInt()){
            println("Nhập số nguyên a lớn hơn 0")
            scanner.next()//loại bỏ để cho lần nhập tiếp theo
        }
        a=scanner.nextInt()
    }while (a<=0)


    do {
        println("Nhập số ngyên b:")
        while (!scanner.hasNextInt()){
            println("Nhập số nguyên b lớn hơn 0")
            scanner.next()//loại bỏ để cho lần nhập tiếp theo
        }
        b=scanner.nextInt()
    }while (b<0)

    if (a >= b) {
        println("Số nguyên b phải lớn hơn a.")
        return
    }

    println("Các số nguyên tố trong khoảng từ $a đến $b là:")
    findPrimeNumbersBetween(a, b, ::printResult)
}

fun findPrimeNumbersBetween(a: Int, b: Int, action: (Int) -> Unit) {
    for (i in a + 1 until b) {
        if (isPrime(i)) {
            action(i)
        }
    }
}

fun isPrime(n: Int): Boolean {
    if (n <= 1) return false
    for (i in 2 until n) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}

fun printResult(number: Int) {
    if (number==0){
        println("Không tồn tại số nguyên tố ở giữa 2 số vừa nhập")
        return
    }

    println(number)
}