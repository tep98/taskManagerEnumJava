import java.util.HashMap;
import java.util.Map;

public class Archive {
    public final Map<Integer, Task> archivedTasks = new HashMap<>();

    public void addTask(Task task) {
        archivedTasks.put(task.getTaskId(), task);
        task.setStatus(Status.ARCHIVED);
    }

    public Task getTask(int id) {
        return archivedTasks.get(id);
    }

    public void printArchive() {
        System.out.println("Архив задач:");
        for (Task task : archivedTasks.values()) {
            System.out.println(task);
        }
    }
}