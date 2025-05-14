/**
 * The interface implemented by the various command classes in the application
 */
interface Command {
    fun execute(): CommandOutput
}