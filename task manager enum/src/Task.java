public class Task {
    private static int idCounter = 1; // Начинаем с 1 для удобства
    private final int taskId;

    String taskName;
    String taskDescription;
    Priority priority;
    private boolean isCompleted = false;

    Task(String taskName, String taskDescription, Priority priority) {
        this.taskId = idCounter++;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.priority = priority;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTask() {
        String status = isCompleted ? "✅" : "❌";
        return String.format(
                "[%s] Номер задачи: %d, Приоритет: %s\n Название: %s\n Описание: %s",
                status, this.taskId, this.priority, this.taskName, this.taskDescription
        );
    }


    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

}
