package task

class TaskList {
    val tasks = mutableListOf<Task>()

    /**
     * Adds a task to the task list.
     */
    fun addTask(name: String?) {
        val id = tasks.size + 1
        val task = Task(name, id)
        tasks.add(task)
    }

    fun showList(): String {
        var output = ""
        output += "Tasks\n"
        for (task in tasks) {
            output += "${task.id}. ${task.name}\n"
        }
        return output
    }
}