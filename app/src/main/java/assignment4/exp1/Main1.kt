package assignment4.exp1

import kotlin.random.Random


fun main() {
        val listNumber = mutableListOf<Int>()
        for (i in 0..10) {
            listNumber.add(Random.nextInt(0, 100))
        }
        println(listNumber)
        val countOddNumber = countElementInCollection(listNumber) {
            it % 2 == 0
        }
        println(countOddNumber)
    }

    private fun <T> countElementInCollection(
        listElement: Collection<T>,
        condition: (T) -> Boolean
    ): Int {
        var count = 0
        for (item: T in listElement) {
            if (condition(item)) {
                count++
            }
        }
        return count
    }