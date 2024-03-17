package assignment2.exp1

import java.util.Scanner

fun main() {
    val number = readNumberT()
    findAndPrintResult(number)//truyền số cần kiểm tra
}

    val findAndPrintResult: (Int) -> Unit = { n ->
        val primePairs = mutableListOf<Pair<Int, Int>>()

        for (i in 2..n / 2) {
            if (isPrimeT(i) && isPrimeT(n - i)) {
                primePairs.add(i to (n - i))//thêm cặp số vào list
            }
        }

        if (primePairs.isEmpty()) {
            println("$n không phải là tổng của hai số nguyên tố.")
        } else {
            println("$n là tổng của các cặp số nguyên tố  sau:")
            primePairs.forEach { pair ->
                println("${pair.first} + ${pair.second}")
            }
        }
    }
//Nhập số cần kiểm tra
fun readNumberT(): Int {
    val scanner = Scanner(System.`in`)
    var innumber: Int
    do {
        println("Nhập số cần kiểm tra:")
        while (!scanner.hasNextInt()) {
            println("Nhập sai, nhập lại một số nguyên lớn hơn 0.")
            scanner.next()
        }
        innumber = scanner.nextInt()
    } while (innumber <= 0)
    return innumber
}

fun isPrimeT(n: Int): Boolean {
    if (n <= 1) return false
    for (i in 2..n / 2) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}