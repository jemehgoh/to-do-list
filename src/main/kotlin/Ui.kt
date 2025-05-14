/**
 * Represents the class for the application.
 */
class Ui {

    /**
     * Returns a string with user input.
     *
     * @return the user input.
     */
    fun getInput(): String {
        print("Enter a command: ")
        return readln()
    }

    fun showOutput(output: String) {
        println(output)
    }
}