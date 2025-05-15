package task

/**
 * Represents the task list for the application
 */
class TaskList {
    val tasks = mutableListOf<Task>()

    /**
     * @return the size of the list.
     */
    fun getSize(): Int {
        return tasks.size
    }

    /**
     * Adds a task to the task list.
     *
     * @param name the name of the task to be added.
     */
    fun addTask(name: String?) {
        val id = tasks.size + 1
        val task = Task(name, id)
        tasks.add(task)
    }

    /**
     * Returns true if the task with the specified ID is in the task list,
     * returns false otherwise.
     *
     * @param id the ID of the task to be removed
     *
     * @return true if a task with ID id is removed from the list, false otherwise
     */
    fun removeTask(id: Int): Boolean {
        return tasks.removeIf { task -> task.id == id }
    }

    /**
     * @return a String representation of the task list.
     */
    fun showList(): String {
        var output = ""
        output += "Tasks\n"
        for (task in tasks) {
            output += "${task.id}. ${task.name}\n"
        }
        return output
    }
}