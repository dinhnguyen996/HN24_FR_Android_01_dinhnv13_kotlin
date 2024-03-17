package assignment2.exp4

import java.util.InputMismatchException
import java.util.Scanner


var inNumber:Int=0
fun main(){
    var scanner=Scanner(System.`in`)
    var checkNumber=false
    println("Nhập vào số tự nhiên")
    while (!checkNumber){
        try {
            inNumber=scanner.nextInt()
            checkNumber=true

        }catch (e:InputMismatchException){
            println("Nhập sai kiểu dữ liệu,hãy nhập lại số tự nhiên")
            scanner.next()//lần nhập kế tiếp
        }
    }
    // Tính tổng các chữ số và in kết quả
    val result = sumNaturalNumbers(inNumber, ::sumOfDigits)
    println("Tổng các chữ số của số $inNumber là: $result")

}
fun sumNaturalNumbers(number: Int, operation: (Int) -> Int): Int {
    return operation(number)
}

fun sumOfDigits(number: Int): Int {
    var sum = 0
    var n = number
    while (n > 0) {
        sum += n % 10
        n /= 10
    }
    return sum
}