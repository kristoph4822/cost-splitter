import java.util.ArrayList;

import static java.lang.System.exit;

public class DebtCalculator {

    private ArrayList<Person> persons;
    private ArrayList<Debt> debts;
    private DebtTable dt;

    public double sum;
    public double x;

    public DebtCalculator(ArrayList<Person> persons) {
        this.persons = persons;
        persons.sort(Person.sortByBalance);
        this.debts = new ArrayList();
        this.sum = 0;
    }

    public void resolveDebt(int version) {
        calculateBalance();
        if(version == 1){
            resolveDebt1();
        }
        else if(version == 2){
            resolveDebt2();
        }
        else{
            System.out.println("Podano złą wersję");
            exit(-1);
        }
    }

    private void resolveDebt1(){ //zależnie która kwota jest najmniejsza wybieramy jedną z 3 opcji
        Person first;
        Person last;

        while(this.persons.size() > 1){
            first = this.persons.get(persons.size() - 1);
            last = persons.get(0);
            double lastAbsBalance = Math.abs(last.getBalance());

            // wyrównujemy najgorszego
            if(first.getBalance() > lastAbsBalance) {
                debts.add(new Debt(first.getName(), last.getName(), lastAbsBalance));
                first.addToBalance(-lastAbsBalance);
                persons.remove(last);
            }

            //wyrównujemy najlepszego
            else {
                debts.add(new Debt(first.getName(), last.getName(), first.getBalance()));
                last.addToBalance(first.getBalance());
                persons.remove(first);
            }
        }
    }

    private void resolveDebt2() {
        this.dt = new DebtTable(persons);
        for (Person p1: persons) {
            double amount = p1.getExpense()/getRatio();
            for (Person p2: persons){
                if(p2.equals(p1))
                    continue;
                dt.addDebt(p1.getName(), p2.getName(), amount * p2.getRatio());
            }
        }

        this.debts = dt.getDebts();

    }

    private void calculateBalance(){
        getSum();
        double ratio = getRatio();
        this.x = sum/ratio; //amount which each person with ratio 1 has to pay overall
        for (Person p: persons) {
            p.setBalance(p.getExpense() - x * p.getRatio());
        }
    }

    private void getSum(){
        for (Person p: persons) {
            sum += p.getExpense();
        }
    }

    private double getRatio(){
        double ratio = 0;
        for (Person p: persons) {
            ratio += p.getRatio();
        }
        return ratio;
    }

    public void printDebts() {
        for(Debt d: debts){
            System.out.println(d.toString());
        }
    }
}
