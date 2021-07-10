
package Vista;

import Gestor.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Reportes extends javax.swing.JInternalFrame {

    Conexion enlace = new Conexion();
    Connection conect = enlace.conectar();
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Reportes() {
        initComponents();
    }
    
    public void mostrarDatosVenta(String fecha1, String fecha2)
    {
        DefaultTableModel tReporte = new DefaultTableModel();
        
        tReporte.addColumn("NRO VENTA");
        tReporte.addColumn("ARTICULO");
        tReporte.addColumn("CLIENTE");
        tReporte.addColumn("CANTIDAD");
        tReporte.addColumn("MONTO");
        tReporte.addColumn("COMPROBANTE");
        tReporte.addColumn("FECHA");
        
        lstReporte.setModel(tReporte);
        
        String codsql;
        
        codsql= "select detalles_venta.id_venta,  a.nombre, c.nombre, detalles_venta.cantidad, ventas.monto, ventas.comprobante, ventas.fecha from clientes c inner join ventas on c.id=ventas.id_cliente inner join detalles_venta on ventas.id=detalles_venta.id_venta inner join articulos a on detalles_venta.id_articulo=a.codigo where fecha between '"+fecha1+"' and '"+fecha2+"'";
        
        String []datos = new String[20];
        
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
                datos[6] = resultado.getString(7);
                    
                tReporte.addRow(datos);
            }
            
            lstReporte.setModel(tReporte);
            
            
            
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jdcDesde = new com.toedter.calendar.JDateChooser();
        jdcHasta = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstReporte = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Reportes");

        jLabel1.setText("DESDE:");

        jLabel2.setText("HASTA:");

        lstReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NRO VENTA", "ARTICULO", "CLIENTE", "CANTIDAD", "MONTO", "COMPROBANTE", "FECHA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(lstReporte);
        if (lstReporte.getColumnModel().getColumnCount() > 0) {
            lstReporte.getColumnModel().getColumn(0).setResizable(false);
            lstReporte.getColumnModel().getColumn(1).setResizable(false);
            lstReporte.getColumnModel().getColumn(2).setResizable(false);
            lstReporte.getColumnModel().getColumn(3).setResizable(false);
            lstReporte.getColumnModel().getColumn(4).setResizable(false);
            lstReporte.getColumnModel().getColumn(5).setResizable(false);
            lstReporte.getColumnModel().getColumn(6).setResizable(false);
        }

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jdcHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jdcDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(193, 193, 193)
                .addComponent(btnBuscar)
                .addContainerGap(294, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdcDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jdcHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        java.util.Date desde = new java.util.Date();
        SimpleDateFormat sdf_desde = new SimpleDateFormat("yyyy-MM-dd");
        desde = Reportes.jdcDesde.getDate();
        String fecha1 = sdf_desde.format(desde);
        
        java.util.Date hasta = new java.util.Date();
        SimpleDateFormat sdf_hasta = new SimpleDateFormat("yyyy-MM-dd");
        hasta = Reportes.jdcHasta.getDate();
        String fecha2 = sdf_hasta.format(hasta);
        
        mostrarDatosVenta(fecha1, fecha2);

        //Date valor1 = jdcDesde.getDate();
        //Date valor2=jdcHasta.getDate();
        //Date date = jdcFecha.getDate();
                
        //long d1 = valor1.getTime();
        //long d2 = valor2.getTime();
        //java.sql.Date fecha1 = new java.sql.Date(d1);
        //java.sql.Date fecha2 = new java.sql.Date(d2);
        
//        java.util.Date desde = new java.util.Date();
//        SimpleDateFormat sdf_desde = new SimpleDateFormat("yyyy-MM-dd");
//        desde = frmComprasDetalladas.dateDesde.getDate();
//        String p_fecha_Desde = sdf_desde.format(desde);
//
//        java.util.Date hasta = new java.util.Date();
//        SimpleDateFormat sdf_hasta = new SimpleDateFormat("yyyy-MM-dd");
//        hasta = frmComprasDetalladas.dateHasta.getDate();
//        String p_fecha_Hasta = sdf_hasta.format(hasta);
//
//        func.mostrarCompras(p_fecha_Desde, p_fecha_Hasta);
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static com.toedter.calendar.JDateChooser jdcDesde;
    public static com.toedter.calendar.JDateChooser jdcHasta;
    public static javax.swing.JTable lstReporte;
    // End of variables declaration//GEN-END:variables
}
