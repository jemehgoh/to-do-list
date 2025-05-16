package command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.int
import task.TaskList

/**
 * Represents the command to remove a task from the task list.
 */
class RemoveCommand(val taskList: TaskList): CliktCommand() {
    val index by argument().int()

    override fun run() {
        val isTaskRemoved = taskList.removeTask(index)
        if (isTaskRemoved) {
            echo("Task $index has been removed from the list.")
        } else {
            echo("Task $index is not present in the list.")
        }
    }
}