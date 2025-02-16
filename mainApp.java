package CA4_CR;

import java.util.Date;

public class mainApp {
    public static void main(String[] args) {
        expensesDAO eDAO = new expensesDAO();
        incomeDAO iDAO = new incomeDAO();

        // Add Expense and Income
        eDAO.addExpense(new expensesDTO(0, "Burger King", "Food", 13.54, new Date()));
        iDAO.addIncome(new incomesDTO(0, "Babysitting", 49.60, new Date()));

        // Gets and Outputs Expenses and Incomes
        System.out.println("Expenses");
        for (expensesDTO expense : eDAO.getAllExpenses()) {
            System.out.println(expense.getTitle() + " - " + expense.getAmount());
        }
        System.out.println("Incomes: ");
        for (incomesDTO income : iDAO.getAllIncome()) {
            System.out.println(income.getTitle() + " - " + income.getAmount());
        }
    }
}
