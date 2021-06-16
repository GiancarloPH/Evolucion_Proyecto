package FORM;


import DATOS.CLIENTES;
import DATOS.DETALLEVENTA;
import DATOS.LOGIN;
import DATOS.VENTAS;
import LOGICO.LCLIENTES;
import LOGICO.LVENTAS;
import LOGICO.conexion;
import com.sun.awt.AWTUtilities;
import com.toedter.calendar.JTextFieldDateEditor;
import LOGICO.VentasFactory;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

public class Ventas extends javax.swing.JFrame {
    
    DefaultTableModel model = new DefaultTableModel();
    conexion cone=new conexion();
    CLIENTES c= new CLIENTES();
    LCLIENTES lc=new LCLIENTES();
    VENTAS vnt= new VENTAS();
    LVENTAS lv=new LVENTAS();
    
    VentasFactory vfactory = new VentasFactory(new LVENTAS());
    
    public Ventas() {
        this.setUndecorated(true);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../Iconos/cashier_icon-icons.com_53629.png")).getImage());
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
        AWTUtilities.setWindowShape(this, forma);
        PanleAgregarCliente.setVisible(false);
            PANELSELECC.setVisible(false);
        listarProducto();
        listarCliente();
        llenartabla();
        calculatTotal();
        noeditarcalendario();
    }
//listar  clientes
    void listarCliente() {
        txtCodigoEmpleado.setVisible(false);
        txtCodigoProducto.setVisible(false);
        txtCliente.setVisible(false);
        txtPrecio.setVisible(false);
        txtCodCliente.setVisible(false);
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            tabla.addColumn("Codigo");
            tabla.addColumn("Nombre");
            tabla.addColumn("Apellido");
            tabla.addColumn("Nacimiento");
            tabla.addColumn("DNI");
        lc.consultar();
        /*
        INTERFAZ EL DIA 5/5/2021 
        AUTORES: EQUIPO DE EVOLUCION
        */

            Object dato[] = new Object[7];
           for (int i = 0; i < LCLIENTES.LCLI.size(); i++) {
                c =(CLIENTES)LCLIENTES.LCLI.get(i);
                 dato[0] = c.getIDCLIENTE();
                 dato[1] = c.getNOMBRE();
                 dato[2] = c.getAPELLIDO();
                 dato[3] = c.getNACIMIENTO();
                 dato[4] = c.getDNI();
                   tabla.addRow(dato);
             }
            this.tblCliente.setModel(tabla);
            // editTabla();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "error     " + e);
        }
    }
