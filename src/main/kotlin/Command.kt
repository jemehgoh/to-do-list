import com.github.ajalt.clikt.core.main
import command.ExitCommand
import exception.InvalidCommandException

class Command(val input: String) {
    val commandParts = input.split(" ")
    val commandWord = commandParts[0].lowercase()
    val commandArgs = commandParts.subList(1, commandParts.size)

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
            else -> throw InvalidCommandException("Invalid command!")
        }
    }
}

