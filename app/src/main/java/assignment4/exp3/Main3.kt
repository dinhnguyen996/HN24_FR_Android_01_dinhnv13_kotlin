package assignment4.exp3

import java.util.Scanner

fun main(){
    val myList= listOf(1.2,1.3,1.4,6.0,7.0)
    val scanner=Scanner(System.`in`)
    var begin:Int=0
    var end:Int=0
    var checkBegin=false
    var checkEnd=false
    while (!checkBegin){
        println("Nhập giá trị begin")
        if (scanner.hasNextInt()){
            begin=scanner.nextInt()
            if (begin>=0){
                checkBegin=true
            }else{
                println("Nhập giá trị lớn hơn hoặc bằng 0")
            }
        }else{
            println("Nhập sai kiểu dữ liệu")
            scanner.next()
        }
    }
    while (!checkEnd){
        println("Nhập giá trị end")
        if (scanner.hasNextInt()){
            end=scanner.nextInt()
            if (end>=1){
                checkEnd=true
            }else{
                println("Nhập giá trị lớn hơn hoặc bằng 0")
            }
        }else{
            println("Nhập sai kiểu dữ liệu")
            scanner.next()
        }
    }
    val maxElementInRange = findMaxInRange(myList, begin, end)
    println("Phần tử max trong phạm vi: $maxElementInRange")

}
fun <T : Comparable<T>> findMaxInRange(list: List<T>, begin: Int, end: Int): T? {
    if (begin < 0 || end > list.size || begin >= end) {
        return null // Trả về null nếu phạm vi không hợp lệ
    }

    var maxElement: T? = null
    for (i in begin until end) {
        val element = list[i]
        if (maxElement == null || element > maxElement) {
            maxElement = element
        }
    }
    return maxElement
}
