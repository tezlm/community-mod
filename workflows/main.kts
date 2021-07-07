import java.io.File

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
    return "v${getRandomLetters(6)}"
}

val outputFile = File("output.json")
val tagFile = File("tag.json")

outputFile.writeText(generateDescription())
tagFile.writeText(generateTag())