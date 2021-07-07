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

fun getRandomLetter(): String {
    var letter = ('a'..'z').random().toString()
    if (kotlin.random.Random.nextBoolean()) letter = letter.toUpperCase()

    return letter
}

fun getRandomLetters(amount: Int = 100, randomize: Boolean = true): String {
    return (1 until (if (!randomize) amount else (1 until amount).random())).map { getRandomLetter() }.joinToString("")
}

fun generateDescription(): String {
    return """## ${getRandomLetters(28, false)}
${getRandomLetters()}
${getRandomLetters()}
${getRandomLetters()}
## ${getRandomLetters(8, false)}
${getRandomLetters()}
${getRandomLetters()}"""
}

fun generateTag(): String {
    val version = "1.0"
    val lastReleaseTag = "v1.0"

    val command = "git log $lastReleaseTag..HEAD --oneline".runCommand()
    val commitsSinceLastRelease = command?.split("\n")?.size

    return "v$version.${commitsSinceLastRelease ?: 0}"
}

val outputFile = File("output.json")
val tagFile = File("tag.json")

outputFile.writeText(generateDescription())
tagFile.writeText(generateTag())