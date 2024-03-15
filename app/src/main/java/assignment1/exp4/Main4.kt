package assignment1.exp4

import java.util.Scanner


fun main() {
    val scanner = Scanner(System.`in`)
    println("Nhập chuỗi cần xử lý:")
    val input = scanner.nextLine()

    val sentence = StringBuilder()
    var wordCount = 0
    var isFirstWord = true

    for (char in input) {
        if (char.isLetter() && isFirstWord) {
            sentence.append(char.uppercaseChar())
            isFirstWord = false
        } else if (char in arrayOf('.', '?', '!')) {
            sentence.append(char)
            isFirstWord = true
        } else if (char.isWhitespace()) {
            sentence.append(char)
            isFirstWord = true
        } else {
            sentence.append(char)
        }
    }

    val modifiedSentence = sentence.toString().trim()//loại bỏ khoảng trắng đầu tiên nhập vào chuỗi
    val words = modifiedSentence.split("[,.!?]".toRegex())
    wordCount = words.sumBy { it.trim().split("\\s+".toRegex()).size }

    println("Chuỗi sau khi viết hoa chữ cái đầu tiên của từ và số từ trong chuỗi: $modifiedSentence")
    println("Số từ trong chuỗi: $wordCount")
}