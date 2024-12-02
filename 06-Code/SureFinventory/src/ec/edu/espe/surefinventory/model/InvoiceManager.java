

package ec.edu.espe.surefinventory.model;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceManager {
    private List<Invoice> invoices;

    public InvoiceManager() {
        this.invoices = new ArrayList<>();
    }

    /**
     * Adds a new invoice to the list.
     *
     * @param invoice The invoice to add.
     */
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    /**
     * Saves all invoices to a JSON file.
     *
     * @param filePath The file path to save the invoices.
     */
    public void saveInvoicesToFile(String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(invoices, writer);
            System.out.println("Invoices saved to " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving invoices: " + e.getMessage());
        }
    }

    /**
     * Prints all invoices.
     */
    public void printAllInvoices() {
        for (Invoice invoice : invoices) {
            invoice.printInvoice();
        }
    }
}
