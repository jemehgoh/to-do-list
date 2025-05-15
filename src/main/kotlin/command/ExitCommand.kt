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
     * Prints the exit message.
     */
    override fun run() {
        echo(EXIT_MESSAGE)
    }
}