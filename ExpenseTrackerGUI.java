import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpenseTrackerGUI {
    private JFrame frame;
    private ExpenseManager expenseManager;

    public ExpenseTrackerGUI() {
        expenseManager = new ExpenseManager();
    }

    public void createAndShowGUI() {
        frame = new JFrame("Personal Expense Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();
        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField();
        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField();
        JButton addButton = new JButton("Add Expense");
        JButton summaryButton = new JButton("View Summary");
        JTextArea summaryArea = new JTextArea();

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String category = categoryField.getText();
                double amount = Double.parseDouble(amountField.getText());
                String description = descriptionField.getText();
                expenseManager.addExpense(new Expense(category, amount, description));
                categoryField.setText("");
                amountField.setText("");
                descriptionField.setText("");
            }
        });

        summaryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                summaryArea.setText(expenseManager.getSummary());
            }
        });

        frame.add(categoryLabel);
        frame.add(categoryField);
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(descriptionLabel);
        frame.add(descriptionField);
        frame.add(addButton);
        frame.add(summaryButton);
        frame.add(new JScrollPane(summaryArea));

        frame.setVisible(true);
    }
}
