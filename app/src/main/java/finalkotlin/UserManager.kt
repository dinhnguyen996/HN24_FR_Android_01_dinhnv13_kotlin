package finalkotlin

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class UserManager {
    private val userList = ArrayList<User>()

    fun addUser(user: User) {
        userList.add(user)
    }

    fun displayUsers() {
        println("Danh sách người dùng:")
        userList.forEach { println("Tên: ${it.name}, Tuổi: ${it.age}, Email: ${it.email}") }
    }

    fun findUserByName(name: String): User? {
        return userList.find { it.name == name }
    }

    fun sortByUserName() {
        userList.sortBy { it.name }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun addUserWithDelay(user: User) {
        val delayTime = Random.nextLong(500, 2001)
        GlobalScope.launch {
            delay(delayTime)
            addUser(user)
            println("Đã thêm người dùng ${user.name}")
        }
    }
}
