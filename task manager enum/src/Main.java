public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        Task task1 = new Task("Купить молоко", "Сходить в магазин и купить самое дешевое молоко по скидке", Priority.MEDIUM);
        manager.addTask(task1);

        SubTask sub1 = new SubTask("Выбрать марку", "Взять безлактозное, по скидке", Priority.LOW, task1.getTaskId());
        manager.addSubTask(sub1);

        System.out.println("=== 1 ===");
        manager.printAllTasks();


        System.out.printf("\n\n\n");

        manager.completeSubTask(sub1.getSubTaskId());
        manager.printAllTasks();

        System.out.printf("\n\n\n");



        manager.removeById(2);

        Task task2 = new Task("Учить Java", "Продолжить изучение java", Priority.MEDIUM);
        manager.addTask(task2);

        SubTask sub2 = new SubTask("enum class", "Изучить как работает enum class в java", Priority.MEDIUM, task2.getTaskId());
        manager.addSubTask(sub2);

        System.out.println("=== 2 ===");
        manager.printAllTasks();
    }
}