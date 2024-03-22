package finalkotlin

import java.util.Scanner

fun main() {
    val userManager = UserManager()
    val scanner = Scanner(System.`in`)
    var choice:Int=0
    while (true) {
        println("Các lựa chọn")
        println("1. Thêm người dùng mới")
        println("2. Hiển thị danh sách người dùng")
        println("3. Tìm kiếm người dùng theo tên")
        println("4. Hiển thị danh sách người dùng sắp xếp theo tên")
        println("0. Thoát")

        print("Nhập lựa chọn của bạn: ")
        var checkChoice=false
        while (!checkChoice){
            if (scanner.hasNextInt()){
                choice=scanner.nextInt()
                checkChoice=true
            }else{
                println("Lựa chọn sai nhập lại lựa chọn")
                scanner.next()
            }
        }
        when (choice) {
            1 -> {
                addUserWithDelay(userManager, scanner)
            }
            2 -> {
                userManager.displayUsers()
            }
            3 -> {
                findUserByName(userManager, scanner)
            }
            4 -> {
                userManager.sortByUserName()
                userManager.displayUsers()
            }
            0 -> {
                println("Thoát khỏi ứng dụng.")
                return
            }
        }
    }
}

// Phương thức tìm người dùng theo tên
fun findUserByName(userManager: UserManager, scanner: Scanner) {
    print("Nhập tên người dùng cần tìm: ")
    val name = scanner.next()
    val findUser = userManager.findUserByName(name)
    if (findUser != null) {
        println("Người dùng ${findUser.name} được tìm thấy. Tuổi: ${findUser.age}, Email: ${findUser.email}")
    } else {
        println("Không tìm thấy người dùng có tên là $name")
    }
}

fun addUserWithDelay(userManager: UserManager, scanner: Scanner) {
    print("Nhập tên người dùng mới: ")
    val name = scanner.next()

    print("Nhập tuổi của người dùng mới: ")
    var age = 0
    var validAge = false
    while (!validAge) {
        if (scanner.hasNextInt()) {
            age = scanner.nextInt()
            if (age > 0) {
                validAge = true
            } else {
                println("Tuổi phải lớn hơn 0. Nhập lại tuổi.")
            }
        } else {
            println("Tuổi không hợp lệ, hãy nhập lại tuổi lớn hơn 0.")
            scanner.next()
        }
    }
    scanner.nextLine()

    var validEmail = false
    var email = ""
    while (!validEmail) {
        print("Nhập email của người dùng mới: ")
        val inputEmail = scanner.nextLine()
        if (inputEmail.contains("@") && !inputEmail.contains(" ") && inputEmail.isNotEmpty()) {
            email = inputEmail
            validEmail = true
        } else {
            println("Email không hợp lệ, hãy nhập lại.")
        }
    }
    val newUser = User(name, age, email)
    userManager.addUserWithDelay(newUser)
}