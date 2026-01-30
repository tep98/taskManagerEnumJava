public class SubTask extends Task {
    private final int parentTaskId;

    public SubTask(String taskName, String taskDescription, Priority priority, int parentTaskId) {
        super(taskName, taskDescription, priority);
        this.parentTaskId = parentTaskId;
    }

    public int getSubTaskId() {
        return getTaskId();
    }

    @Override
    public String getTask() {
        String status = isCompleted() ? "✅" : "❌";
        return String.format(
                "[%s] Номер подзадачи: %d (Родитель: %d), Приоритет: %s\n Название: %s\n Описание: %s",
                status, getTaskId(), this.parentTaskId, this.priority, this.taskName, this.taskDescription
        );
    }

}
