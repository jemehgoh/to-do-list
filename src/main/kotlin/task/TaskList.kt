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
        val task = Task(name)
        tasks.add(task)
    }

    /**
     * Returns true if the task at the specified index is in the task list,
     * returns false otherwise.
     *
     * @param index the ID of the task to be removed
     *
     * @return true if a task at index is removed from the list, false otherwise
     */
    fun removeTask(index: Int): Boolean {
        try {
            tasks.removeAt(index)
            return true
        } catch (e: IndexOutOfBoundsException) {
            return false
        }
    }

    /**
     * @return a String representation of the task list.
     */
    fun showList(): String {
        var output = ""
        output += "Tasks\n"
        for (i in 0 until tasks.size) {
            output += "${i}. ${tasks[i].name}\n"
        }
        return output
    }
}