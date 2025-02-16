package CA4_CR;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class incomeDAO {
    public static void addIncome(incomesDTO income) {
        String sql = "INSERT INTO income (title, amount, dateEarned) VALUES (?, ?, ?)";

        try (Connection conn = sqlConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, income.getTitle());
            ps.setDouble(2, income.getAmount());
            ps.setDate(3, new java.sql.Date(income.getDateEarned().getTime()));

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<incomesDTO> getAllIncome() {
        List<incomesDTO> incomeList = new ArrayList<>();
        String sql = "SELECT * FROM income";

        try (Connection conn = sqlConnection.getConnection();
             Statement ps = conn.createStatement();
             ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                incomeList.add(new incomesDTO(
                        rs.getInt("incomeID"),
                        rs.getString("title"),
                        rs.getDouble("amount"),
                        rs.getDate("dateEarned")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incomeList;
    }

    // Delete income by ID
    public static void deleteIncome(int incomeID) {
        String sql = "DELETE FROM income WHERE incomeID = ?";

        try (Connection conn = sqlConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, incomeID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Total Income
    public double totalIncome() {
        String sql = "SELECT SUM(amount) AS total FROM income";
        double total = 0.0;

        try (Connection conn = sqlConnection.getConnection();
             Statement ps = conn.createStatement();
             ResultSet rs = ps.executeQuery(sql)) {

            if (rs.next()) {
                total = rs.getDouble("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
}
