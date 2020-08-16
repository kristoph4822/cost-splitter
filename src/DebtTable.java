import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DebtTable {

    private Double[][] debtTable;
    private Map<String, Integer> nameIndex = new HashMap<>();
    private ArrayList<Person> persons;

    public DebtTable(ArrayList<Person> p) {
        this.persons = p;
        this.debtTable = new Double[p.size()][p.size()];
        fillTable();
        fillNameIndex(p);
    }

    private void fillTable() {
        for (int i = 0; i < debtTable.length; i++)
            for (int j = 0; j < debtTable.length; j++)
                debtTable[i][j] = 0.;
    }

    private void fillNameIndex(ArrayList<Person> persons) {
        for (int i = 0; i < persons.size(); i++) {
            nameIndex.put(persons.get(i).getName(), i);
        }
    }

    public void addDebt(String reciver, String giver, double x){
        debtTable[nameIndex.get(reciver)][nameIndex.get(giver)] += x;
    }

    public ArrayList<Debt> getDebts(){
        ArrayList<Debt> debtArray = new ArrayList<>();
        for (int i = 0; i < debtTable.length; i++) {
            for (int j = i + 1; j < debtTable.length; j++) {
                double amount = debtTable[i][j] - debtTable[j][i];
                if (amount > 0) {
                    debtArray.add(new Debt(persons.get(i).getName(), persons.get(j).getName(), amount));
                } else if(amount < 0){
                    debtArray.add(new Debt(persons.get(j).getName(), persons.get(i).getName(), Math.abs(amount)));
                }
            }
        }
        return debtArray;
    }
}
