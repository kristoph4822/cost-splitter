import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class FileReader {

    private static final String FILE_FOLDER = "src/files/";

    public static ArrayList<Person> readPersonsFromFile(String filePath) throws IOException {

        ArrayList<Person> persons = new ArrayList<>();
        BufferedReader br = new BufferedReader(new java.io.FileReader(FILE_FOLDER + filePath));
        String line;

        while ((line = br.readLine()) != null) {
            if(line.charAt(0) == '#'){      //lines starting with '#' are ignored
                continue;
            }
            String[] info = line.split(Pattern.quote("|"));
            persons.add(new Person(info[0].trim(), Double.parseDouble(info[1].trim()), Double.parseDouble(info[2].trim())));
        }

        return persons;
    }
}
