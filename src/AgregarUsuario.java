
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class AgregarUsuario extends javax.swing.JFrame {
   
    DefaultTableModel modeloTabla;
    DefaultTableModel modeloTablaUsers12;
    DefaultTableModel modeloTablaOkAccess12;
    
 
    public AgregarUsuario() {
        modeloTabla = new DefaultTableModel(null, getColumnFailAccess());
        modeloTablaUsers12 = new DefaultTableModel(null, getColumnUsers());
        modeloTablaOkAccess12 = new DefaultTableModel(null, getColumnOkAccess());
        setRowFailAccess();
        setRowUsers();
        setRowOkAccess();
        initComponents();
    }
    
    private String[] getColumnFailAccess(){
        String columna[] = new String[]{"Id","UserId","Fecha","Tiempo","Detalles"};
        return columna;
    }
    private String[] getColumnUsers(){
        String columna[] = new String[]{"Id","Usuario","Nombre","Apellido","Nivel","Telefono"};
        return columna;
    }
    private String[] getColumnOkAccess(){
        String columna[] = new String[]{"Id","UserId","Fecha","Hora","Detalles"};
        return columna;
    }
    private void setRowFailAccess(){
        try{
            String sentencia = "SELECT failAccessLogId, userId, date, time, details FROM failaccesslogs";
            
                        PreparedStatement sel = Conexion.crear().prepareStatement(sentencia);
                        ResultSet rs = sel.executeQuery();
                        
                        Object datos[] = new Object[5];
            while(modeloTabla.getRowCount() > 0) {
                modeloTabla.removeRow(0);
            }  
            
             while(rs.next()){
                 for (int i = 0; i < 5; i++){
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
            String sentencia = "SELECT userId, username, firstName, lastName, accessLevel, phone FROM users";
            
                        PreparedStatement sel = Conexion.crear().prepareStatement(sentencia);
                        ResultSet rs = sel.executeQuery();
                        
                        Object datos[] = new Object[6];
            while(modeloTablaUsers12.getRowCount() > 0) {
                modeloTablaUsers12.removeRow(0);
            }  
            
             while(rs.next()){
                 for (int i = 0; i < 6; i++){
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
    private void setRowOkAccess(){
        try{
            String sentencia = "SELECT okAccessLogId, userId, date, time, details FROM okaccesslogs";
            
                        PreparedStatement sel = Conexion.crear().prepareStatement(sentencia);
                        ResultSet rs = sel.executeQuery();
                        
                        Object datos[] = new Object[5];
            while(modeloTablaOkAccess12.getRowCount() > 0) {
                modeloTablaOkAccess12.removeRow(0);
            }               
             while(rs.next()){
                 for (int i = 0; i < 5; i++){
                     datos[i] = rs.getObject(i + 1);
                 }
                 modeloTablaOkAccess12.addRow(datos);
             }
             rs.close();
         }catch(SQLException ex){
             System.out.println("Error en agregando filas a la tabla.");
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
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtBuild = new javax.swing.JTextField();
        btnAddBuild = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtclassRoom = new javax.swing.JTextField();
        btnAddClassRoom = new javax.swing.JButton();
        txtBuildRoom = new javax.swing.JTextField();
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
        btnback = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agregar Usuario");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblHash.setText("Hash");

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

        combAccessLvl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nivel 0", "Nivel 1" }));

        btnAgregaUser.setText("Agregar");
        btnAgregaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregaUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtVerifyPasswd)
                                .addComponent(txtPasswd)
                                .addComponent(txtUsername)
                                .addComponent(txtName)
                                .addComponent(txtLastName)
                                .addComponent(txtEmail)
                                .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btnAgregaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1103, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
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
                .addGap(51, 51, 51)
                .addComponent(btnAgregaUser)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agregar Usuario", jPanel1);

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
                .addContainerGap(647, Short.MAX_VALUE))
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
                .addContainerGap(454, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agregar Edificio y Salón", jPanel2);

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
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(573, 573, 573)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bitacoras", jPanel3);

        btnTemp20.setBackground(new java.awt.Color(51, 51, 255));
        btnTemp20.setText("20");

        btnTemp25.setText("25");

        btnTemp30.setBackground(new java.awt.Color(255, 0, 0));
        btnTemp30.setText("30");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Temperatura1.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iluminacion.jpg"))); // NOI18N

        RadiobtnLamp1.setText("Lampara 1 ");

        RadiobtnLamp2.setText("Lampara 2 ");

        btnEncender.setBackground(new java.awt.Color(51, 255, 0));
        btnEncender.setText("Encender ");

        btnApagar.setBackground(new java.awt.Color(255, 0, 0));
        btnApagar.setText("Apagar");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RadiobtnLamp1)
                    .addComponent(RadiobtnLamp2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(162, 162, 162)
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
                                    .addComponent(btnEncender))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RadiobtnLamp2)
                                    .addComponent(btnApagar)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(btnTemp20))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Control Maestro Iluminacion y Temperatura", jPanel5);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnback)
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHash)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnback)
                .addGap(5, 5, 5)
                .addComponent(lblHash)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
      AdminVen venCont = new AdminVen();
      venCont.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setRowFailAccess();
        setRowUsers();
        setRowOkAccess();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            JOptionPane.showMessageDialog(null, "Contraseña Verificada!");
        }else {
            JOptionPane.showMessageDialog(null, "Contraseña no Verificada!");
        }
    }//GEN-LAST:event_btnAgregaUserActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed

    }//GEN-LAST:event_txtEmailActionPerformed

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
    private javax.swing.JButton btnEncender;
    private javax.swing.JButton btnTemp20;
    private javax.swing.JButton btnTemp25;
    private javax.swing.JButton btnTemp30;
    private javax.swing.JButton btnback;
    private javax.swing.JComboBox<String> combAccessLvl;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lblHash;
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
