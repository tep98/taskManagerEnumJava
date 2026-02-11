import java.util.HashMap;
import java.util.Map;
import java.util.*;


public class TaskManager {
    public final Map<Integer, Task> tasks = new HashMap<>();
    private final Map<Integer, SubTask> subTasks = new HashMap<>();
    private final Archive archive = new Archive(); // Добавляем архив

    public void addTask(Task task) {
        tasks.put(task.getTaskId(), task);
    }

    public void addSubTask(SubTask subTask) {
        subTasks.put(subTask.getTaskId(), subTask);
    }

    public void printAllTasks() {
        System.out.println("Список задач:\n");

        List<Task> sortedTasks = new ArrayList<>(tasks.values());
        sortedTasks.sort(new TaskStatusCompare());


        for (Task task : sortedTasks) {
            System.out.println(task);

            for (SubTask sub : subTasks.values()) {
                if (sub.getParentTaskId() == task.getTaskId()) {
                    System.out.println(sub);
                }
            }
            System.out.println();
        }

        System.out.println("Уникальность задач: " +
                Utils.areTasksUnique(tasks.values()));
    }

    public void completeSubTask(int id) {
        SubTask sub = subTasks.get(id);
        if (sub != null) {
            sub.setCompleted(true);
            sub.setStatus(Status.DONE);
            Task parent = tasks.get(sub.getParentTaskId());
            if (parent != null) {
                Utils.updateTaskStatus(parent, subTasks.values());
            }
        }
    }

    public void removeById(int id) {
        tasks.remove(id);
        subTasks.remove(id);
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public void printArchive() {
        archive.printArchive();
    }

    public Archive getArchive() {
        return archive;
    }
}


/*
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
}*/
