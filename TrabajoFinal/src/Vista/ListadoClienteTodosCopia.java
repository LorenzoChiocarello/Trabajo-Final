
package Vista;

import Gestor.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListadoClienteTodosCopia extends javax.swing.JInternalFrame {

    Conexion enlace = new Conexion();
    java.sql.Connection conect = enlace.conectar();
    
    public ListadoClienteTodosCopia() {
        initComponents();
        
        mostrarDatosCliente(0, null);
    }
    
    public void mostrarDatosCliente(int opbuscar, String valor)
    {
        DefaultTableModel tCliente = new DefaultTableModel();
        
        tCliente.addColumn("IDENTIFICACION");
        tCliente.addColumn("NOMBRE");
        tCliente.addColumn("CODIGO POSTAL");
        tCliente.addColumn("CUIL/CUIT");
        tCliente.addColumn("DIRECCION");
        tCliente.addColumn("TELEFONO");
        
        lstCliente.setModel(tCliente);
        
        String codsql;
        
        if(opbuscar == 0 && valor == null)
        {
            codsql = "SELECT id, nombre, cp, cuil, direccion, telefono FROM clientes where estado=1";
        }
        else
        {
            if(opbuscar == 1 && valor != null)
            {
                codsql = "SELECT id, nombre, cp, cuil, direccion, telefono FROM clientes WHERE nombre LIKE '%"+valor+"%' and estado=1";
            }
            else
            {
                codsql = "SELECT id, nombre, cp, cuil, direccion, telefono FROM clientes where estado=1";
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
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(4);
                datos[4] = resultado.getString(5);
                datos[5] = resultado.getString(6);
                    
                tCliente.addRow(datos);
            }
            
            lstCliente.setModel(tCliente);
            
            
            
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
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCliente = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Listado Clientes");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

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
                .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 618, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(77, 77, 77))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        lstCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lstCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICACION", "NOMBRE", "CODIGO POSTAL", "CUILT/CUIT", "DIRECCION", "TELEFONO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        lstCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lstClienteKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(lstCliente);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int opcion = cboBuscar.getSelectedIndex();
        String valorbus = txtBuscar.getText();

        mostrarDatosCliente(opcion, valorbus);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void lstClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lstClienteKeyPressed
        if(lstCliente.getSelectedRow()>=0)
        {
            try
            {
                DefaultTableModel tm = (DefaultTableModel)lstCliente.getModel();
                int id = Integer.parseInt(String.valueOf(tm.getValueAt(lstCliente.getSelectedRow(), 0)));
                String nombre = tm.getValueAt(lstCliente.getSelectedRow(),1).toString();
                SaldoClienteTodos.txtCodCliente.setText(String.valueOf(id));
                SaldoClienteTodos.txtCliente.setText(nombre);
                
                dispose();
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, "NO CONTIENE UN CLIENTE");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN CLIENTE");
        }
    }//GEN-LAST:event_lstClienteKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cboBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable lstCliente;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}