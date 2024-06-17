data class Subject(val name: String,
                   val countOfCredits: Double)

data class Student(private val pib: String, val subjectToMarkMap: MutableMap<Subject, Int> = mutableMapOf()) {
    fun addMark(subject: Subject, mark: Int) {
        require(mark > 1 || mark < 100) {"Mark can`t be less than 1 or greater than 100"}
        subjectToMarkMap[subject] = mark
    }
}