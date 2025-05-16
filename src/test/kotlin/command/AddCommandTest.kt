package command

import com.github.ajalt.clikt.testing.test
import task.TaskList
import kotlin.test.Test
import kotlin.test.assertEquals

class AddCommandTest {
    val taskList = TaskList()

    @Test
    fun run_validParams_success() {
        val input = "test"
        val result = AddCommand(taskList).test(input)
        assertEquals("""
        The following task has been added to the list:
        - test
        
        """.trimIndent(), result.stdout)
    }
}