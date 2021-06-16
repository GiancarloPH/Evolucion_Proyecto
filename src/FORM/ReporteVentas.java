package FORM;

import DATOS.DETALLEVENTA;
import DATOS.VENTAS;
import LOGICO.LVENTAS;
import LOGICO.conexion;
import com.sun.awt.AWTUtilities;
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
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReporteVentas extends javax.swing.JFrame {

    conexion cone = new conexion();

    SimpleDateFormat dformat = new SimpleDateFormat("dd-MM-yyyy");
    VENTAS v = new VENTAS();
    DETALLEVENTA dv = new DETALLEVENTA();
    LVENTAS lv = new LVENTAS();

    public ReporteVentas() {
        this.setUndecorated(true);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../Iconos/cashier_icon-icons.com_53629.png")).getImage());

        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        AWTUtilities.setWindowShape(this, forma);
        btnMotrarDetalleDeCompra.setVisible(false);
        jScrollPane2.setVisible(false);
        btnRegresarAReportes.setVisible(false);
        txtCodigoVenta.setVisible(false);
        listarRVenta();
        calculatTotal();
        noeditarcalendario();
    }

    void listarRVenta() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {

            tabla.addColumn("Codigo Venta");
            tabla.addColumn("Empleado");
            tabla.addColumn("Fecha De Venta");
            tabla.addColumn("Cliente");
            tabla.addColumn("Importe Total");
            cone.consulta("select * from RV");
            Object dato[] = new Object[5];
            while (cone.getRs().next()) {
                for (int i = 0; i < 5; i++) {
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
            cone.consulta("select * from RDV where idventa='" + txtCodigoVenta.getText() + "'");
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
                    + ",v.importtotal\n"
                    + "from ventas v\n"
                    + "inner join empleados e on e.idempleado= v.idempleado\n"
                    + "inner join clientes c on c.idcliente = v.idcliente\n"
                    + "where fecha between '" + dformat.format(dtcInicio.getDate()) + "' and '" + dformat.format(dtcFinal.getDate()) + "'");

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panels = new javax.swing.JPanel();
        Regresar = new javax.swing.JToggleButton();
        dtcInicio = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dtcFinal = new com.toedter.calendar.JDateChooser();
        btnBuscarFechas = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnMotrarDetalleDeCompra = new javax.swing.JToggleButton();
        txtCodigoVenta = new javax.swing.JLabel();
        btnRegresarAReportes = new javax.swing.JToggleButton();
        btnexportarpdf = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtImporteTotal = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
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
        Regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Regresar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back_35px.png"))); // NOI18N
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        dtcInicio.setBackground(new java.awt.Color(6, 3, 9));
        dtcInicio.setForeground(new java.awt.Color(255, 255, 255));
        dtcInicio.setDateFormatString("dd-MM-yyyy");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hasta");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Desde");

        dtcFinal.setBackground(new java.awt.Color(6, 3, 9));
        dtcFinal.setForeground(new java.awt.Color(255, 255, 255));
        dtcFinal.setDateFormatString("dd-MM-yyyy");

        btnBuscarFechas.setBackground(new java.awt.Color(6, 3, 9));
        btnBuscarFechas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnBuscarFechas.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarFechas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_property_30px.png"))); // NOI18N
        btnBuscarFechas.setText("Buscar");
        btnBuscarFechas.setContentAreaFilled(false);
        btnBuscarFechas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_property_35px.png"))); // NOI18N
        btnBuscarFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFechasActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("REPORTE DE VENTAS");

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
                .addGap(466, 466, 466)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(dtcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtcFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
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
                            .addGroup(panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dtcFinal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(dtcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscarFechas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(16, 16, 16)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, -1));

        jPanel3.setBackground(new java.awt.Color(6, 3, 9));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 160, 10));

        btnMotrarDetalleDeCompra.setBackground(new java.awt.Color(153, 255, 153));
        btnMotrarDetalleDeCompra.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnMotrarDetalleDeCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_30px.png"))); // NOI18N
        btnMotrarDetalleDeCompra.setText("Ver Detalle");
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
        jPanel3.add(btnMotrarDetalleDeCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 140, 30));

        txtCodigoVenta.setForeground(new java.awt.Color(255, 255, 255));
        txtCodigoVenta.setText("jLabel4");
        jPanel3.add(txtCodigoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 272, 100, 30));

        btnRegresarAReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back_30px.png"))); // NOI18N
        btnRegresarAReportes.setBorder(null);
        btnRegresarAReportes.setContentAreaFilled(false);
        btnRegresarAReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresarAReportes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back_35px.png"))); // NOI18N
        btnRegresarAReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarAReportesActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegresarAReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 40, 49));

        btnexportarpdf.setText("Exportar a PDF");
        btnexportarpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexportarpdfActionPerformed(evt);
            }
        });
        jPanel3.add(btnexportarpdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 140, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 540));

        jPanel2.setBackground(new java.awt.Color(6, 3, 9));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Importe Total De Ventas Realizdas");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtImporteTotal.setEditable(false);
        txtImporteTotal.setBackground(new java.awt.Color(6, 3, 9));
        txtImporteTotal.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtImporteTotal.setForeground(new java.awt.Color(51, 255, 0));
        txtImporteTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtImporteTotal.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(820, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 1140, 540));

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
        buscarFechaRVenta();
    }//GEN-LAST:event_btnBuscarFechasActionPerformed

    private void btnMotrarDetalleDeCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMotrarDetalleDeCompraMouseClicked
        buscarDetalleRVenta();
        btnMotrarDetalleDeCompra.setVisible(false);
        btnRegresarAReportes.setVisible(true);
        jScrollPane2.setVisible(true);
        jScrollPane1.setVisible(false);
        calculatTotal();
    }//GEN-LAST:event_btnMotrarDetalleDeCompraMouseClicked

    private void btnRegresarAReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarAReportesActionPerformed
        jScrollPane2.setVisible(false);
        jScrollPane1.setVisible(true);
        btnRegresarAReportes.setVisible(false);
        calculatTotal();
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMotrarDetalleDeCompraActionPerformed

    private void btnexportarpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexportarpdfActionPerformed
        // TODO add your handling code here:
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Ventas.pdf"));
            documento.open();

            PdfPTable tablas = new PdfPTable(5);
            tablas.addCell("Codigo Venta");
            tablas.addCell("Empleado");
            tablas.addCell("Fecha De Venta");
            tablas.addCell("Cliente");
            tablas.addCell("Importe Total");
            

            try {
                cone.consulta("select * from RC");
                Object dato[] = new Object[5];

                if (cone.getRs().next()) {

                    do {
                        tablas.addCell(cone.getRs().getString(1));
                        tablas.addCell(cone.getRs().getString(2));
                        tablas.addCell(cone.getRs().getString(3));
                        tablas.addCell(cone.getRs().getString(4));
                        tablas.addCell(cone.getRs().getString(5));
                    } while (cone.getRs().next());
                    documento.add(tablas);
                }
                
            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte Creado");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }
    }//GEN-LAST:event_btnexportarpdfActionPerformed

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
            java.util.logging.Logger.getLogger(ReporteVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Regresar;
    private javax.swing.JToggleButton btnBuscarFechas;
    private javax.swing.JToggleButton btnMotrarDetalleDeCompra;
    private javax.swing.JToggleButton btnRegresarAReportes;
    private javax.swing.JButton btnexportarpdf;
    private com.toedter.calendar.JDateChooser dtcFinal;
    private com.toedter.calendar.JDateChooser dtcInicio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel panels;
    private javax.swing.JTable tbDetalleReporteVenta;
    private javax.swing.JTable tblReporteVenta;
    private javax.swing.JLabel txtCodigoVenta;
    private javax.swing.JTextField txtImporteTotal;
    private javax.swing.JLabel txtcodigo;
    // End of variables declaration//GEN-END:variables

    void calculatTotal() {
        DecimalFormat df = new DecimalFormat("#.##");
        try {
            if (jScrollPane1.isVisible() == true) {
                double tpagar = 0;
                for (int i = 0; i < tblReporteVenta.getRowCount(); i++) {
                    double te = Double.parseDouble(String.valueOf(tblReporteVenta.getValueAt(i, 4)));
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

}
