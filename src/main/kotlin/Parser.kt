/**
 * Represents the command parser for the application.
 */
class Parser(val command: String) {
    fun parse(): Command {
       val commandWord = command.split(" ")[0]
        return when (commandWord) {
            "exit" -> ExitCommand()
            else -> throw InvalidCommandException("Invalid command!")
        }
    }
}