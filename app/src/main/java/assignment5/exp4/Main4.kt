package assignment5.exp4





import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlin.random.Random

fun main() = runBlocking {

    val channel = Channel<Int>()

    val job1 = launch {
        repeat(10) {
            val randomNumber = Random.nextInt(-100, 1)
            channel.send(randomNumber)
            delay(300)

        }
        channel.close()
    }

    // Coroutine 2 sinh ngẫu nhiên các số từ 0 đến 100
    val job2 = launch {
        repeat(10) {
            val randomNumber = Random.nextInt(0, 101)
            channel.send(randomNumber)
            delay(300)
        }
        channel.close()
    }

    var total = 0
    for (number in channel) {
        total += number
        println(" Total: $total")

        if (total <= -100 || total >= 100) {
            job1.cancel()
            job2.cancel()
            println("Nằm ngoài khoảng điều kiện")
            break
        }
    }
}