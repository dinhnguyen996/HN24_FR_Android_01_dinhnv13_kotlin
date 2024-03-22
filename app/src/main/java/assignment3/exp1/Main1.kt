package assignment3.exp1

import java.util.Scanner

fun main(){
   var listStudent= mutableListOf<Student>()
   var listTeacher= mutableListOf<Teacher>()
   val scanner=Scanner(System.`in`)

   var select:Int
   do {
       while (true){
           println("Các lựa chọn")
           println("1. Thêm sinh viên/giảng viên.")
           println("2. Sửa sinh viên/giảng viên theo mã.")
           println("3. Xóa sinh viên/giảng viên theo mã.")
           println("4. Sắp xếp sinh viên/giảng viên theo họ tên.")
           println("5. Hiển thị thông tin tất cả sinh viên.")
           println("6. Hiển thị thông tin tất cả giảng viên.")
           println("7. Sắp xếp và hiển thị sinh viên theo điểm trung bình.")
           println("8. Sắp xếp và hiển thị giảng viên theo lương.")
           println("0. Thoát chương trình.")
           print("Lựa chọn của bạn là : ")
           while (!scanner.hasNextInt()){
               println("Nhập sai lựa chọn, nhập lại")
               scanner.next()
           }
           select=scanner.nextInt()
           when(select){
               1 -> {
                   addPerson(listStudent, listTeacher)
               }
               2 -> {
                   editPerson(listStudent, listTeacher)
               }
               3 -> {
                   deletePerson(listStudent, listTeacher)
               }
               4 -> {
                   sortByName(listStudent, listTeacher)
               }
               5 -> {
                   displayStudents(listStudent)
               }
               6 -> {
                   displayTeachers(listTeacher)
               }
               7 -> {
                   sortByGPA(listStudent)
               }
               8 -> {
                   sortBySalary(listTeacher)
               }
               0 -> {
                   println("Chương trình đã thoát.")
               }
               else -> {
                   println("Lựa chọn không hợp lệ.")
               }
           }
       }
   
   } while (select != 0)

       
}

fun displayTeachers(listTeacher: MutableList<Teacher>) {
    println("Thông tin giáo viên")
    listTeacher.forEach { it.showInfo() }

}

fun displayStudents(listStudent: MutableList<Student>) {
    println("Thông tin học sinh")
    listStudent.forEach { it.showInfo() }
}

fun sortByName(listStudent: MutableList<Student>, listTeacher: MutableList<Teacher>) {
    val sortedStudents = listStudent.sortedBy { it.name }
    val sortedTeachers = listTeacher.sortedBy { it.name }

    println("Danh sách sinh viên đã được sắp xếp theo họ tên:")
    sortedStudents.forEach { println(it.showInfo()) }

    println("\nDanh sách giáo viên đã được sắp xếp theo họ tên:")
    sortedTeachers.forEach { println(it.showInfo()) }
}

fun deletePerson(listStudent: MutableList<Student>, listTeacher: MutableList<Teacher>) {
    val scanner = Scanner(System.`in`)
    println("Chọn loại:")
    println("1. Sinh viên")
    println("2. Giáo viên")
    print("Chọn: ")
    while (!scanner.hasNextInt()){
        println("Nhập sai hãy nhập lại")
        scanner.next()
    }
    val select = scanner.nextInt()
    when (select) {
        1 -> {
            println("Nhập mã sinh viên cần xóa: ")
            val studentID = addPrefix(scanner.next())
            val studentIndex = listStudent.indexOfFirst { it.studentID == studentID }
            if (studentIndex != -1) {
                listStudent.removeAt(studentIndex)
                println("Sinh viên có mã $studentID đã được xóa.")
            } else {
                println("Không tìm thấy sinh viên có mã $studentID.")
            }
        }
        2 -> {
            println("Nhập mã giáo viên cần xóa: ")
            val teacherID = addPrefix(scanner.next())
            val teacherIndex = listTeacher.indexOfFirst { it.teacherID == teacherID }
            if (teacherIndex != -1) {
                listTeacher.removeAt(teacherIndex)
                println("Giáo viên có mã $teacherID đã được xóa.")
            } else {
                println("Không tìm thấy giáo viên có mã $teacherID.")
            }
        }
        else -> {
            println("Lựa chọn không hợp lệ.")
        }
    }
}

