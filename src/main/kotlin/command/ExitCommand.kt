package command

import com.github.ajalt.clikt.core.CliktCommand

/**
 * Represents the program's exit command
 */
class ExitCommand(): CliktCommand() {

    companion object {
        private const val EXIT_MESSAGE = "Program shutting down...."
    }

    /**
     * Returns the command message with an exit message.
     */
    override fun run() {
        echo(EXIT_MESSAGE)
    }
}