package CA4_CR;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class expensesDAO {
    public void addExpense(expensesDTO expenses) {
        String sql = "INSERT INTO expenses (title, category, amount, dateIncurred) VALUES (?, ?, ?, ?)";

        try (Connection conn = sqlConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, expenses.getTitle());
            stmt.setString(2, expenses.getCategory());
            stmt.setDouble(3, expenses.getAmount());
            stmt.setDate(4, new java.sql.Date(expenses.getDateIncurred().getTime()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<expensesDTO> getAllExpenses() {
        List<expensesDTO> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses";

        try (Connection conn = sqlConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

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
}

