import exception.InvalidCommandException
import task.TaskList

class Application {
    private val ui = Ui() // The application's UI
    private val taskList = TaskList()

    fun run() {
        println("ToDoList")
        var canExit = false
        while (!canExit) {
            try {
                val input = ui.getInput()
                val command = Command(input, taskList)
                command.execute()
                canExit = command.checkIfCanExit()
            } catch (exception: InvalidCommandException) {
                ui.showOutput(exception.message)
            }
        }
    }
}