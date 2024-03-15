package assignment1.exp2

import java.util.InputMismatchException
import java.util.Scanner
/*Bài 2: Viết chương trình nhập vào một số nguyên có hai chữ số. Chuyển
đổi và in ra giá trị của số đã nhập ở dạng nhị phân và thập lục phân.*/
fun main(){
    val scanner=Scanner(System.`in`)
    var checkInput:Boolean=false//biến cờ

    while (!checkInput){
        //tương đương như while(true) luôn chạy
        println("Nhập vào số nguyên  có 2 chữ số")
        try {
            var inPutNumber:Int=scanner.nextInt()
            if (inPutNumber in 10..99 || inPutNumber in -99..-10){
                checkInput=true//set lại giá trị biến để thoát vòng lặp

                toBinaryString(inPutNumber)//phương thức chuyển sang dạng nhị phân

                toHexString(inPutNumber)//pt chuyển sang dạng thục lập phân
            }else{
                println("Nhập lỗi, nhập lại số có 2 chữ số")
            }
        }catch (e:InputMismatchException){
            println("Số nhập không hợp lệ,xin nhập lại")
            scanner.next()//doc dòng tiep theo để tránh lặp vô hạn
        }

    }
}

fun toHexString(inPutNumber: Int) {
    val hexString = Integer.toHexString(inPutNumber)
    println("Số  $inPutNumber có dạng thục lập phân là: $hexString")
}

fun toBinaryString(inPutNumber: Int) {
    val binaryString = Integer.toBinaryString(inPutNumber)
    println("Số  $inPutNumber có dạng nhị phân là: $binaryString")
}



