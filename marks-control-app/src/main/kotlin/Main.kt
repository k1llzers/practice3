fun main() {
    val student = Student("Семицький Олександр Ігорович")
    student.addMark(Subject("Ока", 5.5), 90)
    student.addMark(Subject("БД", 5.0), 93)
    student.addMark(Subject("КА", 4.0), 93)
    println(student.isScholarship())
}