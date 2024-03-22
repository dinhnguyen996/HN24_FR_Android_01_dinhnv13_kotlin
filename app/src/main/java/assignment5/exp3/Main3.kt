package assignment5.exp3

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlin.random.Random


fun CoroutineScope.randomNumbers(channel: Channel<Int>) {
    launch {
        while (true) {
            val randomNumber = Random.nextInt(1, 21)
            channel.send(randomNumber)
            delay(2000)
        }
    }
}


fun CoroutineScope.squareNumbers(channel: Channel<Int>) {
    launch {
        while (true) {
            val number = channel.receive()
            println("Square of $number: ${number * number}")
            delay(1000) // Dừng 1 giây
        }
    }
}

fun main() = runBlocking<Unit> {
    val channel = Channel<Int>()

    // Bắt đầu hai coroutine
    randomNumbers(channel)
    squareNumbers(channel)

    // Chờ coroutine kết thúc
    delay(Long.MAX_VALUE)
}