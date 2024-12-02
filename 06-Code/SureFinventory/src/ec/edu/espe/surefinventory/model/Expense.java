
package ec.edu.espe.surefinventory.model;

import java.time.LocalDate;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
class Expense {
    private double amount;
    private String description;
    private LocalDate date;

   public Expense(double amount, String description, LocalDate date) {
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
               "amount=" + amount +
               ", description='" + description + '\'' +
               ", date=" + date +
               '}';
    }
}