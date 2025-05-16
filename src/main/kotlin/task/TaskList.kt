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
     * Returns true if the task at the specified index can be set with the specified status,
     * returns false otherwise.
     *
     * @param index the index of the task.
     * @param status the status that the task at index is to be set to.
     *
     * @return true if the task at index's status is set to status, false otherwise.
     */
    fun setTaskStatus(index: Int, status: String): Boolean {
        if (index >= tasks.size) {
            return false
        }

        tasks[index].status = Status.valueOf(status)
        return true
    }

    /**
     * @return a String representation of the task list.
     */
    fun showList(): String {
        var output = ""
        output += "Tasks\n"
        for (i in 0 until tasks.size) {
            output += "${i}. ${tasks[i].name} [${tasks[i].status}]\n"
        }
        return output
    }
}