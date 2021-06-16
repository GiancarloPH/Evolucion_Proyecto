package FORM;
 
import DATOS.CATEGORIA;
import DATOS.PRODUCTOS;
import LOGICO.LCATEGORIA;
import LOGICO.LPRODUCTOS;
import LOGICO.conexion;
//import com.sun.awt.AWTUtilities;
import LOGICO.CategoriaFactory;
import LOGICO.ProductoFactory;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Productos extends javax.swing.JFrame {
      PRODUCTOS tempro=new PRODUCTOS();
      LPRODUCTOS p=new LPRODUCTOS();
      CATEGORIA cat=new CATEGORIA();
      LCATEGORIA c=new LCATEGORIA();
      conexion cone=new conexion();
      
      ProductoFactory pfactory = new ProductoFactory(new LPRODUCTOS());
      CategoriaFactory cfactory = new CategoriaFactory(new LCATEGORIA());
      
       void listarTipo() {
       try {
             c.consultarcategoria();
             /*
             INTERFAZ EL DIA 5/5/2021 
             AUTORES: EQUIPO DE EVOLUCION
             */
             /*cfactory.consultarCategoriaNuevo();*/
             
             for (int i = 0; i < LCATEGORIA.LCT.size(); i++) {
                 cat =(CATEGORIA)LCATEGORIA.LCT.get(i);
                 cboCategoria.addItem(cat.getNombre());
                 cboCategoria.setSelectedIndex(cat.getCodigo()); 
             }
        } catch (Exception ex) {
      }
    }
       
      void listarProducto() {
          txtcodigo.setVisible(false);
          txtStock.setVisible(false);
          txtCodigoCate.setVisible(false);
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
          JOptionPane.showMessageDialog(null, "error tablaPRODUC   " + e);
        }
    }

    public Productos() {
        this.setUndecorated(true);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../Iconos/cashier_icon-icons.com_53629.png")).getImage());
       this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15, 15);
    //    AWTUtilities.setWindowShape(this, forma);
        listarProducto();
        listarTipo();
        Select2();
        limpiar();
        PanelCategoria.setVisible(false);
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
            String letra=txtBuscar.getText();
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
        txtcodigo = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtStock = new javax.swing.JLabel();
        txtCodigoCate = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        PanelCategoria = new javax.swing.JPanel();
        txtNombreCategoria = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAgregarCategoria = new javax.swing.JToggleButton();
        btnEliminarCategoria = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtPrecioUnit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox<>();
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
        btnAgregarUnaNuevaCategoria = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema De Ventas Tienda");
        setMinimumSize(new java.awt.Dimension(1312, 690));
        setUndecorated(true);
        setOpacity(0.95F);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
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

        txtcodigo.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 0, 0));
        jLabel13.setText("INGRESO DE PRODUCTOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Regresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 533, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(248, 248, 248)
                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Regresar))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 30));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        txtCodigoCate.setBackground(new java.awt.Color(51, 51, 51));
        txtCodigoCate.setForeground(new java.awt.Color(255, 0, 255));
        txtCodigoCate.setOpaque(true);

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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                        .addComponent(txtStock)
                        .addGap(58, 58, 58))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoCate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtStock))
                                .addGap(0, 8, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodigoCate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, -1));

        tblProductos = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex,int colIndex) {
                return false;
            }
        };
        tblProductos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblProductos.getTableHeader().setReorderingAllowed(false);
        //tblProductos.setColumnSelectionAllowed(true);
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblProductos.setFocusable(false);
        tblProductos.setSelectionBackground(new java.awt.Color(51, 102, 255));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 910, 580));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 910, 660));

        jPanel3.setBackground(new java.awt.Color(20, 19, 32));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelCategoria.setBackground(new java.awt.Color(6, 3, 9));

        txtNombreCategoria.setBackground(new java.awt.Color(6, 3, 9));
        txtNombreCategoria.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombreCategoria.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreCategoria.setBorder(null);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre:");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Agregar Nueva Categorias:");

        btnAgregarCategoria.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAgregarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_property_30px.png"))); // NOI18N
        btnAgregarCategoria.setText("Guardar");
        btnAgregarCategoria.setToolTipText("Click Para Guardar La Categoria");
        btnAgregarCategoria.setContentAreaFilled(false);
        btnAgregarCategoria.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_property_35px.png"))); // NOI18N
        btnAgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCategoriaActionPerformed(evt);
            }
        });

        btnEliminarCategoria.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEliminarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_document_30px.png"))); // NOI18N
        btnEliminarCategoria.setText("Eliminar");
        btnEliminarCategoria.setToolTipText("Si desea Eliminar Debera Escribir El nombre de la categoria");
        btnEliminarCategoria.setContentAreaFilled(false);
        btnEliminarCategoria.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete_document_35px.png"))); // NOI18N
        btnEliminarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCategoriaLayout = new javax.swing.GroupLayout(PanelCategoria);
        PanelCategoria.setLayout(PanelCategoriaLayout);
        PanelCategoriaLayout.setHorizontalGroup(
            PanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelCategoriaLayout.createSequentialGroup()
                        .addComponent(btnAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                    .addComponent(jLabel7)
                    .addGroup(PanelCategoriaLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator8)
                            .addComponent(txtNombreCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        PanelCategoriaLayout.setVerticalGroup(
            PanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCategoriaLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(PanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarCategoria)
                    .addComponent(btnAgregarCategoria))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel3.add(PanelCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 310, 120));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        txtNombre.setBackground(new java.awt.Color(20, 19, 32));
        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.setBorder(null);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 289, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripcion:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        txtDescripcion.setBackground(new java.awt.Color(20, 19, 32));
        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(153, 153, 153));
        txtDescripcion.setRows(5);
        txtDescripcion.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescripcion);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 289, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio Unitario:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        txtPrecioUnit.setBackground(new java.awt.Color(20, 19, 32));
        txtPrecioUnit.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtPrecioUnit.setForeground(new java.awt.Color(153, 153, 153));
        txtPrecioUnit.setBorder(null);
        txtPrecioUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioUnitKeyTyped(evt);
            }
        });
        jPanel3.add(txtPrecioUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 289, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Categoria:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        cboCategoria.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        cboCategoria.setToolTipText("Selecciones Una Categoria");
        cboCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCategoriaItemStateChanged(evt);
            }
        });
        cboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriaActionPerformed(evt);
            }
        });
        jPanel3.add(cboCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 270, -1));

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
        jPanel3.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 289, -1));

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
        jPanel3.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 289, -1));

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
        jPanel3.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 289, -1));

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
        jPanel3.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 289, -1));

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
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 289, -1));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 289, 10));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 289, 10));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 289, 10));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 289, 10));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 289, 10));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 289, 10));

        btnAgregarUnaNuevaCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_30px.png"))); // NOI18N
        btnAgregarUnaNuevaCategoria.setBorder(null);
        btnAgregarUnaNuevaCategoria.setContentAreaFilled(false);
        btnAgregarUnaNuevaCategoria.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_35px.png"))); // NOI18N
        btnAgregarUnaNuevaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUnaNuevaCategoriaActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregarUnaNuevaCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 40, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, 410, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        MenuPrincipal obj = new MenuPrincipal();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_RegresarActionPerformed
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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        if (txtNombre.getText().equals("") || txtDescripcion.getText().equals("") || txtPrecioUnit.getText().equals("") || cboCategoria.getSelectedItem() == "Seleccionar") {
            JOptionPane.showMessageDialog(this, "Tiene que llenar Todos Los Campos");
        } else {
            try {
                   
                   PRODUCTOS ins = new PRODUCTOS();
                   ins.setNombre(txtNombre.getText());
                   ins.setDescripcion(txtDescripcion.getText());
                   ins.setPrecio(Double.parseDouble(txtPrecioUnit.getText()));
                   ins.setCategoria(Integer.parseInt(txtCodigoCate.getText()));
                 //  p.insertarempleado(ins);
                 /*
                 INTERFAZ EL DIA 5/5/2021 
                 AUTORES: EQUIPO DE EVOLUCION
                 */
                 pfactory.insertarProductoNuevo(ins);
                 
                   listarProducto();

            } catch (Exception ex) {
                //JOptionPane.showMessageDialog(this, "Producto Registrado correctamente!!" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        Select1();
        int row = tblProductos.getSelectedRow();
        txtcodigo.setText(tblProductos.getValueAt(row, 0).toString());
        txtNombre.setText(tblProductos.getValueAt(row, 1).toString());
        txtDescripcion.setText(tblProductos.getValueAt(row, 2).toString());
        txtPrecioUnit.setText(tblProductos.getValueAt(row, 3).toString());
        txtStock.setText(tblProductos.getValueAt(row, 4).toString());
        cboCategoria.setSelectedItem(tblProductos.getValueAt(row, 5).toString());
        

    }//GEN-LAST:event_tblProductosMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Select2();
        limpiar();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
     int row = tblProductos.getSelectedRow();

     if (row == -1) {
         JOptionPane.showMessageDialog(this, "No Ha Selecionado Un Registro");
     
     } else {
            try {
                 PRODUCTOS delP=new PRODUCTOS();
                 delP.setCodigo(txtcodigo.getText());
                //p.eliminarproductos(delP);
                p.eliminarproductos(delP);
                 listarProducto();
                 limpiar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Eliminacion", JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int row = tblProductos.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "No Ha Selecionado Un Registro");
        } else {
           try {
                  PRODUCTOS upd=new PRODUCTOS();
                  upd.setCodigo(txtcodigo.getText());
                  upd.setNombre(txtNombre.getText());
                  upd.setDescripcion(txtDescripcion.getText());
                  upd.setPrecio(Double.parseDouble(txtPrecioUnit.getText()));
                  upd.setCategoria(Integer.parseInt(txtCodigoCate.getText()));//cod del cbo
                //  p.actualizarProducto(upd);
                /*
                INTERFAZ EL DIA 5/5/2021 
                AUTORES: EQUIPO DE EVOLUCION
                */
                pfactory.actualizarProductoNuevo(upd);
                
                
                  listarProducto();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Producto Modificado Correctamente"+ex);
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        buscarProducto();
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtPrecioUnitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioUnitKeyTyped
       char car = evt.getKeyChar();
        if (txtPrecioUnit.getText().length() >= 4) {
            evt.consume();
        }
        if ((car < '0' || car > '9') && (car < 46 || car > 46)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioUnitKeyTyped

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if (txtBuscar.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if (txtNombre.getText().length() >= 49) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        char car = evt.getKeyChar();
        if (txtDescripcion.getText().length() >= 99) {
            evt.consume();
        }

        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car < ' ' || car > ' ') && (car<'0' || car>'9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void btnAgregarUnaNuevaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUnaNuevaCategoriaActionPerformed
        if (PanelCategoria.isVisible() == true) {
            PanelCategoria.setVisible(false);
        } else {
            PanelCategoria.setVisible(true);
        }

    }//GEN-LAST:event_btnAgregarUnaNuevaCategoriaActionPerformed

    private void btnAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCategoriaActionPerformed
      String cates = txtNombreCategoria.getText();
        if (cates.equals("")) {
            JOptionPane.showMessageDialog(this, "Tiene que llenar el nombre de la categoria para registrar...");
        } else {
           try {
               CATEGORIA ins = new CATEGORIA();
                 ins.setNombre(txtNombreCategoria.getText());
                 c.insertarcate(ins);
                 
                 PanelCategoria.setVisible(false);
                 listarTipo();  
                 
           } catch (Exception ex) {

           }
    }
    }//GEN-LAST:event_btnAgregarCategoriaActionPerformed

    private void btnEliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCategoriaActionPerformed
        String cate = txtNombreCategoria.getText();

        if (cate.equals("")) {
            JOptionPane.showMessageDialog(this, "Tiene que ingresar el nombre de la categoria para eliminar");
        } else {
          try {
                 CATEGORIA delcate=new CATEGORIA();
                 delcate.setNombre(txtNombreCategoria.getText());
                 c.eliminarCATEGORIA(delcate);
                  PanelCategoria.setVisible(false);  
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Eliminacion", JOptionPane.ERROR_MESSAGE);

            }
        }

    }//GEN-LAST:event_btnEliminarCategoriaActionPerformed

    private void cboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriaActionPerformed

    }//GEN-LAST:event_cboCategoriaActionPerformed

    private void cboCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCategoriaItemStateChanged
        
        try{
         String nom=cboCategoria.getSelectedItem()+"";
         cone.consulta("Select * from categorias where nombre='"+nom+"' ");
        while (cone.getRs().next()) {
            this.txtCodigoCate.setText( cone.getRs().getString(1));
           }
         }catch(Exception ex){
        }     
        
    }//GEN-LAST:event_cboCategoriaItemStateChanged

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCategoria;
    private javax.swing.JToggleButton Regresar;
    private javax.swing.JToggleButton btnActualizar;
    private javax.swing.JToggleButton btnAgregar;
    private javax.swing.JToggleButton btnAgregarCategoria;
    private javax.swing.JToggleButton btnAgregarUnaNuevaCategoria;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnEliminar;
    private javax.swing.JButton btnEliminarCategoria;
    private javax.swing.JToggleButton btnNuevo;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JLabel txtCodigoCate;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreCategoria;
    private javax.swing.JTextField txtPrecioUnit;
    private javax.swing.JLabel txtStock;
    private javax.swing.JLabel txtcodigo;
    // End of variables declaration//GEN-END:variables

    void limpiar(){
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtPrecioUnit.setText("");
        cboCategoria.setSelectedItem("Seleccionar");
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

    void editTabla() {
        tblProductos.getColumnModel().getColumn(0).setPreferredWidth(85);
        tblProductos.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblProductos.getColumnModel().getColumn(2).setPreferredWidth(300);
        tblProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblProductos.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblProductos.getColumnModel().getColumn(5).setPreferredWidth(168);
        tblProductos.getColumnModel().getColumn(0).setResizable(false);
        tblProductos.getColumnModel().getColumn(1).setResizable(false);
        tblProductos.getColumnModel().getColumn(2).setResizable(false);
        tblProductos.getColumnModel().getColumn(3).setResizable(false);
        tblProductos.getColumnModel().getColumn(4).setResizable(false);
        tblProductos.getColumnModel().getColumn(5).setResizable(false);
    }

   
}