//filtrado de la informacion de los clientes
    void BuscarCliente() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {

            tabla.addColumn("Codigo");
            tabla.addColumn("Nombre");
            tabla.addColumn("Apellido");
            tabla.addColumn("Nacimiento");
            tabla.addColumn("DNI");
            String letra=txtBuscarClientes.getText();
            cone.consulta("  Select * from listarcliente\n" +
            "    WHERE ESTADO=1 \n" +
            "    AND (REGEXP_LIKE( LOWER(nm),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(ap),LOWER('"+letra+"+'))\n" +
            "    OR REGEXP_LIKE( LOWER(dn),LOWER('"+letra+"+')))");
             Object dato[] = new Object[5];
             while(cone.getRs().next()){
                for (int i = 0; i < 5; i++) {
                    dato[i] = cone.getRs().getString(i + 1);
                }
                tabla.addRow(dato);
             } 
            this.tblCliente.setModel(tabla);
            // editTabla();
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
            // editTabla();
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
            // editTabla();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "error     " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Regresar = new javax.swing.JToggleButton();
        txtCodigoComprobante = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        PANELSELECC = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtApellido1 = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        txtNombre1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        PanleAgregarCliente = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFechaNac = new com.toedter.calendar.JDateChooser();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        jToggleButton2 = new javax.swing.JToggleButton();
        jSeparator4 = new javax.swing.JSeparator();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        Regresar1 = new javax.swing.JToggleButton();
        btnNuevo1 = new javax.swing.JToggleButton();
        jSeparator17 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        txtBuscarProductos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtcodigo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        panelcli = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        txtBuscarClientes = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jSeparator15 = new javax.swing.JSeparator();
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
        txtCantidad1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtCodigoProducto = new javax.swing.JLabel();
        txtCliente = new javax.swing.JLabel();
        txtImporteTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnGeneraCompra = new javax.swing.JToggleButton();
        jSeparator3 = new javax.swing.JSeparator();
        txtPrecio = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JLabel();
        txtCodigoEmpleado = new javax.swing.JLabel();
        txtStock = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema De Ventas Tienda");
        setMinimumSize(new java.awt.Dimension(1312, 709));
        setUndecorated(true);
        setOpacity(0.95F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
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

        txtCodigoComprobante.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 0, 0));
        jLabel14.setText("VENTAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Regresar)
                .addGap(352, 352, 352)
                .addComponent(txtCodigoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jLabel14)
                .addContainerGap(634, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Regresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtCodigoComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 30));

        jPanel2.setBackground(new java.awt.Color(20, 19, 32));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProductos = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex,int colIndex) {
                return false;
            }
        };
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProductos);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 108, 600, 150));

        PANELSELECC.setBackground(new java.awt.Color(20, 19, 32));
        PANELSELECC.setForeground(new java.awt.Color(255, 255, 255));
        PANELSELECC.setFocusable(false);

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 204, 0));
        jLabel15.setText("Cliente Seleccionado");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Apellido");

        txtApellido1.setEditable(false);
        txtApellido1.setBackground(new java.awt.Color(20, 19, 32));
        txtApellido1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtApellido1.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido1.setBorder(null);

        txtNombre1.setEditable(false);
        txtNombre1.setBackground(new java.awt.Color(20, 19, 32));
        txtNombre1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombre1.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre1.setBorder(null);

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nombre");

        javax.swing.GroupLayout PANELSELECCLayout = new javax.swing.GroupLayout(PANELSELECC);
        PANELSELECC.setLayout(PANELSELECCLayout);
        PANELSELECCLayout.setHorizontalGroup(
            PANELSELECCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANELSELECCLayout.createSequentialGroup()
                .addGroup(PANELSELECCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANELSELECCLayout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel15))
                    .addGroup(PANELSELECCLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel17)
                        .addGap(12, 12, 12)
                        .addGroup(PANELSELECCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator8)
                            .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PANELSELECCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        PANELSELECCLayout.setVerticalGroup(
            PANELSELECCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANELSELECCLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel15)
                .addGap(42, 42, 42)
                .addGroup(PANELSELECCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PANELSELECCLayout.createSequentialGroup()
                        .addGroup(PANELSELECCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PANELSELECCLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel17))
                            .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PANELSELECCLayout.createSequentialGroup()
                        .addGroup(PANELSELECCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jPanel2.add(PANELSELECC, new org.netbeans.lib.awtextra.AbsoluteConstraints(664, 10, 640, 260));

        PanleAgregarCliente.setBackground(new java.awt.Color(20, 19, 32));
        PanleAgregarCliente.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Apellido");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DNI");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("cumpleaños");

        txtFechaNac.setBackground(new java.awt.Color(20, 19, 32));
        txtFechaNac.setForeground(new java.awt.Color(255, 255, 255));
        txtFechaNac.setDateFormatString("dd-MM-yyyy");

        txtApellido.setBackground(new java.awt.Color(20, 19, 32));
        txtApellido.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido.setBorder(null);
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        txtNombre.setBackground(new java.awt.Color(20, 19, 32));
        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(null);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtDNI.setBackground(new java.awt.Color(20, 19, 32));
        txtDNI.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDNI.setForeground(new java.awt.Color(255, 255, 255));
        txtDNI.setBorder(null);
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });

        jToggleButton2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_document_30px.png"))); // NOI18N
        jToggleButton2.setText("Eliminar");
        jToggleButton2.setContentAreaFilled(false);
        jToggleButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_document_35px.png"))); // NOI18N
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jToggleButton3.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_property_30px.png"))); // NOI18N
        jToggleButton3.setText("Guardar");
        jToggleButton3.setContentAreaFilled(false);
        jToggleButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_property_35px.png"))); // NOI18N
        jToggleButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton3MouseClicked(evt);
            }
        });
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jToggleButton4.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit_property_30px.png"))); // NOI18N
        jToggleButton4.setText("Actualizar");
        jToggleButton4.setContentAreaFilled(false);
        jToggleButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit_property_35px.png"))); // NOI18N
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Agregar Cliente");

        Regresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back_30px.png"))); // NOI18N
        Regresar1.setBorder(null);
        Regresar1.setContentAreaFilled(false);
        Regresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Regresar1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back_35px.png"))); // NOI18N
        Regresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Regresar1ActionPerformed(evt);
            }
        });

        btnNuevo1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnNuevo1.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new_30px.png"))); // NOI18N
        btnNuevo1.setText("Nuevo");
        btnNuevo1.setContentAreaFilled(false);
        btnNuevo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNuevo1.setIconTextGap(20);
        btnNuevo1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new_35px.png"))); // NOI18N
        btnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo1ActionPerformed(evt);
            }
        });

        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout PanleAgregarClienteLayout = new javax.swing.GroupLayout(PanleAgregarCliente);
        PanleAgregarCliente.setLayout(PanleAgregarClienteLayout);
        PanleAgregarClienteLayout.setHorizontalGroup(
            PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanleAgregarClienteLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(12, 12, 12)
                                .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator4)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanleAgregarClienteLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel9)
                                .addGap(12, 12, 12)
                                .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator13)
                                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2))))
                    .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                        .addComponent(Regresar1)
                        .addGap(222, 222, 222)
                        .addComponent(jLabel11))
                    .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                        .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        PanleAgregarClienteLayout.setVerticalGroup(
            PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                        .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanleAgregarClienteLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Regresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                                .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel7))
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                                .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel9))
                            .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addComponent(txtFechaNac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanleAgregarClienteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jToggleButton3)
                                    .addComponent(jToggleButton4, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(PanleAgregarClienteLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanleAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jToggleButton2)
                                        .addComponent(btnNuevo1))
                                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel2.add(PanleAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 630, 260));

        jPanel6.setBackground(new java.awt.Color(20, 19, 32));

        txtBuscarProductos.setBackground(new java.awt.Color(20, 19, 32));
        txtBuscarProductos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtBuscarProductos.setForeground(new java.awt.Color(153, 153, 153));
        txtBuscarProductos.setBorder(null);
        txtBuscarProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarProductosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarProductosKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_30px.png"))); // NOI18N

        jLabel12.setBackground(new java.awt.Color(255, 204, 0));
        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 204, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Productos");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator7)
                            .addComponent(txtBuscarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(txtcodigo)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(158, 158, 158))))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtcodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtBuscarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 2, 520, 100));

        panelcli.setBackground(new java.awt.Color(20, 19, 32));

        tblCliente = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex,int colIndex) {
                return false;
            }
        };
        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCliente.setOpaque(false);
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCliente);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search_30px.png"))); // NOI18N

        txtBuscarClientes.setBackground(new java.awt.Color(20, 19, 32));
        txtBuscarClientes.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtBuscarClientes.setForeground(new java.awt.Color(153, 153, 153));
        txtBuscarClientes.setBorder(null);
        txtBuscarClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarClientesKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarClientesKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 204, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Clientes");

        jToggleButton1.setBackground(new java.awt.Color(20, 19, 32));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_30px.png"))); // NOI18N
        jToggleButton1.setContentAreaFilled(false);
        jToggleButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_35px.png"))); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout panelcliLayout = new javax.swing.GroupLayout(panelcli);
        panelcli.setLayout(panelcliLayout);
        panelcliLayout.setHorizontalGroup(
            panelcliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelcliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelcliLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelcliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelcliLayout.createSequentialGroup()
                                .addComponent(txtBuscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelcliLayout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelcliLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelcliLayout.setVerticalGroup(
            panelcliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcliLayout.createSequentialGroup()
                .addGroup(panelcliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelcliLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelcliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelcliLayout.createSequentialGroup()
                                .addGroup(panelcliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtBuscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jToggleButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelcliLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.add(panelcli, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 640, 280));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1310, 280));

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
        jPanel4.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 140, -1));

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
        jPanel4.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 140, -1));

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
        jPanel4.add(btnAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 130, -1));

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
        jPanel4.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 200, 30));
        jPanel4.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 200, 20));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad A Vender:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        txtCantidad.setBackground(new java.awt.Color(6, 3, 9));
        txtCantidad.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(153, 153, 153));
        txtCantidad.setBorder(null);
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        jPanel4.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 160, 20));
        jPanel4.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 160, 20));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Producto");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 11, 40));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 11, 40));

        txtCantidad1.setBackground(new java.awt.Color(6, 3, 9));
        txtCantidad1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtCantidad1.setBorder(null);
        txtCantidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidad1ActionPerformed(evt);
            }
        });
        txtCantidad1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidad1KeyTyped(evt);
            }
        });
        jPanel4.add(txtCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 70, 20));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 1310, 80));

        tblVenta = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex,int colIndex) {
                return false;
            }
        };
        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblVenta);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 1310, 240));

        jPanel5.setBackground(new java.awt.Color(20, 19, 32));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigoProducto.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txtCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));
        jPanel5.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));

        txtImporteTotal.setEditable(false);
        txtImporteTotal.setBackground(new java.awt.Color(6, 3, 9));
        txtImporteTotal.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtImporteTotal.setForeground(new java.awt.Color(51, 255, 0));
        txtImporteTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtImporteTotal.setBorder(null);
        jPanel5.add(txtImporteTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 50, 140, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Importe Total");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 30, -1, 20));

        btnGeneraCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnGeneraCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/sale_30px.png"))); // NOI18N
        btnGeneraCompra.setText("Generar Venta");
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
        jPanel5.add(btnGeneraCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 40, 140, 40));
        jPanel5.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 70, 140, 10));
        jPanel5.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, -1, -1));
        jPanel5.add(txtCodCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));
        jPanel5.add(txtCodigoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));
        jPanel5.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 1310, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        MenuPrincipal obj = new MenuPrincipal();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_RegresarActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();

        this.setLocation(xx - x1, yy - y1);
    }//GEN-LAST:event_jPanel1MouseDragged
    int x1, y1;
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed

        x1 = evt.getX();
        y1 = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed

        if (tblVenta.getSelectedRow() != -1) {
            model.removeRow(tblVenta.getSelectedRow());
            calculatTotal();
        } else {
            JOptionPane.showMessageDialog(null, "No has selecionado un registro...");
        }

    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo();
         paneles();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAñadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirMouseClicked
        try {
            int cant= Integer.parseInt(txtCantidad.getText());
            int stock = Integer.parseInt(txtStock.getText());
            
            if (stock == 0  || cant>= stock) {
                JOptionPane.showMessageDialog(this, "Producto agotado o supera cantidad de stock");
                 paneles();
            } else {
                if (txtCodCliente.getText().equals("") || txtCodigoProducto.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "No Ha Selecionado Un Cliente o Un Producto...");
                     paneles();
                } else if (txtCantidad.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "No Ha Ingresando Una Cantidad A vender...");
                     paneles();
                    
                } else {

                    model = (DefaultTableModel) tblVenta.getModel();
                    String codClie = txtCodCliente.getText();
                    String codproducto = txtCodigoProducto.getText();
                    String Cliente = txtCliente.getText();
                    String producto = txtProducto.getText();
                    int Cant = Integer.parseInt(txtCantidad.getText());
                    double pre = Double.parseDouble(txtPrecio.getText());
                    double total = Cant * pre;
                    ArrayList lista = new ArrayList();
                    lista.add(codproducto);
                    lista.add(codClie);
                    lista.add(Cliente);
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
                    tblVenta.setModel(model);
                    calculatTotal();
                }
            }
        } catch (Exception ex) {
           // JOptionPane.showMessageDialog(this, "error" + ex.getMessage());
        }
    }//GEN-LAST:event_btnAñadirMouseClicked

    private void txtProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyTyped
        if (txtProducto.getText().length() >= 49) {
            evt.consume();
        }
    }//GEN-LAST:event_txtProductoKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
         char car = evt.getKeyChar();
        if (txtCantidad.getText().length() >= 5) {
            evt.consume();
        }
          if ((car < '0' || car > '9')){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void btnGeneraCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGeneraCompraMouseClicked

        try {

            if (tblVenta.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No Ha Añadido Un Producto A La lista...");
            } else {
                String cod="";
                try {
                    VENTAS comp= new VENTAS();
                    comp.setIdEmpleado(txtCodigoEmpleado.getText());
                    comp.setImportTotal(Float.parseFloat(txtImporteTotal.getText()));
                   
                    comp.setIdCliente(txtCodCliente.getText());
                   
                   // lv.insertarventa(comp);
                   /*
                   INTERFAZ EL DIA 5/5/2021 
                   AUTORES: EQUIPO DE EVOLUCION
                   */
                   vfactory.insertarVentaNuevo(comp);
                   
               } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error en generar venta " + ex.getMessage());
                     paneles();
                }
                for(int i = 0; i < tblVenta.getRowCount(); i++) {
                    String idp = tblVenta.getValueAt(i,0).toString();
                    int cant = Integer.parseInt(tblVenta.getValueAt(i, 4).toString());
                    Float pre = Float.parseFloat(tblVenta.getValueAt(i, 5).toString());
                    try { 
                         cone.consulta("select idventa from VENTAS \n" +
                         "where idventa in(select max(idventa) from VENTAS)");
                          while (cone.getRs().next()) {
                          cod= cone.getRs().getString(1);
                         }
                        DETALLEVENTA dcomp = new DETALLEVENTA();
                        dcomp.setIdVenta(cod);
                        dcomp.setIdProducto(idp);
                        dcomp.setCantidad(cant);
                        dcomp.setPrecio(pre);
                     //   lv.insertardetVENTA(dcomp);
                     /*
                     INTERFAZ EL DIA 5/5/2021 
                     AUTORES: EQUIPO DE EVOLUCION
                     */
                     vfactory.insertardetVentaNuevo(dcomp);
               } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error en generar detventa " + ex.getMessage());
                         paneles();
                    }
                }
                calculatTotal();
                JOptionPane.showMessageDialog(this, "Se Realizo con Exito");
                panelcli.setVisible(true);
                nuevo();
                listarProducto();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_btnGeneraCompraMouseClicked

    private void txtBuscarProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductosKeyPressed
        buscarProducto();
    }//GEN-LAST:event_txtBuscarProductosKeyPressed

    private void txtBuscarProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductosKeyTyped
        if (txtBuscarProductos.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarProductosKeyTyped

    private void txtBuscarClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClientesKeyPressed

        BuscarCliente();
    }//GEN-LAST:event_txtBuscarClientesKeyPressed

    private void txtBuscarClientesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClientesKeyTyped
        if (txtBuscarClientes.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarClientesKeyTyped
   LOGIN log=new LOGIN();
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        txtCodigoEmpleado.setText(String.valueOf(log.getCodigo()));

    }//GEN-LAST:event_formWindowActivated

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        if (PanleAgregarCliente.isVisible()) {
            PanleAgregarCliente.setVisible(false);
            panelcli.setVisible(true);

        } else {

            panelcli.setVisible(false);
            PanleAgregarCliente.setVisible(true);

        }


    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
       
        int row = tblProductos.rowAtPoint(evt.getPoint());

        txtCodigoProducto.setText(tblProductos.getValueAt(row, 0).toString());
        txtProducto.setText(tblProductos.getValueAt(row, 1).toString());
        txtPrecio.setText(tblProductos.getValueAt(row, 3).toString());
        txtStock.setText(tblProductos.getValueAt(row, 4).toString());
        
        
    }//GEN-LAST:event_tblProductosMouseClicked

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        int row = tblCliente.rowAtPoint(evt.getPoint());
        txtCodCliente.setText(tblCliente.getValueAt(row, 0).toString());
        txtCliente.setText(tblCliente.getValueAt(row, 1).toString());
        txtNombre1.setText(tblCliente.getValueAt(row, 1).toString());
        txtApellido1.setText(tblCliente.getValueAt(row, 2).toString());
        txtNombre.setText(tblCliente.getValueAt(row, 1).toString()); 
        txtApellido.setText(tblCliente.getValueAt(row, 2).toString());
        txtDNI.setText(tblCliente.getValueAt(row, 4).toString());
