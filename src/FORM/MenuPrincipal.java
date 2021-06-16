package FORM;

import DATOS.EMPLEADOS;
import LOGICO.LEMPLEADO;
//import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import AppPackage.AnimationClass;
import DATOS.LOGIN;

public class MenuPrincipal extends javax.swing.JFrame {
   
  
    public MenuPrincipal() {
        this.setUndecorated(true);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../Iconos/cashier_icon-icons.com_53629.png")).getImage());
        this.setExtendedState(NORMAL);
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
    //    AWTUtilities.setWindowShape(this, forma);
        btnRventas.setVisible(false);
        btnRcompras.setVisible(false);
    }
    
    LOGIN log=new LOGIN();
     void listar_nombre(){
       txtUsuario.setText(log.getNombre()+" "+log.getApellido());
       txtTipo.setText(log.getCargo());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn3rayitas = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        btnRcompras = new javax.swing.JToggleButton();
        btnRventas = new javax.swing.JToggleButton();
        btnReportes = new javax.swing.JToggleButton();
        jSeparator5 = new javax.swing.JSeparator();
        btnProveedores = new javax.swing.JToggleButton();
        jSeparator4 = new javax.swing.JSeparator();
        btnEmpleados = new javax.swing.JToggleButton();
        btnCompras = new javax.swing.JToggleButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnProductos = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnVentas = new javax.swing.JToggleButton();
        btnCerrarSesion = new javax.swing.JToggleButton();
        MENU = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema De Ventas Tienda");
        setExtendedState(1);
        setUndecorated(true);
        setOpacity(0.95F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(20, 19, 32));
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

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn3rayitas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btn3rayitas.setForeground(new java.awt.Color(255, 255, 255));
        btn3rayitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/lista.png"))); // NOI18N
        btn3rayitas.setSelected(true);
        btn3rayitas.setToolTipText("");
        btn3rayitas.setBorder(null);
        btn3rayitas.setContentAreaFilled(false);
        btn3rayitas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn3rayitas.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/shopping_cart_35px.png"))); // NOI18N
        btn3rayitas.setHideActionText(true);
        btn3rayitas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn3rayitas.setIconTextGap(25);
        btn3rayitas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/shopping_cart_35px.png"))); // NOI18N
        btn3rayitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn3rayitasMouseClicked(evt);
            }
        });
        btn3rayitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3rayitasActionPerformed(evt);
            }
        });
        jPanel2.add(btn3rayitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(51, 0, 255));
        jPanel3.setOpaque(false);

        btnRcompras.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnRcompras.setForeground(new java.awt.Color(255, 255, 255));
        btnRcompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/sell_30px.png"))); // NOI18N
        btnRcompras.setText("Compras");
        btnRcompras.setToolTipText("");
        btnRcompras.setBorder(null);
        btnRcompras.setContentAreaFilled(false);
        btnRcompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRcompras.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/shopping_cart_35px.png"))); // NOI18N
        btnRcompras.setHideActionText(true);
        btnRcompras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRcompras.setIconTextGap(25);
        btnRcompras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/sell_35px.png"))); // NOI18N
        btnRcompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRcomprasActionPerformed(evt);
            }
        });

        btnRventas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnRventas.setForeground(new java.awt.Color(255, 255, 255));
        btnRventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/basket_30px.png"))); // NOI18N
        btnRventas.setText("Ventas");
        btnRventas.setToolTipText("");
        btnRventas.setBorder(null);
        btnRventas.setContentAreaFilled(false);
        btnRventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRventas.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/shopping_cart_35px.png"))); // NOI18N
        btnRventas.setHideActionText(true);
        btnRventas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRventas.setIconTextGap(25);
        btnRventas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/basket_35px.png"))); // NOI18N
        btnRventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRventasActionPerformed(evt);
            }
        });

        btnReportes.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/report_card_30px.png"))); // NOI18N
        btnReportes.setText("Reportes");
        btnReportes.setToolTipText("");
        btnReportes.setBorder(null);
        btnReportes.setContentAreaFilled(false);
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/shopping_cart_35px.png"))); // NOI18N
        btnReportes.setHideActionText(true);
        btnReportes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportes.setIconTextGap(25);
        btnReportes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/report_card_35px.png"))); // NOI18N
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        btnProveedores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnProveedores.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/management_30px.png"))); // NOI18N
        btnProveedores.setText("Proveedores");
        btnProveedores.setToolTipText("");
        btnProveedores.setBorder(null);
        btnProveedores.setContentAreaFilled(false);
        btnProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedores.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/shopping_cart_35px.png"))); // NOI18N
        btnProveedores.setHideActionText(true);
        btnProveedores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProveedores.setIconTextGap(25);
        btnProveedores.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/management_35px.png"))); // NOI18N
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnEmpleados.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/team_30px.png"))); // NOI18N
        btnEmpleados.setText("Empleados");
        btnEmpleados.setToolTipText("");
        btnEmpleados.setBorder(null);
        btnEmpleados.setContentAreaFilled(false);
        btnEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpleados.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/shopping_cart_35px.png"))); // NOI18N
        btnEmpleados.setHideActionText(true);
        btnEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEmpleados.setIconTextGap(25);
        btnEmpleados.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/team_35px.png"))); // NOI18N
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });

        btnCompras.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnCompras.setForeground(new java.awt.Color(255, 255, 255));
        btnCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/sell_stock_30px.png"))); // NOI18N
        btnCompras.setText("Compras");
        btnCompras.setToolTipText("");
        btnCompras.setBorder(null);
        btnCompras.setContentAreaFilled(false);
        btnCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCompras.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/shopping_cart_35px.png"))); // NOI18N
        btnCompras.setHideActionText(true);
        btnCompras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCompras.setIconTextGap(25);
        btnCompras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/sell_stock_35px.png"))); // NOI18N
        btnCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprasActionPerformed(evt);
            }
        });

        btnProductos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/open_box_30px.png"))); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.setToolTipText("");
        btnProductos.setBorder(null);
        btnProductos.setContentAreaFilled(false);
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/shopping_cart_35px.png"))); // NOI18N
        btnProductos.setHideActionText(true);
        btnProductos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProductos.setIconTextGap(25);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnVentas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/shopping_cart_30px.png"))); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.setToolTipText("");
        btnVentas.setBorder(null);
        btnVentas.setContentAreaFilled(false);
        btnVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVentas.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/shopping_cart_35px.png"))); // NOI18N
        btnVentas.setHideActionText(true);
        btnVentas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVentas.setIconTextGap(25);
        btnVentas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/shopping_cart_35px.png"))); // NOI18N
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnCerrarSesion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/shutdown_30px.png"))); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.setToolTipText("");
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setContentAreaFilled(false);
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        btnCerrarSesion.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/shopping_cart_35px.png"))); // NOI18N
        btnCerrarSesion.setHideActionText(true);
        btnCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCerrarSesion.setIconTextGap(25);
        btnCerrarSesion.setName(""); // NOI18N
        btnCerrarSesion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/shutdown_35px.png"))); // NOI18N
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRventas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRcompras, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnRventas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnRcompras, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(btnCerrarSesion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MENU.setBackground(new java.awt.Color(255, 255, 255));

        txtUsuario.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Bienvenido(a): ");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Cargo:");
        jLabel2.setToolTipText("");

        txtTipo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 153, 153));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/logomarket.png"))); // NOI18N
        jLabel3.setFocusable(false);

        javax.swing.GroupLayout MENULayout = new javax.swing.GroupLayout(MENU);
        MENU.setLayout(MENULayout);
        MENULayout.setHorizontalGroup(
            MENULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENULayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MENULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(MENULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(471, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENULayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        MENULayout.setVerticalGroup(
            MENULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENULayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 496, Short.MAX_VALUE)
                .addGroup(MENULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MENULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MENU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(MENU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int x, y;
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
       InicioSesion ini = new InicioSesion();
    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        String botones[] = {"Si", "No"};
        int result = JOptionPane.showOptionDialog(this, "Desea Cerrar Sesion?", "Cerrar Sssion", 0, 0, null, botones, this);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            ini.setVisible(true);
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        Productos obj = new Productos();
        obj.setVisible(true);
        this.setVisible(false);   
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        Ventas obj = new Ventas();
        obj.setVisible(true);
        this.setVisible(false);   
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        Empleados obj = new Empleados();
        obj.setVisible(true);
        this.setVisible(false);       
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        Proveedores obj = new Proveedores();
        obj.setVisible(true);
        this.setVisible(false);         
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprasActionPerformed
        Compras obj = new Compras();
        obj.setVisible(true);
        this.setVisible(false);       
    }//GEN-LAST:event_btnComprasActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        listar_nombre();
        switch (log.getCargo()) {
            case "Vendedor": {
                btnCompras.setEnabled(false);
                btnEmpleados.setEnabled(false);
                btnProductos.setEnabled(false);
                btnProveedores.setEnabled(false);
                btnVentas.setEnabled(true);
                break;
            }
            case "Administrador": {
                btnCompras.setEnabled(true);
                btnEmpleados.setEnabled(true);
                btnProductos.setEnabled(true);
                btnProveedores.setEnabled(true);
                btnVentas.setEnabled(true);
                break;
            }
            case "Almacenero": {
                btnCompras.setEnabled(false);
                btnEmpleados.setEnabled(false);
                btnProductos.setEnabled(true);
                btnProveedores.setEnabled(false);
                btnVentas.setEnabled(false);
                break;
            }
        
       }
    }//GEN-LAST:event_formWindowActivated

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        if (btnReportes.isSelected()) {
            btnRventas.setVisible(true);
            btnRcompras.setVisible(true);
        } else {
            btnRventas.setVisible(false);
            btnRcompras.setVisible(false);
        }

    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnRventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRventasActionPerformed
        ReporteVentas obj = new ReporteVentas();
        obj.setVisible(true);
        this.setVisible(false);        
    }//GEN-LAST:event_btnRventasActionPerformed

    private void btnRcomprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRcomprasActionPerformed
        ReporteCompras obj = new ReporteCompras();
        obj.setVisible(true);
        this.setVisible(false);  
    }//GEN-LAST:event_btnRcomprasActionPerformed

    private void btn3rayitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3rayitasActionPerformed
          
    }//GEN-LAST:event_btn3rayitasActionPerformed

    private void btn3rayitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3rayitasMouseClicked
      AnimationClass menudesp = new AnimationClass();
     
    }//GEN-LAST:event_btn3rayitasMouseClicked

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MENU;
    private javax.swing.JToggleButton btn3rayitas;
    private javax.swing.JToggleButton btnCerrarSesion;
    private javax.swing.JToggleButton btnCompras;
    private javax.swing.JToggleButton btnEmpleados;
    private javax.swing.JToggleButton btnProductos;
    private javax.swing.JToggleButton btnProveedores;
    private javax.swing.JToggleButton btnRcompras;
    private javax.swing.JToggleButton btnReportes;
    private javax.swing.JToggleButton btnRventas;
    private javax.swing.JToggleButton btnVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel txtTipo;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
