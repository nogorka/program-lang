import java.lang.StringBuilder

fun isNumber(s: String): Boolean {
    if (s.isEmpty()) return false
    for (symbol in s) {
        if (!symbol.isDigit()) {
            return false
        }
    }
    return true
}

fun pop(s: MutableList<String>): String {

    var result = s.first()
    s.removeAt(0)
    return result
}

fun main(args: Array<String>) {

    print("Please input expression: ")
    val answer: String? = readLine()
    val ops = arrayOf("+", "-", "*", "/")
    if (!answer.isNullOrEmpty()) {
        val parts = answer?.split(' ')
        val stack = mutableListOf<String>()

        for (part in parts.reversed()) {

            if (isNumber(part)) {
                stack.add(0, part)
            } else if (part in ops) {
                if (stack.size > 1) {
                    var first = stack.first()
                    stack.removeAt(0)
                    var second = stack.first()
                    stack.removeAt(0)
                    var str = "(" + first + part + second + ")"
                    stack.add(0, str)
                } else {
                    println("Not enough arguments")
                    return
                }
            } else {
                println("Wrong expression. There're not recognized symbol ")
                return
            }
        }

        if (stack.size > 1) {
            println("Not enough operators to unpack")
        } else if (stack.isEmpty()) {
            println("Stack is empty")
        } else {
            println("Result: ${stack.removeAt(stack.lastIndex)}")
        }
    } else {
        println("Expression is empty")
    }
}