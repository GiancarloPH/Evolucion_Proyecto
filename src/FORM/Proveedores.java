package FORM;

import DATOS.PROVEEDORES;
import LOGICO.LPROVEEDORES;
import LOGICO.conexion;
import com.sun.awt.AWTUtilities;
import LOGICO.ProveedorFactory;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Proveedores extends javax.swing.JFrame {

    PROVEEDORES pv= new PROVEEDORES();
    LPROVEEDORES lpv=new LPROVEEDORES();
    conexion cone= new conexion();
    
    ProveedorFactory pfactory = new ProveedorFactory(new LPROVEEDORES());

    public Proveedores() {
        this.setUndecorated(true);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../Iconos/cashier_icon-icons.com_53629.png")).getImage());
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        AWTUtilities.setWindowShape(this, forma);
        Select2();
        listarProveedores();
    }

    void listarProveedores() {
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
            /*
            INTERFAZ EL DIA 5/5/2021 
            AUTORES: EQUIPO DE EVOLUCION
            */
            
            //pfactory.consultarProveedorNew();
            
            
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
             }
            this.tblProveedores.setModel(tabla);
            editTabla();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "error     " + e);
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
            String letra=txtBuscar.getText();
            cone.consulta("  Select * from listarprov \n" +
            "    WHERE (REGEXP_LIKE( LOWER(ru),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(ne),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(nc),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(ap),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(tc),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(de),LOWER('"+letra+"+')))");
             Object dato[] = new Object[7];
             while(cone.getRs().next()){
                for (int i = 0; i < 7; i++) {
                    dato[i] = cone.getRs().getString(i + 1);
                }
                tabla.addRow(dato);
             } 
            this.tblProveedores.setModel(tabla);
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
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtcodigo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTelefonoDeContacto = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JToggleButton();
        btnAgregar = new javax.swing.JToggleButton();
        btnActualizar = new javax.swing.JToggleButton();
        btnEliminar = new javax.swing.JToggleButton();
        btnCancelar = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        txtRUC = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        txtNombreContacto = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        txtApellidoDeContacto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        txtDireccionDeEmpresa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema De Ventas Tienda");
        setMinimumSize(new java.awt.Dimension(1300, 726));
        setUndecorated(true);
        setOpacity(0.95F);

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

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 0));
        jLabel9.setText("INGRESO DE PROVEEDORES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Regresar)
                .addGap(547, 547, 547)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Regresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        jPanel4.setBackground(new java.awt.Color(20, 19, 32));

        txtBuscar.setBackground(new java.awt.Color(20, 19, 32));
        txtBuscar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(153, 153, 153));
        txtBuscar.setBorder(null);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_30px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator7)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtcodigo)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtcodigo))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(20, 19, 32));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Empresa");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 20, -1, -1));

        txtEmpresa.setBackground(new java.awt.Color(20, 19, 32));
        txtEmpresa.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtEmpresa.setForeground(new java.awt.Color(153, 153, 153));
        txtEmpresa.setBorder(null);
        txtEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaActionPerformed(evt);
            }
        });
        txtEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmpresaKeyTyped(evt);
            }
        });
        jPanel3.add(txtEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 289, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ruc");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre De Contacto");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txtTelefonoDeContacto.setBackground(new java.awt.Color(20, 19, 32));
        txtTelefonoDeContacto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtTelefonoDeContacto.setForeground(new java.awt.Color(153, 153, 153));
        txtTelefonoDeContacto.setBorder(null);
        txtTelefonoDeContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoDeContactoKeyTyped(evt);
            }
        });
        jPanel3.add(txtTelefonoDeContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 289, -1));

        btnNuevo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new_30px.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNuevo.setIconTextGap(75);
        btnNuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new_35px.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel3.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 290, -1));

        btnAgregar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_property_30px.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAgregar.setIconTextGap(75);
        btnAgregar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_property_35px.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 289, -1));

        btnActualizar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit_property_30px.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnActualizar.setIconTextGap(75);
        btnActualizar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit_property_35px.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel3.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 289, -1));

        btnEliminar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_document_30px.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEliminar.setIconTextGap(75);
        btnEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_document_35px.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 289, -1));

        btnCancelar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel_subscription_30px.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancelar.setIconTextGap(75);
        btnCancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel_subscription_35px.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 289, -1));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 289, 10));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 289, 10));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 289, 10));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 289, 10));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 60, 289, 10));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 289, 10));

        txtRUC.setBackground(new java.awt.Color(20, 19, 32));
        txtRUC.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtRUC.setForeground(new java.awt.Color(153, 153, 153));
        txtRUC.setBorder(null);
        txtRUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRUCKeyTyped(evt);
            }
        });
        jPanel3.add(txtRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 289, -1));
        jPanel3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 289, 10));

        txtNombreContacto.setBackground(new java.awt.Color(20, 19, 32));
        txtNombreContacto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombreContacto.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreContacto.setBorder(null);
        txtNombreContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreContactoActionPerformed(evt);
            }
        });
        txtNombreContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreContactoKeyTyped(evt);
            }
        });
        jPanel3.add(txtNombreContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 289, -1));
        jPanel3.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 289, 10));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Telefono De Contacto");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));
        jPanel3.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 289, 10));

        txtApellidoDeContacto.setBackground(new java.awt.Color(20, 19, 32));
        txtApellidoDeContacto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtApellidoDeContacto.setForeground(new java.awt.Color(153, 153, 153));
        txtApellidoDeContacto.setBorder(null);
        txtApellidoDeContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoDeContactoKeyTyped(evt);
            }
        });
        jPanel3.add(txtApellidoDeContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 289, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Apellido De Contacto");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        jPanel3.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 289, 10));

        txtDireccionDeEmpresa.setBackground(new java.awt.Color(20, 19, 32));
        txtDireccionDeEmpresa.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDireccionDeEmpresa.setForeground(new java.awt.Color(153, 153, 153));
        txtDireccionDeEmpresa.setBorder(null);
        txtDireccionDeEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionDeEmpresaKeyTyped(evt);
            }
        });
        jPanel3.add(txtDireccionDeEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 289, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Direccion De Empresa");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        tblProveedores = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex,int colIndex) {
                return false;
            }
        };
        tblProveedores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProveedores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblProveedores.setFocusable(false);
        tblProveedores.setSelectionBackground(new java.awt.Color(51, 102, 255));
        tblProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProveedores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        MenuPrincipal obj = new MenuPrincipal();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_RegresarActionPerformed
    int x1, y1;
    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();

        this.setLocation(xx - x1, yy - y1);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x1 = evt.getX();
        y1 = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        BuscarProveedores();
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if (txtBuscar.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtEmpresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpresaKeyTyped
         char car = evt.getKeyChar();
        if (txtEmpresa.getText().length() >= 50) {
            evt.consume();
        }
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car < ' ' || car > ' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEmpresaKeyTyped

    private void txtTelefonoDeContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoDeContactoKeyTyped
        char car = evt.getKeyChar();
        if (txtTelefonoDeContacto.getText().length() >=9) {
            evt.consume();
        }
        if (car < '0' || car > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoDeContactoKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        if (txtNombreContacto.getText().equals("") || txtApellidoDeContacto.getText().equals("") || txtRUC.getText().equals("")
                || txtDireccionDeEmpresa.getText().equals("") || txtTelefonoDeContacto.getText().equals("") || txtEmpresa.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tiene que llenar Todos Los Campos");
        } else {
            try {
            PROVEEDORES ins=new PROVEEDORES();
            ins.setRUC(txtRUC.getText());
            ins.setNomEmpr(txtEmpresa.getText());
            ins.setNomCont(txtNombreContacto.getText());
            ins.setApeCont(txtApellidoDeContacto.getText());
            ins.setTelCont(txtTelefonoDeContacto.getText());
            ins.setDirEmp(txtDireccionDeEmpresa.getText());
            lpv.ionsertarproveedor(ins);
            listarProveedores();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Proveedor Registrado correctamente!!" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int row = tblProveedores.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "No Ha Selecionado Un Registro");
        } else {
            try {
             PROVEEDORES upd=new PROVEEDORES();
             upd.setIdproveedor(txtcodigo.getText());
             upd.setRUC(txtRUC.getText());
             upd.setNomEmpr(txtEmpresa.getText());
             upd.setNomCont(txtNombreContacto.getText());
             upd.setApeCont(txtApellidoDeContacto.getText());
             upd.setTelCont(txtTelefonoDeContacto.getText());
             upd.setDirEmp(txtDireccionDeEmpresa.getText());
             lpv.actualizarproveedor(upd);
             listarProveedores();
             
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int row = tblProveedores.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "No Ha Selecionado Un Registro");
        } else {
            try {
           PROVEEDORES del=new PROVEEDORES();
           del.setIdproveedor(txtcodigo.getText());
           lpv.eliminarproveedor(del);
            listarProveedores();
                    limpiar();
                
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Select2();
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedoresMouseClicked
        Select1();
        try{
        int row = tblProveedores.getSelectedRow();
        txtcodigo.setText(tblProveedores.getValueAt(row, 0).toString());
        txtRUC.setText(tblProveedores.getValueAt(row, 1).toString());
        txtEmpresa.setText(tblProveedores.getValueAt(row, 2).toString());
        txtNombreContacto.setText(tblProveedores.getValueAt(row, 3).toString());
        txtApellidoDeContacto.setText(tblProveedores.getValueAt(row, 4).toString());
        txtTelefonoDeContacto.setText(tblProveedores.getValueAt(row, 5).toString());
        txtDireccionDeEmpresa.setText(tblProveedores.getValueAt(row, 6).toString());
        }catch(Exception e){
        }
    }//GEN-LAST:event_tblProveedoresMouseClicked

    private void txtRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRUCKeyTyped
         char car = evt.getKeyChar();
        if (txtRUC.getText().length() >= 11) {
            evt.consume();
        }
        if (car < '0' || car > '9' ) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRUCKeyTyped

    private void txtNombreContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreContactoKeyTyped
        char car = evt.getKeyChar();
        if (txtNombreContacto.getText().length() >= 50) {
            evt.consume();
        }
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car < ' ' || car > ' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreContactoKeyTyped

    private void txtApellidoDeContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoDeContactoKeyTyped
         char car = evt.getKeyChar();
        if (txtApellidoDeContacto.getText().length() >= 50) {
            evt.consume();
        }
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car < ' ' || car > ' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoDeContactoKeyTyped

    private void txtDireccionDeEmpresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionDeEmpresaKeyTyped
         if (txtDireccionDeEmpresa.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionDeEmpresaKeyTyped

    private void txtNombreContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreContactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreContactoActionPerformed

    private void txtEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaActionPerformed

   
    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Regresar;
    private javax.swing.JToggleButton btnActualizar;
    private javax.swing.JToggleButton btnAgregar;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnEliminar;
    private javax.swing.JToggleButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable tblProveedores;
    private javax.swing.JTextField txtApellidoDeContacto;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDireccionDeEmpresa;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtNombreContacto;
    private javax.swing.JTextField txtRUC;
    private javax.swing.JTextField txtTelefonoDeContacto;
    private javax.swing.JLabel txtcodigo;
    // End of variables declaration//GEN-END:variables

    void Select1() {

        btnAgregar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }

    void Select2() {

        btnAgregar.setEnabled(true);
        btnNuevo.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }

    void editTabla() {
        tblProveedores.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblProveedores.getColumnModel().getColumn(1).setPreferredWidth(90);
        tblProveedores.getColumnModel().getColumn(2).setPreferredWidth(170);
        tblProveedores.getColumnModel().getColumn(3).setPreferredWidth(160);
        tblProveedores.getColumnModel().getColumn(4).setPreferredWidth(160);
        tblProveedores.getColumnModel().getColumn(5).setPreferredWidth(120);
        tblProveedores.getColumnModel().getColumn(6).setPreferredWidth(222);
        tblProveedores.getColumnModel().getColumn(0).setResizable(false);
        tblProveedores.getColumnModel().getColumn(1).setResizable(false);
        tblProveedores.getColumnModel().getColumn(2).setResizable(false);
        tblProveedores.getColumnModel().getColumn(3).setResizable(false);
        tblProveedores.getColumnModel().getColumn(4).setResizable(false);
        tblProveedores.getColumnModel().getColumn(5).setResizable(false);
        tblProveedores.getColumnModel().getColumn(6).setResizable(false);
    }

    void limpiar() {
        txtRUC.setText("");
        txtEmpresa.setText("");
        txtNombreContacto.setText("");
        txtApellidoDeContacto.setText("");
        txtTelefonoDeContacto.setText("");
        txtDireccionDeEmpresa.setText("");
    }
}
