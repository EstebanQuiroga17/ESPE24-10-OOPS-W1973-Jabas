
package ec.edu.espe.easyorder.view;

import ec.edu.espe.easyorder.controller.InvoiceController;
import ec.edu.espe.easyorder.model.Invoice;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;
import utils.MongoDbManager;

/**
 *
 * @author Benjamin Robalino <jabasteam>
 */
public class FrmInvoice extends javax.swing.JFrame {

    private InvoiceController invoiceController;

    public FrmInvoice() {
        invoiceController = new InvoiceController();
        initComponents();
        populateCustomersComboBox();
        populateOrderIdComboBox();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void populateCustomersComboBox() {
        cmbCustomer.removeAllItems();
        List<Document> customers = MongoDbManager.getAll("Customer");

        if (customers.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han encontrado clientes", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (Document customerDoc : customers) {
            int id = customerDoc.getInteger("id");
            String name = customerDoc.getString("name");
            String lastname = customerDoc.getString("lastname");
            cmbCustomer.addItem(id + " - " + name + " " + lastname);
        }

        if (cmbCustomer.getItemCount() > 0) {
            cmbCustomer.setSelectedIndex(0);
        }
    }

    private void populateOrderIdComboBox() {
        cmbOrderId.removeAllItems();
        List<Document> orders = MongoDbManager.getAll("Order");

        if (orders.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han encontrado ordenes.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (Document orderDoc : orders) {
            String orderId = orderDoc.getString("orderId");
            if (orderId != null && !orderId.isEmpty()) {
                cmbOrderId.addItem(orderId);
            }
        }

        if (cmbOrderId.getItemCount() > 0) {
            cmbOrderId.setSelectedIndex(0);
        }

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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbCustomer = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbOrderId = new javax.swing.JComboBox<>();
        btnGenerateInvoice = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInvoice = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        btnSaveInvoice = new javax.swing.JButton();
        btnPrintInvoice = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        jLabel2.setText("Cliente");

        cmbCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomerActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha");

        jLabel5.setText("N° Orden");

        cmbOrderId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbOrderId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrderIdActionPerformed(evt);
            }
        });

        btnGenerateInvoice.setText("Generar Factura");
        btnGenerateInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateInvoiceActionPerformed(evt);
            }
        });

        txtInvoice.setColumns(20);
        txtInvoice.setRows(5);
        jScrollPane1.setViewportView(txtInvoice);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerateInvoice)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(147, 147, 147)
                        .addComponent(jLabel4)))
                .addGap(80, 80, 80))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerateInvoice))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSaveInvoice.setText("Guardar Factura");
        btnSaveInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveInvoiceActionPerformed(evt);
            }
        });

        btnPrintInvoice.setText("Imprimir Factura");
        btnPrintInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintInvoiceActionPerformed(evt);
            }
        });

        btnReturn.setText("Volver");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnSaveInvoice)
                .addGap(54, 54, 54)
                .addComponent(btnPrintInvoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReturn)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveInvoice)
                    .addComponent(btnPrintInvoice)
                    .addComponent(btnReturn))
                .addGap(0, 40, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FACTURAS");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(81, 81, 81)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateInvoiceActionPerformed
        try {
            String selectedCustomer = (String) cmbCustomer.getSelectedItem();
            String selectedOrderId = (String) cmbOrderId.getSelectedItem();

            if (selectedCustomer == null || selectedCustomer.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor seleccione un cliente.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (selectedOrderId == null || selectedOrderId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor seleccione una orden.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Invoice invoice = invoiceController.generateInvoice(selectedCustomer, selectedOrderId);
            if (invoice != null) {
                txtInvoice.setText(invoiceController.generateInvoiceText(invoice));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al generar factura: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGenerateInvoiceActionPerformed

    private void cmbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCustomerActionPerformed

    private void cmbOrderIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrderIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOrderIdActionPerformed

    private void btnSaveInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveInvoiceActionPerformed
        if (txtInvoice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay factura para guardar .", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Invoice invoice = invoiceController.generateInvoice(
                (String) cmbCustomer.getSelectedItem(),
                (String) cmbOrderId.getSelectedItem()
        );

        if (invoice != null) {
            invoiceController.saveInvoice(invoice);
        }

    }//GEN-LAST:event_btnSaveInvoiceActionPerformed

    private void btnPrintInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintInvoiceActionPerformed
        try {
            String invoiceText = txtInvoice.getText();
            if (invoiceText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna factura para imprimir.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            PrinterJob printerJob = PrinterJob.getPrinterJob();
            printerJob.setPrintable(new Printable() {
                @Override
                public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                    if (pageIndex > 0) {
                        return NO_SUCH_PAGE;
                    }

                    Graphics2D g2d = (Graphics2D) graphics;
                    g2d.setFont(new Font("Monospaced", Font.PLAIN, 10));
                    g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                    String[] lines = invoiceText.split("\n");
                    int y = 20;
                    for (String line : lines) {
                        g2d.drawString(line, 10, y);
                        y += 15;
                    }

                    return PAGE_EXISTS;
                }
            });

            if (printerJob.printDialog()) {
                printerJob.print();
                JOptionPane.showMessageDialog(this, "Factura impresa con éxito!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(this, "Error al imprimir factura: " + e.getMessage(), "Print Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPrintInvoiceActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        this.setVisible(false);
        new FrmManager().setVisible(true);
    }//GEN-LAST:event_btnReturnActionPerformed

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
            java.util.logging.Logger.getLogger(FrmInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInvoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerateInvoice;
    private javax.swing.JButton btnPrintInvoice;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSaveInvoice;
    private javax.swing.JComboBox<String> cmbCustomer;
    private javax.swing.JComboBox<String> cmbOrderId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtInvoice;
    // End of variables declaration//GEN-END:variables
}
