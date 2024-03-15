package assignment1.exp3

import java.util.InputMismatchException
import java.util.Scanner

/**/
    /*Bài 3: Nhập một mảng các số nguyên a 0, a 1, a 2, ..., a n-1. Không sử
    dụng bất kỳ mảng khác, in ra màn hình mảng trên theo thứ tự tăng dần.*/
fun main() {
    val arrayList = ArrayList<Int>()
    val scanner = Scanner(System.`in`)
    var n: Int

    do {
        println("Nhập số phần tử của mảng lớn hơn 0:")
        while (!scanner.hasNextInt()) {
            //kiểm tra scaner nhập  ở  sau có nhập vào số nguyên hay không, nếu k phải lặp tiếp
            println("Nhập sai,nhập lại một số nguyên lớn hơn 0.")
            scanner.next()//bỏ qua dòng để nhập cho các lần sau
        }
        n = scanner.nextInt()
    } while (n <= 0)

    for (i in 0 until n) {
        println("Nhập phần tử thứ ${i + 1}:")
        while (!scanner.hasNextInt()) {
            println("Vui lòng nhập một số nguyên.")
            scanner.next()
        }
        arrayList.add(scanner.nextInt())
    }

    arrayList.sort()//sắp   xếp mảng theo thư tự tăng dần

    println("Mảng nhập và sắp xếp theo thứ tự tăng dần là: $arrayList")
}