package FORM;

import DATOS.COMPRA;
import DATOS.DETCOMPRA;
import DATOS.PROVEEDORES;
import LOGICO.LCOMPRAS;
import LOGICO.LPROVEEDORES;
import LOGICO.conexion;
import com.sun.awt.AWTUtilities;
import LOGICO.CargoFactory;
import LOGICO.LCARGO;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class Compras extends javax.swing.JFrame {

    /*
    IMPLEMENTAR NUEVAS REFACTORIZACIONES!!! 
    URGE
    
    */
    
    DefaultTableModel model = new DefaultTableModel();
    conexion cone= new conexion();
    PROVEEDORES pv= new PROVEEDORES();
    LPROVEEDORES lpv=new LPROVEEDORES();
    LCOMPRAS lcom=new LCOMPRAS();
     
    CargoFactory cargo = new CargoFactory(new LCARGO());

    public Compras() {
        this.setUndecorated(true);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../Iconos/cashier_icon-icons.com_53629.png")).getImage());
          panelprovselec.setVisible(false); 
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        AWTUtilities.setWindowShape(this, forma);
        listarProveedores();
        listarProducto();
      
    }


    void listarProveedores() {
        txtCodigoProducto.setVisible(false);
        txtCodigoProveedor.setVisible(false);
        txtProveedor.setVisible(false);
        llenartabla();
        calculatTotal();
        txtcodigo.setVisible(false);
        DefaultTableModel tabla = new DefaultTableModel();
        try {

            tabla.addColumn("Codigo");
            tabla.addColumn("RUC");
            tabla.addColumn("Empresa");
            tabla.addColumn("Nombre Contacto");
            tabla.addColumn("Apellido Contacto");
            tabla.addColumn("Telefono Contacto");
            tabla.addColumn("Dreccion Empresa");
         lpv.consultar();
            Object dato[] = new Object[7];
           for (int i = 0; i < LPROVEEDORES.Lprovee.size(); i++) {
                pv =(PROVEEDORES)LPROVEEDORES.Lprovee.get(i);
                 dato[0] = pv.getIdproveedor();
                 dato[1] = pv.getRUC();
                 dato[2] = pv.getNomEmpr();
                 dato[3] = pv.getNomCont();
                 dato[4] = pv.getApeCont();
                 dato[5] = pv.getTelCont();
                 dato[6] = pv.getDirEmp();
                   tabla.addRow(dato);
             }this.tblProvee.setModel(tabla);
            editTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error     " + e);
        }
    }

    void BuscarProveedores() {
        txtcodigo.setVisible(false);
        DefaultTableModel tabla = new DefaultTableModel();
        try {

            tabla.addColumn("Codigo");
            tabla.addColumn("RUC");
            tabla.addColumn("Empresa");
            tabla.addColumn("Nombre Contacto");
            tabla.addColumn("Apellido Contacto");
            tabla.addColumn("Telefono Contacto");
            tabla.addColumn("Dreccion Empresa");
             String letra=txtBuscarProveedores.getText();
            cone.consulta("  Select * from proveedores\n" +
            "    WHERE ESTADO=1 \n" +
            "    AND (REGEXP_LIKE( LOWER(ruc),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(NOMEMPRESA),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(nombrecontacto),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(apellidocontacto),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(direccionempresa),LOWER('"+letra+"+')))");
             Object dato[] = new Object[7];
             while(cone.getRs().next()){
                for (int i = 0; i < 7; i++) {
                    dato[i] = cone.getRs().getString(i + 1);
                }
                tabla.addRow(dato);
             } 
            this.tblProvee.setModel(tabla);
            editTabla();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "error     " + e);
        }
    }

    void listarProducto() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {

            tabla.addColumn("Codigo");
            tabla.addColumn("Nombre");
            tabla.addColumn("Descripcion");
            tabla.addColumn("Precio Unitario");
            tabla.addColumn("Stock");
            tabla.addColumn("Categoria");
            cone.consulta("Select * from listarProductos");
            Object dato[] = new Object[6];
            while (cone.getRs().next()) {
                for (int i = 0; i < 6; i++) {
                    dato[i] = cone.getRs().getString(i + 1);
                }
                tabla.addRow(dato);
            }
            this.tblProductos.setModel(tabla);
             editTabla();
       } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "error     " + e);
        }
    }

    void buscarProducto() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            tabla.addColumn("Codigo");
            tabla.addColumn("Nombre");
            tabla.addColumn("Descripcion");
            tabla.addColumn("Precio Unitario");
            tabla.addColumn("Stock");
            tabla.addColumn("Categoria");
           String letra=txtBuscarProductos.getText();
            cone.consulta("  Select * from listarProductos\n" +
            "    WHERE ESTADO=1 \n" +
            "    AND (REGEXP_LIKE( LOWER(NOMBRE),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(Descripcion),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(preciounit),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(CATGEORIA),LOWER('"+letra+"+')))");
             Object dato[] = new Object[6];
             while(cone.getRs().next()){
                for (int i = 0; i < 6; i++) {
                    dato[i] = cone.getRs().getString(i + 1);
                }
                tabla.addRow(dato);
             } 
            this.tblProductos.setModel(tabla);
            editTabla();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "error     " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Regresar = new javax.swing.JToggleButton();
        txtComprobante = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnQuitar = new javax.swing.JToggleButton();
        btnNuevo = new javax.swing.JToggleButton();
        btnAñadir = new javax.swing.JToggleButton();
        txtProducto = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtPrecioDeCompra = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        panelprovselec = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtruc = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        txtcontacto = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        txtrazonsoc = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProvee = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        txtBuscarProveedores = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jSeparator9 = new javax.swing.JSeparator();
        txtBuscarProductos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtCodigoProveedor = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JLabel();
        txtImporteTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnGeneraCompra = new javax.swing.JToggleButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCompra = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema De Ventas Tienda");
        setMinimumSize(new java.awt.Dimension(1312, 709));
        setUndecorated(true);
        setOpacity(0.95F);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));
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

        txtComprobante.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 0));
        jLabel9.setText("COMPRAS DE ALMACEN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Regresar)
                .addGap(183, 183, 183)
                .addComponent(txtComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addComponent(jLabel9)
                .addContainerGap(580, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Regresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, -1));

        jPanel4.setBackground(new java.awt.Color(6, 3, 9));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnQuitar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/trash_30px.png"))); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.setContentAreaFilled(false);
        btnQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuitar.setIconTextGap(20);
        btnQuitar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/trash_35px.png"))); // NOI18N
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        jPanel4.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 140, -1));

        btnNuevo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new_30px.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNuevo.setIconTextGap(20);
        btnNuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new_35px.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, 140, -1));

        btnAñadir.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnAñadir.setForeground(new java.awt.Color(255, 255, 255));
        btnAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_30px.png"))); // NOI18N
        btnAñadir.setText("Añadir");
        btnAñadir.setContentAreaFilled(false);
        btnAñadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAñadir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAñadir.setIconTextGap(20);
        btnAñadir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_35px.png"))); // NOI18N
        btnAñadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAñadirMouseClicked(evt);
            }
        });
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });
        jPanel4.add(btnAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 130, -1));

        txtProducto.setEditable(false);
        txtProducto.setBackground(new java.awt.Color(6, 3, 9));
        txtProducto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtProducto.setForeground(new java.awt.Color(153, 153, 153));
        txtProducto.setBorder(null);
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductoKeyTyped(evt);
            }
        });
        jPanel4.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 180, 30));
        jPanel4.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 180, 10));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad A Llevar:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        txtCantidad.setBackground(new java.awt.Color(6, 3, 9));
        txtCantidad.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(153, 153, 153));
        txtCantidad.setBorder(null);
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        jPanel4.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 80, 30));
        jPanel4.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 80, 10));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Producto");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 20, 11, 40));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 11, 40));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio De Compra");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        txtPrecioDeCompra.setBackground(new java.awt.Color(6, 3, 9));
        txtPrecioDeCompra.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtPrecioDeCompra.setForeground(new java.awt.Color(153, 153, 153));
        txtPrecioDeCompra.setBorder(null);
        txtPrecioDeCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioDeCompraKeyTyped(evt);
            }
        });
        jPanel4.add(txtPrecioDeCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 80, 30));
        jPanel4.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 80, 10));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 1310, 80));

        panelprovselec.setBackground(new java.awt.Color(20, 19, 32));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 204, 0));
        jLabel15.setText("Proveedor Seleccionado");

        txtruc.setEditable(false);
        txtruc.setBackground(new java.awt.Color(20, 19, 32));
        txtruc.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtruc.setForeground(new java.awt.Color(255, 255, 255));
        txtruc.setBorder(null);

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("RUC:");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("contacto");

        txtcontacto.setEditable(false);
        txtcontacto.setBackground(new java.awt.Color(20, 19, 32));
        txtcontacto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtcontacto.setForeground(new java.awt.Color(255, 255, 255));
        txtcontacto.setBorder(null);

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Razon Social:");

        txtrazonsoc.setEditable(false);
        txtrazonsoc.setBackground(new java.awt.Color(20, 19, 32));
        txtrazonsoc.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtrazonsoc.setForeground(new java.awt.Color(255, 255, 255));
        txtrazonsoc.setBorder(null);

        javax.swing.GroupLayout panelprovselecLayout = new javax.swing.GroupLayout(panelprovselec);
        panelprovselec.setLayout(panelprovselecLayout);
        panelprovselecLayout.setHorizontalGroup(
            panelprovselecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelprovselecLayout.createSequentialGroup()
                .addGroup(panelprovselecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelprovselecLayout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel15))
                    .addGroup(panelprovselecLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel17)
                        .addGap(12, 12, 12)
                        .addGroup(panelprovselecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator10)
                            .addComponent(txtruc, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelprovselecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator11)
                            .addComponent(txtrazonsoc, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelprovselecLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelprovselecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcontacto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(198, 198, 198))
        );
        panelprovselecLayout.setVerticalGroup(
            panelprovselecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelprovselecLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel15)
                .addGroup(panelprovselecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelprovselecLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(panelprovselecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelprovselecLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel17))
                            .addComponent(txtruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelprovselecLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(panelprovselecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelprovselecLayout.createSequentialGroup()
                                .addComponent(txtrazonsoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18))))
                .addGap(18, 18, 18)
                .addGroup(panelprovselecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(panelprovselecLayout.createSequentialGroup()
                        .addComponent(txtcontacto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        getContentPane().add(panelprovselec, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 660, 310));

        jPanel2.setBackground(new java.awt.Color(20, 19, 32));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProvee = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex,int colIndex) {
                return false;
            }
        };
        tblProvee.getTableHeader().setReorderingAllowed(false);
        tblProvee.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblProvee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProvee.setSelectionBackground(new java.awt.Color(51, 102, 255));
        tblProvee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProvee);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 610, 180));

        jPanel6.setBackground(new java.awt.Color(20, 19, 32));

        txtBuscarProveedores.setBackground(new java.awt.Color(20, 19, 32));
        txtBuscarProveedores.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtBuscarProveedores.setForeground(new java.awt.Color(153, 153, 153));
        txtBuscarProveedores.setBorder(null);
        txtBuscarProveedores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarProveedoresKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarProveedoresKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_30px.png"))); // NOI18N

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 0));
        jLabel8.setText("PROVEEDORES");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(txtBuscarProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(116, 116, 116)
                        .addComponent(txtcodigo)
                        .addGap(30, 30, 30))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtcodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel1))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 500, 70));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 428, 10));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 660, 310));

        jPanel3.setBackground(new java.awt.Color(20, 19, 32));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProductos = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex,int colIndex) {
                return false;
            }
        };
        tblProductos.getTableHeader().setReorderingAllowed(false);
        tblProductos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProductos.setFocusable(false);
        tblProductos.setSelectionBackground(new java.awt.Color(51, 102, 255));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProductos);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 590, 180));
        jPanel3.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 428, 10));

        txtBuscarProductos.setBackground(new java.awt.Color(20, 19, 32));
        txtBuscarProductos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtBuscarProductos.setForeground(new java.awt.Color(153, 153, 153));
        txtBuscarProductos.setBorder(null);
        txtBuscarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProductosActionPerformed(evt);
            }
        });
        txtBuscarProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarProductosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarProductosKeyTyped(evt);
            }
        });
        jPanel3.add(txtBuscarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 428, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_30px.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 0));
        jLabel10.setText("PRODUCTOS");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 650, 310));

        jPanel5.setBackground(new java.awt.Color(20, 19, 32));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigoProveedor.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txtCodigoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, -1));

        txtCodigoProducto.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txtCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));
        jPanel5.add(txtProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));

        txtImporteTotal.setEditable(false);
        txtImporteTotal.setBackground(new java.awt.Color(6, 3, 9));
        txtImporteTotal.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtImporteTotal.setForeground(new java.awt.Color(51, 255, 0));
        txtImporteTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtImporteTotal.setBorder(null);
        jPanel5.add(txtImporteTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 40, 140, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Importe Total");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, -1, 20));

        btnGeneraCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnGeneraCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/sale_30px.png"))); // NOI18N
        btnGeneraCompra.setText("Generar Compra");
        btnGeneraCompra.setBorder(null);
        btnGeneraCompra.setContentAreaFilled(false);
        btnGeneraCompra.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/sale_35px.png"))); // NOI18N
        btnGeneraCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGeneraCompraMouseClicked(evt);
            }
        });
        btnGeneraCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneraCompraActionPerformed(evt);
            }
        });
        jPanel5.add(btnGeneraCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 140, 40));
        jPanel5.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 70, 140, 10));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 1310, 100));

        tblCompra = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex,int colIndex) {
                return false;
            }
        };
        tblCompra.getTableHeader().setReorderingAllowed(false);
        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblCompra);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1310, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        MenuPrincipal obj = new MenuPrincipal();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_RegresarActionPerformed

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        int row = tblProductos.rowAtPoint(evt.getPoint());
        txtCodigoProducto.setText(tblProductos.getValueAt(row, 0).toString());
        txtProducto.setText(tblProductos.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tblProductosMouseClicked

    private void txtBuscarProveedoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProveedoresKeyPressed
        BuscarProveedores();
    }//GEN-LAST:event_txtBuscarProveedoresKeyPressed

    private void txtBuscarProveedoresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProveedoresKeyTyped
        if (txtBuscarProveedores.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarProveedoresKeyTyped

    private void txtBuscarProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductosKeyPressed
        buscarProducto();
    }//GEN-LAST:event_txtBuscarProductosKeyPressed

    private void txtBuscarProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProductosKeyTyped
    int x1, y1;
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x1 = evt.getX();
        y1 = evt.getY();

    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();

        this.setLocation(xx - x1, yy - y1);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed

        if (tblCompra.getSelectedRow() != -1) {
            model.removeRow(tblCompra.getSelectedRow());
            calculatTotal();
        } else {
            JOptionPane.showMessageDialog(null, "No has selecionado un registro...");
        }


    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
            limpiarTabla();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyTyped
        if (txtProducto.getText().length() >= 49) {
            evt.consume();
        }
    }//GEN-LAST:event_txtProductoKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
       char car = evt.getKeyChar();
        if (txtCantidad.getText().length() >= 5 ) {
            evt.consume();
        } 
          if (car < '0' || car > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void tblProveeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveeMouseClicked
        int row = tblProvee.rowAtPoint(evt.getPoint());
        txtCodigoProveedor.setText(tblProvee.getValueAt(row, 0).toString());
        txtProveedor.setText(tblProvee.getValueAt(row, 2).toString());
        txtruc.setText(tblProvee.getValueAt(row,1).toString());
        txtrazonsoc.setText(tblProvee.getValueAt(row,2).toString());
        txtcontacto.setText(tblProvee.getValueAt(row,3).toString());
        
    }//GEN-LAST:event_tblProveeMouseClicked

    private void txtPrecioDeCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioDeCompraKeyTyped
        char car = evt.getKeyChar();
        if (txtCantidad.getText().length() >= 5) {
            evt.consume();
        }
          if ((car < '0' || car > '9') && (car < 46 || car > 46)){
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioDeCompraKeyTyped

    private void btnAñadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirMouseClicked
        try {
            if (txtCantidad.getText().equals("") || txtCodigoProducto.getText().equals("") || txtCodigoProveedor.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Tiene Que selecionar algun registro O ingresar datos en los campos");
                 paneles();
            } else {
                model = (DefaultTableModel) tblCompra.getModel();
                String codproveedor = txtCodigoProveedor.getText();
                String codproducto = txtCodigoProducto.getText();
                String proveedor = txtProveedor.getText();
                String producto = txtProducto.getText();
                int Cant = Integer.parseInt(txtCantidad.getText());
                double pre = Double.parseDouble(txtPrecioDeCompra.getText());
                double total = Cant * pre;
                ArrayList lista = new ArrayList();
                lista.add(codproveedor);
                lista.add(codproducto);
                lista.add(proveedor);
                lista.add(producto);
                lista.add(Cant);
                lista.add(pre);
                lista.add(total);
                validar();
                Object[] ob = new Object[7];
                ob[0] = lista.get(0);
                ob[1] = lista.get(1);
                ob[2] = lista.get(2);
                ob[3] = lista.get(3);
                ob[4] = lista.get(4);
                ob[5] = lista.get(5);
                ob[6] = lista.get(6);
                model.addRow(ob);
                tblCompra.setModel(model);
                calculatTotal();
            }
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(this, "error" + ex);
        }

    }//GEN-LAST:event_btnAñadirMouseClicked

    private void btnGeneraCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGeneraCompraMouseClicked
         try {
            if (tblCompra.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No Ha Añadido Un Producto A La lista...");
                
            } else {String cod="";
                try {
                    COMPRA comp= new COMPRA();
                    comp.setIdproveedor(txtCodigoProveedor.getText());
                    comp.setImportTotal(Float.parseFloat(txtImporteTotal.getText()));
                    lcom.insertarcompra(comp);
               } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error en generar compra " + ex.getMessage());
                    paneles();
                }
                for(int i = 0; i < tblCompra.getRowCount(); i++) {
                  
                    String idp = tblCompra.getValueAt(i, 1).toString();
                    int cant = Integer.parseInt(tblCompra.getValueAt(i, 4).toString());
                    Float pre = Float.parseFloat(tblCompra.getValueAt(i, 5).toString());
                    try { 
                          cone.consulta("select idcompra from COMPRAS \n" +
                         "where idcompra in(select max(idcompra) from COMPRAS)");
                          while (cone.getRs().next()) {
                          cod= cone.getRs().getString(1);
                         }
                        DETCOMPRA dcomp = new DETCOMPRA();
                        dcomp.setIdcompra(cod);
                        dcomp.setIdproducto(idp);
                        dcomp.setCantidad(cant);
                        dcomp.setPrecioU(pre);
                        lcom.insertardetcompra(dcomp);
               } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error en generar detcompra " + ex.getMessage());
                    }
                }
                calculatTotal();
                JOptionPane.showMessageDialog(this, "Compra " +cod+ " Se Realizo con Exito");
                nuevo();
                listarProducto();
                paneles();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }


    }//GEN-LAST:event_btnGeneraCompraMouseClicked

    private void btnGeneraCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneraCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGeneraCompraActionPerformed

    private void txtBuscarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProductosActionPerformed

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
         panelprovselec.setVisible(true);   
        jPanel2.setVisible(false);
    }//GEN-LAST:event_btnAñadirActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Regresar;
    private javax.swing.JToggleButton btnAñadir;
    private javax.swing.JToggleButton btnGeneraCompra;
    private javax.swing.JToggleButton btnNuevo;
    private javax.swing.JToggleButton btnQuitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel panelprovselec;
    private javax.swing.JTable tblCompra;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblProvee;
    private javax.swing.JTextField txtBuscarProductos;
    private javax.swing.JTextField txtBuscarProveedores;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JLabel txtCodigoProducto;
    private javax.swing.JLabel txtCodigoProveedor;
    private javax.swing.JLabel txtComprobante;
    private javax.swing.JTextField txtImporteTotal;
    private javax.swing.JTextField txtPrecioDeCompra;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JLabel txtProveedor;
    private javax.swing.JLabel txtcodigo;
    private javax.swing.JTextField txtcontacto;
    private javax.swing.JTextField txtrazonsoc;
    private javax.swing.JTextField txtruc;
    // End of variables declaration//GEN-END:variables

    void validar() {
        for (int i = 0; i < tblCompra.getRowCount(); i++) {

            if (tblCompra.getValueAt(i, 1).equals(txtCodigoProducto.getText())) {
                JOptionPane.showMessageDialog(null, "El producto  '" + txtProducto.getText() + "'  Ya Esta Añadido A La Lista...");
                model.removeRow(i);
            }
        }
    }

    private void llenartabla() {
        model.addColumn("CodProv");
        model.addColumn("CodProd");
        model.addColumn("Empresa");
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        model.addColumn("Total");
        tblCompra.setModel(model);

    }

    void calculatTotal() {
        try {
            double tpagar = 0;
            for (int i = 0; i < tblCompra.getRowCount(); i++) {
                int cant = Integer.parseInt(String.valueOf(tblCompra.getValueAt(i, 4)));
                double pre = Double.parseDouble(String.valueOf(tblCompra.getValueAt(i, 5)));
                tpagar = tpagar + (cant * pre);
            }
            txtImporteTotal.setText("" + tpagar + "0");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No se pudo calcular el total: " + e);
        }
    }

    void limpiarTabla() {
        try {
           for (int i = 0; i < model.getRowCount(); i++) {
                model.removeRow(i);
                i = i - 1;
            }
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Error en limpiar" + E.getMessage());
        }
    }

    void nuevo() {
        limpiarTabla();
        calculatTotal();
        txtProducto.setText("");
        txtCantidad.setText("");
        txtPrecioDeCompra.setText("");
        txtCantidad.requestFocus();
    }

    
    
     void editTabla() {
         
        tblProvee.getColumnModel().getColumn(0).setPreferredWidth(-1);
        tblProvee.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblProvee.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblProvee.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblProvee.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblProvee.getColumnModel().getColumn(5).setPreferredWidth(75);
        tblProvee.getColumnModel().getColumn(6).setPreferredWidth(100);
        tblProvee.getColumnModel().getColumn(0).setResizable(false);
        tblProvee.getColumnModel().getColumn(1).setResizable(false);
        tblProvee.getColumnModel().getColumn(2).setResizable(false);
        tblProvee.getColumnModel().getColumn(3).setResizable(false);
        tblProvee.getColumnModel().getColumn(4).setResizable(false);
        tblProvee.getColumnModel().getColumn(5).setResizable(false);
        tblProvee.getColumnModel().getColumn(6).setResizable(false);
    }

    void paneles(){
        panelprovselec.setVisible(false);
        jPanel2.setVisible(true);
    }
}
