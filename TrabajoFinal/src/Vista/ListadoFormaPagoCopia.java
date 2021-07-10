
package Vista;

import Gestor.Conexion;
import static Vista.ListadoFormaPago.lstFormaPago;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ListadoFormaPagoCopia extends javax.swing.JInternalFrame {

    
    Conexion enlace = new Conexion();
    java.sql.Connection conect = enlace.conectar();
    
    public ListadoFormaPagoCopia() {
        initComponents();
        
        mostrarDatosFormaPago(0, null);
    }
    
    public void mostrarDatosFormaPago(int opbuscar, String valor)
    {
        DefaultTableModel tPago = new DefaultTableModel();
        
        tPago.addColumn("IDENTIFICACION");
        tPago.addColumn("DESCRIPCION");
        
        lstFormaPago.setModel(tPago);
        
        String codsql;
        
        if(opbuscar == 0 && valor == null)
        {
            codsql = "SELECT * FROM formaspago";
        }
        else
        {
            if(opbuscar == 1 && valor != null)
            {
                codsql = "SELECT * FROM formaspago WHERE forma_pago LIKE '%"+valor+"%'";
            }
            else
            {
                codsql = "SELECT * FROM formaspago";
            }
            
        }
        
        String []datos = new String[10];
        
        try
        {
            Statement leer = conect.createStatement();
            ResultSet resultado = leer.executeQuery(codsql);
                
            while(resultado.next())
            {
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                    
                tPago.addRow(datos);
            }
            
            lstFormaPago.setModel(tPago);
            
            
            
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e +  "Error en la consulta");
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
        cboBuscar = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFormaPago = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Listado Formas Pago");

        cboBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MOSTRAR TODOS", "NOMBRE" }));

        txtBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 525, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(77, 77, 77))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lstFormaPago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lstFormaPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICACION", "DESCRIPCION"
            }
        ));
        lstFormaPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lstFormaPagoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(lstFormaPago);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1206, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int opcion = cboBuscar.getSelectedIndex();
        String valorbus = txtBuscar.getText();

        mostrarDatosFormaPago(opcion, valorbus);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void lstFormaPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lstFormaPagoKeyPressed
        if(lstFormaPago.getSelectedRow()>=0)
        {
            try
            {
                DefaultTableModel tm = (DefaultTableModel)lstFormaPago.getModel();
                int id = Integer.parseInt(String.valueOf(tm.getValueAt(lstFormaPago.getSelectedRow(), 0)));
                String forma_pago = tm.getValueAt(lstFormaPago.getSelectedRow(),1).toString();
                Venta.txtPago.setText(String.valueOf(id));
                Venta.txtMedioPago.setText(forma_pago);
                
                dispose();

                //SaldoProveedor.txtCodProducto.setText(String.valueOf(id));

                //Venta.txtCodProducto.setText(String.valueOf(codigo));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, "NO CONTIENE UNA FORMA DE PAGO");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FORMA DE PAGO");
        }
    }//GEN-LAST:event_lstFormaPagoKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cboBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable lstFormaPago;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
