import com.github.ajalt.clikt.core.CliktError
import com.github.ajalt.clikt.core.parse
import command.AddCommand
import command.ExitCommand
import command.RemoveCommand
import command.SetStatusCommand
import exception.InvalidCommandException
import task.TaskList

/**
 * Represents the class that handles command execution.
 */
class Command(val input: String, val taskList: TaskList) {
    private val commandParts = splitBySpace(input)
    private val commandWord = commandParts[0].lowercase()
    private val commandArgs = commandParts.subList(1, commandParts.size)

    /**
     * @return true if the program can exit, false otherwise.
     */
    fun checkIfCanExit(): Boolean {
        if (commandWord == "exit") {
            return true
        }

        return false
    }

    /**
     * Executes the command based on the command word specified.
     */
    fun execute() {
        try {
            when (commandWord) {
                "exit" -> ExitCommand().parse(commandArgs)
                "add" -> AddCommand(taskList).parse(commandArgs)
                "remove" -> RemoveCommand(taskList).parse(commandArgs)
                "setstatus" -> SetStatusCommand(taskList).parse(commandArgs)
                else -> throw InvalidCommandException("Invalid command!")
            }
        } catch (error: CliktError) {
            throw InvalidCommandException(setErrorMessage(commandWord))
        }
    }

    private fun setErrorMessage(commandWord: String): String {
        return when (commandWord) {
            "add" -> """
                Please key in the command in this format:
                add <NAME>
            """.trimIndent()
            "remove" -> """
                Please key in the command in this format:
                remove <INDEX>
            """.trimIndent()
            "setstatus" -> """
                Please key in the command in this format:
                setstatus <INDEX> <STATUS>
            """.trimIndent()
            else -> "Invalid command!"
        }
    }
}

private fun splitBySpace(input:String): MutableList<String> {
    var isInQuotes = false
    val outputList = mutableListOf<String>()
    var index = 0
    for (i in 0 until input.length) {
        if (input[i] == ' ' && !isInQuotes) {
            addItem(outputList, input.substring(index, i))
            index = (i + 1)
        } else if (input[i] == '\'') {
            if (isInQuotes) {
                outputList.add(input.substring((index + 1), i))
                index = (i + 1)
            }
            isInQuotes = !isInQuotes
        }
    }
    addItem(outputList, input.substring(index, input.length))
    return outputList
}

private fun addItem(list: MutableList<String>, item: String) {
    if (item.isNotEmpty()) {
        list.add(item)
    }
}