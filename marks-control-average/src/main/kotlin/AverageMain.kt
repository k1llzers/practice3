import java.io.BufferedReader
import java.io.FileReader

fun Student.getAverageMark(): Double {
    val countOfCredits = this.subjectToMarkMap.keys.stream()
        .mapToDouble { it.countOfCredits }
        .sum()
    val markCountMultCredits = this.subjectToMarkMap.entries.stream()
        .mapToDouble { it.key.countOfCredits * it.value }
        .sum()
    return markCountMultCredits / countOfCredits
}

fun Student.isScholarship() = getMinMarkForScholarship() <= this.getAverageMark()

fun getMinMarkForScholarship(): Int {
    val reader = BufferedReader(FileReader("D:\\Users\\Sasha\\university_projects\\Automation java\\practice3\\marks-control-average\\src\\main\\resources\\minMarkForScholarship.txt"))
    return reader.use { it.readLine().toInt() }
}