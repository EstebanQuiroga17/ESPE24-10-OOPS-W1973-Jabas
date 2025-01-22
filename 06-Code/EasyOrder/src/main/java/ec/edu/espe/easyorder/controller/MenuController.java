

package ec.edu.espe.easyorder.controller;

import ec.edu.espe.easyorder.view.FrmMenu;
import static ec.edu.espe.easyorder.view.FrmMenu.getTableModel;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import utils.MongoDbManager;

/**
 *
 * @author abner
 */
public class MenuController {
    
    public static void AddRowToJTableDelete(Object[] dataRow) {
    DefaultTableModel model = getTableModel();
    model.addRow(dataRow);
    }
    
    public void loadDishesFromDatabase() {
    List<Document> dishes = MongoDbManager.getAll("Menu");

    for (Document dish : dishes) {
        int id = dish.getInteger("id");
        String name = dish.getString("name");
        float price = dish.getDouble("price").floatValue();

        FrmMenu.AddRowToJTable(new Object[]{id, name, price});
    }

}
}
