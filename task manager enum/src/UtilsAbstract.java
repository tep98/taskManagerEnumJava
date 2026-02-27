import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class UtilsAbstract implements IUtils {
    public static boolean areTasksUnique(Collection<? extends Task> tasks) {
        return false;
    }

    public static int compareByStatus(Task t1, Task t2) {
        return 0;
    }

    public static void updateTaskStatus(Task task, Collection<SubTask> allSubTasks) {
        return;
    }

    public static void handleCompletedTask(TaskManager manager, Archive archive, int taskId, boolean useArchive) {
        return;
    }
}
