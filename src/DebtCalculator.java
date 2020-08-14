import java.util.ArrayList;
import java.util.Collections;

public class DebtCalculator {

    private ArrayList<Person> persons;
    private ArrayList<Debt> debts;

    public DebtCalculator(ArrayList<Person> persons) {
        this.persons = persons;
        persons.sort(Person.sortByBalance);
        this.debts = new ArrayList();
    }

    public void resolveDebt(){
        calculateBalance();
        Person first;
        Person last;

        while(this.persons.size() > 1){
            first = this.persons.get(0);
            last = persons.get(persons.size() - 1);
            double lastAbsBalance = Math.abs(last.getBalance());

            if(first.getBalance() > lastAbsBalance){
                debts.add(new Debt(first.getName(), last.getName(), lastAbsBalance));
                first.addToBalance(-lastAbsBalance);
                persons.remove(last);
            }

            else{
                debts.add(new Debt(first.getName(), last.getName(), first.getBalance()));
                last.addToBalance(first.getBalance());
                persons.remove(first);
            }
        }
    }

    private void calculateBalance(){
        double sum = getSum();
        double ratio = getRatio();
        double x = sum/ratio; //amount which each person with ratio 1 has to pay overall
        for (Person p: persons) {
            p.setBalance(p.getExpense() - x * p.getRatio());
        }
    }

    private double getSum(){
        double sum = 0;
        for (Person p: persons) {
            sum += p.getExpense();
        }
        return sum;
    }

    private double getRatio(){
        double ratio = 0;
        for (Person p: persons) {
            ratio += p.getRatio();
        }
        return ratio;
    }

    public ArrayList<Debt> getDebts() {
        return debts;
    }

}
