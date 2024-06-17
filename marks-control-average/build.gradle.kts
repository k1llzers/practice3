import java.io.BufferedWriter
import java.io.FileWriter

plugins {
    kotlin("jvm")
}

group = "org.ukma"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":marks-control-models"))
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

val minMarkForScholarshipFile = file("D:\\Users\\Sasha\\university_projects\\Automation java\\practice3\\marks-control-average\\src\\main\\resources\\minMarkForScholarship.txt")

println(minMarkForScholarshipFile.exists())

tasks.register("checkFileExist") {
    doLast {
        if (!minMarkForScholarshipFile.exists())
            throw RuntimeException("minMarkForScholarship.txt not exist in marks-control-average resources")
    }
}

tasks.register("checkFileNotEmpty") {
    doLast {
        if (minMarkForScholarshipFile.length() == 0L) {
            val writer = BufferedWriter(FileWriter(minMarkForScholarshipFile))
            writer.use { it.write("80") }
        }
    }
}

tasks.compileKotlin {
    dependsOn("checkFileExist", "checkFileNotEmpty")
}

tasks.named("checkFileNotEmpty") {
    mustRunAfter("checkFileExist")
}