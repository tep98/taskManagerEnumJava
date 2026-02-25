//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class SubTask extends Task {
    private final int parentTaskId;

    public SubTask(String taskName, String taskDescription, Priority priority, int parentTaskId, int TaskCount) {
        super(taskName, taskDescription, priority, TaskCount);
        this.parentTaskId = parentTaskId;
        this.setStatus(Status.NEW);
    }

    public int getParentTaskId() {
        return this.parentTaskId;
    }

    public String toString() {
        String var10000;
        switch (this.getStatus()) {
            case NEW -> var10000 = "\ud83d\udd35";
            case IN_PROGRESS -> var10000 = "\ud83d\udfe1";
            case DONE -> var10000 = "✅";
            case ARCHIVED -> var10000 = "\ud83d\udce6";
            default -> throw new MatchException((String)null, (Throwable)null);
        }

        String statusIcon = var10000;
        return String.format("   └─ [%s] Подзадача #%d | %s | %s\n      %s", statusIcon, this.getTaskId(), this.priority, this.getStatus(), this.taskName);
    }
}
