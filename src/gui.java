import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class gui {
    ArrayList<Person> persons = new ArrayList<>();
    public JPanel mainPanel;
    private JTextField nameTextField;
    private JTextField expenseTextField;
    private JTextField ratioTextField;
    private JButton addPersonButton;
    private JTextArea personsTextArea;
    private JButton resolveButton;
    private JRadioButton simplifyDebtsRadioButton;
    private JTextArea textArea1;


    public gui() {
        addPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                persons.add(new Person(nameTextField.getText(), Double.parseDouble(expenseTextField.getText()), Double.parseDouble(ratioTextField.getText())));
                personsTextArea.append(persons.get(persons.size() - 1) + "\n");
                nameTextField.setText("");
                expenseTextField.setText("");
                ratioTextField.setText("");
            }
        });
    }
}