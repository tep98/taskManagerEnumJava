import java.util.Comparator;

class TaskStatusCompare implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        Status s1 = t1 != null ? t1.getStatus() : Status.NEW;
        Status s2 = t2 != null ? t2.getStatus() : Status.NEW;
        return Integer.compare(s1.ordinal(), s2.ordinal());
    }
}