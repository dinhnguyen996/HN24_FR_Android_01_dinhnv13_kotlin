package assignment1.exp5

import java.util.InputMismatchException
import java.util.Scanner

fun main(){
    val scanner = Scanner(System.`in`)
    var month: Int
    var year: Int
    //nhập tháng từ người dùng,yêu cầu nhập lại nếu nhập không hợp lệ
    do {
        try {
            println("Nhập tháng (1-12): ")
            month = scanner.nextInt()
            if (month in 1..12){
                break // Thoát khỏi vòng lặp nếu tháng hợp lệ
            } else {
                println("Tháng không hợp lệ. Vui lòng nhập lại.")
            }
        } catch (e: InputMismatchException) {
            //băt ngoại lệ nhập k phải số
            println("Tháng không hợp lệ. Vui lòng nhập lại.")
            scanner.next() // Xóa input không hợp lệ để tránh vòng lặp vô hạn
        }
    } while (true)

    // Nhập năm từ người dùng, yêu cầu nhập lại nếu không hợp lệ
    do {
        try {
            println("Nhập năm: ")
            year = scanner.nextInt()
            if (year > 0){
                break // Thoát khỏi vòng lặp nếu năm hợp lệ
            } else{
                println("Năm không hợp lệ. Vui lòng nhập lại.")
            }
        } catch (e: InputMismatchException) {
            //bắt ngoại lệ nhập k phải số
            println("Năm không hợp lệ. Vui lòng nhập lại.")
            scanner.next() // Xóa input không hợp lệ để tránh vòng lặp vô hạn
        }
    } while (true)

    //In tra số ngày trong tháng tương ứng
    val daysInMonth = getDaysInMonth(month, year)
    println("Số ngày trong tháng $month năm $year là: $daysInMonth")
}

fun getDaysInMonth(month: Int, year: Int): Int {
    return when (month) {
        1, 3, 5, 7, 8, 10, 12 -> 31 //tháng 31 ngày
        4, 6, 9, 11 -> 30 //tháng 30 ngày
        2 -> if (isLeapYear(year)) 29 else 28
        else -> 0
    }
}
//kiểm tra có phải năm nhuận hay không
fun isLeapYear(year: Int): Boolean {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
}