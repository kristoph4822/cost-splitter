import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Debt {

    public static final String CURRENCY = "PLN";

    private String reciver;
    private String giver;
    private double amount;

    public Debt(String reciver, String giver, double amount) {
        this.reciver = reciver;
        this.giver = giver;
        this.amount = amount;
    }

    @Override
    public String toString(){

        NumberFormat f = new DecimalFormat("#0.00");
        return this.giver + " owes " + this.reciver + " " + f.format(this.amount) + " " + CURRENCY;
    }

}
