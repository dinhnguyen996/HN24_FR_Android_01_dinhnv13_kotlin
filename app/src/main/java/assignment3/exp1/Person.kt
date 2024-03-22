package assignment3.exp1

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Scanner

// Khai báo lớp Person
open class Person(
    var name: String ,
    var gender: String ,
    var dateOfBirth: String ,
    var address: String
) {

    //secondary constructor
    constructor() : this("","","","")

    // Nhập thông tin từ bàn phím
    open fun inputInfo() {
        val scanner = Scanner(System.`in`)
        println("Nhập tên: ")
        name = scanner.nextLine()

        println("Nhập giới tính: ")
        var checkgender:Boolean=false
        while (!checkgender){
            var inputGender=scanner.nextLine().toLowerCase()
            if (inputGender.contains("nam") || inputGender.contains("nữ")){
                gender=inputGender
                checkgender=true
            }else{
                println("Nhập sai dữ liệu,giơ tính chỉ được nhập nam hoặc nữ")
            }
        }



        var validDateOfBirth = false

        while (!validDateOfBirth) {
            println("Nhập ngày tháng năm sinh (dd/MM/yyyy): ")
            val inputDateOfBirth = scanner.nextLine()
            if (isDateValid(inputDateOfBirth)) {
                dateOfBirth = inputDateOfBirth
                validDateOfBirth = true
            } else {
                println("Ngày tháng năm sinh không hợp lệ. Vui lòng nhập lại.")
            }
        }

        println("Nhập địa chỉ: ")
        address = scanner.nextLine()
    }

    // Hiển thị thông tin
    open fun showInfo() {
        println("Tên: $name")
        println("Giới tính: $gender")
        println("Ngày sinh: $dateOfBirth")
        println("Địa chỉ: $address")
    }

    //kiểm tra ngày tháng hợp lệ
    @SuppressLint("SimpleDateFormat")
    fun isDateValid(dateOfBirth: String): Boolean {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        dateFormat.isLenient = false

        try {
            dateFormat.parse(dateOfBirth)
            return true
        } catch (e: ParseException) {
            return false
        }
    }

}

