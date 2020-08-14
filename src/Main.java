import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        if (args.length == 0)
            throw new IllegalArgumentException("No argument was given.");

        DebtCalculator dc = null;

        try {
            dc = new DebtCalculator(FileReader.readPersonsFromFile(args[0]));
        } catch (IOException e) {
            System.out.println("Unable to open given file.");
            System.exit(-1);
        }

        dc.resolveDebt();
        for(Debt d: dc.getDebts()){
            System.out.println(d.toString());
        }

    }


}
