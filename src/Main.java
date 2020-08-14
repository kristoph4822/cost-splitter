import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        if (args.length == 0)
            throw new IllegalArgumentException("No argument was given.");

        ArrayList<Person> persons = null;

        try {
            persons = FileReader.readPersonsFromFile(args[0]);
        } catch (IOException e) {
            System.out.println("Unable to open given file.");
            System.exit(-1);
        }
        for (Person p : persons)
            System.out.println(p.getName());
    }


}
