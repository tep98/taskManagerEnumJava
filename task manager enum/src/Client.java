import java.util.HashMap;

public class Client extends Person implements FinansableClient{
    int money;
    Master master;
    public Client(int id, String name, int money, Master master) {
        super (id, name);
        this.money = money;
        this.master = master;
    }

    public int getMoney() {
        return money;
    }

    public void addTask(Task task, int price) {
        if (money < price) {
            System.out.println("Money is not enough");
            return;
        }

        int moneyBefore = money;
        spendMoney(price);

        if (moneyBefore - price == money) {
            tasks.put(task, price);
            master.addTask(task, price);
        }
    }
    @Override
    public void spendMoney(int moneyRemove) {
        money -= moneyRemove;
        master.getMoney(moneyRemove);
    }

    public HashMap<Task, Integer> getTasks() {
        return this.tasks;
    }
}
