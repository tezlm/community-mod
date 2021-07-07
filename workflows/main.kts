import java.io.File

fun getRandomLetter(): String {
    var letter = ('a'..'z').random().toString()
    if (kotlin.random.Random.nextBoolean()) letter = letter.toUpperCase()

    return letter
}

fun getRandomLetters(amount: Int): String {
    return (1 until amount).map { getRandomLetter() }.joinToString("")
}

fun generateDescription(): String {
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

outputFile.writeText(generateDescription())
tagFile.writeText(generateTag())