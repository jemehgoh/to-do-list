class ToDoList {
    private val ui = Ui() // The application's UI

    fun run() {
        println("ToDoList")
        while (true) {
            val input = ui.getInput()
            ui.showOutput(input)
        }
    }
}