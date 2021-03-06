
package Vista;

import Gestor.Conexion;
import static Vista.ListadoArticulos.lstArticulo;
import static Vista.Principal.VentanaPrincipal;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class ListadoArticuloCopia extends javax.swing.JInternalFrame {

    Conexion enlace = new Conexion();
    java.sql.Connection conect = enlace.conectar();
    
    public ListadoArticuloCopia() {
        initComponents();
        
        mostrarDatosArticulo(0, null);
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        lstArticulo.getColumnModel().getColumn(2).setCellRenderer(tcr);
        lstArticulo.getColumnModel().getColumn(3).setCellRenderer(tcr);
    }
    
    public void mostrarDatosArticulo(int opbuscar, String valor)
    {
        DefaultTableModel tArticulo = new DefaultTableModel();
        
        tArticulo.addColumn("IDENTIFICACION");
        tArticulo.addColumn("NOMBRE");
        tArticulo.addColumn("PRECIO COMPRA");
        tArticulo.addColumn("PRECIO VENTA");
        tArticulo.addColumn("STOCK");
        tArticulo.addColumn("STOCK MINIMO");
        
        lstArticulo.setModel(tArticulo);
        
        String codsql;
        
        if(opbuscar == 0 && valor == null)
        {
            codsql ="SELECT codigo,nombre, precioCompra, precioVenta, stock, stockMinimo FROM articulos where estado = 1" ;
        }
        else
        {
            if(opbuscar == 1 && valor != null)
            {
                codsql ="SELECT codigo,nombre, precioCompra, precioVenta, stock, stockMinimo FROM articulos WHERE nombre LIKE '%"+valor+"%' and estado = 1" ;
            }
            else
            {
                codsql ="SELECT codigo,nombre, precioCompra, precioVenta, stock, stockMinimo FROM articulos where estado = 1" ;
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
                    
                tArticulo.addRow(datos);
            }
            
            lstArticulo.setModel(tArticulo);
            
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.RIGHT);
            lstArticulo.getColumnModel().getColumn(2).setCellRenderer(tcr);
            lstArticulo.getColumnModel().getColumn(3).setCellRenderer(tcr);
            
            
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
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Listado Articulos");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(77, 77, 77))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        lstArticulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lstArticulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICACION", "NOMBRE", "PRECIO COMPRA", "PRECIO VENTA", "STOCK", "STOCK MINIMO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        lstArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lstArticuloKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(lstArticulo);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregar.setText("AGREGAR");

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnRefrescar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRefrescar.setText("REFRESCAR");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("CANCELAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1228, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefrescar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int opcion = cboBuscar.getSelectedIndex();
        String valorbus = txtBuscar.getText();

        mostrarDatosArticulo(opcion, valorbus);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void lstArticuloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lstArticuloKeyPressed
        if(lstArticulo.getSelectedRow()>=0)
        {
            try
            {
                DefaultTableModel tm = (DefaultTableModel)lstArticulo.getModel();
                int id = Integer.parseInt(String.valueOf(tm.getValueAt(lstArticulo.getSelectedRow(), 0)));
                String nombre = tm.getValueAt(lstArticulo.getSelectedRow(),1).toString();
                double precio = Double.parseDouble(String.valueOf(tm.getValueAt(lstArticulo.getSelectedRow(), 3)));
                int stock = Integer.parseInt(String.valueOf(tm.getValueAt(lstArticulo.getSelectedRow(), 4)));

                //Venta.txtCodProducto.setText(String.valueOf(id));
                //Venta.txtProducto.setText(nombre);
                //Venta.txtPrecio.setText(String.valueOf(precio));
                //Venta.txtStock.setText(String.valueOf(stock));

                Venta.txtCodProducto.setText(String.valueOf(id));
                Venta.txtProducto.setText(nombre);
                Venta.txtPrecio.setText(String.valueOf(precio));
                Venta.txtStock.setText(String.valueOf(stock));

                dispose();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, "NO CONTIENE UN PRODUCTO");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN PRODUCTO");
        }
    }//GEN-LAST:event_lstArticuloKeyPressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(lstArticulo.getSelectedRow()>=0)
        {
            try
            {

                ModificarArticulo lrs= new ModificarArticulo();
                Principal.VentanaPrincipal.add(lrs);
                lrs.toFront();
                lrs.setVisible(true);

                Dimension desktopSize = VentanaPrincipal.getSize();
                Dimension FrameSize = lrs.getSize();
                lrs.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                lrs.show();

                DefaultTableModel tm = (DefaultTableModel)lstArticulo.getModel();
                int id = Integer.parseInt(String.valueOf(tm.getValueAt(lstArticulo.getSelectedRow(), 0)));
                String nombre = tm.getValueAt(lstArticulo.getSelectedRow(),1).toString();
                double precioCompra = Double.parseDouble(String.valueOf(tm.getValueAt(lstArticulo.getSelectedRow(), 2)));
                double precioVenta = Double.parseDouble(String.valueOf(tm.getValueAt(lstArticulo.getSelectedRow(), 3)));
                int stock = Integer.parseInt(String.valueOf(tm.getValueAt(lstArticulo.getSelectedRow(), 4)));
                int stockMinimo = Integer.parseInt(String.valueOf(tm.getValueAt(lstArticulo.getSelectedRow(), 5)));

                ModificarArticulo.txtId.setText(String.valueOf(id));
                ModificarArticulo.txtNombre.setText(nombre);
                ModificarArticulo.txtCompra.setText(String.valueOf(precioCompra));
                ModificarArticulo.txtVenta.setText(String.valueOf(precioVenta));
                ModificarArticulo.txtStock.setText(String.valueOf(stock));
                ModificarArticulo.txtStockMinimo.setText(String.valueOf(stockMinimo));

                //dispose();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, "NO CONTIENE UN PRODUCTO");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN PRODUCTO");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        mostrarDatosArticulo(0, null);
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int r = showConfirmDialog(null, "ESTA SEGURO QUE DESEA ELIMINAR EL REGISTRO?");
        if(r==0)
        {
        eliminarArticulo();
        }
        else
        {
        
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    public void eliminarArticulo()
    {
        int fila = lstArticulo.getSelectedRow();
        
        
        if(fila>=0)
        {
            String valor = lstArticulo.getValueAt(fila, 0).toString();
            try 
            {
                PreparedStatement eliminar = conect.prepareStatement("UPDATE articulos SET estado=2 WHERE codigo='"+valor+"'");
                eliminar.executeUpdate();
                mostrarDatosArticulo(0,null);
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,e + "No se pudo eliminar");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No selecciono ninguno");
        }
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JComboBox<String> cboBuscar;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable lstArticulo;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
