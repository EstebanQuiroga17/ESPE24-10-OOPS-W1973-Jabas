package ec.edu.espe.surefinventory.utils;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.surefinventory.model.Invoice;

import java.lang.reflect.Type;
import java.util.List;

public class InvoiceManager {
    private static final String invoiceFilePath = "data/invoices.json";
    private static final Type invoiceListType = new TypeToken<List<Invoice>>() {}.getType();
    private static final MainDataManager<Invoice> invoiceManager = new MainDataManager<>(invoiceFilePath, invoiceListType);

    public static MainDataManager<Invoice> getInvoiceManager() {
        return invoiceManager;
    }
}
