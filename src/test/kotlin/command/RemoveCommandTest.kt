package command

import com.github.ajalt.clikt.testing.test
import org.junit.jupiter.api.BeforeEach
import task.TaskList
import kotlin.test.Test
import kotlin.test.assertEquals

class RemoveCommandTest {
    val taskList = TaskList()

    @BeforeEach
    fun setupTestTaskList() {
        taskList.addTask("test")
    }

    @Test
    fun execute_taskPresent_success() {
        val input = "0"
        val result = RemoveCommand(taskList).test(input)
        assertEquals("Task 0 has been removed from the list.\n", result.stdout)
    }

    @Test
    fun execute_taskAbsent_failure() {
        val input = "7"
        val result = RemoveCommand(taskList).test(input)
        assertEquals("Task 7 is not present in the list.\n", result.stdout)
    }
}