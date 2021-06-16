package FORM;

import DATOS.CARGO;
import DATOS.EMPLEADOS;
import LOGICO.EFAC;
import LOGICO.IE;
import LOGICO.LCARGO;
import LOGICO.LEMPLEADO;
import LOGICO.conexion;
import com.sun.awt.AWTUtilities;
import com.toedter.calendar.JTextFieldDateEditor;
import LOGICO.EmpleadoFactory;
import static java.awt.Frame.NORMAL;
import java.awt.HeadlessException;
import java.awt.Shape;
import java.sql.SQLException;
import java.awt.geom.RoundRectangle2D;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public final class Empleados extends javax.swing.JFrame {
     
    EMPLEADOS temp=new EMPLEADOS();
    LEMPLEADO con=new LEMPLEADO();
    conexion  cone=new conexion();
    LCARGO car=new LCARGO();
    CARGO c=new CARGO();
    
      EmpleadoFactory empleadofactoria = new EmpleadoFactory(new LEMPLEADO());
      //EFAC fac = new EFAC(new LEMPLEADO() );

    public Empleados() {
       //this.setUndecorated(true);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../Iconos/cashier_icon-icons.com_53629.png")).getImage());
        this.setExtendedState(NORMAL);
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        AWTUtilities.setWindowShape(this, forma);
        listarEmpleado();
        listarTipo();
        noeditarcalendario();
        Select2();
        cboTipo.setSelectedItem("Seleccionar");
       
    }
       
     void listarTipo() {
       try {  car.consultarcargo();
             for (int i = 0; i < LCARGO.Lcarg.size(); i++) {
                c =(CARGO)LCARGO.Lcarg.get(i);
                this.cboTipo.addItem(c.getNombre());
                this.cboTipo.setSelectedIndex(c.getCodigo());
             }
        } catch (Exception ex) {
      }
    }
    
    void listarEmpleado() {
    DefaultTableModel tabla=new DefaultTableModel(); 
     try {  
            tabla.addColumn("Codigo");
            tabla.addColumn("DNI");
            tabla.addColumn("Nombre");
            tabla.addColumn("Apellido");
            tabla.addColumn("Genero");
            tabla.addColumn("Nacimiento");
            tabla.addColumn("Telefono");
            tabla.addColumn("Correo");
            tabla.addColumn("Direccion");
            tabla.addColumn("Usuario");
            tabla.addColumn("Contraseña");
            tabla.addColumn("tipo");
            cone.consulta("Select * from listarempleado");
            Object dato[] = new Object[12];
             while(cone.getRs().next()){
                for (int i = 0; i < 12; i++) {
                   dato[i] = cone.getRs().getString(i + 1);
                 //  System.out.println(cone.getRs().getString(i + 1));
                }
                tabla.addRow(dato);
             } this.tblEmpleados.setModel(tabla);
                    editTabla();
                } catch (Exception e) {
             //JOptionPane.showMessageDialog(this,"error en listar Empleado!.." + e.getMessage());
        }
    }

    void BuscarEmpleado() {
       DefaultTableModel tabla = new DefaultTableModel();
        try {

            tabla.addColumn("Codigo");
            tabla.addColumn("DNI");
            tabla.addColumn("Nombre");
            tabla.addColumn("Apellido");
            tabla.addColumn("Genero");
            tabla.addColumn("Nacimiento");
            tabla.addColumn("Telefono");
            tabla.addColumn("Correo");
            tabla.addColumn("Direccion");
            tabla.addColumn("Usuario");
            tabla.addColumn("Contraseña");
            tabla.addColumn("Tipo");
            String letra=txtBuscar.getText();
            cone.consulta("Select * from listarempleado\n" +
            "    WHERE ESTADO=1 \n" +
            "    AND (REGEXP_LIKE( LOWER(NOMBRE),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(APELLIDOS),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(DNI),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(USUARIO),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(GEN),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(CARGO),LOWER('"+letra+"+')))");
            Object dato[] = new Object[12];
             while(cone.getRs().next()){
                for (int i = 0; i < 12; i++) {
                    dato[i] = cone.getRs().getString(i + 1);
                }
                tabla.addRow(dato);
             } this.tblEmpleados.setModel(tabla);
                    editTabla();
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "error busE frm     " + e.getMessage());
        }
    }
    
    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        Regresar = new javax.swing.JToggleButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnAgregar = new javax.swing.JToggleButton();
        jSeparator13 = new javax.swing.JSeparator();
        btnActualizar = new javax.swing.JToggleButton();
        jSeparator14 = new javax.swing.JSeparator();
        btnEliminar = new javax.swing.JToggleButton();
        jSeparator15 = new javax.swing.JSeparator();
        btnCancelar = new javax.swing.JToggleButton();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        txtContraseña = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rdbMasculino = new javax.swing.JRadioButton();
        txtCorreo = new javax.swing.JTextField();
        rdbFemenino = new javax.swing.JRadioButton();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        txtDNI = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cboTipo = new javax.swing.JComboBox<>();
        jSeparator9 = new javax.swing.JSeparator();
        txtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtfecha = new com.toedter.calendar.JDateChooser();
        jSeparator3 = new javax.swing.JSeparator();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtBuscar = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema De Ventas Tienda");
        setMinimumSize(new java.awt.Dimension(1312, 690));
        setName("Proveedores"); // NOI18N
        setUndecorated(true);
        setOpacity(0.95F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

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

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 0, 0));
        jLabel13.setText("INGRESO DE EMPLEADOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(553, 553, 553))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Regresar)
                    .addComponent(jLabel13))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(20, 19, 32));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new_30px.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new_35px.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_property_30px.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_property_35px.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit_property_30px.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit_property_35px.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_document_30px.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_document_35px.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel_subscription_30px.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel_subscription_35px.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jSeparator16.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator1)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator5))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 262, -1, 60));

        jPanel5.setBackground(new java.awt.Color(20, 19, 32));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inicio Secion", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Century Gothic", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Usuario:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 32));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Contraseña:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(20, 19, 32));
        txtUsuario.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setBorder(null);
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        jPanel5.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 212, 30));

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 212, 10));

        txtContraseña.setBackground(new java.awt.Color(20, 19, 32));
        txtContraseña.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(255, 255, 255));
        txtContraseña.setBorder(null);
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyTyped(evt);
            }
        });
        jPanel5.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 212, 30));

        jSeparator11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 212, 10));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 350, 150));

        jPanel6.setBackground(new java.awt.Color(20, 19, 32));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS EMPLEADOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Century Gothic", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DNI:");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Correo:");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Genero:");

        rdbMasculino.setBackground(new java.awt.Color(20, 19, 32));
        buttonGroup1.add(rdbMasculino);
        rdbMasculino.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        rdbMasculino.setForeground(new java.awt.Color(255, 255, 255));
        rdbMasculino.setText("Masculino");

        txtCorreo.setBackground(new java.awt.Color(20, 19, 32));
        txtCorreo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.setBorder(null);
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        rdbFemenino.setBackground(new java.awt.Color(20, 19, 32));
        buttonGroup1.add(rdbFemenino);
        rdbFemenino.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        rdbFemenino.setForeground(new java.awt.Color(255, 255, 255));
        rdbFemenino.setSelected(true);
        rdbFemenino.setText("Femenino");
        rdbFemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbFemeninoActionPerformed(evt);
            }
        });

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));

        txtDNI.setBackground(new java.awt.Color(20, 19, 32));
        txtDNI.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtDNI.setForeground(new java.awt.Color(255, 255, 255));
        txtDNI.setBorder(null);
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));

        txtNombre.setBackground(new java.awt.Color(20, 19, 32));
        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(null);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Telefono:");

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));

        txtTelefono.setBackground(new java.awt.Color(20, 19, 32));
        txtTelefono.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setBorder(null);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Direccion:");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Cargo:");

        cboTipo.setBackground(new java.awt.Color(204, 255, 204));
        cboTipo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        cboTipo.setToolTipText("Selecciones Una Categoria");

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));

        txtDireccion.setBackground(new java.awt.Color(20, 19, 32));
        txtDireccion.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setBorder(null);
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha Nac:");

        txtfecha.setBackground(new java.awt.Color(20, 19, 32));
        txtfecha.setForeground(new java.awt.Color(255, 255, 255));
        txtfecha.setDateFormatString("dd-MM-yyyy");
        txtfecha.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtfecha.setMaxSelectableDate(new java.util.Date(253370786502000L));
        txtfecha.setMinSelectableDate(new java.util.Date(-62135747898000L));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));

        txtApellido.setBackground(new java.awt.Color(20, 19, 32));
        txtApellido.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido.setBorder(null);
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addComponent(txtfecha, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addGap(44, 44, 44))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(9, 9, 9)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(rdbMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(rdbFemenino, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jLabel12)
                .addGap(10, 10, 10)
                .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))))
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(rdbMasculino)
                    .addComponent(rdbFemenino)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 800, 230));

        jPanel4.setBackground(new java.awt.Color(20, 19, 32));

        tblEmpleados = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex,int colIndex) {
                return false;
            }
        };
        tblEmpleados.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblEmpleados.getTableHeader().setReorderingAllowed(false);
        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblEmpleados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblEmpleados.setFocusable(false);
        tblEmpleados.setSelectionBackground(new java.awt.Color(51, 102, 255));
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);
        tblEmpleados.getAccessibleContext().setAccessibleDescription("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_30px.png"))); // NOI18N

        txtBuscar.setBackground(new java.awt.Color(20, 19, 32));
        txtBuscar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(153, 153, 153));
        txtBuscar.setBorder(null);
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1)
                                .addGap(4, 4, 4)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(71, 71, 71)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 446, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        Select1();
        try {
            int row = tblEmpleados.getSelectedRow();
            txtCodigo.setText(tblEmpleados.getValueAt(row, 0).toString());
            txtDNI.setText(tblEmpleados.getValueAt(row, 1).toString());
            txtNombre.setText(tblEmpleados.getValueAt(row, 2).toString());
            txtApellido.setText(tblEmpleados.getValueAt(row, 3).toString());
           
            if (tblEmpleados.getValueAt(row, 4).toString().equals("femenino")) {
                 rdbFemenino.isSelected();
            } else {
                rdbMasculino.isSelected();
            }
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse((String) tblEmpleados.getValueAt(row, 5));
            txtfecha.setDate(date);
            txtTelefono.setText(tblEmpleados.getValueAt(row, 6).toString());
            txtCorreo.setText(tblEmpleados.getValueAt(row, 7).toString());
            txtDireccion.setText(tblEmpleados.getValueAt(row, 8).toString());
            txtUsuario.setText(tblEmpleados.getValueAt(row, 9).toString());
            txtContraseña.setText(tblEmpleados.getValueAt(row, 10).toString());
            cboTipo.setSelectedItem(tblEmpleados.getValueAt(row, 11).toString());
            } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "error     " + ex);
        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        MenuPrincipal obj = new MenuPrincipal();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_RegresarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        BuscarEmpleado();
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if (txtBuscar.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
      
      if (txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtContraseña.getText().equals("") 
                      || txtCorreo.getText().equals("") || txtDNI.getText().equals("")
                || txtDireccion.getText().equals("") || txtTelefono.getText().equals("") 
                      || txtUsuario.getText().equals("") || txtfecha.getDate() == (null)
                || cboTipo.getSelectedIndex()== 0) {
                JOptionPane.showMessageDialog(null, "Llene Todos Los Campos...");
        } else {
          try { 
                 String fechnc=((JTextField) txtfecha.getDateEditor().getUiComponent()).getText();
                 EMPLEADOS ins = new EMPLEADOS();
                 ins.setDNI(txtDNI.getText());
                 ins.setNombre(txtNombre.getText());
                 ins.setApellido(txtApellido.getText());
                if (rdbMasculino.isSelected()) {
                   ins.setGenero("Masculino");
                }else if (rdbFemenino.isSelected()) {
                    ins.setGenero("Femenino");
                }
                 ins.setNacimiento(fechnc);
                 ins.setTelefono(txtTelefono.getText());
                 ins.setCorreo(txtCorreo.getText());
                 ins.setDireccion(txtDireccion.getText());
                 ins.setUsuario(txtUsuario.getText());
                 ins.setContraseña(txtContraseña.getText());
                 ins.setIdcargo(cboTipo.getSelectedIndex());
                 //con.insertarempleado(ins);
                 empleadofactoria.insertarEmpleadoNuevo(ins);
                listarEmpleado();
            } catch (Exception e) {
                
                 Logger log = Logger.getLogger("MyLog");
                 log.warning("Error "+ JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, e.getMessage(), "Ingreso Doble", JOptionPane.ERROR_MESSAGE);
            }
      }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
     
        int row = tblEmpleados.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "No Ha Selecionado Un Registro");
        } else {
              int i= JOptionPane.showConfirmDialog(null, "Seguro de Eliminar Empleado?");
            if(i==0){
                try {
                 EMPLEADOS delE=new EMPLEADOS();
                 delE.setCodigo(txtCodigo.getText());
                 delE.setUsuario(txtUsuario.getText());
                // con.eliminarempleados(delE);
                //
                //
                empleadofactoria.eliminarEmpleadoNuevo(delE);
                
                 listarEmpleado();
                 limpiar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Eliminacion", JOptionPane.ERROR_MESSAGE);
            }
            
            }else {
                  JOptionPane.showMessageDialog(this, "No se elimino");
                  listarEmpleado();
                 limpiar();
        }
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
     limpiar();
     Select2();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
     
        int row = tblEmpleados.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "No Ha Selecionado Un Registro");
        } else {
            try {
                 String fechnc=((JTextField) txtfecha.getDateEditor().getUiComponent()).getText();
                 EMPLEADOS upd = new EMPLEADOS();
                 upd.setCodigo(txtCodigo.getText());
                 upd.setDNI(txtDNI.getText());
                 upd.setNombre(txtNombre.getText());
                 upd.setApellido(txtApellido.getText());
                  if (rdbMasculino.isSelected()) {
                   upd.setGenero("Masculino");
                } else if (rdbFemenino.isSelected()) {
                    upd.setGenero("Femenino");
                }
                 upd.setNacimiento(fechnc);
                 upd.setTelefono(txtTelefono.getText());
                 upd.setCorreo(txtCorreo.getText());
                 upd.setDireccion(txtDireccion.getText());
                 upd.setUsuario(txtUsuario.getText());
                 upd.setContraseña(txtContraseña.getText());
                 upd.setIdcargo(cboTipo.getSelectedIndex());
                 /*
                 REFACTORIZADO EL DIA 5/05/2021
                 SE HIZO LA IMPLEMENTACIÓN DE UNA INTERFACE
                 EMPLEADOFACTORY
                 */
                 
               empleadofactoria.actualizarEmpleadoNuevo(upd);
            
                listarEmpleado();
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Producto Modificado Correctamente" + ex.getMessage());
            }
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       
    }//GEN-LAST:event_formWindowActivated

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char car = evt.getKeyChar();
        if (txtNombre.getText().length() >= 50) {
            evt.consume();
        }
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car < ' ' || car > ' ') && (car < 46 || car > 46)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        char car = evt.getKeyChar();
        if (txtApellido.getText().length() >= 50) {
            evt.consume();
        }
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car < ' ' || car > ' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        char car = evt.getKeyChar();
        if (txtDNI.getText().length() >= 8) {
            evt.consume();
        }
        if (car < '0' || car > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtDNIKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char t = evt.getKeyChar();
        if (txtTelefono.getText().length() >= 9) {
            evt.consume();
        }
        if (t < '0' || t > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        if (txtCorreo.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        if (txtUsuario.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        if (txtDireccion.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyTyped
        if (txtContraseña.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtContraseñaKeyTyped

    private void rdbFemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbFemeninoActionPerformed
        
    }//GEN-LAST:event_rdbFemeninoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
       
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new Empleados().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Regresar;
    private javax.swing.JToggleButton btnActualizar;
    private javax.swing.JToggleButton btnAgregar;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnEliminar;
    private javax.swing.JToggleButton btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JRadioButton rdbFemenino;
    private javax.swing.JRadioButton rdbMasculino;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JLabel txtCodigo;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    private com.toedter.calendar.JDateChooser txtfecha;
    // End of variables declaration//GEN-END:variables
    
    void editTabla() {
        tblEmpleados.getColumnModel().getColumn(0).setPreferredWidth(75);
        tblEmpleados.getColumnModel().getColumn(1).setPreferredWidth(75);
        tblEmpleados.getColumnModel().getColumn(2).setPreferredWidth(140);
        tblEmpleados.getColumnModel().getColumn(3).setPreferredWidth(140);
        tblEmpleados.getColumnModel().getColumn(4).setPreferredWidth(75);
        tblEmpleados.getColumnModel().getColumn(5).setPreferredWidth(75);
        tblEmpleados.getColumnModel().getColumn(6).setPreferredWidth(75);
        tblEmpleados.getColumnModel().getColumn(7).setPreferredWidth(180);
        tblEmpleados.getColumnModel().getColumn(8).setPreferredWidth(180);
        tblEmpleados.getColumnModel().getColumn(9).setPreferredWidth(85);
        tblEmpleados.getColumnModel().getColumn(10).setPreferredWidth(85);
        tblEmpleados.getColumnModel().getColumn(11).setPreferredWidth(108);
        tblEmpleados.getColumnModel().getColumn(0).setResizable(false);
        tblEmpleados.getColumnModel().getColumn(1).setResizable(false);
        tblEmpleados.getColumnModel().getColumn(2).setResizable(false);
        tblEmpleados.getColumnModel().getColumn(3).setResizable(false);
        tblEmpleados.getColumnModel().getColumn(4).setResizable(false);
        tblEmpleados.getColumnModel().getColumn(5).setResizable(false);
        tblEmpleados.getColumnModel().getColumn(6).setResizable(false);
        tblEmpleados.getColumnModel().getColumn(7).setResizable(false);
        tblEmpleados.getColumnModel().getColumn(8).setResizable(false);
        tblEmpleados.getColumnModel().getColumn(9).setResizable(false);
        tblEmpleados.getColumnModel().getColumn(10).setResizable(false);
        tblEmpleados.getColumnModel().getColumn(11).setResizable(false);
    }

    void noeditarcalendario() {
        JTextFieldDateEditor editor = (JTextFieldDateEditor) txtfecha.getDateEditor();
        editor.setEditable(false);
    }

    void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtContraseña.setText("");
        txtCorreo.setText("");
        txtDNI.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtUsuario.setText("");
        txtfecha.setDate(null);
        cboTipo.setSelectedItem("Seleccionar");
        buttonGroup1.clearSelection();
    }

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
    
   
}
