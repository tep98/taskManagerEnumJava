import java.util.HashMap;

public class Master extends Person implements Finansable{
    int money;
    public Master(int id, String name, int money) {
        super(id, name);
        this.money = money;
    }
    @Override
    public void getMoney(int moneyAdd) {
        money += moneyAdd;
    }
    @Override
    public void spendMoney(int moneyRemove) {
        if (moneyRemove > money) {
            System.out.println("Money is not enough");
            return;
        }
        money -= moneyRemove;
    }

    public int getMoneyCount() {
        return money;
    }

    public void addTask(Task task, int price) {
        tasks.put(task, price);
    }

    public HashMap<Task, Integer> getTasks() {
        return this.tasks;
    }
}