import com.github.ajalt.clikt.core.CliktCommand
import exception.InvalidCommandException

class Application {
    private val ui = Ui() // The application's UI
    private val taskList = mutableListOf<String>()

    fun run() {
        println("ToDoList")
        var canExit = false
        while (!canExit) {
            try {
                val input = ui.getInput()
                val command = Command(input)
                command.execute()
                canExit = command.checkIfCanExit()
            } catch (exception: InvalidCommandException) {
                ui.showOutput(exception.message)
            }
        }
    }
}