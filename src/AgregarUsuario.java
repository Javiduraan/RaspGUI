
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgregarUsuario extends javax.swing.JFrame {
   
    DefaultTableModel modeloTabla;
    DefaultTableModel modeloTablaUsers12;
    DefaultTableModel modeloTablaOkAccess12;
    DefaultTableModel modeloTablaMostrarUsuarios;
    DefaultTableModel modeloTablaSingleBoardPC;
    DefaultTableModel modeloTablaMostrarRooms;
    DefaultTableModel modeloTablaReservs;
    DefaultTableModel modeloTablaHours;
    
        public void cargarUsersCombBoxTabReservs() throws SQLException{
       Statement consulta;
       int X = 0;
       consulta = Conexion.cone.createStatement();
       String SQL = "SELECT username FROM Users;";
       try{
           ResultSet rs = consulta.executeQuery(SQL);
           cmbUser.removeAllItems();
           while(rs.next()){
               cmbUser.addItem(rs.getString(1));
              
           }
       }catch(SQLException ex){
           System.out.println(ex.toString());
       }   
   
    }
        public void cargarBuildingCombBoxTabReservs() throws SQLException{
       Statement consulta;
       consulta = Conexion.cone.createStatement();
       String SQL = "SELECT name FROM Buildings;";
       try{
           ResultSet rs = consulta.executeQuery(SQL);
           cmbBuilding.removeAllItems();
           while(rs.next()){
               cmbBuilding.addItem(rs.getString(1));
              
           }
       }catch(SQLException ex){
           System.out.println(ex.toString());
       }   
   
    }
        public void cargarRoomsCombBoxTabReservs() throws SQLException{
       Statement consulta;
       consulta = Conexion.cone.createStatement();
       String SQL = "SELECT name FROM Rooms WHERE buildingId IN(SELECT buildingId FROM Buildings WHERE name='"+cmbBuilding.getSelectedItem().toString()+"');";
       try{
           ResultSet rs = consulta.executeQuery(SQL);
           cmbRoom.removeAllItems();
           while(rs.next()){
               cmbRoom.addItem(rs.getString(1));
              
           }
       }catch(SQLException ex){
           System.out.println(ex.toString());
       }   
   
    }
        public void cargarBuildingCombBoxTabHours() throws SQLException{
          Statement consulta;
          consulta = Conexion.cone.createStatement();
           String SQL = "SELECT name FROM Buildings;";
           try{
           ResultSet rs = consulta.executeQuery(SQL);
           cmbBuildingTabHours.removeAllItems();
           while(rs.next()){
               cmbBuildingTabHours.addItem(rs.getString(1));
              
           }
          }catch(SQLException ex){
           System.out.println(ex.toString());
           }       
        }
        public void cargarRoomsCombBoxTabHours() throws SQLException{
          Statement consulta;
          consulta = Conexion.cone.createStatement();
          String SQL = "SELECT name FROM Rooms WHERE buildingId IN(SELECT buildingId FROM Buildings WHERE name='"+cmbBuildingTabHours.getSelectedItem().toString()+"');";
           try{
             ResultSet rs = consulta.executeQuery(SQL);
             cmbRoomTabHours.removeAllItems();
             while(rs.next()){
               cmbRoomTabHours.addItem(rs.getString(1));
              
               }
           }catch(SQLException ex){
           System.out.println(ex.toString());
            }  
        }
        public void cargarUsersNameCombBoxTabHours() throws SQLException{
        Statement consulta;
        consulta = Conexion.cone.createStatement();
        String SQL = "SELECT firstName FROM Users;";
           try{
             ResultSet rs = consulta.executeQuery(SQL);
             cmbFirstNameTabHours.removeAllItems();
             while(rs.next()){
               cmbFirstNameTabHours.addItem(rs.getString(1));
              }
            }catch(SQLException ex){
               System.out.println(ex.toString());
              } 
        }
     public AgregarUsuario() {
        modeloTabla = new DefaultTableModel(null, getColumnFailAccess());
        modeloTablaUsers12 = new DefaultTableModel(null, getColumnUsers());
        modeloTablaOkAccess12 = new DefaultTableModel(null, getColumnOkAccess());
        modeloTablaMostrarUsuarios = new DefaultTableModel(null, getColumnAllUsers());
        modeloTablaSingleBoardPC = new DefaultTableModel(null, getColumnSingleBoardPC());
        modeloTablaMostrarRooms = new DefaultTableModel(null, getColumnRooms());
        modeloTablaReservs = new DefaultTableModel(null, getColumnReservas());
        modeloTablaHours = new DefaultTableModel(null, getColumnHours());
        setRowFailAccess();
        setRowUsers();
        setRowOkAccess();
        setRowAllUsers();
        setRowSingleBoard();
        setRowRooms();
        setRowReservs();
        setRowHours();
        initComponents();
        try {
            cargarUsersCombBoxTabReservs();
            cargarBuildingCombBoxTabReservs();
            cargarRoomsCombBoxTabReservs();
            cargarBuildingCombBoxTabHours();
            cargarRoomsCombBoxTabHours();
            cargarUsersNameCombBoxTabHours();
        } catch (SQLException ex) {
            Logger.getLogger(AgregarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private String[] getColumnRooms(){
        String columna[] = new String[]{"Id","Edificio","nombre de Salon","Temperatura minima","Temperatura media","Temperatura maxima","Temperatura seleccionada","modo"};
        return columna; 
    }
     private String[] getColumnReservas(){
        String columna[] = new String[]{"ID usuario","ID Salon","Fecha","Hora y dia","Caso"};
        return columna;
    } 
     private String[] getColumnHours(){
         String columna[] = new String[]{"Nombre","Apellido","Salon","Hora y dia"};
         return columna;
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
    private void setRowRooms(){
        try{
            String sentencia = "SELECT Rooms.roomId, buildings.name, Rooms.name, Rooms.minTemp, Rooms.midTemp, Rooms.maxTemp, Rooms.selTemp, Rooms.mode FROM Rooms, buildings WHERE buildings.buildingId=rooms.buildingId";
            
                        PreparedStatement sel = Conexion.crear().prepareStatement(sentencia);
                        ResultSet rs = sel.executeQuery();
                        
                        Object datos[] = new Object[8];
            while(modeloTablaMostrarRooms.getRowCount() > 0) {
                modeloTablaMostrarRooms.removeRow(0);//jashjabda
            }  
            
             while(rs.next()){
                 for (int i = 0; i < 8; i++){
                     datos[i] = rs.getObject(i + 1);
                 }
                 modeloTablaMostrarRooms.addRow(datos);
             }
             rs.close();
         }catch(SQLException ex){
             System.out.println("Error en agregando filas a la tabla.");
         }catch(ClassNotFoundException ex){
             System.out.println("Error en el metodo crear Conexion.");
         }
    }
    private void setRowReservs(){
                try{
            String statement = "SELECT userId, roomId, date, weekDayAndHour, reservs.case FROM reservs";
            
                        PreparedStatement sel = Conexion.crear().prepareStatement(statement);
                        ResultSet rs = sel.executeQuery();
                        
                        Object datos[] = new Object[5];
            while(modeloTablaReservs.getRowCount() > 0) {
                modeloTablaReservs.removeRow(0);
            }               
             while(rs.next()){
                 for (int i = 0; i < 5; i++){
                     datos[i] = rs.getObject(i + 1);
                 }
                 modeloTablaReservs.addRow(datos);
             }
             rs.close();
         }catch(SQLException ex){
             System.out.println("Error agregando filas a la tabla.");
                    System.out.println(ex.toString());
         }catch(ClassNotFoundException ex){
             System.out.println("Error en el metodo crear Conexion.");
         }
    }
    private void setRowHours(){
                      try{
            String statement = "SELECT Users.firstName, Users.lastName, Rooms.name, Hours.weekDayAndHour FROM Hours, Users, Rooms WHERE Users.userId = Hours.userId AND Rooms.roomId = Hours.roomId;";
            
                        PreparedStatement sel = Conexion.crear().prepareStatement(statement);
                        ResultSet rs = sel.executeQuery();
                        
                        Object datos[] = new Object[4];
            while(modeloTablaHours.getRowCount() > 0) {
                modeloTablaHours.removeRow(0);
            }               
             while(rs.next()){
                 for (int i = 0; i < 4; i++){
                     datos[i] = rs.getObject(i + 1);
                 }
                 modeloTablaHours.addRow(datos);
             }
             rs.close();
         }catch(SQLException ex){
             System.out.println("Error agregando filas a la tabla.");
                    System.out.println(ex.toString());
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
        buttonGroup1 = new javax.swing.ButtonGroup();
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
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtminTemp = new javax.swing.JTextField();
        txtmidTemp = new javax.swing.JTextField();
        txtmaxTemp = new javax.swing.JTextField();
        txtselTemp = new javax.swing.JTextField();
        txtmode = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        btnDeleteRoms = new javax.swing.JButton();
        lblbuild = new javax.swing.JLabel();
        btnUpdateRoom = new javax.swing.JButton();
        lblroomid = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        cmbUser = new javax.swing.JComboBox<>();
        cmbBuilding = new javax.swing.JComboBox<>();
        cmbRoom = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jcalendarCmb = new org.freixas.jcalendar.JCalendarCombo();
        jLabel23 = new javax.swing.JLabel();
        cmbHora = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        btnReservar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        cmbFirstNameTabHours = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cmbBuildingTabHours = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        cmbRoomTabHours = new javax.swing.JComboBox<>();
        lblPrueba = new javax.swing.JLabel();
        btnPrueba = new javax.swing.JButton();
        btnAceptarHours = new javax.swing.JButton();
        chkbLunes = new javax.swing.JCheckBox();
        chkbMartes = new javax.swing.JCheckBox();
        chkbMiercoles = new javax.swing.JCheckBox();
        chkbJueves = new javax.swing.JCheckBox();
        chkbViernes = new javax.swing.JCheckBox();
        chkbSabado = new javax.swing.JCheckBox();
        cmbHorarioHora = new javax.swing.JComboBox<>();
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
        jTable4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
                .addContainerGap(157, Short.MAX_VALUE))
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
                .addContainerGap(232, Short.MAX_VALUE))
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
                .addContainerGap(221, Short.MAX_VALUE))
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

        jLabel14.setText("Temperatura minima");

        jLabel15.setText("Temperatura maxima");

        jLabel16.setText("Temperatura media");

        jLabel17.setText("Temperatura seleccionada");

        jLabel18.setText("modo");

        txtminTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtminTempActionPerformed(evt);
            }
        });

        jTable6.setModel(modeloTablaMostrarRooms);
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);

        btnDeleteRoms.setText("Eliminar salon");
        btnDeleteRoms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRomsActionPerformed(evt);
            }
        });

        btnUpdateRoom.setText("Editar Salon");
        btnUpdateRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateRoomActionPerformed(evt);
            }
        });

        lblroomid.setText("jLabel27");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtminTemp, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtclassRoom, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuildRoom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(txtmidTemp, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmaxTemp, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtselTemp)
                                    .addComponent(txtmode, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(lblroomid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnAddBuild)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtBuild, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAddClassRoom)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteRoms)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(lblbuild))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUpdateRoom)))))
                        .addContainerGap(1034, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtBuild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnAddBuild)
                        .addGap(26, 26, 26)
                        .addComponent(lblroomid)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtBuildRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtclassRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtminTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtmidTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtmaxTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtselTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtmode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddClassRoom)
                            .addComponent(btnDeleteRoms)
                            .addComponent(btnUpdateRoom))
                        .addGap(138, 138, 138))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblbuild)
                        .addGap(124, 124, 124))))
        );

        jTabbedPane1.addTab("Agregar Edificio y Salón", jPanel2);

        jTable7.setModel(modeloTablaReservs);
        jScrollPane7.setViewportView(jTable7);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel19.setText("Reservas");

        cmbBuilding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBuildingActionPerformed(evt);
            }
        });

        jLabel20.setText("Usuario que hara la reserva:");

        jLabel21.setText("Edificio donde esta el salón:");

        jLabel22.setText("Salon que se va a reservar:");

        jButton2.setText("Recargar Tabla");

        jLabel23.setText("Dia:");

        cmbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        jLabel24.setText("Hora:");

        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(44, 44, 44)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnReservar)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jcalendarCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(cmbBuilding, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbRoom, 0, 100, Short.MAX_VALUE))))
                        .addGap(190, 190, 190))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jLabel19)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton2)
                .addContainerGap(133, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel19)
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBuilding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcalendarCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReservar)
                .addGap(100, 100, 100))
        );

        jTabbedPane1.addTab("Reservas", jPanel6);

        jTable8.setModel(modeloTablaHours);
        jScrollPane8.setViewportView(jTable8);

        jLabel25.setText("Edicion de Horarios");

        jLabel26.setText("Nombre");

        jLabel27.setText("Edificio");

        cmbBuildingTabHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBuildingTabHoursActionPerformed(evt);
            }
        });

        jLabel28.setText("Salon");

        lblPrueba.setText("jLabel29");

        btnPrueba.setText("jButton4");
        btnPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaActionPerformed(evt);
            }
        });

        btnAceptarHours.setText("Aceptar");

        chkbLunes.setText("Lunes");

        chkbMartes.setText("Martes");

        chkbMiercoles.setText("Miercoles");

        chkbJueves.setText("Jueves");

        chkbViernes.setText("Viernes");

        chkbSabado.setText("Sabado");
        chkbSabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbSabadoActionPerformed(evt);
            }
        });

        cmbHorarioHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnPrueba)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(lblPrueba)
                                .addGap(581, 581, 581))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(255, 255, 255)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbHorarioHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAceptarHours))
                                .addContainerGap(437, Short.MAX_VALUE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbBuildingTabHours, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbFirstNameTabHours, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbRoomTabHours, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkbLunes)
                            .addComponent(chkbMartes)
                            .addComponent(chkbMiercoles)
                            .addComponent(chkbJueves)
                            .addComponent(chkbViernes)
                            .addComponent(chkbSabado))
                        .addGap(548, 548, 548))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbFirstNameTabHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(cmbBuildingTabHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(cmbRoomTabHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(342, 342, 342)
                        .addComponent(btnPrueba))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(268, 268, 268)
                                .addComponent(btnAceptarHours))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkbLunes)
                                    .addComponent(cmbHorarioHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkbMartes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkbMiercoles)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkbJueves)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkbViernes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkbSabado)))
                        .addGap(16, 16, 16)
                        .addComponent(lblPrueba)))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Horarios", jPanel7);

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
        String minTemp = txtminTemp.getText();
        String midTemp = txtmidTemp.getText();
        String maxTemp = txtmaxTemp.getText();
        String selTemp = txtselTemp.getText();
        String mode= txtmode.getText();
        Integer.parseInt(minTemp);
        Integer.parseInt(midTemp);
        Integer.parseInt(maxTemp);
        Integer.parseInt(selTemp);
        Integer.parseInt(mode);
        
        String buildID =Conexion.getBuildId(build);
        
        if (buildID.contentEquals("catch 2")) {
            JOptionPane.showMessageDialog(null, "no se agrego el edificio");
        }else  {
            Conexion.newClassRoom(buildID, classRoom, minTemp, midTemp, maxTemp, selTemp, mode);
            setRowRooms();
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

    private void txtminTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtminTempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtminTempActionPerformed

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        int fila = jTable6.getSelectedRow();
        if(fila>=0){
            lblroomid.setText(jTable6.getValueAt(fila,0).toString());
            lblroomid.setVisible(false);
            txtBuildRoom.setText(jTable6.getValueAt(fila, 1).toString());
            txtclassRoom.setText(jTable6.getValueAt(fila, 2).toString());
            txtminTemp.setText(jTable6.getValueAt(fila, 3).toString());
            txtmidTemp.setText(jTable6.getValueAt(fila, 4).toString());
            txtmaxTemp.setText(jTable6.getValueAt(fila, 5).toString());
            txtselTemp.setText(jTable6.getValueAt(fila, 6).toString());
            txtmode.setText(jTable6.getValueAt(fila, 7).toString());
          
            
            }
            else{
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
    }//GEN-LAST:event_jTable6MouseClicked

    private void btnDeleteRomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRomsActionPerformed
        String room= txtclassRoom.getText();
        String roomId = Conexion.getRoomId(room);
        Integer.parseInt(roomId);

        Conexion.DeleteClassRomm(roomId); 

            txtBuildRoom.setText("");
            txtclassRoom.setText("");
            txtminTemp.setText("");
            txtmidTemp.setText("");
            txtmaxTemp.setText("");
            txtselTemp.setText("");
            txtmode.setText("");
            setRowRooms();
    }//GEN-LAST:event_btnDeleteRomsActionPerformed

    private void cmbBuildingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBuildingActionPerformed
        // TODO add your handling code here:
        try {
            cargarRoomsCombBoxTabReservs();
        } catch (SQLException ex) {
            Logger.getLogger(AgregarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbBuildingActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReservarActionPerformed

    private void btnUpdateRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateRoomActionPerformed
        String roomid = lblroomid.getText();
        String build = txtBuildRoom.getText();
        String name = txtclassRoom.getText();
        String minTemp = txtminTemp.getText();
        String midTemp = txtmidTemp.getText();
        String maxTemp = txtmaxTemp.getText();
        String selTemp = txtselTemp.getText();
        String mode= txtmode.getText();
        Integer.parseInt(roomid);
        
        Integer.parseInt(minTemp);
        Integer.parseInt(midTemp);
        Integer.parseInt(maxTemp);
        Integer.parseInt(selTemp);
        Integer.parseInt(mode); 
        
        String buildID =Conexion.getBuildId(build);
        Integer.parseInt(buildID);
        
        
        Conexion.EditRoom(roomid, buildID, name, minTemp, midTemp, maxTemp, selTemp, mode);
        setRowRooms();
    }//GEN-LAST:event_btnUpdateRoomActionPerformed

    private void cmbBuildingTabHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBuildingTabHoursActionPerformed
        try {
            cargarRoomsCombBoxTabHours();
        } catch (SQLException ex) {
            Logger.getLogger(AgregarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }    }//GEN-LAST:event_cmbBuildingTabHoursActionPerformed

    private void btnPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebaActionPerformed
        LinkedList lista;  
      lista = Conexion.getDataTableHours();
      // int ListaInt = Integer.parseInt(lista.toString());
//      String XXE = Conexion.metodoDiaHoraToString(prueba);
      int longuitud = lista.size();
      for(int i = 0; i < longuitud; i++){
          //int j = (int) lista.get(i);
          System.out.println("Deb:" + Conexion.metodoDiaHoraToString((int)lista.get(i)));
      }
       lblPrueba.setText(lista.toString());
    }//GEN-LAST:event_btnPruebaActionPerformed

    private void chkbSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbSabadoActionPerformed
        String Status = "";
        if(chkbLunes.isSelected()){Status = "Lu";}
        if(chkbMartes.isSelected()){Status = "Ma";}
        if(chkbMiercoles.isSelected()){Status = "Mi";}
        if(chkbJueves.isSelected()){Status = "Ju";}
        if(chkbViernes.isSelected()){Status = "Vi";}
        if(chkbSabado.isSelected()){Status = "Sa";}
    }//GEN-LAST:event_chkbSabadoActionPerformed

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
    private javax.swing.JButton btnAceptarHours;
    private javax.swing.JButton btnAddBuild;
    private javax.swing.JButton btnAddClassRoom;
    private javax.swing.JButton btnAgregaUser;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnDeleteRoms;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnEncender;
    private javax.swing.JButton btnPasarDatos;
    private javax.swing.JButton btnPrueba;
    private javax.swing.JButton btnReloadTables;
    private javax.swing.JButton btnReservar;
    private javax.swing.JButton btnTemp20;
    private javax.swing.JButton btnTemp25;
    private javax.swing.JButton btnTemp30;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateRoom;
    private javax.swing.JButton btnVerifySBP;
    private javax.swing.JButton btnback;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkbJueves;
    private javax.swing.JCheckBox chkbLunes;
    private javax.swing.JCheckBox chkbMartes;
    private javax.swing.JCheckBox chkbMiercoles;
    private javax.swing.JCheckBox chkbSabado;
    private javax.swing.JCheckBox chkbViernes;
    private javax.swing.JComboBox<String> cmbBuilding;
    private javax.swing.JComboBox<String> cmbBuildingTabHours;
    private javax.swing.JComboBox<String> cmbFirstNameTabHours;
    private javax.swing.JComboBox<String> cmbHora;
    private javax.swing.JComboBox<String> cmbHorarioHora;
    private javax.swing.JComboBox<String> cmbRoom;
    private javax.swing.JComboBox<String> cmbRoomTabHours;
    private javax.swing.JComboBox<String> cmbUser;
    private javax.swing.JComboBox<String> combAccessLvl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private org.freixas.jcalendar.JCalendarCombo jcalendarCmb;
    private javax.swing.JLabel lblHash;
    private javax.swing.JLabel lblLamp1;
    private javax.swing.JLabel lblLamp2;
    private javax.swing.JLabel lblPrueba;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUserid;
    private javax.swing.JLabel lblbuild;
    private javax.swing.JLabel lblroomid;
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
    private javax.swing.JTextField txtmaxTemp;
    private javax.swing.JTextField txtmidTemp;
    private javax.swing.JTextField txtminTemp;
    private javax.swing.JTextField txtmode;
    private javax.swing.JTextField txtselTemp;
    // End of variables declaration//GEN-END:variables
}
