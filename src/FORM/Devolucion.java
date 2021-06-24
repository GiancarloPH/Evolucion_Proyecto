package FORM;

import DATOS.DETALLEVENTA;
import DATOS.VENTAS;
import LOGICO.LVENTAS;
import LOGICO.conexion;
//import com.sun.awt.AWTUtilities;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Devolucion extends javax.swing.JFrame {
    conexion cone = new  conexion();
    
    
    
    SimpleDateFormat dformat = new SimpleDateFormat("dd-MM-yyyy");
    VENTAS v=new VENTAS();
    DETALLEVENTA dv=new DETALLEVENTA();
    LVENTAS  lv=new LVENTAS();
    public Devolucion() {
        this.setUndecorated(true);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../Iconos/cashier_icon-icons.com_53629.png")).getImage());
       
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
    //    AWTUtilities.setWindowShape(this, forma);
        btnMotrarDetalleDeCompra.setVisible(false);
        jScrollPane2.setVisible(false);
        btnRegresarAReportes.setVisible(false);
        txtCodigoVenta.setVisible(false);
        listarRVenta();
      //  calculatTotal();
      //  noeditarcalendario();
    }

    void listarRVenta() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {

            tabla.addColumn("Codigo Venta");
            tabla.addColumn("Empleado");
            tabla.addColumn("Fecha De Venta");
            tabla.addColumn("Cliente");
            tabla.addColumn("NRO COMPROBANTE");
            tabla.addColumn("Importe Total");
            tabla.addColumn("ESTADO");
             cone.consulta("select * from RVD");
            Object dato[] = new Object[7];
            while (cone.getRs().next()) {
                for (int i = 0; i < 7; i++) {
                    dato[i] = cone.getRs().getString(i + 1);
                }
                tabla.addRow(dato);
            }
            this.tblReporteVenta.setModel(tabla);
            // editTabla();
        } catch (Exception e) {
        }
    }

    void buscarRVenta() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            tabla.addColumn("Codigo Venta");
            tabla.addColumn("Empleado");
            tabla.addColumn("Fecha De Venta");
            tabla.addColumn("Cliente");
            tabla.addColumn("Importe Total");
           
          
            this.tblReporteVenta.setModel(tabla);
            //editTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error  fe   " + e);
        }
    }

    void buscarDetalleRVenta() {

        DefaultTableModel tabla = new DefaultTableModel();
        try {
            tabla.addColumn("Codigo Venta");
            tabla.addColumn("Producto");
            tabla.addColumn("Precio");
            tabla.addColumn("Cantidad");
            tabla.addColumn("Importe");
             cone.consulta("select * from RDV where idventa='"+txtCodigoVenta.getText()+"'");
            Object dato[] = new Object[5];
            while (cone.getRs().next()) {
                for (int i = 0; i < 5; i++) {
                    dato[i] = cone.getRs().getString(i + 1);
                }
                tabla.addRow(dato);
            }
            this.tbDetalleReporteVenta.setModel(tabla);
            //editTabla();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "error     " + e);
        }
    }
