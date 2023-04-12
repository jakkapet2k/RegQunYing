package teest;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class test2 {
    public static void main(String[] args) {
        // Create a JTable with sample data
        String[][] data = {{"John", "Doe", "30"}, {"Jane", "Smith", "25"}, {"Tom", "Brown", "35"}};
        String[] columnNames = {"First Name", "Last Name", "Age"};
        JTable table = new JTable(data, columnNames);

        // Create a JComboBox
        JComboBox<String> comboBox = new JComboBox<>();

        // Add an ActionListener to the JTable
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        // Get the data from the selected row of the JTable
                        String firstName = table.getValueAt(selectedRow, 0).toString();
                        String lastName = table.getValueAt(selectedRow, 1).toString();
                        String age = table.getValueAt(selectedRow, 2).toString();

                        // Update the JComboBox with the selected data
                        comboBox.removeAllItems();
                        comboBox.addItem(firstName);
                        comboBox.addItem(lastName);
                        comboBox.addItem(age);
                    }
                }
            }
        });

        // Create a JFrame to display the JTable and JComboBox
        JFrame frame = new JFrame("JTable to JComboBox Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.add(new JScrollPane(table));
        frame.add(comboBox);
        frame.pack();
        frame.setVisible(true);
    }
}
