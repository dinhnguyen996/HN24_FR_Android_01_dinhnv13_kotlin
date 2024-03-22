package assignment4.exp4

import android.os.Build
import androidx.annotation.RequiresApi
import java.lang.reflect.Field
import java.lang.reflect.InvocationTargetException
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible


fun main() {

    val people = People(22, "Male")

    val properties = People::class.memberProperties
    val functions = People::class.memberFunctions

    println("Properties:")
    for (property in properties) {
        property.isAccessible = true
        println("${property.name}: ${property.get(people)}")
    }

    println("memberFunctions:")
    for (method in functions) {
        method.isAccessible = true
        if (method.name == "getPeoPleAge" || method.name == "getPeoPleGender") {
            println("${method.name}: ${method.call(people)}")
        }
    }
}