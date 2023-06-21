package ru.myitschool.lab23

class TestUtils {
    fun initializeRandomPostfixesForTables(
        requiredArraySize: Int,
        requiredPostfixLength: Int,
        withDigits: Boolean = true,
    ): Array<String> {
        var coursesPostfixes = Array(requiredArraySize) { "" }
        for (i in coursesPostfixes.indices) {
            coursesPostfixes[i] = getRandomString(requiredPostfixLength, withDigits)
        }

        return coursesPostfixes
    }

    fun initializeFakeDataForTables(
        courses: List<String>,
        coursesPostfixes: Array<String>,
    ): Array<String> {
        var fakeCourses = Array(courses.size) { "" }
        for (i in fakeCourses.indices) {
            val d = courses[i]
            fakeCourses[i] = "$d${coursesPostfixes[i]}"
        }

        return fakeCourses
    }

    fun getRandomString(length: Int, numbersAllowed: Boolean = true): String {
        val allowedChars = ('A'..'Z') +
            if (numbersAllowed) {
                ('a'..'z') + ('0'..'9')
            } else {
                ('a'..'z')
            }
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}
