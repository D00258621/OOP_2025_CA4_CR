package CA4_CR;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class incomeDAO {
    public void addIncome(incomesDTO income) {
        String sql = "INSERT INTO income (title, amount, dateEarned) VALUES (?, ?, ?)";

        try (Connection conn = sqlConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, income.getTitle());
            stmt.setDouble(2, income.getAmount());
            stmt.setDate(3, new java.sql.Date(income.getDateEarned().getTime()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<incomesDTO> getAllIncome() {
        List<incomesDTO> incomeList = new ArrayList<>();
        String sql = "SELECT * FROM income";

        try (Connection conn = sqlConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

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
}
