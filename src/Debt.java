public class Debt {

    private final String CURRENCY = "PLN";

    private String reciver;
    private String giver;
    private int amount;

    public Debt(String reciver, String giver, int amount) {
        this.reciver = reciver;
        this.giver = giver;
        this.amount = amount;
    }

    @Override
    public String toString(){

        return this.giver + " owes " + this.reciver + " " + this.amount + " " + CURRENCY;
    }
}