/*
    void buscarFechaRVenta() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            tabla.addColumn("Codigo Venta");
            tabla.addColumn("Empleado");
            tabla.addColumn("Fecha De Venta");
            tabla.addColumn("Cliente");
            tabla.addColumn("Importe Total");
             cone.consulta("select v.idventa,e.nombre ||' '|| e.apellido NB_EMPLE"
             + ",TO_CHAR(v.fecha,'dd-MM-yyyy') fecha,c.nombre ||' '|| c.apellido NB_CLIENTE"
             + ",v.importtotal\n" +
                "from ventas v\n" +
                "inner join empleados e on e.idempleado= v.idempleado\n" +
                "inner join clientes c on c.idcliente = v.idcliente\n" +
                "where fecha between '"+dformat.format(dtcInicio.getDate())+"' and '"+dformat.format(dtcFinal.getDate())+"'");
                     
            Object dato[] = new Object[5];
            while (cone.getRs().next()) {
                for (int i = 0; i < 5; i++) {
                    dato[i] = cone.getRs().getString(i + 1);
                }
                tabla.addRow(dato);
            }
          
            this.tblReporteVenta.setModel(tabla);
            //editTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error  fe   " + e);
        }
    }
*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panels = new javax.swing.JPanel();
        Regresar = new javax.swing.JToggleButton();
        btnBuscarFechas = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        txtCodigoVenta = new javax.swing.JLabel();
        btnRegresarAReportes = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        btnMotrarDetalleDeCompra = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDetalleReporteVenta = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteVenta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1300, 726));
        setUndecorated(true);
        setOpacity(0.9F);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panels.setBackground(new java.awt.Color(6, 3, 9));
        panels.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelsMouseDragged(evt);
            }
        });
        panels.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelsMousePressed(evt);
            }
        });

        Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back_30px.png"))); // NOI18N
        Regresar.setBorder(null);
        Regresar.setContentAreaFilled(false);
        Regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Regresar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back_35px.png"))); // NOI18N
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        btnBuscarFechas.setBackground(new java.awt.Color(6, 3, 9));
        btnBuscarFechas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnBuscarFechas.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarFechas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_property_30px.png"))); // NOI18N
        btnBuscarFechas.setText("Buscar");
        btnBuscarFechas.setContentAreaFilled(false);
        btnBuscarFechas.setEnabled(false);
        btnBuscarFechas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_property_35px.png"))); // NOI18N
        btnBuscarFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFechasActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("DEVOLUCION");

        javax.swing.GroupLayout panelsLayout = new javax.swing.GroupLayout(panels);
        panels.setLayout(panelsLayout);
        panelsLayout.setHorizontalGroup(
            panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1028, 1028, 1028))
            .addGroup(panelsLayout.createSequentialGroup()
                .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(891, 891, 891)
                .addComponent(btnBuscarFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(710, 710, 710))
        );
        panelsLayout.setVerticalGroup(
            panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsLayout.createSequentialGroup()
                .addGroup(panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelsLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscarFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(16, 16, 16)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, -1));

        jPanel3.setBackground(new java.awt.Color(6, 3, 9));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 160, 10));

        txtCodigoVenta.setForeground(new java.awt.Color(255, 255, 255));
        txtCodigoVenta.setText("jLabel4");
        jPanel3.add(txtCodigoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 272, 100, 30));

        btnRegresarAReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back_30px.png"))); // NOI18N
        btnRegresarAReportes.setBorder(null);
        btnRegresarAReportes.setContentAreaFilled(false);
        btnRegresarAReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresarAReportes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back_35px.png"))); // NOI18N
        btnRegresarAReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarAReportesActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegresarAReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 40, 49));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 540));

        jPanel2.setBackground(new java.awt.Color(6, 3, 9));

        btnMotrarDetalleDeCompra.setBackground(new java.awt.Color(250, 183, 27));
        btnMotrarDetalleDeCompra.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnMotrarDetalleDeCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_20px.png"))); // NOI18N
        btnMotrarDetalleDeCompra.setText("Cancelar Venta");
        btnMotrarDetalleDeCompra.setBorder(null);
        btnMotrarDetalleDeCompra.setBorderPainted(false);
        btnMotrarDetalleDeCompra.setOpaque(true);
        btnMotrarDetalleDeCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMotrarDetalleDeCompraMouseClicked(evt);
            }
        });
        btnMotrarDetalleDeCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotrarDetalleDeCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(655, Short.MAX_VALUE)
                .addComponent(btnMotrarDetalleDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(505, 505, 505))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnMotrarDetalleDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 1300, 110));

        tbDetalleReporteVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbDetalleReporteVenta);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 1140, 540));

        tblReporteVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblReporteVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReporteVentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblReporteVenta);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 1140, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        MenuPrincipal obj = new MenuPrincipal();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_RegresarActionPerformed

    private void btnBuscarFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFechasActionPerformed
     //   buscarFechaRVenta();
    }//GEN-LAST:event_btnBuscarFechasActionPerformed

    private void btnMotrarDetalleDeCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMotrarDetalleDeCompraMouseClicked
       
    }//GEN-LAST:event_btnMotrarDetalleDeCompraMouseClicked

    private void btnRegresarAReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarAReportesActionPerformed
        jScrollPane2.setVisible(false);
        jScrollPane1.setVisible(true);
        btnRegresarAReportes.setVisible(false);
     //   calculatTotal();
    }//GEN-LAST:event_btnRegresarAReportesActionPerformed

    private void tblReporteVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReporteVentaMouseClicked
        btnMotrarDetalleDeCompra.setVisible(true);
        int row = tblReporteVenta.getSelectedRow();
        txtCodigoVenta.setText(tblReporteVenta.getValueAt(row, 0).toString());
    }//GEN-LAST:event_tblReporteVentaMouseClicked
    int x, y;
    private void panelsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_panelsMousePressed

    private void panelsMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsMouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();

        this.setLocation(xx - x, yy - y);
    }//GEN-LAST:event_panelsMouseDragged

    private void btnMotrarDetalleDeCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotrarDetalleDeCompraActionPerformed
        int fila=tblReporteVenta.getSelectedRow();
        if(fila<0){
            JOptionPane.showMessageDialog(null, "Ninguna venta seleccionada.","Error",JOptionPane.ERROR_MESSAGE);
        }else{
                conexion con=new conexion();
                CallableStatement cc;
                try{
                cc=con.getCon().prepareCall("{call actualizar_boleta(?)}");
                cc.setString(1, tblReporteVenta.getValueAt(fila, 0).toString());
                int respuesta = cc.executeUpdate();
                if (respuesta == 1) {
                        JOptionPane.showMessageDialog(null, "Boleta cancelada.","Advertencia",JOptionPane.WARNING_MESSAGE);
                    }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"ERROR INGRESO VENTA"+ e.getMessage());
            }
                
            listarRVenta();    
        }
    }//GEN-LAST:event_btnMotrarDetalleDeCompraActionPerformed

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
            java.util.logging.Logger.getLogger(Devolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Devolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Devolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Devolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Devolucion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Regresar;
    private javax.swing.JToggleButton btnBuscarFechas;
    private javax.swing.JToggleButton btnMotrarDetalleDeCompra;
    private javax.swing.JToggleButton btnRegresarAReportes;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panels;
    private javax.swing.JTable tbDetalleReporteVenta;
    private javax.swing.JTable tblReporteVenta;
    private javax.swing.JLabel txtCodigoVenta;
    private javax.swing.JLabel txtcodigo;
    // End of variables declaration//GEN-END:variables
/*
    void calculatTotal() {
        DecimalFormat df = new DecimalFormat("#.##");
        try {
            if (jScrollPane1.isVisible() == true) {
                double tpagar = 0;
                for (int i = 0; i < tblReporteVenta.getRowCount(); i++) {
                    double te = Double.parseDouble(String.valueOf(tblReporteVenta.getValueAt(i, 5)));
                    tpagar = tpagar + te;
                }
                txtImporteTotal.setText("" + tpagar + "0");
            } else if (jScrollPane2.isVisible() == true) {
                double tpagar = 0;
                for (int i = 0; i < tbDetalleReporteVenta.getRowCount(); i++) {
                    double te = Double.parseDouble(String.valueOf(tbDetalleReporteVenta.getValueAt(i, 4)));
                    tpagar = tpagar + te;
                }
                txtImporteTotal.setText("" + tpagar + "0");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo calcular el total: " + e.getMessage());
        }
    }

    void noeditarcalendario() {
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dtcFinal.getDateEditor();
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) dtcInicio.getDateEditor();
        editor.setEditable(false);
        editor2.setEditable(false);
    }
*/
}
