import com.github.ajalt.clikt.core.main
import command.AddCommand
import command.ExitCommand
import exception.InvalidCommandException
import task.TaskList

class Command(val input: String, val taskList: TaskList) {
    private val commandParts = input.split(" ")
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

    fun execute() {
        when (commandWord) {
            "exit" -> ExitCommand().main(commandArgs)
            "add" -> AddCommand(taskList).main(commandArgs)
            else -> throw InvalidCommandException("Invalid command!")
        }
    }
}

