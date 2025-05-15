package command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.int
import task.TaskList

/**
 * Represents the command to remove a task from the task list.
 */
class RemoveCommand(val taskList: TaskList): CliktCommand() {
    val id by argument().int()

    override fun run() {
        val isTaskRemoved = taskList.removeTask(id)
        if (isTaskRemoved) {
            echo("Task $id has been removed from the list.")
        } else {
            echo("Task $id is not present in the list.")
        }
    }
}