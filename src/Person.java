import java.util.Comparator;

public class Person {

    private final String name;
    private final double expense;
    private final double ratio;
    private double balance;

    public Person(String name, double expense, double ratio) {
        this.name = name;
        this.expense = expense;
        this.ratio = ratio;
        this.balance = 0;
    }

    public String getName() {
        return name;
    }

    public double getExpense() {
        return expense;
    }

    public double getRatio() {
        return ratio;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addToBalance(double amount) {
        this.balance += amount;
    }

    public static Comparator<Person> sortByBalance = new Comparator<>() {

        @Override
        public int compare(Person p1, Person p2) {
            int x = Double.compare(p1.getBalance(), p2.getBalance());
            //sort in ascending order
            if(x == 0)
                return Double.compare(p1.getExpense(), p2.getExpense());
            return x;
        }
    };

    @Override
    public String toString(){
        return name + " | " + expense + " | " + ratio;
    }
}
