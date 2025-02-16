package CA4_CR;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class expensesDAO {
    public void addExpense(expensesDTO expenses) {
        String sql = "INSERT INTO expenses (title, category, amount, dateIncurred) VALUES (?, ?, ?, ?)";

        try (Connection conn = sqlConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, expenses.getTitle());
            ps.setString(2, expenses.getCategory());
            ps.setDouble(3, expenses.getAmount());
            ps.setDate(4, new java.sql.Date(expenses.getDateIncurred().getTime()));

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // List all income
    public static List<expensesDTO> getAllExpenses() {
        List<expensesDTO> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses";

        try (Connection conn = sqlConnection.getConnection();
             Statement ps = conn.createStatement();
             ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                expenses.add(new expensesDTO(
                        rs.getInt("expenseID"),
                        rs.getString("title"),
                        rs.getString("category"),
                        rs.getDouble("amount"),
                        rs.getDate("dateIncurred")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    // Delete an expense by ID
    public static void deleteExpense(int expenseID) {
        String sql = "DELETE FROM expenses WHERE expenseID = ?";

        try (Connection conn = sqlConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, expenseID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

