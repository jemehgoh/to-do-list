import com.github.ajalt.clikt.core.main
import command.AddCommand
import command.ExitCommand
import command.RemoveCommand
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
        when (commandWord) {
            "exit" -> ExitCommand().main(commandArgs)
            "add" -> AddCommand(taskList).main(commandArgs)
            "remove" -> RemoveCommand(taskList).main(commandArgs)
            else -> throw InvalidCommandException("Invalid command!")
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