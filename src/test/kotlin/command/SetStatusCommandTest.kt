package command

import com.github.ajalt.clikt.testing.test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import task.TaskList
import kotlin.test.Test
import kotlin.test.assertFails

class SetStatusCommandTest {
    val taskList = TaskList()

    @BeforeEach
    fun setUp() {
        taskList.addTask("test")
    }

    @Test
    fun run_taskPresent_success() {
        val input = "0 done"
        val result = SetStatusCommand(taskList).test(input)
        assertEquals("Task 0's status is now done.\n", result.stdout)
    }

    @Test
    fun run_taskAbsent_success() {
        val input = "5 done"
        val result = SetStatusCommand(taskList).test(input)
        assertEquals("Task 5 not found.\n", result.stdout)
    }

    @Test
    fun run_invalidStatus_failure() {
        val input = "0 predicted"
        assertFails { SetStatusCommand(taskList).test(input) }
    }
}