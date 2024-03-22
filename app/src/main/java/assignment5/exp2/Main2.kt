package assignment5.exp2
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking


fun calculateSum(n: Int): Int {
    return (0..n).sum()
}
fun generateResults(): Flow<Int> = flow {
    for (i in 0..10) {
        delay(500)
        emit(calculateSum(i))
    }
}
fun main() = runBlocking {
    generateResults().collect { result ->
        println("Result: $result")
    }
}