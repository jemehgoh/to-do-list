package exception

/**
 * Represents an invalid command exception.
 */
class InvalidCommandException(override val message: String?): Throwable() {
}