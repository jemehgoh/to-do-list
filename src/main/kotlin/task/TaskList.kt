package task

class TaskList {
    val tasks = mutableListOf<Task>()

    /**
     * Adds a task to the task list.
     */
    fun addTask(name: String) {
        val id = tasks.size
        val task = Task(name, id)
        tasks.add(task)
    }
}