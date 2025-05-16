package command

import task.TaskList
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option

/**
 * Represents the command to add a task to the task list.
 */
class AddCommand(val taskList: TaskList): CliktCommand() {
    val taskName by option("-n")

    override fun run() {
        echo("""
        The following task has been added to the list:
        - $taskName
        """.trimIndent())
        taskList.addTask(taskName)
    }
}