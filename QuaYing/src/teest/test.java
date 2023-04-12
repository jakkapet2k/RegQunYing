package teest;

import javax.swing.*;
import javax.swing.table.*;

public class test {
    public static void main(String[] args) {
        // Create a JTable with sample data
        String[][] data = {{"John", "Doe", "30"}, {"Jane", "Smith", "25"}, {"Tom", "Brown", "35"}};
        String[] columnNames = {"First Name", "Last Name", "Age"};
        JTable table = new JTable(data, columnNames);

        // Get the column model of the JTable
        TableColumnModel columnModel = table.getColumnModel();

        // Get the column index that you want to hide
        int columnIndexToHide = 1;

        // Get the TableColumn object for the column to be hidden
        TableColumn columnToHide = columnModel.getColumn(columnIndexToHide);

        // Set the width of the column to zero to hide it
        columnToHide.setMinWidth(0);
        columnToHide.setMaxWidth(0);
        columnToHide.setPreferredWidth(0);

        // Refresh the table to apply the changes
        table.getTableHeader().repaint();
        table.repaint();
        
        // Create a JFrame to display the JTable
        JFrame frame = new JFrame("JTable Hide Column Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }
}
