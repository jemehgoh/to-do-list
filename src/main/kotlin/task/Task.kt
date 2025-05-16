package task

import Status

/**
 * Represents a task in the task list.
 */
data class Task(val name: String?) {
    var status: Status = Status.PENDING
}
