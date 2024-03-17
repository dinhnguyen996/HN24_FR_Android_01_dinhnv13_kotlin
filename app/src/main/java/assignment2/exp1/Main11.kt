package assignment2.exp1

import java.util.Scanner
fun main() {
    val number = readNumber()

    findPrimePairs(number, ::printResult)
}

fun readNumber(): Int {
    val scanner=Scanner(System.`in`)
    var innumber: Int
    do {
        println("Nhập số cần kiểm tra:")
        while (!scanner.hasNextInt()) {
            //kiểm tra scaner nhập  ở  sau có nhập vào số nguyên hay không, nếu k phải lặp tiếp
            println("Nhập sai,nhập lại một số nguyên lớn hơn 0.")
            scanner.next()//bỏ qua dòng để nhập cho các lần sau
        }
        innumber = scanner.nextInt()
    } while (innumber <= 0)
    return innumber
}
//tìm cặp số thoả mãn điều kiện
fun findPrimePairs(number: Int, action: (Int, List<Pair<Int, Int>>) -> Unit) {
    val primePairs = mutableListOf<Pair<Int, Int>>()

    for (i in 2..number / 2) {
        if (isPrime(i) && isPrime(number - i)) {
            primePairs.add(i to (number - i))//tạo ra cặp giá trị (i,number-i)
        }
    }

  action(number, primePairs)//chạy hàm printResult đồng thời truyền vào 2 tham số để sử dụng
}
//kim tra xem có phải số nguyên tố khng
fun isPrime(n: Int): Boolean {
    if (n <= 1) return false
    for (i in 2..n/2) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}
//in kết quả
fun printResult(number: Int, primePairs: List<Pair<Int, Int>>) {
    if (primePairs.isEmpty()) {
        println("$number không phải là tổng của hai số nguyên tố.")
    } else {
        println("$number là tổng của các cặp số nguyên tố sau:")
        primePairs.forEach { pair ->
            println("${pair.first} + ${pair.second}")
        }
    }
}