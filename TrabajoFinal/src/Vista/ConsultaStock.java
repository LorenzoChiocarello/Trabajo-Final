
package Vista;

import Gestor.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ConsultaStock extends javax.swing.JInternalFrame {

    Conexion enlace = new Conexion();
    java.sql.Connection conect = enlace.conectar();
    
    public ConsultaStock() {
        initComponents();
        
        mostrarDatosArticulo(0, null);
    }
    
    public void mostrarDatosArticulo(int opbuscar, String valor)
    {
        DefaultTableModel tArticulo = new DefaultTableModel();
        
        tArticulo.addColumn("IDENTIFICACION");
        tArticulo.addColumn("NOMBRE");
        tArticulo.addColumn("STOCK");
        tArticulo.addColumn("STOCK MINIMO");
        
        lstArticulo.setModel(tArticulo);
        
        String codsql;
        
        if(opbuscar == 0 && valor == null)
        {
            codsql = "SELECT codigo,nombre,stock, stockMinimo FROM articulos";
        }
        else
        {
            if(opbuscar == 1 && valor != null)
            {
                codsql = "SELECT codigo,nombre,stock, stockMinimo FROM articulos WHERE codigo = '" + valor +"'";
            }
            else
            {
                if(opbuscar == 2 && valor != null)
                {
                    codsql = "SELECT codigo,nombre,stock, stockMinimo FROM articulos WHERE nombre LIKE '%"+valor+"%'";
                }
                else
                {
                    codsql = "SELECT codigo,nombre,stock, stockMinimo FROM articulos";
                }
            
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
                    
                tArticulo.addRow(datos);
            }
            
            lstArticulo.setModel(tArticulo);
            
            
            
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
        lstArticulo = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consulta Stock");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por:"));

        cboBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MOSTRAR TODOS", "CODIGO", "NOMBRE" }));

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
                .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 614, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        lstArticulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lstArticulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICACION", "NOMBRE", "STOCK", "STOCK MINIMO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(lstArticulo);
        if (lstArticulo.getColumnModel().getColumnCount() > 0) {
            lstArticulo.getColumnModel().getColumn(0).setResizable(false);
            lstArticulo.getColumnModel().getColumn(1).setResizable(false);
            lstArticulo.getColumnModel().getColumn(2).setResizable(false);
            lstArticulo.getColumnModel().getColumn(3).setResizable(false);
        }

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        if(txtBuscar.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un DATO DE BUSQUEDA");
        }
        else
        {
            int opcion = cboBuscar.getSelectedIndex();
            String valorbus = txtBuscar.getText();

            mostrarDatosArticulo(opcion, valorbus);
            
//            DefaultTableModel tm = (DefaultTableModel)lstArticulo.getModel();
//            int stock = Integer.parseInt(String.valueOf(tm.getValueAt(lstArticulo.getSelectedRow(), 2)));
//            int stockMinimo = Integer.parseInt(String.valueOf(tm.getValueAt(lstArticulo.getSelectedRow(), 3)));
//            
//            if(stock<stockMinimo)
//            {
//                JOptionPane.showMessageDialog(this, "STOCK POR DEBAJO DEL MINIMO");
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(this, "TODO LEGAL PA");
//            }
            
            
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cboBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable lstArticulo;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
