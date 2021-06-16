package FORM;

import LOGICO.conexion;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.awt.AWTUtilities;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.HeadlessException;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ReporteCompras extends javax.swing.JFrame {

    SimpleDateFormat dformat = new SimpleDateFormat("dd-MM-yyyy");
   

    public ReporteCompras() {
        this.setUndecorated(true);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../Iconos/cashier_icon-icons.com_53629.png")).getImage());
       
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        AWTUtilities.setWindowShape(this, forma);
        listarRCompra();
        noeditarcalendario();
        btnMotrarDetalleDeCompra1.setVisible(false);
        jScrollPane2.setVisible(false);
        btnRegresarAReportes.setVisible(false);
        txtCodigoCompra.setVisible(false);
        calculatTotal();
    }
    conexion cone= new conexion();
    void listarRCompra() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {

            tabla.addColumn("Codigo Compra");
            tabla.addColumn("Empresa");
            tabla.addColumn("RUC");
            tabla.addColumn("Fecha De Compra");
            tabla.addColumn("Importe Total");
            cone.consulta("select * from RC");
            Object dato[] = new Object[5];
            while (cone.getRs().next()) {
                for (int i = 0; i < 5; i++) {
                    dato[i] = cone.getRs().getString(i + 1);
                }
                tabla.addRow(dato);
            }
            this.tblReporteCompra.setModel(tabla);
            // editTabla();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "error     " + e);
        }
    }

    void buscarRCompra() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            tabla.addColumn("Codigo Compra");
            tabla.addColumn("Empresa");
            tabla.addColumn("RUC");
            tabla.addColumn("Fecha De Compra");
            tabla.addColumn("Importe Total");
