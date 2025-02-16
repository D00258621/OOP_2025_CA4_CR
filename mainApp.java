package CA4_CR;

import java.text.DateFormat;
import java.util.*;
import java.util.Date;

public class mainApp {
    public static void main(String[] args) {
        expensesDAO eDAO = new expensesDAO();
        Scanner scanner = new Scanner(System.in);

        // Add Expense and Income
        eDAO.addExpense(new expensesDTO(0, "Burger King", "Food", 13.54, new Date()));
        incomeDAO.addIncome(new incomesDTO(0, "Babysitting", 49.60, new Date()));

        while (true) {
            System.out.println("\nFinance Tracker v1.122.3\n");
            System.out.println("1. List all expenses & total spend");
            System.out.println("2. Add a new expense");
            System.out.println("3. Delete an expense");
            System.out.println("4. List all income & total income");
            System.out.println("5. Add a new income");
            System.out.println("6. Delete an income");
            System.out.println("7. Show income & expenses for a month");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Gets and Outputs Expenses
                    List<expensesDTO> expenses = expensesDAO.getAllExpenses();
                    double totalSpent = 0;

                    System.out.println("\n--- Expenses ---");
                    for (expensesDTO expense : expenses) {
                        System.out.println(expense);
                        totalSpent += expense.getAmount();
                    }
                    System.out.println("Total Spent: €" + totalSpent);
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String dateOne = scanner.nextLine();

                    expensesDTO expense = new expensesDTO(0, title, category, amount, dateOne);
                    eDAO.addExpense(expense);
                    System.out.println("Expenses added successfully!");
                    break;
                case 3:
                    System.out.print("Enter expense ID to delete: ");
                    int id = scanner.nextInt();
                    expensesDAO.deleteExpense(id);
                    System.out.println("Expense deleted successfully!");
                    break;
                case 4:
                    List<incomesDTO> incomeList = incomeDAO.getAllIncome();
                    double totalIncome = 0;

                    System.out.println("\n--- Income ---");
                    for (incomesDTO income : incomeList) {
                        System.out.println(income);
                        totalIncome += income.getAmount();
                    }
                    System.out.println("Total Income: €" + totalIncome);
                    break;
                case 5:
                    System.out.println("Enter Title");
                    String title2 = scanner.nextLine();
                    System.out.println("Enter Amount");
                    double amount2 = scanner.nextDouble();
                    scanner.nextLine(); // Stops empty intakes
                    System.out.println("Enter Date (YYYY-MM-DD)");
                    String dateTwo = scanner.nextLine();

                    incomesDTO income = new incomesDTO(0,title2, amount2, dateTwo);
                    incomeDAO.addIncome(income);
                    System.out.println("Added income successfully!");
                    break;
                case 6:
                    System.out.print("Enter income ID to delete: ");
                    int id2 = scanner.nextInt();
                    incomeDAO.deleteIncome(id2);
                    System.out.println("Income deleted successfully!");
                    break;
                case 7:
                    System.out.println("Enter Month and Year (YYYY-MM)");
                    String YYYYMM = scanner.nextLine();
                    break;
                case 8:
                    System.out.println("Exiting program. Bye-Bye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
