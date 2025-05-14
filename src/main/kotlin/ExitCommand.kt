/**
 * Represents the program's exit command
 */
class ExitCommand(): Command {
    companion object {
        private const val EXIT_MESSAGE = "Program shutting down...."
    }

    /**
     * Returns the command message with an exit message.
     */
    override fun execute(): CommandOutput {
        return CommandOutput(EXIT_MESSAGE, true)
    }
}