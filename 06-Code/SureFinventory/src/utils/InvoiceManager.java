

package utils;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.surefinventory.model.Invoice;

import java.lang.reflect.Type;
import java.util.List;

public class InvoiceManager {
    private static final String INVOICE_FILE_PATH = "data/invoices.json";

    private static final Type INVOICE_LIST_TYPE = new TypeToken<List<Invoice>>() {}.getType();
    private static final MainDataManager<Invoice> invoiceManager = new MainDataManager<>(INVOICE_FILE_PATH, INVOICE_LIST_TYPE);

    public static MainDataManager<Invoice> getInvoiceManager() {
        return invoiceManager;
    }
}
