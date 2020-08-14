import java.util.ArrayList;

public class Person {

    private final String name;
    private final int expense;
    private final double ratio;
    private int balance;


    public Person(String name, int expense, double ratio) {
        this.name = name;
        this.expense = expense;
        this.ratio = ratio;
        this.balance = 0;
    }

    public String getName() {
        return name;
    }

    public int getExpense() {
        return expense;
    }

    public double getRatio() {
        return ratio;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
