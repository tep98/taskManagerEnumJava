import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Utils {

    public static boolean areTasksUnique(Collection<? extends Task> tasks) {
        Set<Task> unique = new HashSet<>(tasks);
        return unique.size() == tasks.size();
    }

    public static int compareByStatus(Task t1, Task t2) {
        Status s1 = t1 != null ? t1.getStatus() : Status.NEW;
        Status s2 = t2 != null ? t2.getStatus() : Status.NEW;
        return Integer.compare(s1.ordinal(), s2.ordinal());
    }

    public static void updateTaskStatus(Task task, Collection<SubTask> allSubTasks) {
        boolean allDone = true;
        boolean hasSubTasks = false;

        for (SubTask sub : allSubTasks) {
            if (sub.getParentTaskId() == task.getTaskId()) {
                hasSubTasks = true;
                if (!sub.isCompleted()) {
                    allDone = false;
                    break;
                }
            }
        }

        if (hasSubTasks) {
            task.setCompleted(allDone);
            task.setStatus(allDone ? Status.DONE : Status.IN_PROGRESS);
        }
    }

    public static void handleCompletedTask(TaskManager manager, Archive archive, int taskId, boolean useArchive) {
        Task task = manager.getTaskById(taskId);
        if (task != null) {
            if (useArchive) {
                archive.addTask(task);
                manager.removeById(taskId);
                System.out.println("✅ Задача #" + taskId + " перемещена в архив");
            } else {
                task.setStatus(Status.DONE);
                System.out.println("✅ Задача #" + taskId + " помечена как выполненная");
            }
        }
    }
}
