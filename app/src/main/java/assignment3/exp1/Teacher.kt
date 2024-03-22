package assignment3.exp1

import java.util.Scanner

class Teacher:Person {

    var teacherID: String = ""
    var teachingClass: String = ""
    var hourlySalary: Double = 0.0
    var teachingHoursPerMonth: Int = 0

    constructor(name: String, gender: String, dateOfBirth: String, address: String, teacherID: String, teachingClass: String, hourlySalary: Double, teachingHoursPerMonth: Int) : super(name, gender, dateOfBirth, address) {
        this.teacherID = "GV$teacherID" // Thêm prefix GV cho ID giáo viên
        this.teachingClass = teachingClass
        this.hourlySalary = hourlySalary
        this.teachingHoursPerMonth = teachingHoursPerMonth
    }

    constructor() : super()

    override fun inputInfo() {
        super.inputInfo()
        val scanner = Scanner(System.`in`)
        println("Nhập mã giáo viên: ")
        teacherID ="GV"+ scanner.nextLine()
        var inputClass:String
        var checkClass :Boolean=false
        while (!checkClass){
            println("Nhập lớp dạy: ")
            var inputClass=scanner.nextLine()
            if (inputClass.startsWith("G")||inputClass.startsWith("H")||inputClass.startsWith("I")||inputClass.startsWith("K")||inputClass.startsWith("L")||inputClass.startsWith("M")){
                teachingClass=inputClass
                checkClass=true
            }else{
                println("Lớp k hợp lệ")
            }
        }

        println("Nhập lương một giờ dạy: ")
        hourlySalary = scanner.nextDouble()
        println("Nhập số giờ dạy trong tháng: ")
        teachingHoursPerMonth = scanner.nextInt()
    }

    override fun showInfo() {
        super.showInfo()
        println("Mã giáo viên: $teacherID")
        println("Lớp dạy: $teachingClass")
        println("Lương một giờ dạy: $hourlySalary")
        println("Số giờ dạy trong tháng: $teachingHoursPerMonth")
    }
    // Method tính lương
    fun calculateSalary(): Double {
        var totalSalary: Double
        totalSalary = if (teachingClass.startsWith("G") || teachingClass.startsWith("H") || teachingClass.startsWith("I")|| teachingClass.startsWith("K")) {
            hourlySalary * teachingHoursPerMonth
        } else {
            hourlySalary * teachingHoursPerMonth + 500000
        }
        return totalSalary
    }
}