fun editPerson(listStudent: MutableList<Student>, listTeacher: MutableList<Teacher>) {

    val scanner = Scanner(System.`in`)
    var  choice:Int=0
    while (true){
        println("Chọn loại:")
        println("1. Sinh viên")
        println("2. Giáo viên")
        print("Chọn: ")
        if (scanner.hasNextInt()) { // Vòng lặp sẽ tiếp tục cho đến khi checkSelect là true
            choice = scanner.nextInt()
            if (choice==1 || choice==2){
                break
            }else{
                println("Lựa chọn không hợp lệ, vui lòng chọn lại")
            }
        }else{
            println("Nhập k hợp lệ,hãy nhập lại")
        }
    }

    when (choice) {
        1 -> {
            println("Nhập mã sinh viên cần sửa: ")
            val studentID = addPrefix(scanner.next())
            val studentIndex = listStudent.indexOfFirst { it.studentID == studentID }
            if (studentIndex != -1) {
                val student = listStudent[studentIndex]
                println("Nhập thông tin mới cho sinh viên:")
                student.inputInfo()
                println("Thông tin sinh viên đã được cập nhật.")
            } else {
                println("Không tìm thấy sinh viên có mã $studentID.")
            }
        }
        2 -> {
            println("Nhập mã giáo viên cần sửa: ")
            val teacherID = addPrefix(scanner.next())
            val teacherIndex = listTeacher.indexOfFirst { it.teacherID == teacherID }
            if (teacherIndex != -1) {
                val teacher = listTeacher[teacherIndex]
                println("Nhập thông tin mới cho giáo viên:")
                teacher.inputInfo()
                println("Thông tin giáo viên đã được cập nhật.")
            } else {
                println("Không tìm thấy giáo viên có mã $teacherID.")
            }
        }
        else -> {
            println("Lựa chọn không hợp lệ.")
        }
    }

}

fun sortBySalary(listTeacher: MutableList<Teacher>) {
    println("Danh sách giáo viên đã được sắp xếp theo lương:")
    listTeacher.sortedByDescending { it.calculateSalary() }.forEach { it.showInfo() }
}

fun sortByGPA(listStudent: MutableList<Student>) {
    println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình:")
    listStudent.sortedByDescending { it.gpa }.forEach { it.showInfo() }
}
//kiểm tra người dùng đã nhập mã sinh vien/giáo viên đã có prefix hay chưa
fun addPrefix(id: String): String {
    return if (id.startsWith("SV") || id.startsWith("GV")) {
        id // Nếu đã có prefix, trả về nguyên vẹn mã
    } else {
        "SV$id" // Nếu chưa có prefix, thêm prefix "SV"
    }
}


fun addPerson(listStudent:MutableList<Student>, listTeacher:MutableList<Teacher>) {
    val scanner = Scanner(System.`in`)
    var select:Int=0
    while (true) {
        println("Chọn loại:")
        println("1. Sinh viên")
        println("2. Giáo viên")
        print("Chọn: ")

        if (scanner.hasNextInt()) { // Kiểm tra xem người dùng đã nhập một số nguyên hợp lệ chưa
            select = scanner.nextInt()
            if (select == 1 || select == 2) {
                break // Thoát khỏi vòng lặp nếu lựa chọn hợp lệ
            } else {
                println("Lựa chọn không hợp lệ. Vui lòng chọn lại.")
            }
        } else {
            println("Lựa chọn không hợp lệ. Vui lòng chọn lại.")
            scanner.next() // Đọc và loại bỏ giá trị không phải số nguyên khỏi luồng đầu vào
        }
    }

    when (select) {
        1 -> {
            val student = Student()
            student.inputInfo()
            listStudent.add(student)
        }
        2 -> {
            val teacher = Teacher()
            teacher.inputInfo()
            listTeacher.add(teacher)
        }
    }

}
