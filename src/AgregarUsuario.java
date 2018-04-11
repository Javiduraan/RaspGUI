
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgregarUsuario extends javax.swing.JFrame {
   
    DefaultTableModel modeloTabla;
    DefaultTableModel modeloTablaUsers12;
    DefaultTableModel modeloTablaOkAccess12;
    DefaultTableModel modeloTablaMostrarUsuarios;
    DefaultTableModel modeloTablaSingleBoardPC;
    
 
    public AgregarUsuario() {
        modeloTabla = new DefaultTableModel(null, getColumnFailAccess());
        modeloTablaUsers12 = new DefaultTableModel(null, getColumnUsers());
        modeloTablaOkAccess12 = new DefaultTableModel(null, getColumnOkAccess());
        modeloTablaMostrarUsuarios = new DefaultTableModel(null, getColumnAllUsers());
        modeloTablaSingleBoardPC = new DefaultTableModel(null, getColumnSingleBoardPC());
        setRowFailAccess();
        setRowUsers();
        setRowOkAccess();
        setRowAllUsers();
        setRowSingleBoard();
        initComponents();
    }
    
    private String[] getColumnFailAccess(){
        String columna[] = new String[]{"UserId","Fecha","Tiempo","Detalles"};
        return columna;
    }
    private String[] getColumnUsers(){
        String columna[] = new String[]{"Id","Usuario","Nombre","Apellido","Nivel","Email","Telefono"};
        return columna;
    }
    private String[] getColumnOkAccess(){
        String columna[] = new String[]{"UserId","Fecha","Hora","Detalles"};
        return columna;
    }
    private String[] getColumnSingleBoardPC(){
        String columna[] = new String[]{"SBPid","nombre"};
        return columna;        
    }
    private String[] getColumnAllUsers(){
        String columna[] = new String[]{"Id","Usuario","contraseña","Nombre","Apellido","Nivel","Email","Telefono"};
        return columna; //dkjsfk
    }
    
    private void setRowFailAccess(){
        try{
            String sentencia = "SELECT  userId, date, time, details FROM failaccesslogs";
            
                        PreparedStatement sel = Conexion.crear().prepareStatement(sentencia);
                        ResultSet rs = sel.executeQuery();
                        
                        Object datos[] = new Object[4];
            while(modeloTabla.getRowCount() > 0) {
                modeloTabla.removeRow(0);
            }  
            
             while(rs.next()){
                 for (int i = 0; i < 4; i++){
                     datos[i] = rs.getObject(i + 1);
                 }
                 modeloTabla.addRow(datos);
             }
             rs.close();
         }catch(SQLException ex){
             System.out.println("error en agregando filas a la tabla.");
         }catch(ClassNotFoundException ex){
             System.out.println("Error en el metodo crear Conexion.");
         }
    }
    private void setRowUsers(){
        try{
            String sentencia = "SELECT userId, username, firstName, lastName, accessLevel, mail, phone FROM users";
            
                        PreparedStatement sel = Conexion.crear().prepareStatement(sentencia);
                        ResultSet rs = sel.executeQuery();
                        
                        Object datos[] = new Object[7];
            while(modeloTablaUsers12.getRowCount() > 0) {
                modeloTablaUsers12.removeRow(0);
            }  
            
             while(rs.next()){
                 for (int i = 0; i < 7; i++){
                     datos[i] = rs.getObject(i + 1);
                 }
                 modeloTablaUsers12.addRow(datos);
             }
             rs.close();
         }catch(SQLException ex){
             System.out.println("Error en agregando filas a la tabla.");
         }catch(ClassNotFoundException ex){
             System.out.println("Error en el metodo crear Conexion.");
         }
    }
    private void setRowAllUsers(){
        try{
            String sentencia = "SELECT userId, username, password, firstName, lastName, accessLevel, mail, phone FROM users";
            
                        PreparedStatement sel = Conexion.crear().prepareStatement(sentencia);
                        ResultSet rs = sel.executeQuery();
                        
                        Object datos[] = new Object[8];
            while(modeloTablaMostrarUsuarios.getRowCount() > 0) {
                modeloTablaMostrarUsuarios.removeRow(0);//jashjabda
            }  
            
             while(rs.next()){
                 for (int i = 0; i < 8; i++){
                     datos[i] = rs.getObject(i + 1);
                 }
                 modeloTablaMostrarUsuarios.addRow(datos);
             }
             rs.close();
         }catch(SQLException ex){
             System.out.println("Error en agregando filas a la tabla.");
         }catch(ClassNotFoundException ex){
             System.out.println("Error en el metodo crear Conexion.");
         }
    }
    private void setRowOkAccess(){
        try{
            String sentencia = "SELECT  userId, date, time, details FROM okaccesslogs";
            
                        PreparedStatement sel = Conexion.crear().prepareStatement(sentencia);
                        ResultSet rs = sel.executeQuery();
                        
                        Object datos[] = new Object[4];
            while(modeloTablaOkAccess12.getRowCount() > 0) {
                modeloTablaOkAccess12.removeRow(0);
            }               
             while(rs.next()){
                 for (int i = 0; i < 4; i++){
                     datos[i] = rs.getObject(i + 1);
                 }
                 modeloTablaOkAccess12.addRow(datos);
             }
             rs.close();
         }catch(SQLException ex){
             System.out.println("Error agregando filas a la tabla.");
         }catch(ClassNotFoundException ex){
             System.out.println("Error en el metodo crear Conexion.");
         }
    }
    private void setRowSingleBoard(){
                try{
            String statement = "SELECT singleBoardPcId, name FROM SingleBoardsPc";
            
                        PreparedStatement sel = Conexion.crear().prepareStatement(statement);
                        ResultSet rs = sel.executeQuery();
                        
                        Object datos[] = new Object[2];
            while(modeloTablaSingleBoardPC.getRowCount() > 0) {
                modeloTablaSingleBoardPC.removeRow(0);
            }               
             while(rs.next()){
                 for (int i = 0; i < 2; i++){
                     datos[i] = rs.getObject(i + 1);
                 }
                 modeloTablaSingleBoardPC.addRow(datos);
             }
             rs.close();
         }catch(SQLException ex){
             System.out.println("Error agregando filas a la tabla.");
         }catch(ClassNotFoundException ex){
             System.out.println("Error en el metodo crear Conexion.");
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

        jRadioButton1 = new javax.swing.JRadioButton();
        lblHash = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPasswd = new javax.swing.JPasswordField();
        txtVerifyPasswd = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        combAccessLvl = new javax.swing.JComboBox<>();
        btnAgregaUser = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        btnDeleteUser = new javax.swing.JButton();
        btnReloadTables = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblUserid = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnTemp20 = new javax.swing.JButton();
        btnTemp25 = new javax.swing.JButton();
        btnTemp30 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        RadiobtnLamp1 = new javax.swing.JRadioButton();
        RadiobtnLamp2 = new javax.swing.JRadioButton();
        btnEncender = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        lblLamp1 = new javax.swing.JLabel();
        lblLamp2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        btnPasarDatos = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnVerifySBP = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtBuild = new javax.swing.JTextField();
        btnAddBuild = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtclassRoom = new javax.swing.JTextField();
        btnAddClassRoom = new javax.swing.JButton();
        txtBuildRoom = new javax.swing.JTextField();
        btnback = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agregar Usuario");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblHash.setText("Hash");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre de usuario");

        jLabel2.setText("Contraseña");

        jLabel3.setText("Verificar Contraseña");

        jLabel4.setText("Nombre");

        jLabel5.setText("Apellido");

        jLabel6.setText("eMail");

        jLabel7.setText("Nivel de Acceso");

        jLabel8.setText("Teléfono");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        combAccessLvl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nivel 0", "Nivel 1", "Nivel 2", "Nivel 3", "Nivel 4" }));

        btnAgregaUser.setText("Agregar");
        btnAgregaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregaUserActionPerformed(evt);
            }
        });

        jTable4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable4.setModel(modeloTablaMostrarUsuarios);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        btnDeleteUser.setText("Eliminar");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        btnReloadTables.setText("Recargar tablas");
        btnReloadTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadTablesActionPerformed(evt);
            }
        });

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combAccessLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnDeleteUser)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtVerifyPasswd)
                                            .addComponent(txtPasswd)
                                            .addComponent(txtUsername)
                                            .addComponent(txtName)
                                            .addComponent(txtLastName)
                                            .addComponent(txtEmail)
                                            .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(btnAgregaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUserid)
                        .addGap(151, 151, 151)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnReloadTables)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtVerifyPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(combAccessLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAgregaUser)
                                    .addComponent(btnDeleteUser)
                                    .addComponent(btnUpdate))
                                .addGap(70, 70, 70)
                                .addComponent(lblUserid))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btnReloadTables)))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agregar Usuario", jPanel1);

        jTable1.setModel(modeloTabla);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(modeloTablaOkAccess12);
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(modeloTablaUsers12);
        jScrollPane3.setViewportView(jTable3);

        jButton1.setText("Recargar Tablas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(573, 573, 573)
                        .addComponent(jButton1)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bitacoras", jPanel3);

        btnTemp20.setBackground(new java.awt.Color(51, 51, 255));
        btnTemp20.setText("20");

        btnTemp25.setText("25");

        btnTemp30.setBackground(new java.awt.Color(255, 0, 0));
        btnTemp30.setText("30");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Temperatura1.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Iluminacion.jpg"))); // NOI18N

        RadiobtnLamp1.setText("Lampara 1 ");

        RadiobtnLamp2.setText("Lampara 2 ");

        btnEncender.setBackground(new java.awt.Color(51, 255, 0));
        btnEncender.setText("Encender ");
        btnEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncenderActionPerformed(evt);
            }
        });

        btnApagar.setBackground(new java.awt.Color(255, 0, 0));
        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        lblLamp1.setText("Status");

        lblLamp2.setText("Status");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTemp25)
                    .addComponent(btnTemp20)
                    .addComponent(btnTemp30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RadiobtnLamp1)
                    .addComponent(RadiobtnLamp2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLamp1)
                    .addComponent(lblLamp2))
                .addGap(67, 67, 67)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEncender))
                .addGap(61, 61, 61))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btnTemp30)
                        .addGap(51, 51, 51)
                        .addComponent(btnTemp25)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RadiobtnLamp1)
                                    .addComponent(btnEncender)
                                    .addComponent(lblLamp1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RadiobtnLamp2)
                                    .addComponent(btnApagar)
                                    .addComponent(lblLamp2)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(btnTemp20))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Control Maestro Iluminacion y Temperatura", jPanel5);

        jTable5.setModel(modeloTablaSingleBoardPC);
        jScrollPane5.setViewportView(jTable5);

        btnPasarDatos.setText("Pasar Datos");
        btnPasarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarDatosActionPerformed(evt);
            }
        });

        jButton3.setText("Borrar");

        btnVerifySBP.setText("Verificar");
        btnVerifySBP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifySBPActionPerformed(evt);
            }
        });

        lblStatus.setText("Status");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPasarDatos)
                    .addComponent(jButton3)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblStatus)
                        .addComponent(btnVerifySBP)))
                .addContainerGap(937, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnPasarDatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVerifySBP)
                        .addGap(52, 52, 52)
                        .addComponent(lblStatus))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dev", jPanel4);

        jLabel10.setText("Letra de edificio");

        btnAddBuild.setText("Agregar Edificio");
        btnAddBuild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBuildActionPerformed(evt);
            }
        });

        jLabel9.setText("Edificio");

        jLabel11.setText("Salon para agregar");

        btnAddClassRoom.setText("Agregar salon");
        btnAddClassRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClassRoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddClassRoom)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAddBuild)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBuild, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(254, 254, 254)
                                .addComponent(jLabel9))
                            .addComponent(jLabel11))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtclassRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(txtBuildRoom))
                        .addGap(59, 59, 59)))
                .addContainerGap(664, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtBuild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtBuildRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtclassRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnAddBuild)))
                .addGap(16, 16, 16)
                .addComponent(btnAddClassRoom)
                .addContainerGap(485, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agregar Edificio y Salón", jPanel2);

        btnback.setText("Volver");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHash)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnback)
                .addGap(50, 50, 50))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblHash))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnback)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
      AdminVen venCont = new AdminVen();
      venCont.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnAddClassRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClassRoomActionPerformed
        String build = txtBuildRoom.getText();
        String classRoom = txtclassRoom.getText();

        String buildID =Conexion.getBuildId(build);
        if (buildID.contentEquals("catch 2")) {
            JOptionPane.showMessageDialog(null, "no se agrego el edificio");
        }else  {
            Conexion.newClassRoom(buildID, classRoom);
            JOptionPane.showMessageDialog(null, "se agrego el salon");
        }

        //ds
    }//GEN-LAST:event_btnAddClassRoomActionPerformed

    private void btnAddBuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBuildActionPerformed

        String NewBuild= txtBuild.getText();
        Conexion.edificioNuevo(NewBuild);
        JOptionPane.showMessageDialog(null, "Edificio agregado");
    }//GEN-LAST:event_btnAddBuildActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        if(RadiobtnLamp1.isSelected()){
            Conexion.lamparas(0,1);
            lblLamp1.setText("OFF");
            lblLamp1.setForeground(java.awt.Color.black);
        }
        if(RadiobtnLamp2.isSelected()){
            Conexion.lamparas(0,2);
            lblLamp2.setText("OFF");
            lblLamp2.setForeground(java.awt.Color.black);
        }
    }//GEN-LAST:event_btnApagarActionPerformed

    private void btnEncenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncenderActionPerformed
        if(RadiobtnLamp1.isSelected()){
            Conexion.lamparas(1,1);
            lblLamp1.setText("ON");
            lblLamp1.setForeground(java.awt.Color.green);
        }
        if(RadiobtnLamp2.isSelected()){
            Conexion.lamparas(1,2);
            lblLamp2.setText("ON");
            lblLamp2.setForeground(java.awt.Color.green);
        }
    }//GEN-LAST:event_btnEncenderActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setRowFailAccess();
        setRowUsers();
        setRowOkAccess();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnReloadTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadTablesActionPerformed
        setRowAllUsers();
    }//GEN-LAST:event_btnReloadTablesActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed

        String User= txtUsername.getText();
        String userid = Conexion.getUserId(User);
        Integer.parseInt(userid);

        Conexion.DeleteUser(userid);

        txtUsername.setText("");
        txtPasswd.setText("");
        txtVerifyPasswd.setText("");
        txtName.setText("");
        txtLastName.setText("");
        combAccessLvl.setSelectedItem(0);
        txtEmail.setText("");
        txtPhone.setText("");
        setRowAllUsers();

    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        int fila = jTable4.getSelectedRow();
        if(fila>=0){

            lblUserid.setText(jTable4.getValueAt(fila, 0).toString());
            txtUsername.setText(jTable4.getValueAt(fila, 1).toString());
            txtPasswd.setText(jTable4.getValueAt(fila, 2).toString());
            txtVerifyPasswd.setText(jTable4.getValueAt(fila, 2).toString());
            txtName.setText(jTable4.getValueAt(fila, 3).toString());
            txtLastName.setText(jTable4.getValueAt(fila, 4).toString());
            //combAccessLvl.setSelectedItem((jTable4.getValueAt(fila, 5).toString();
                combAccessLvl.setSelectedIndex(Integer.parseInt(jTable4.getValueAt(fila, 5).toString()));
                txtEmail.setText(jTable4.getValueAt(fila, 6).toString());
                txtPhone.setText(jTable4.getValueAt(fila, 7).toString());
                //jButton1.setEnabled(false);
                //jButton6.setEnabled(true);
                //jButton2.setEnabled(true);  jButton4.setEnabled(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
    }//GEN-LAST:event_jTable4MouseClicked

    private void btnAgregaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregaUserActionPerformed
        String NewUser= txtUsername.getText();
        String DESCipher = txtPasswd.getText();
        String VerifyPasswd = txtVerifyPasswd.getText();
        String firstName = txtName.getText();
        String lastName = txtLastName.getText();
        int  accessLevel = combAccessLvl.getSelectedIndex();
        String mail = txtEmail.getText();
        String phone = txtPhone.getText();

        if(VerifyPasswd.equals(DESCipher)){
            String PassEncrypted = Conexion.encriptar(NewUser, DESCipher);
            lblHash.setText(PassEncrypted);
            Conexion.usuarioNuevo(NewUser, PassEncrypted, firstName, lastName, accessLevel, mail, phone);
            setRowAllUsers();
            JOptionPane.showMessageDialog(null, "Contraseña Verificada!");
        }else {
            JOptionPane.showMessageDialog(null, "Contraseña no Verificada!");
        }

    }//GEN-LAST:event_btnAgregaUserActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed

    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnVerifySBPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifySBPActionPerformed
        try {
            Conexion.crearConexionGetInf();
        } catch (SQLException ex) {
            Logger.getLogger(AgregarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgregarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(Conexion.verifyAccessSBP()== 0){
          lblStatus.setText("La tabla esta vacia.");
       }else lblStatus.setText("La tabla tiene datos.");
        
        
    }//GEN-LAST:event_btnVerifySBPActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String User= txtUsername.getText();
        String userid= lblUserid.getText();
        String passwd = txtPasswd.getText();
        String VerifyPasswd = txtVerifyPasswd.getText();
        String firstName = txtName.getText();
        String lastName = txtLastName.getText();
        int  accessLevel = combAccessLvl.getSelectedIndex();
        String mail = txtEmail.getText();
        String phone = txtPhone.getText();
        
       // String userid = Conexion.getUserId(User);
        Integer.parseInt(userid);
        
        if(VerifyPasswd.equals(passwd)){
            String PassEncrypted = Conexion.encriptar(User, passwd);
        
        Conexion.EditUser(userid, User, PassEncrypted, firstName, lastName, accessLevel, mail, phone);
        setRowAllUsers();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnPasarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarDatosActionPerformed
        // TODO add your handling code here:
        try {
            Conexion.crearConexionGetInf();
        } catch (SQLException ex) {
            Logger.getLogger(AgregarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgregarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Conexion.pasarDatosEntreTablas();
        
    }//GEN-LAST:event_btnPasarDatosActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarUsuario().setVisible(true);
                //yoto robotoooooooooooo
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RadiobtnLamp1;
    private javax.swing.JRadioButton RadiobtnLamp2;
    private javax.swing.JButton btnAddBuild;
    private javax.swing.JButton btnAddClassRoom;
    private javax.swing.JButton btnAgregaUser;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnEncender;
    private javax.swing.JButton btnPasarDatos;
    private javax.swing.JButton btnReloadTables;
    private javax.swing.JButton btnTemp20;
    private javax.swing.JButton btnTemp25;
    private javax.swing.JButton btnTemp30;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnVerifySBP;
    private javax.swing.JButton btnback;
    private javax.swing.JComboBox<String> combAccessLvl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JLabel lblHash;
    private javax.swing.JLabel lblLamp1;
    private javax.swing.JLabel lblLamp2;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUserid;
    private javax.swing.JTextField txtBuild;
    private javax.swing.JTextField txtBuildRoom;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPasswd;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPasswordField txtVerifyPasswd;
    private javax.swing.JTextField txtclassRoom;
    // End of variables declaration//GEN-END:variables
}
