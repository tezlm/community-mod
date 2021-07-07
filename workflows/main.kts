import java.io.File
import java.util.concurrent.TimeUnit
import kotlin.math.round

fun String.runCommand(
    workingDir: File = File("."),
): String? = runCatching {
    ProcessBuilder(split(" "))
        .directory(workingDir)
        .redirectOutput(ProcessBuilder.Redirect.PIPE)
        .redirectError(ProcessBuilder.Redirect.PIPE)
        .start()
        .inputStream.bufferedReader().readText()
}.onFailure { it.printStackTrace() }.getOrNull()

data class Date(val source: String, val use24Hr: Boolean) {
    val days = mapOf(
        "Sun" to "Sunday",
        "Mon" to "Monday",
        "Tue" to "Tuesday",
        "Wed" to "Wednesday",
        "Thu" to "Thursday",
        "Fri" to "Friday",
        "Sat" to "Saturday"
    )

    val months = mapOf(
        "Jan" to "January",
        "Feb" to "February",
        "Mar" to "March",
        "Apr" to "April",
        "May" to "May",
        "Jun" to "June",
        "Jul" to "July",
        "Aug" to "August",
        "Sep" to "September",
        "Oct" to "October",
        "Nov" to "November",
        "Dec" to "December"
    )

    val monthdayEnds = mapOf(
        1 to "st",
        2 to "nd",
        3 to "rd",
        4 to "th",
        5 to "th",
        6 to "th",
        7 to "th",
        8 to "th",
        9 to "th",
        0 to "th"
    )

    /** Tue */
    var weekday: String

    /** May */
    var month: String

    /** 25 */
    var monthday: Int

    /** 12 */
    var hour: Int

    /** 16 */
    var minute: Int

    /** 34 */
    var second: Int

    /** 2021 */
    var year: Int

    var formatted: String
    
    fun convert24HrTo12Hr(hour: Int, minute: Int, second: Int): String {
        /** Example:
         * 12:59:59
         * 12:60 AM
         **/

        val morning = hour < 12 || hour == 24

        var outMinute = minute + round(second / 30.0).toInt()
        val outHour = (hour - if (hour > 12) 12 else 0) + (if (outMinute == 60) 1 else 0)

        if (outMinute == 60) outMinute %= 60

        return "$outHour:${if (outMinute < 10) "0$outMinute" else outMinute} ${if (morning) "AM" else "PM"}"
    }

    fun convertDateToString(): String {
        /** Monday, January 1st, 2021 */
        return "${days.get(weekday)}, ${months.get(month)} $monthday${monthdayEnds.get(monthday % 10)}, $year"
    }

    init {
        if (source.split(" ").size != 5) {
            val exception = "Source size must be 5, but found ${source.split(" ").size}. \nSource: $source"
            throw Exception(exception)
        }

        /** Example:
         * Tue May 25 12:16:34 2021
         **/

        val arr = source.split(" ")
        println(arr)

        weekday = arr[0]
        month = arr[1]
        monthday = arr[2].toInt()

        val time = arr[3].split(":")

        hour = time[0].toInt()
        minute = time[1].toInt()
        second = time[2].toInt()

        year = arr[4].toInt()

        formatted = "${if (use24Hr) convert24HrTo12Hr(hour, minute, second) else "$hour:$minute:$second"}, ${convertDateToString()}"
    }
}

data class CommitInfo(val hash: String) {
    var author: String
    var date: Date
    var name: String

    init {
        val command = "git show $hash".runCommand()

        if (command != null) {
            val process = command.split("\n")

            /* Example of "git show <hash>"
            commit <hash> (HEAD -> master, origin/master)
            Author: <username> <<email>>
            Date:   <weekday> <month> <monthday> <time> <year> -0500
                <commit-name>
             */

            author = process[1]
                .split(" ")[1]

            date = Date(process[2]
                .split("( ){1,100}".toRegex())
                .subList(1, 6)
                .joinToString(" "), true)

            name = process[4]
                .substring(4)
        } else {
            throw NullPointerException("Result from command 'git show $hash' was null.")
        }
    }
}

fun getRandomLetter(): String {
    var letter = ('a'..'z').random().toString()
    if (kotlin.random.Random.nextBoolean()) letter = letter.toUpperCase()

    return letter
}

fun getRandomLetters(amount: Int): Iterable<String> {
    return (1 until amount).map { getRandomLetter() }
}

fun generateDescription(info: CommitInfo): String {
    return """## ${getRandomLetters(28)}
${getRandomLetters(75)}
${getRandomLetters(46)}
${getRandomLetters(28)}
## ${getRandomLetters(8)}
${getRandomLetters(82)}
${getRandomLetters(38)}"""
}

fun generateTag(): String {
    return "v${getRandomLetters(6)}"
}

val hash = args[0]

val outputFile = File("output.json")
val tagFile = File("tag.json")

outputFile.writeText(generateDescription(CommitInfo(hash)))
tagFile.writeText(generateTag())