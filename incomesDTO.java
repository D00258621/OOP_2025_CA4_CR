package CA4_CR;

import java.util.Date;

public class incomesDTO {
    private int incomeID;
    private String title;
    private double amount;
    private Date dateEarned;

    public incomesDTO(int incomeID, String incomeTitle, double amount, String dateEarned) {
        this.incomeID = incomeID;
        this.title = incomeTitle;
        this.amount = amount;
        this.dateEarned = dateEarned;
    }

    // Getters and Setters
    public int getIncomeID() {return incomeID;}
    public void setIncomeID(int incomeID) {this.incomeID = incomeID;}

    public String getTitle() {return title;}
    public void setTitle(String incomeTitle) {this.title = incomeTitle;}

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}

    public Date getDateEarned() {return dateEarned;}
    public void setDateEarned(Date dateEarned) {this.dateEarned = dateEarned;}

    @Override
    public String toString() {
        return "income{" +
                "incomeID=" + incomeID +
                ", title='" + title + '\'' +
                ", amount=" + amount +
                ", dateEarned=" + dateEarned +
                '}';
    }
}
