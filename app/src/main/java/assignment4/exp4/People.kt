package assignment4.exp4

class People(var age: Int, private val gender: String) {
    fun getPeoPleAge(): Int {
        return age
    }
    private fun getPeoPleGender(): String {
        return gender
    }

}