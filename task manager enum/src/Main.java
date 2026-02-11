public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 Демонстрация всех возможностей TaskManager\n");

        TaskManager manager = new TaskManager();

        // === 1. ДОБАВЛЕНИЕ ЗАДАЧ И ПОДЗАДАЧ, СОРТИРОВКА ПО СТАТУСУ ===
        System.out.println("=== 1. Добавление задач и подзадач ===\n");

        Task task1 = new Task("Купить молоко", "Сходить в магазин", Priority.MEDIUM);
        manager.addTask(task1);

        SubTask sub1 = new SubTask("Выбрать марку", "Безлактозное по скидке", Priority.LOW, task1.getTaskId());
        SubTask sub2 = new SubTask("Заплатить", "Наличными или картой?", Priority.HIGH, task1.getTaskId());
        manager.addSubTask(sub1);
        manager.addSubTask(sub2);

        Task task2 = new Task("Учить Java", "Продолжить изучение", Priority.HIGH);
        task2.setStatus(Status.IN_PROGRESS); // Задача уже в работе
        manager.addTask(task2);

        Task task3 = new Task("Протестировать код", "Проверить все функции", Priority.VERY_HIGH);
        manager.addTask(task3);

        manager.printAllTasks();
        System.out.println();

        // === 2. ЗАВЕРШЕНИЕ ПОДЗАДАЧ ===
        System.out.println("=== 2. Завершение подзадач (автообновление статуса родителя) ===\n");
        manager.completeSubTask(sub1.getTaskId()); // Завершаем первую подзадачу
        manager.completeSubTask(sub2.getTaskId()); // Завершаем вторую - задача станет DONE

        manager.printAllTasks();
        System.out.println();

        // === 3. ВАРИАНТ 1: ЗАМЕНА СТАТУСА НА DONE ===
        System.out.println("=== 3. Вариант 1: Только замена статуса на DONE (useArchive = false) ===\n");
        Utils.handleCompletedTask(manager, manager.getArchive(), task2.getTaskId(), false);
        manager.printAllTasks();
        System.out.println();

        // === 4. ВАРИАНТ 2: ПЕРЕНОС В АРХИВ ===
        System.out.println("=== 4. Вариант 2: Перенос в архив (useArchive = true) ===\n");
        Utils.handleCompletedTask(manager, manager.getArchive(), task1.getTaskId(), true);
        manager.printAllTasks();

        manager.printArchive();
        System.out.println();

        // === 5. РУЧНАЯ СМЕНА СТАТУСОВ ===
        System.out.println("=== 5. Ручная смена статусов ===\n");
        task3.setStatus(Status.IN_PROGRESS);
        manager.printAllTasks();
        System.out.println();

        // === 6. УДАЛЕНИЕ ЗАДАЧ ===
        System.out.println("=== 6. Удаление задачи по ID ===\n");
        System.out.println("Удаляем задачу #" + task3.getTaskId());
        manager.removeById(task3.getTaskId());
        manager.printAllTasks();
        System.out.println();

        // === 7. ПРОВЕРКА УНИКАЛЬНОСТИ ===
        System.out.println("=== 7. Проверка уникальности задач ===\n");
        System.out.println("Уникальность задач: " + Utils.areTasksUnique(manager.tasks.values()));
        System.out.println();

        // === 8. РАЗЛИЧНЫЕ СТАТУСЫ ДЛЯ ДЕМОНСТРАЦИИ СОРТИРОВКИ ===
        System.out.println("=== 8. Финальная демонстрация сортировки по статусам ===\n");

        // Создаем задачи всех статусов
        Task demoNew = new Task("Новая задача", "Только что создана", Priority.MEDIUM);
        Task demoProgress = new Task("В работе", "Выполняется", Priority.LOW);
        demoProgress.setStatus(Status.IN_PROGRESS);
        Task demoDone = new Task("Выполненная", "Готова", Priority.HIGH);
        demoDone.setStatus(Status.DONE);

        manager.addTask(demoNew);
        manager.addTask(demoProgress);
        manager.addTask(demoDone);

        manager.printAllTasks();
    }
}
