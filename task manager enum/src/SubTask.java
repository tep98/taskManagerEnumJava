public class SubTask extends Task {
    private final int parentTaskId;

    public SubTask(String taskName, String taskDescription, Priority priority, int parentTaskId) {
        super(taskName, taskDescription, priority);
        this.parentTaskId = parentTaskId;
        setStatus(Status.NEW); // ✅ Устанавливаем статус для подзадач
    }

    public int getParentTaskId() {
        return parentTaskId;
    }

    @Override
    public String toString() {
        String statusIcon = switch (getStatus()) {
            case NEW -> "🔵";
            case IN_PROGRESS -> "🟡";
            case DONE -> "✅";
            case ARCHIVED -> "📦";
        };
        return String.format(
                "   └─ [%s] Подзадача #%d | %s | %s\n      %s",
                statusIcon, getTaskId(), priority, getStatus(), taskName
        );
    }
}
