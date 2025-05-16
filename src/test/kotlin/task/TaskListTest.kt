package task

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TaskListTest {
    @Test
    fun addTask_valid_success() {
        val taskList = TaskList()
        taskList.addTask("test task")
        assertEquals(1, taskList.getSize())
    }

    @Test
    fun removeTask_valid_success() {
        val taskList = TaskList()
        taskList.addTask("test task")
        taskList.addTask("test task 2")
        assertTrue(taskList.removeTask(1))
    }

    @Test
    fun removeTask_invalid_failure() {
        val taskList = TaskList()
        taskList.addTask("test task")
        taskList.addTask("test task 2")
        assertFalse(taskList.removeTask(26))
    }
}