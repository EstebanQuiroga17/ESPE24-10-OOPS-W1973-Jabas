package ec.edu.espe.easyorder.view;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
import ec.edu.espe.easyorder.controller.OrderController;
import ec.edu.espe.easyorder.model.Dish;
import ec.edu.espe.easyorder.model.Order;
import ec.edu.espe.easyorder.model.Menu;
import java.util.ArrayList;
import utils.MongoDbManager;
import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FrmOrder extends javax.swing.JFrame {

    /**
     * Creates new form FrmOrder
     */
    public FrmOrder() {
        initComponents();
<<<<<<< HEAD
        populateDishesComboBox();
        updateDate();
        updateOrderId();
        
=======

        populateDishesComboBox();
        updateDate();
        updateOrderId();
>>>>>>> e085a6c3e6e123ae3d94482313c1c93be5724e9d
         populateDishesComboBox();
          updateDate();
        updateOrderId();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void addDishToTable() {
        // Retrieve selected dish from the combo box
        String selectedDish = (String) cmbDishes.getSelectedItem();

        // Retrieve the quantity from the text field
        String quantityText = txtQuantity.getText();

        // Check if quantity is valid
        if (selectedDish == null || selectedDish.isEmpty() || quantityText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a dish and enter a quantity.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convert quantity to an integer, and handle potential parsing errors
        int quantity = 0;
        try {
            quantity = Integer.parseInt(quantityText);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Quantity must be a positive number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid quantity entered. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add the dish and quantity to the table
        DefaultTableModel model = (DefaultTableModel) jtOrders.getModel();
        model.addRow(new Object[]{selectedDish, quantity});

        // Optionally, clear the quantity field after adding the item
        txtQuantity.setText("");
    }

    private void updateOrderId() {
        String uniqueOrderId = new OrderController().generateOrderId();
        lblOrderId.setText(" " + uniqueOrderId);
    }

    private void updateDate() {
        String currentDate = new OrderController().getCurrentDate();
        lblDate.setText(" " + currentDate);
    }

    private void populateDishesComboBox() {
        try {
            // Fetch menu items from the database
            List<Document> menuItems = MongoDbManager.getAll("Menu");

            // Debug log
            System.out.println("Menu Items Retrieved: " + menuItems.size());

            // Clear the combo box to prevent duplicate entries
            cmbDishes.removeAllItems();

            // If no items are fetched, show an error message
            if (menuItems.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No dishes found in the menu.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Add each dish to the combo box
            for (Document dish : menuItems) {
                String dishName = dish.getString("name");
                System.out.println("Adding dish: " + dishName);  // Debug log for each dish
                cmbDishes.addItem(dishName);
            }

            // Select the first dish by default
            cmbDishes.setSelectedIndex(0); // Select the first item to prevent null selection

            // Enable the quantity field after populating the combo box
            txtQuantity.setEnabled(true);

        } catch (Exception e) {
            // Show any exceptions that occur during loading
            JOptionPane.showMessageDialog(this, "Error loading menu: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        // Clear the table
        DefaultTableModel model = (DefaultTableModel) jtOrders.getModel();
        model.setRowCount(1);  // Remove all rows from the table

        // Clear the quantity field
        txtQuantity.setText("");

        // Re-enable the combo box and quantity field
        if (cmbDishes.getItemCount() > 0) {
            cmbDishes.setSelectedIndex(0);  // Set combo box to default value (first item)
        }
        txtQuantity.setEnabled(true);   // Enable quantity field
        // Update the order ID and date again (for the next order)
        updateOrderId();
        updateDate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbDishes = new javax.swing.JComboBox<>();
        btnAddDish = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtOrders = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        btnDeleteDish = new javax.swing.JButton();
        btnSaveOrder = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblOrderId = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSeeOrders = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LISTA DE PEDIDOS");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(16, 16, 16))
        );

        jLabel1.setText("Elegir Platillo:");

        cmbDishes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAddDish.setText("Añadir");
        btnAddDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDishActionPerformed(evt);
            }
        });

        jtOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Dish", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtOrders);
        DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Dish", "Quantity"
            }
        ) {
            // Define the types of the columns
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };

            // Specify if cells are editable (set to false here, to prevent editing)
            boolean[] canEdit = new boolean [] {
                false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };

        // Set the table model to the JTable
        jtOrders.setModel(model);

        // Add the JScrollPane
        jScrollPane1.setViewportView(jtOrders);

        jLabel3.setText("Cantidad");

        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        btnDeleteDish.setText("Borrar Plato");

        btnSaveOrder.setText("Guardar Orden");
        btnSaveOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveOrderActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha");

        jLabel5.setText("N° Orden");

        lblDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblOrderId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbDishes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddDish)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteDish)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveOrder)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(lblOrderId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDishes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteDish)
                    .addComponent(btnAddDish))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(lblOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(btnSaveOrder))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        btnSeeOrders.setText("Visualizar Ordenes");
        btnSeeOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeOrdersActionPerformed(evt);
            }
        });

        btnReturn.setText("Volver");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(btnSeeOrders)
                .addGap(69, 69, 69)
                .addComponent(btnReturn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeeOrders)
                    .addComponent(btnReturn))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(318, 318, 318)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveOrderActionPerformed
        try {
            String orderId = lblOrderId.getText().trim(); // Get order ID
            String orderDate = lblDate.getText().trim(); // Get order date

            DefaultTableModel model = (DefaultTableModel) jtOrders.getModel();
            List<Document> dishesList = new ArrayList<>();

            for (int i = 0; i < model.getRowCount(); i++) {
                String dishName = (String) model.getValueAt(i, 0); // Get dish from table
                Object quantityObj = model.getValueAt(i, 1); // Get quantity from table


                if (dishName == null || quantityObj == null) {
                    JOptionPane.showMessageDialog(this, "Dish or Quantity is missing!", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int quantity = Integer.parseInt(quantityObj.toString());
                Document dish = new Document("name", dishName).append("quantity", quantity);
                dishesList.add(dish); // Add to dishes list
            }

            Document orderDocument = new Document("orderId", orderId)
                    .append("date", orderDate)
                    .append("dishes", dishesList);

            MongoDbManager.insertDocument("Order", orderDocument);
            JOptionPane.showMessageDialog(this, "Order saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            clearForm();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving order: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSaveOrderActionPerformed

    private void btnSeeOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeOrdersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeeOrdersActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        System.exit(0);// TODO add your handling code here:
    }//GEN-LAST:event_btnReturnActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        String quantityText = txtQuantity.getText();
        try {
            int quantity = Integer.parseInt(quantityText);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Quantity must be greater than 0.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                txtQuantity.setText(""); // Clear invalid input
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a numeric value for quantity.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            txtQuantity.setText(""); // Clear invalid input
        }
    }//GEN-LAST:event_txtQuantityActionPerformed


    private void btnAddDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDishActionPerformed
        String selectedDish = (String) cmbDishes.getSelectedItem();  // ComboBox value
        String quantityText = txtQuantity.getText();  // Quantity from text field
        if (selectedDish == null || selectedDish.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a valid dish.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (quantityText == null || quantityText.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int quantity = Integer.parseInt(quantityText);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Quantity must be greater than 0.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            DefaultTableModel model = (DefaultTableModel) jtOrders.getModel();
            model.addRow(new Object[]{selectedDish, quantity});
            txtQuantity.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for quantity.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnAddDishActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmOrder().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDish;
    private javax.swing.JButton btnDeleteDish;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSaveOrder;
    private javax.swing.JButton btnSeeOrders;
    private javax.swing.JComboBox<String> cmbDishes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtOrders;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblOrderId;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables

}