//        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(tblCliente.getValueAt(row, 3).toString());

       // txtFechaNac.setDate(date);
    //    
    }//GEN-LAST:event_tblClienteMouseClicked

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        PANELSELECC.setVisible(true);   
        PanleAgregarCliente.setVisible(false);
            panelcli.setVisible(false);
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void Regresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regresar1ActionPerformed
        PanleAgregarCliente.setVisible(false);
        panelcli.setVisible(true);
    }//GEN-LAST:event_Regresar1ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton3MouseClicked
        try {
            String fechnc=((JTextField) txtFechaNac.getDateEditor().getUiComponent()).getText();
          CLIENTES ins=new CLIENTES();
          ins.setNOMBRE(txtNombre.getText());
          ins.setAPELLIDO(txtApellido.getText());
          ins.setNACIMIENTO(fechnc);
          ins.setDNI(txtDNI.getText());
          lc.insertarcli(ins);
          listarCliente();
          limpiar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Ingreso Doble", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jToggleButton3MouseClicked

    private void btnGeneraCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneraCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGeneraCompraActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        
        int row = tblCliente.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "No Ha Selecionado Un Registro");
        }else {
              int i= JOptionPane.showConfirmDialog(null, "Seguro de Eliminar Cliente?");
            if(i==0){
                try {
                 CLIENTES delc=new CLIENTES();
                 delc.setIDCLIENTE(txtCodCliente.getText());
                 lc.eliminarcliente(delc);
                 listarCliente();
                 limpiar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Eliminacion", JOptionPane.ERROR_MESSAGE);
            }
            
            }else {
                  JOptionPane.showMessageDialog(this, "No se elimino");
                   listarCliente();
                   limpiarTabla();
        }
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        limpiar();
    }//GEN-LAST:event_btnNuevo1ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
      int row = tblCliente.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "No Ha Selecionado Un Registro");
        } else {
            try {
               String fechnc=((JTextField) txtFechaNac.getDateEditor().getUiComponent()).getText();
                 CLIENTES upd = new CLIENTES();
                 upd.setIDCLIENTE(txtCodCliente.getText());
                 upd.setNOMBRE(txtNombre.getText());
                 upd.setAPELLIDO(txtApellido.getText());
                 upd.setNACIMIENTO(fechnc);
                 upd.setDNI(txtDNI.getText());
                
                lc.actualizarcli(upd);
                listarCliente();
                limpiar();
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Producto Modificado Correctamente" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
     char car = evt.getKeyChar();
        if (txtDNI.getText().length() >= 8) {
            evt.consume();
        }
        if (car < '0' || car > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtDNIKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
      char car = evt.getKeyChar();
        if (txtNombre.getText().length() >= 50) {
            evt.consume();
        }
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car < ' ' || car > ' ') ) {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        char car = evt.getKeyChar();
        if (txtApellido.getText().length() >= 50) {
            evt.consume();
        }
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car < ' ' || car > ' ') ) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtCantidad1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidad1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidad1KeyTyped

    private void txtCantidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidad1ActionPerformed

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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PANELSELECC;
    private javax.swing.JPanel PanleAgregarCliente;
    private javax.swing.JToggleButton Regresar;
    private javax.swing.JToggleButton Regresar1;
    private javax.swing.JToggleButton btnAñadir;
    private javax.swing.JToggleButton btnGeneraCompra;
    private javax.swing.JToggleButton btnNuevo;
    private javax.swing.JToggleButton btnNuevo1;
    private javax.swing.JToggleButton btnQuitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JPanel panelcli;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblVenta;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtBuscarClientes;
    private javax.swing.JTextField txtBuscarProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidad1;
    private javax.swing.JLabel txtCliente;
    private javax.swing.JLabel txtCodCliente;
    private javax.swing.JLabel txtCodigoComprobante;
    private javax.swing.JLabel txtCodigoEmpleado;
    private javax.swing.JLabel txtCodigoProducto;
    private javax.swing.JTextField txtDNI;
    private com.toedter.calendar.JDateChooser txtFechaNac;
    private javax.swing.JTextField txtImporteTotal;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JLabel txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JLabel txtStock;
    private javax.swing.JLabel txtcodigo;
    // End of variables declaration//GEN-END:variables
    private void llenartabla() {
        model.addColumn("CodPro");
        model.addColumn("CodCli");
        model.addColumn("Cliente");
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        model.addColumn("Total");
        tblVenta.setModel(model);
    }

    void validar() {
        for (int i = 0; i < tblVenta.getRowCount(); i++) {

            if (tblVenta.getValueAt(i, 0).equals(txtCodigoProducto.getText())) {
                JOptionPane.showMessageDialog(null, "El producto  '" + txtProducto.getText() + "'  Ya Esta Añadido A La Lista...");
                model.removeRow(i);
            }
            
        }
     
               
    }
    void paneles(){
        panelcli.setVisible(true);
                PANELSELECC.setVisible(false);
    }
    void calculatTotal() {
        try {
            double tpagar = 0;
            for (int i = 0; i < tblVenta.getRowCount(); i++) {
                float cant = Float.parseFloat(String.valueOf(tblVenta.getValueAt(i, 4)));
                double pre = Double.parseDouble(String.valueOf(tblVenta.getValueAt(i, 5)));
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

    void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDNI.setText("");
        txtFechaNac.setDate(null);
    }
    void nuevo() {
        limpiarTabla();
        calculatTotal();
        txtProducto.setText("");
        txtCantidad.setText("");
        txtCodigoProducto.setText("");
        txtCodCliente.setText("");
        txtCantidad.requestFocus();
    }

        void noeditarcalendario() {
        JTextFieldDateEditor editor = (JTextFieldDateEditor) txtFechaNac.getDateEditor();
        editor.setEditable(false);
    }
}
