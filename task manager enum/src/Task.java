import java.util.Objects;

public class Task /*implements Comparable<Task>*/ {
    private static int idCounter = 1;
    private final int taskId;

    String taskName;
    String taskDescription;
    Priority priority;
    private boolean isCompleted = false;
    private Status status = Status.NEW;

    Task(String taskName, String taskDescription, Priority priority) {
        this.taskId = idCounter++;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.priority = priority;
        this.status = Status.NEW;
    }

    public int getTaskId() {
        return taskId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "Задача #%d | %s | %s\n Название: %s\n Описание: %s",
                taskId, priority, status, taskName, taskDescription
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return taskId == task.taskId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }

    /*@Override
    public int compareTo(Task o) {
        int priorityCompare = o.priority.ordinal() - this.priority.ordinal();
        return priorityCompare >= 0 ? priorityCompare : Integer.compare(this.taskId, o.taskId);
    }*/

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
