import java.util.ArrayList;

public class ExpenseManager {
    private ArrayList<Expense> expenses;

    public ExpenseManager() {
        expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public String getSummary() {
        StringBuilder summary = new StringBuilder();
        double totalAmount = 0;
        for (Expense expense : expenses) {
            summary.append("Category: ").append(expense.getCategory())
                   .append(", Amount: ").append(expense.getAmount())
                   .append(", Description: ").append(expense.getDescription()).append("\n");
            totalAmount += expense.getAmount();
        }
        summary.append("Total Amount: ").append(totalAmount);
        return summary.toString();
    }
}
