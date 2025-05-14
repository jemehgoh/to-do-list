class Application {
    private val ui = Ui() // The application's UI
    private val taskList = mutableListOf<String>()

    fun run() {
        println("ToDoList")
        var canExit = false
        while (!canExit) {
            val input = ui.getInput().lowercase()
            ui.showOutput(input)

            when (input) {
                "exit" -> {
                    canExit = true
                }
                else -> {
                    taskList.add(input)
                }
            }
        }
        ui.showOutput("Program shutting down")
    }
}