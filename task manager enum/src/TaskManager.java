import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private final Map<Integer, Task> tasks = new HashMap<>();
    private final Map<Integer, SubTask> subTasks = new HashMap<>();

    public void addTask(Task task) {
        tasks.put(task.getTaskId(), task);
    }

    public void addSubTask(SubTask subTask) {
        subTasks.put(subTask.getSubTaskId(), subTask);
    }

    public void printAllTasks() {
        System.out.println("--- Список всех задач ---");
        for (Task task : tasks.values()) {
            System.out.println(task.getTask());
            System.out.println("-------------------------");
        }
        for (SubTask subTask : subTasks.values()) {
            System.out.println(subTask.getTask());
            System.out.println("-------------------------");
        }
    }

    public void removeById(int id) {
        tasks.remove(id);
        subTasks.remove(id);
    }

    public void completeSubTask(int id) {
        SubTask sub = subTasks.get(id);
        if (sub != null) {
            sub.setCompleted(true);

            Task parent = tasks.get(sub.getTaskId());
            if (parent != null) {
                Utils.updateTaskStatus(parent, subTasks.values());
            }
        }
    }
}