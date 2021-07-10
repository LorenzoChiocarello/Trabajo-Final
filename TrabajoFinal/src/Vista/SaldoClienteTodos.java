
package Vista;

import Gestor.Conexion;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.SaldoClienteDAO;
import Modelo.SaldoClientes;
import static Vista.PrincipalTodos.VentanaPrincipal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.sql.Connection;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class SaldoClienteTodos extends javax.swing.JInternalFrame {

    Conexion enlace = new Conexion();
    Connection conect = enlace.conectar();
    
    SaldoClienteDAO scdao = new SaldoClienteDAO();
    ClienteDAO cdao = new ClienteDAO();
    Cliente c = new Cliente();
    SaldoClientes sc = new SaldoClientes();
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    Calendar fecha_actual= new GregorianCalendar();
    
    public SaldoClienteTodos() {
        initComponents();
        
        txtCodCliente.requestFocus();
        txtCodCliente.setBackground(Color.yellow);
        
        jdcFecha.setCalendar(fecha_actual);
        
        txtImporte.setEnabled(false);
        
        btnMostrarSaldo.setEnabled(false);
        btnAceptar.setEnabled(false);
        txtDescripcion.setEnabled(false);
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
        jLabel1 = new javax.swing.JLabel();
        cboTipo = new javax.swing.JComboBox();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        btnMostrarSaldo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboFormaPago = new javax.swing.JComboBox<>();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCliente = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Saldo Cliente");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("TIPO");

        cboTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ANTICIPO", "DEBITO", "CREDITO" }));

        jdcFecha.setEnabled(false);
        jdcFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("FECHA:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("CLIENTE");

        txtCodCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodClienteKeyPressed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtCliente.setEditable(false);
        txtCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnMostrarSaldo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMostrarSaldo.setText("MOSTRAR SALDO");
        btnMostrarSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarSaldoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodCliente)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnMostrarSaldo)
                                .addGap(385, 385, 385))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(txtCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnMostrarSaldo))
                .addGap(10, 10, 10))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("IMPORTE");

        txtImporte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtImporteKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("$");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("DESCRIPCION");

        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("FORMA PAGO");

        cboFormaPago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Debito", "Credito", "Cheque" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(448, 448, 448)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtDescripcion)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lstCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lstCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICACION", "NOMBRE", "SALDO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(lstCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1178, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(444, 444, 444)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodClienteKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
        
            if(txtCodCliente.getText().equals(""))
            {
                txtCodCliente.requestFocus();
                txtCodCliente.setBackground(Color.yellow);
                
                JOptionPane.showMessageDialog(this, "CLIENTE NO REGISTRADO");
            }
            else
            {
                buscarCliente();
                btnMostrarSaldo.setEnabled(true);
            }
            
        
        }
    }//GEN-LAST:event_txtCodClienteKeyPressed

    void buscarCliente()
    {
        int id = Integer.parseInt(txtCodCliente.getText());
        Cliente c = cdao.listarID(id);
        txtCliente.setText(c.getNombre());
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        //        if(txtCodCliente.getText().equals(""))
        //        {
            //            txtCodCliente.requestFocus();
            //            txtCodCliente.setBackground(Color.yellow);
            //
            //            JOptionPane.showMessageDialog(this, "Debe ingresar codigo del cliente");
            //        }
        //        else
        //        {
            //            buscarCliente();
            //
            //            mostrarDatosCliente(0, null);
            //
            //            //txtImporte.requestFocus();
            //            //txtImporte.setBackground(Color.YELLOW);
            //            //txtCodCliente.setBackground(Color.WHITE);
            //        }

        ListadoClienteTodosCopia lp = new ListadoClienteTodosCopia();
        PrincipalTodos.VentanaPrincipal.add(lp);
        lp.toFront();
        lp.setVisible(true);
        
        Dimension desktopSize = VentanaPrincipal.getSize();
        Dimension FrameSize = lp.getSize();
        lp.setLocation((desktopSize.width - FrameSize.width)/3, (desktopSize.height- FrameSize.height)/3);
        lp.show();

        //buscarCliente();

        btnMostrarSaldo.setEnabled(true);

    }//GEN-LAST:event_btnBuscarActionPerformed

    
    
    private void btnMostrarSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarSaldoActionPerformed
        if(txtCliente.getText().equals(""))
        {
            txtCodCliente.requestFocus();
            txtCodCliente.setBackground(Color.yellow);
            
            JOptionPane.showMessageDialog(this, "Debe ingresar un CLIENTE VALIDO");
        }
        else
        {
            mostrarDatosCliente(0, null);

            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.RIGHT);
            lstCliente.getColumnModel().getColumn(2).setCellRenderer(tcr);

            txtImporte.setEnabled(true);
            btnAceptar.setEnabled(true);
            txtImporte.requestFocus();
            txtImporte.setBackground(Color.yellow);
            txtCodCliente.setBackground(Color.white);
            txtDescripcion.setEnabled(true);
        }
        
    }//GEN-LAST:event_btnMostrarSaldoActionPerformed

    private void txtImporteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            txtDescripcion.requestFocus();
            txtDescripcion.setBackground(Color.YELLOW);
            txtImporte.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtImporteKeyPressed

    void agregarSaldo()
    {
        
        int opcion = cboTipo.getSelectedIndex();
        
        
            if(opcion == 0)
            {
                int idc= Integer.parseInt(txtCodCliente.getText());
                double monto = Double.parseDouble(txtImporte.getText());
                String descripcion = txtDescripcion.getText();
                String forma_pago = cboFormaPago.getSelectedItem().toString();
                Date date = jdcFecha.getDate();
                
                long d = date.getTime();
                java.sql.Date fecha = new java.sql.Date(d);
            
                sc.setIdCliente(idc);
                sc.setMonto(monto);
                sc.setDescripcion(descripcion);
                sc.setForma_pago(forma_pago);
                sc.setFecha(fecha);
            
                scdao.GuardarSaldoAnticipo(sc);
            }
            else
            {
                if(opcion == 1)
                {
                    int idc= Integer.parseInt(txtCodCliente.getText());
                    double resto = Double.parseDouble(txtImporte.getText());
                    String descripcion = txtDescripcion.getText();
                    String forma_pago = cboFormaPago.getSelectedItem().toString();
                    Date date = jdcFecha.getDate();
                
                    long d = date.getTime();
                    java.sql.Date fecha = new java.sql.Date(d);
            
                    sc.setIdCliente(idc);
                    sc.setResto(resto);
                    sc.setDescripcion(descripcion);
                    sc.setForma_pago(forma_pago);
                    sc.setFecha(fecha);
            
                    scdao.GuardarSaldoDeuda(sc);
                }
            else
            {
                int idp= Integer.parseInt(txtCodCliente.getText());
                double monto = Double.parseDouble(txtImporte.getText());
                String descripcion = txtDescripcion.getText();
                String forma_pago = cboFormaPago.getSelectedItem().toString();
                Date date = jdcFecha.getDate();
                
                long d = date.getTime();
                java.sql.Date fecha = new java.sql.Date(d);
            
                sc.setIdCliente(idp);
                sc.setMonto(monto);
                sc.setDescripcion(descripcion);
                sc.setForma_pago(forma_pago);
                sc.setFecha(fecha);
            
                scdao.GuardarSaldoAnticipo(sc);
            }
        }
    }
    
    public void mostrarDatosCliente(int opbuscar, String valor)
    {
        DefaultTableModel tCliente = new DefaultTableModel();
        
        tCliente.addColumn("IDENTIFICACION");
        tCliente.addColumn("NOMBRE");
        tCliente.addColumn("SALDO");
        
        lstCliente.setModel(tCliente);
        
        String codsql = null;
        
        int id = Integer.parseInt(txtCodCliente.getText());
        if(txtCodCliente.getText() != null)
        {
            codsql = "select c.id, nombre, sum(monto)-sum(resto) as saldo from clientes c, saldos_cliente s where c.id=s.id_cliente  and c.id = '" + id +"' group by c.id, nombre";
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

                    
                tCliente.addRow(datos);
            }
            
            lstCliente.setModel(tCliente);
            
            
            
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e +  "Error en la consulta");
        }
    }
    
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        //        if(txtCodCliente.getText().equals("") )
        //        {
            //            txtCodCliente.requestFocus();
            //            txtCodCliente.setBackground(Color.yellow);
            //
            //            JOptionPane.showMessageDialog(this, "Debe ingresar codigo del cliente");
            //        }
        //        else
        //        {
            //            if((txtImporte.getText().equals("")))
            //            {
                //                JOptionPane.showMessageDialog(this, "Debe ingresar el importe");
                //
                //                txtImporte.requestFocus();
                //                txtImporte.setBackground(Color.yellow);
                //            }
            //            else
            //            {
                //                if(txtDescripcion.getText().equals(""))
                //                {
                    //                    JOptionPane.showMessageDialog(this, "Debe ingresar una descripcion");
                    //
                    //                    txtDescripcion.requestFocus();
                    //                    txtDescripcion.setBackground(Color.yellow);
                    //                }
                //                else
                //                {
                    //                    if(!validarNumeros(txtImporte.getText().trim()))
                    //                    {
                        //                        txtImporte.requestFocus();
                        //                        txtImporte.setBackground(Color.yellow);
                        //
                        //                        JOptionPane.showMessageDialog(this, "Debe ingresar un IMPORTE VALIDO");
                        //                    }
                    //                    else
                    //                    {
                        //                        agregarSaldo();
                        //
                        //                        limpiarCampos();
                        //                        limpiarTabla();
                        //
                        //
                        //
                        //                        txtCodCliente.requestFocus();
                        //                        txtCodCliente.setBackground(Color.yellow);
                        //                        txtImporte.setBackground(Color.white);
                        //                        txtDescripcion.setBackground(Color.white);
                        //                    }
                    //                }
                //
                //            }
            //        }

        if(txtCliente.getText().equals(""))
        {
            txtCliente.requestFocus();
            txtCliente.setBackground(Color.yellow);

            JOptionPane.showMessageDialog(this, "Debe ingresar un PROVEEDOR VALIDO");
        }
        else
        {
            if(txtImporte.getText().equals(""))
            {
                txtImporte.requestFocus();
                txtImporte.setBackground(Color.yellow);

                JOptionPane.showMessageDialog(this, "Debe ingresar un IMPORTE");
            }
            else
            {
                if(!validarNumeros(txtImporte.getText().trim()))
                {
                    txtImporte.requestFocus();
                    txtImporte.setBackground(Color.yellow);

                    JOptionPane.showMessageDialog(this, "Debe ingresar un IMPORTE VALIDO");
                }
                else
                {
                    
                    int r = showConfirmDialog(null, "ESTA SEGURO QUE DESEA CARGAR EL SALDO?");
                    if(r==0)
                    {
                        agregarSaldo();

                        limpiarCampos();
                        limpiarTabla();

                        JOptionPane.showMessageDialog(this, "EL SALDO SE REALIZO CON EXITO");

                        txtCodCliente.requestFocus();
                        txtCodCliente.setBackground(Color.yellow);
                        txtCliente.setBackground(Color.white);
                        txtImporte.setBackground(Color.white);
                        txtDescripcion.setBackground(Color.white);
                        cboFormaPago.setBackground(Color.white);

                        txtImporte.setEnabled(false);

                        btnMostrarSaldo.setEnabled(false);
                        btnAceptar.setEnabled(false);
                        txtDescripcion.setEnabled(false);
                    }
                    else{}
                    
                }
            }
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            cboFormaPago.requestFocus();
            cboFormaPago.setBackground(Color.YELLOW);
            txtDescripcion.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtDescripcionKeyPressed

    void limpiarCampos()
    {
        limpiarTabla();
        txtCodCliente.setText("");
        txtCliente.setText("");
        txtImporte.setText("");
        txtDescripcion.setText("");
    }
    
    void limpiarTabla()
    {
        DefaultTableModel tb = (DefaultTableModel) lstCliente.getModel();
        int a = lstCliente.getRowCount()-1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount()-1);
            i=i-1;
        }
    }
    
    public static boolean validarNumeros(String datos)
    {
        return datos.matches("[0-9]*");
        //return datos.marches("[0-9]{1, 3}"); PARA LA CANTIDAD DE DIGITOS POSIBLES
        //return datos.marches("[a-zA-Z]*");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnMostrarSaldo;
    private javax.swing.JComboBox<String> cboFormaPago;
    private javax.swing.JComboBox cboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTable lstCliente;
    public static javax.swing.JTextField txtCliente;
    public static javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtImporte;
    // End of variables declaration//GEN-END:variables
}
