package assignment3.exp1

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Scanner

class Student: Person {
    var studentID: String=""
    var gpa: Double =0.0
    var email: String=""

    // Secondary constructor cho Student
    constructor(name: String, gender: String, dateOfBirth: String, address: String, studentID: String, gpa: Double, email: String) : super(name, gender, dateOfBirth, address) {
        this.studentID = "SV$studentID" // Thêm prefix SV cho ID sinh viên
        this.gpa = gpa
        this.email = email

    }

    constructor() : super()

    override fun inputInfo() {
        super.inputInfo()

        val scanner = Scanner(System.`in`)
        println("Nhập id sinh viên: ")
        studentID="SV"+scanner.nextLine()
        println("Nhập điểm trung bình: ")
        while (true){
            if (scanner.hasNextDouble()){
                gpa=scanner.nextDouble()
                if (gpa in 0.0..10.0){
                    break
                }else{
                    println("nhập sai điểm,hãy nhập lại")
                }
            }else{
                println("nhập sai điểm,hãy nhập lại")
                scanner.nextLine()
            }
        }
        scanner.nextLine()


        //nhập email
        var checkEmail:Boolean=false
        while (!checkEmail){
            println("Nhập email sinh viên: ")
            var inputEmail=scanner.nextLine()
            if (inputEmail.contains("@")&& !inputEmail.contains(" ")  && inputEmail.isNotEmpty()){
                email=inputEmail
                checkEmail=true
            }else{
                println("nhập email không hợp lệ,hãy nhập lại")
            }
        }

    }

    override fun showInfo() {
        super.showInfo()
        println("Mã sinh viên: $studentID")
        println("Điểm trung bình: $gpa")
        println("Email: $email")
        setScholarship() // Gọi phương thức setScholarship() để hiển thị thông tin học bổng
    }
    fun setScholarship(){
        if (gpa>=8){
            println("Sinh viên $name được nhận học bổng")
        }else{
            println("Sinh vie $name không được nhận học bổng")
        }
    }

}