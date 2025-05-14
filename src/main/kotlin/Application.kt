class Application {
    private val ui = Ui() // The application's UI
    private val taskList = mutableListOf<String>()

    fun run() {
        println("ToDoList")
        var canExit = false
        while (!canExit) {
            try {
                val input = ui.getInput().lowercase()
                val command: Command = Parser(input).parse()
                val output = command.execute()
                ui.showOutput(output.message)
                canExit = output.canExit
            } catch (exception: InvalidCommandException) {
                ui.showOutput(exception.message)
            }
        }
    }
}