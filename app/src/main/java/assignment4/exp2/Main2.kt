package assignment4.exp2

import java.util.Scanner


fun <T> swap(array: Array<T>, index1: Int, index2: Int) {
    if (index1 !in array.indices || index2 !in array.indices) {
        throw IndexOutOfBoundsException("Index out of bounds")
    }

    val temp = array[index1]
    array[index1] = array[index2]
    array[index2] = temp
}

fun <T> inputArray(scanner: Scanner, size: Int): Array<T> {
    val array = arrayOfNulls<Any>(size)
    println("Enter $size elements:")
    for (i in 0 until size) {
        val element = scanner.next()
        @Suppress("UNCHECKED_CAST")
        array[i] = element as T
    }
    @Suppress("UNCHECKED_CAST")
    return array as Array<T>
}

fun main() {
    val scanner = Scanner(System.`in`)

    print("Enter the size of the array: ")
    var checkSize=false
    var size:Int=0
    while (!checkSize){
        if(scanner.hasNextInt() ){
            size=scanner.nextInt()
            if (size>0){
                checkSize=true
            }else{
                println("size lớn hơn 0")
            }
        }else{
            println("Error,Enter the size of the array:")
            scanner.next()
        }
    }


    val arr = inputArray<Any>(scanner, size)

    println("Original array: ${arr.joinToString()}")

    print("Enter the first index to swap: ")
    val index1 = scanner.nextInt()
    print("Enter the second index to swap: ")
    val index2 = scanner.nextInt()

    try {
        swap(arr, index1, index2)
        println("Array after swapping: ${arr.joinToString()}")
    } catch (e: IndexOutOfBoundsException) {
        println("Error: ${e.message}")
    }
}