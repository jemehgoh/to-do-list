package command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.int
import task.TaskList

/**
 * Represents the command to set a task's status as done or pending.
 */
class SetStatusCommand(val taskList: TaskList): CliktCommand() {
    val index by argument().int()
    val status by argument()

    override fun run() {
        val isStatusSet = taskList.setTaskStatus(index, status.uppercase())

        if (isStatusSet) {
            echo("Task $index's status is now $status.")
        } else {
            echo("Task $index not found.")
        }
    }
}
