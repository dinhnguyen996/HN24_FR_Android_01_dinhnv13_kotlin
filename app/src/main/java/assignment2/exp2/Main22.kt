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
    val printPrime: (Int) -> Unit = { println(it) }
    findPrimesBetween(a + 1, b).forEach (printPrime)
}

fun findPrimesBetween(start: Int, end: Int): List<Int> {
    val primes = mutableListOf<Int>()
    for (num in start until end) {
        if (isPrimeT(num)) {
            primes.add(num)
        }
    }
    return primes
}

fun isPrimeT(n: Int): Boolean {
    if (n <= 1) return false
    for (i in 2 until n) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}