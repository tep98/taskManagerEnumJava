import java.util.HashMap;

public abstract class Person {
    int id;
    String name;
    HashMap<Task, Integer> tasks = new HashMap<Task, Integer>();

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//абстрактный класс персон (имя, айди, мани), клиент и мастер наследуются от персон. у мастера может быть несколько задач.
// если у одного мастера несколько задач и у клиента одна задача - логично в классе клиент держать. у абстракт класса будет карта задач передоваемая и клиенту и мастера