//            cst = con.prepareCall("{call SEL_BUSCAR_RCOMPRA (?)}");
//            cst.setString(1, txtBuscar.getText());
//            r = cst.executeQuery();
//            while (r.next()) {
//                Object dato[] = new Object[5];
//                for (int i = 0; i < 5; i++) {
//                    dato[i] = r.getString(i + 1);
//                }
//                tabla.addRow(dato);
//            }
            this.tblReporteCompra.setModel(tabla);
            //editTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error  fe   " + e);
        }
    }

    void buscarFechaRCompra() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            tabla.addColumn("Codigo Compra");
            tabla.addColumn("Empresa");
            tabla.addColumn("RUC");
            tabla.addColumn("Fecha De Compra");
            tabla.addColumn("Importe Total");
           cone.consulta("select c.idcompra,p.nombrecontacto || ' ' ||p.apellidocontacto NOMPROV"
                + ",p.ruc,TO_CHAR(c.fecha,'dd-MM-yyyy') fecha,c.importetotal\n" +
                "from compras c  inner join proveedores p on p.idproveedor = c.idproveedor\n" +
                "where fecha between '"+dformat.format(dtcInicio.getDate())+"' and '"+dformat.format(dtcFinal.getDate())+"'");
                
              Object dato[] = new Object[5];
            while (cone.getRs().next()) {
                for (int i = 0; i < 5; i++) {
                    dato[i] = cone.getRs().getString(i + 1);
                }
                tabla.addRow(dato);
            }
          
            this.tblReporteCompra.setModel(tabla);
            //editTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error  fe   " + e);
        }
    }

    void buscarDetalleRCompra() {

        DefaultTableModel tabla = new DefaultTableModel();
        try {
            tabla.addColumn("Codigo Compra");
            tabla.addColumn("Producto");
            tabla.addColumn("Cantidad");
            tabla.addColumn("Precio De Compra");
            tabla.addColumn("Importe");
          cone.consulta("select * from RDC where idcompra='"+txtCodigoCompra.getText()+"'");
            Object dato[] = new Object[5];
            while (cone.getRs().next()) {
                for (int i = 0; i < 5; i++) {
                    dato[i] = cone.getRs().getString(i + 1);
                }
                tabla.addRow(dato);
            }
            this.tbDetalleReporteCompra.setModel(tabla);
            //editTabla();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "error     " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbDetalleReporteCompra = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtcodigo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Regresar = new javax.swing.JToggleButton();
        btnBuscarFechas = new javax.swing.JToggleButton();
        dtcFinal = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        dtcInicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtImporteTotal = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteCompra = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        txtCodigoCompra = new javax.swing.JLabel();
        btnRegresarAReportes = new javax.swing.JToggleButton();
        btnMotrarDetalleDeCompra1 = new javax.swing.JToggleButton();
        btnexportpdfv = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1300, 726));
        setUndecorated(true);
        setOpacity(0.9F);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbDetalleReporteCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbDetalleReporteCompra);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 1140, 530));

        jPanel1.setBackground(new java.awt.Color(6, 3, 9));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(6, 3, 9));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("REPORTE DE COMPRAS");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtcodigo))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(421, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtcodigo)
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addContainerGap(27, Short.MAX_VALUE))
        );

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

        btnBuscarFechas.setBackground(new java.awt.Color(6, 3, 9));
        btnBuscarFechas.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
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

        dtcFinal.setBackground(new java.awt.Color(6, 3, 9));
        dtcFinal.setForeground(new java.awt.Color(255, 255, 255));
        dtcFinal.setDateFormatString("dd-MM-yyyy");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("hasta:");

        dtcInicio.setBackground(new java.awt.Color(6, 3, 9));
        dtcInicio.setForeground(new java.awt.Color(255, 255, 255));
        dtcInicio.setDateFormatString("dd-MM-yyyy");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("desde:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Regresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dtcFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Regresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dtcFinal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dtcInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 100));

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
        txtImporteTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImporteTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(807, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1300, 100));

        tblReporteCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblReporteCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReporteCompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblReporteCompra);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 1140, 530));

        jPanel3.setBackground(new java.awt.Color(6, 3, 9));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 160, 10));

        txtCodigoCompra.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtCodigoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 272, 100, 30));

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
        jPanel3.add(btnRegresarAReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 30, 49));

        btnMotrarDetalleDeCompra1.setBackground(new java.awt.Color(153, 255, 153));
        btnMotrarDetalleDeCompra1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnMotrarDetalleDeCompra1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_30px.png"))); // NOI18N
        btnMotrarDetalleDeCompra1.setText("Ver Detalle");
        btnMotrarDetalleDeCompra1.setBorder(null);
        btnMotrarDetalleDeCompra1.setBorderPainted(false);
        btnMotrarDetalleDeCompra1.setOpaque(true);
        btnMotrarDetalleDeCompra1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMotrarDetalleDeCompra1MouseClicked(evt);
            }
        });
        btnMotrarDetalleDeCompra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotrarDetalleDeCompra1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnMotrarDetalleDeCompra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 140, 30));

        btnexportpdfv.setText("Exportar PDF");
        btnexportpdfv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexportpdfvActionPerformed(evt);
            }
        });
        jPanel3.add(btnexportpdfv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 140, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 160, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        MenuPrincipal obj = new MenuPrincipal();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_RegresarActionPerformed

    private void btnRegresarAReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarAReportesActionPerformed
        jScrollPane2.setVisible(false);
        jScrollPane1.setVisible(true);
        btnRegresarAReportes.setVisible(false);
        calculatTotal();
    }//GEN-LAST:event_btnRegresarAReportesActionPerformed

    private void tblReporteCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReporteCompraMouseClicked
        btnMotrarDetalleDeCompra1.setVisible(true);
        int row = tblReporteCompra.getSelectedRow();
        txtCodigoCompra.setText(tblReporteCompra.getValueAt(row, 0).toString());
    }//GEN-LAST:event_tblReporteCompraMouseClicked

    private void btnBuscarFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFechasActionPerformed
        buscarFechaRCompra();
    }//GEN-LAST:event_btnBuscarFechasActionPerformed
    int x, y;
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();

        this.setLocation(xx - x, yy - y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void txtImporteTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImporteTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImporteTotalActionPerformed

    private void btnMotrarDetalleDeCompra1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMotrarDetalleDeCompra1MouseClicked
        buscarDetalleRCompra();
        btnMotrarDetalleDeCompra1.setVisible(false);
        btnRegresarAReportes.setVisible(true);
        jScrollPane2.setVisible(true);
        jScrollPane1.setVisible(false);
        calculatTotal();
    }//GEN-LAST:event_btnMotrarDetalleDeCompra1MouseClicked

    private void btnMotrarDetalleDeCompra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotrarDetalleDeCompra1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMotrarDetalleDeCompra1ActionPerformed

    private void btnexportpdfvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexportpdfvActionPerformed
        // TODO add your handling code here:
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Compras.pdf"));
            documento.open();

            PdfPTable tablas = new PdfPTable(5);
            tablas.addCell("Codigo Compra");
            tablas.addCell("Empleado");
            tablas.addCell("RUC");
            tablas.addCell("Fecha De Compra");
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
    }//GEN-LAST:event_btnexportpdfvActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReporteCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Regresar;
    private javax.swing.JToggleButton btnBuscarFechas;
    private javax.swing.JToggleButton btnMotrarDetalleDeCompra1;
    private javax.swing.JToggleButton btnRegresarAReportes;
    private javax.swing.JButton btnexportpdfv;
    private com.toedter.calendar.JDateChooser dtcFinal;
    private com.toedter.calendar.JDateChooser dtcInicio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tbDetalleReporteCompra;
    private javax.swing.JTable tblReporteCompra;
    private javax.swing.JLabel txtCodigoCompra;
    private javax.swing.JTextField txtImporteTotal;
    private javax.swing.JLabel txtcodigo;
    // End of variables declaration//GEN-END:variables

    void calculatTotal() {
        try {
            if (jScrollPane1.isVisible() == true) {
                double tpagar = 0;
                for (int i = 0; i < tblReporteCompra.getRowCount(); i++) {
                    double te = Double.parseDouble(String.valueOf(tblReporteCompra.getValueAt(i, 4)));
                    tpagar = tpagar + te;
                }
                txtImporteTotal.setText("" + tpagar + "0");
            } else if (jScrollPane2.isVisible() == true) {
                double tpagar = 0;
                for (int i = 0; i < tbDetalleReporteCompra.getRowCount(); i++) {
                    double te = Double.parseDouble(String.valueOf(tbDetalleReporteCompra.getValueAt(i, 5)));
                    tpagar = tpagar + te;
                }
                txtImporteTotal.setText("" + tpagar + "0");
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No se pudo calcular el total: " + e);
        }
    }

    void noeditarcalendario() {
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dtcFinal.getDateEditor();
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) dtcInicio.getDateEditor();
        editor.setEditable(false);
        editor2.setEditable(false);
    }

}
