import exception.InvalidCommandException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import task.TaskList
import kotlin.test.Test
import kotlin.test.assertFailsWith

class CommandTest {
    val taskList = TaskList()

    @Test
    fun checkIfCanExit_exit_true() {
        val input = "exit"
        val command = Command(input, taskList)
        assertTrue { command.checkIfCanExit() }
    }

    @Test
    fun checkIfCanExit_notExit_false() {
        val input = "add test"
        val command = Command(input, taskList)
        assertFalse { command.checkIfCanExit() }
    }

    @Test
    fun execute_invalidCommand_failure() {
        val input = "hello world"
        val command = Command(input, taskList)
        assertFailsWith<InvalidCommandException> { command.execute() }
    }

    @Test
    fun execute_addCommandInvalidParams_failure() {
        val input = "add"
        val command = Command(input, taskList)
        assertFailsWith<InvalidCommandException> { command.execute() }
    }

    @Test
    fun execute_removeCommandInvalidParams_failure() {
        val input = "remove"
        val command = Command(input, taskList)
        assertFailsWith<InvalidCommandException> { command.execute() }
    }

    @Test
    fun execute_setstatusCommandInvalidParams_failure() {
        val input = "setstatus 0"
        val command = Command(input, taskList)
        assertFailsWith<InvalidCommandException> { command.execute() }
    }
}