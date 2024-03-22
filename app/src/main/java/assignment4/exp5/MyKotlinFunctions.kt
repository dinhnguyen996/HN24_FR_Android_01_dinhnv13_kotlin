package assignment4.exp5

fun add(a: Long, b: Long): Long {
    return a + b
}

fun subtract(a: Long, b: Long): Long {
    return a - b
}

fun multiply(a: Long, b: Long): Long {
    return a * b
}

fun divide(a: Long, b: Long): Long {
    require(b != 0L) { "Không có phép chia cho 0" }
    return a / b
}