import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class FileReader {

    private final String FILE_FOLDER = "src/files/";
    private final String FilePath;

    public FileReader(String filePath) {
        FilePath = filePath;
    }

    public ArrayList<Person> readPersonsFromFile() throws IOException {

        ArrayList<Person> persons = new ArrayList<>();
        BufferedReader br = new BufferedReader(new java.io.FileReader(FILE_FOLDER + FilePath));
        String line;

        while ((line = br.readLine()) != null) {
            if(line.charAt(0) == '#'){      //lines starting with '#' are ignored
                continue;
            }
            String[] info = line.split(Pattern.quote("|"));
            persons.add(new Person(info[0], Integer.parseInt(info[1]), Double.parseDouble(info[2])));
        }

        return persons;
    }
}
