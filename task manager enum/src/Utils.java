import java.util.Collection;

public class Utils {

    public static void updateTaskStatus(Task task, Collection<SubTask> allSubTasks) {
        boolean allDone = true;
        boolean hasSubTasks = false;

        for (SubTask sub : allSubTasks) {
            if (sub.getTaskId() == task.getTaskId()) {
                hasSubTasks = true;
                if (!sub.isCompleted()) {
                    allDone = false;
                    break;
                }
            }
        }

        if (hasSubTasks && allDone) {
            task.setCompleted(true);
        } else if (hasSubTasks) {
            task.setCompleted(false);
        }
    }
}
