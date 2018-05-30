
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class AgregarUsuario extends javax.swing.JFrame {
   
    DefaultTableModel modeloTabla;
    DefaultTableModel modeloTablaUsers12;
    DefaultTableModel modeloTablaOkAccess12;
    DefaultTableModel modeloTablaMostrarUsuarios;
    DefaultTableModel modeloTablaSingleBoardPC;
    DefaultTableModel modeloTablaMostrarRooms;
    DefaultTableModel modeloTablaReservs;
    DefaultTableModel modeloTablaHours;
    
        public void cargarUsersCombBoxTabReservs() throws SQLException{ //Metodo para mostrar el nombre de usuarios de la base de datos por medio de un ComboBox en la pestaña de reservas. 
       Statement consulta; //Se crea una consulta 
       int X = 0;
       consulta = Conexion.cone.createStatement();
       String SQL = "SELECT username FROM Users WHERE userId != 0;"; //Se hace la consulta y se guarda en una variable String llamada SQL 
       try{
           ResultSet rs = consulta.executeQuery(SQL); //Se ejecuta la consulta y se guarda en una variable que contendra su resultado. 
           cmbUserTabReservs.removeAllItems(); //Se borran los datos que se tenian para que no se haga un ComboBox muy largo 
           while(rs.next()){ //Este ciclo While revisa que el resultado de la consulta sea valido revisando la tabla de la base de datos y asi saber que se encuentra en la base de datos.
               cmbUserTabReservs.addItem(rs.getString(1)); //Si se encuentra en la base de datos se agrega un elemento al ComboBoxUsuarios con el nombre de los campos.  
           }
       }catch(SQLException ex){
           System.out.println(ex.toString());
       }   
   
    }
        public void cargarBuildingCombBoxTabReservs() throws SQLException{ //Vease linea de codigo 21 
       Statement consulta;
       consulta = Conexion.cone.createStatement();
       String SQL = "SELECT name FROM Buildings;";
       try{
           ResultSet rs = consulta.executeQuery(SQL);
           cmbBuildingTabReservs.removeAllItems();
           while(rs.next()){
               cmbBuildingTabReservs.addItem(rs.getString(1));
              
           }
       }catch(SQLException ex){
           System.out.println(ex.toString());
       }   
   
    }
        public void cargarRoomsCombBoxTabReservs() throws SQLException{ //Vease linea de codigo 21
       Statement consulta;
       consulta = Conexion.cone.createStatement();
       String SQL = "SELECT name FROM Rooms WHERE buildingId IN(SELECT buildingId FROM Buildings WHERE name='"+cmbBuildingTabReservs.getSelectedItem().toString()+"');"; //Consulta SELECT anidada que muestra el Salon dependiendo el edificio que este en el ComboBoxBuildings
       try{
           ResultSet rs = consulta.executeQuery(SQL);
           cmbRoomTabReservs.removeAllItems();
           while(rs.next()){
               cmbRoomTabReservs.addItem(rs.getString(1));
              
           }
       }catch(SQLException ex){
           System.out.println(ex.toString());
       }   
   
    }
        public void cargarBuildingCombBoxTabHours() throws SQLException{ //Vease linea de codigo 21 
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
        public void cargarRoomsCombBoxTabHours() throws SQLException{ //Vease linea de codigo 21
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
        public void cargarUsersNameCombBoxTabHours() throws SQLException{ //Vease linea de codigo 21
        Statement consulta;
        consulta = Conexion.cone.createStatement();
        String SQL = "SELECT username FROM Users WHERE userid != 0;";
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
     public AgregarUsuario() { //Constructor de la clase 
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
        setLocationRelativeTo(null);
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
        return columna; 
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
            String sentencia = "SELECT userId, username, firstName, lastName, accessLevel, mail, phone FROM users WHERE userId != 0";
            
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
            String sentencia = "SELECT userId, username, password, firstName, lastName, accessLevel, mail, phone FROM users WHERE userId != 0;";
            
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
        TabMaster = new javax.swing.JTabbedPane();
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
        lblHash = new javax.swing.JLabel();
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
        jSeparator2 = new javax.swing.JSeparator();
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
        cmbUserTabReservs = new javax.swing.JComboBox<>();
        cmbBuildingTabReservs = new javax.swing.JComboBox<>();
        cmbRoomTabReservs = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        cmbHourTabReservs = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        btnReservar = new javax.swing.JButton();
        SelectorDia = new com.toedter.calendar.JDateChooser();
        lblUserIdRes = new javax.swing.JLabel();
        lblRoomidRes = new javax.swing.JLabel();
        lbldateRes = new javax.swing.JLabel();
        lblwdhRes = new javax.swing.JLabel();
        btnReservar1 = new javax.swing.JButton();
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
        btnAceptarHours = new javax.swing.JButton();
        chkbLunes = new javax.swing.JCheckBox();
        chkbMartes = new javax.swing.JCheckBox();
        chkbMiercoles = new javax.swing.JCheckBox();
        chkbJueves = new javax.swing.JCheckBox();
        chkbViernes = new javax.swing.JCheckBox();
        chkbSabado = new javax.swing.JCheckBox();
        cmbHorarioHora = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnback = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agregar Usuario");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1200, 600));
        setMinimumSize(new java.awt.Dimension(1200, 600));
        setPreferredSize(new java.awt.Dimension(1200, 600));
        setResizable(false);

        TabMaster.setBackground(new java.awt.Color(255, 255, 255));
        TabMaster.setMaximumSize(new java.awt.Dimension(1195, 511));
        TabMaster.setMinimumSize(new java.awt.Dimension(1195, 511));
        TabMaster.setPreferredSize(new java.awt.Dimension(1195, 511));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        combAccessLvl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desarrollador/Administrador", "Administrador de horarios", "Administrador de unidades", "Usuario mortal" }));

        btnAgregaUser.setText("AGREGAR");
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

        btnDeleteUser.setText("ELIMINAR");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        btnReloadTables.setText("RECARGAR TABLAS");
        btnReloadTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadTablesActionPerformed(evt);
            }
        });

        btnUpdate.setText("ACTUALIZAR");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblHash.setText("Hash");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserid)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
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
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtVerifyPasswd)
                                        .addComponent(txtPasswd)
                                        .addComponent(txtName)
                                        .addComponent(txtLastName)
                                        .addComponent(txtEmail)
                                        .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                        .addComponent(txtUsername)
                                        .addComponent(combAccessLvl, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnAgregaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnReloadTables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblHash))))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregaUser)
                            .addComponent(btnDeleteUser)
                            .addComponent(btnUpdate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReloadTables)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHash)
                        .addGap(45, 45, 45)
                        .addComponent(lblUserid))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        TabMaster.addTab("Agregar Usuario", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1195, 511));

        jTable1.setModel(modeloTabla);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setMaximumSize(new java.awt.Dimension(380, 480));
        jTable1.setMinimumSize(new java.awt.Dimension(380, 480));
        jTable1.setPreferredSize(new java.awt.Dimension(380, 480));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(modeloTablaOkAccess12);
        jTable2.setMaximumSize(new java.awt.Dimension(380, 480));
        jTable2.setMinimumSize(new java.awt.Dimension(380, 480));
        jTable2.setPreferredSize(new java.awt.Dimension(380, 480));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(modeloTablaUsers12);
        jTable3.setMaximumSize(new java.awt.Dimension(380, 480));
        jTable3.setMinimumSize(new java.awt.Dimension(380, 480));
        jTable3.setPreferredSize(new java.awt.Dimension(380, 480));
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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabMaster.addTab("Bitacoras", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

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
        btnEncender.setText("ENCENDER");
        btnEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncenderActionPerformed(evt);
            }
        });

        btnApagar.setBackground(new java.awt.Color(255, 0, 0));
        btnApagar.setText("APAGAR");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        lblLamp1.setText("Status");

        lblLamp2.setText("Status");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(btnTemp20)
                        .addGap(53, 53, 53)
                        .addComponent(btnTemp25)
                        .addGap(49, 49, 49)
                        .addComponent(btnTemp30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnEncender)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RadiobtnLamp1)
                            .addComponent(RadiobtnLamp2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLamp1)
                            .addComponent(lblLamp2))))
                .addContainerGap(348, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnTemp30)
                                    .addComponent(btnTemp25)
                                    .addComponent(btnTemp20)
                                    .addComponent(btnEncender)
                                    .addComponent(btnApagar)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLamp2)
                            .addComponent(RadiobtnLamp1))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lblLamp1))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(RadiobtnLamp2)))
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
        );

        TabMaster.addTab("Control Maestro Iluminacion y Temperatura", jPanel5);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTable5.setModel(modeloTablaSingleBoardPC);
        jScrollPane5.setViewportView(jTable5);

        btnPasarDatos.setText("PASAR DATOS");
        btnPasarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarDatosActionPerformed(evt);
            }
        });

        jButton3.setText("BORRAR");

        btnVerifySBP.setText("VERIFICAR");
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
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPasarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerifySBP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(614, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblStatus)
                .addGap(18, 18, 18)
                .addComponent(btnPasarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(btnVerifySBP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addContainerGap())
        );

        TabMaster.addTab("Dev", jPanel4);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Letra de edificio");

        btnAddBuild.setText("AGREGAR EDIFICIO");
        btnAddBuild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBuildActionPerformed(evt);
            }
        });

        jLabel9.setText("Edificio");

        jLabel11.setText("Salon para agregar");

        txtclassRoom.setMaximumSize(new java.awt.Dimension(205, 20));
        txtclassRoom.setMinimumSize(new java.awt.Dimension(205, 20));
        txtclassRoom.setPreferredSize(new java.awt.Dimension(205, 20));

        btnAddClassRoom.setText("Agregar salon");
        btnAddClassRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClassRoomActionPerformed(evt);
            }
        });

        txtBuildRoom.setMaximumSize(new java.awt.Dimension(205, 20));
        txtBuildRoom.setMinimumSize(new java.awt.Dimension(205, 20));
        txtBuildRoom.setPreferredSize(new java.awt.Dimension(205, 20));

        jLabel14.setText("Temperatura Min.");

        jLabel15.setText("Temperatura Max.");

        jLabel16.setText("Temperatura Med.");

        jLabel17.setText("Temperatura selecc.");

        jLabel18.setText("Modo");

        txtminTemp.setMaximumSize(new java.awt.Dimension(205, 20));
        txtminTemp.setMinimumSize(new java.awt.Dimension(205, 20));
        txtminTemp.setPreferredSize(new java.awt.Dimension(205, 20));
        txtminTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtminTempActionPerformed(evt);
            }
        });

        txtmidTemp.setMaximumSize(new java.awt.Dimension(205, 20));
        txtmidTemp.setMinimumSize(new java.awt.Dimension(205, 20));
        txtmidTemp.setPreferredSize(new java.awt.Dimension(205, 20));

        txtmaxTemp.setMaximumSize(new java.awt.Dimension(205, 20));
        txtmaxTemp.setMinimumSize(new java.awt.Dimension(205, 20));
        txtmaxTemp.setPreferredSize(new java.awt.Dimension(205, 20));

        txtselTemp.setMaximumSize(new java.awt.Dimension(205, 20));
        txtselTemp.setMinimumSize(new java.awt.Dimension(205, 20));
        txtselTemp.setPreferredSize(new java.awt.Dimension(205, 20));

        txtmode.setMaximumSize(new java.awt.Dimension(205, 20));
        txtmode.setMinimumSize(new java.awt.Dimension(205, 20));
        txtmode.setPreferredSize(new java.awt.Dimension(205, 20));

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
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtselTemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtmaxTemp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAddBuild, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAddClassRoom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdateRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeleteRoms, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblroomid)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel9)
                                                    .addGap(53, 53, 53)))
                                            .addGap(24, 24, 24)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtBuild, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtBuildRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtclassRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel16))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtminTemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtmidTemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(270, 270, 270)
                                .addComponent(lblbuild)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddBuild)
                        .addGap(12, 12, 12)
                        .addComponent(lblroomid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtBuildRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtclassRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtminTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtmidTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtmaxTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtselTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtmode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdateRoom)
                            .addComponent(btnAddClassRoom)
                            .addComponent(btnDeleteRoms))
                        .addGap(59, 59, 59)))
                .addGap(37, 37, 37)
                .addComponent(lblbuild)
                .addGap(124, 124, 124))
        );

        TabMaster.addTab("Agregar Edificio y Salón", jPanel2);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jTable7.setModel(modeloTablaReservs);
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable7);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel19.setText("Reservas");

        cmbUserTabReservs.setMaximumSize(new java.awt.Dimension(200, 20));
        cmbUserTabReservs.setMinimumSize(new java.awt.Dimension(200, 20));
        cmbUserTabReservs.setPreferredSize(new java.awt.Dimension(200, 20));

        cmbBuildingTabReservs.setMaximumSize(new java.awt.Dimension(200, 20));
        cmbBuildingTabReservs.setMinimumSize(new java.awt.Dimension(200, 20));
        cmbBuildingTabReservs.setPreferredSize(new java.awt.Dimension(200, 20));
        cmbBuildingTabReservs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBuildingTabReservsActionPerformed(evt);
            }
        });

        cmbRoomTabReservs.setMaximumSize(new java.awt.Dimension(200, 20));
        cmbRoomTabReservs.setMinimumSize(new java.awt.Dimension(200, 20));
        cmbRoomTabReservs.setPreferredSize(new java.awt.Dimension(200, 20));

        jLabel20.setText("Usuario que hara la reserva:");

        jLabel21.setText("Edificio donde esta el salón:");

        jLabel22.setText("Salon que se va a reservar:");

        jButton2.setText("Recargar Tabla");

        jLabel23.setText("Dia:");

        cmbHourTabReservs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22" }));
        cmbHourTabReservs.setMaximumSize(new java.awt.Dimension(200, 20));
        cmbHourTabReservs.setMinimumSize(new java.awt.Dimension(200, 20));
        cmbHourTabReservs.setPreferredSize(new java.awt.Dimension(200, 20));

        jLabel24.setText("Hora:");

        btnReservar.setText("RESERVAR AULA");
        btnReservar.setMaximumSize(new java.awt.Dimension(200, 30));
        btnReservar.setMinimumSize(new java.awt.Dimension(200, 30));
        btnReservar.setPreferredSize(new java.awt.Dimension(200, 30));
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        btnReservar1.setText("LIBERAR AULA");
        btnReservar1.setMaximumSize(new java.awt.Dimension(200, 30));
        btnReservar1.setMinimumSize(new java.awt.Dimension(200, 30));
        btnReservar1.setPreferredSize(new java.awt.Dimension(200, 30));
        btnReservar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jButton2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserIdRes)
                    .addComponent(lbldateRes)
                    .addComponent(lblwdhRes)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(lblRoomidRes))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19)
                            .addComponent(cmbBuildingTabReservs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbRoomTabReservs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbHourTabReservs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbUserTabReservs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SelectorDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnReservar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(cmbUserTabReservs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(cmbBuildingTabReservs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(cmbRoomTabReservs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(SelectorDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(cmbHourTabReservs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReservar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUserIdRes)
                        .addGap(18, 18, 18)
                        .addComponent(lblRoomidRes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbldateRes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblwdhRes)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabMaster.addTab("Reservas", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTable8.setModel(modeloTablaHours);
        jScrollPane8.setViewportView(jTable8);

        jLabel25.setText("Edicion de Horarios");

        cmbFirstNameTabHours.setMaximumSize(new java.awt.Dimension(200, 20));
        cmbFirstNameTabHours.setMinimumSize(new java.awt.Dimension(200, 20));
        cmbFirstNameTabHours.setPreferredSize(new java.awt.Dimension(200, 20));

        jLabel26.setText("Nombre");

        jLabel27.setText("Edificio");

        cmbBuildingTabHours.setMaximumSize(new java.awt.Dimension(200, 20));
        cmbBuildingTabHours.setMinimumSize(new java.awt.Dimension(200, 20));
        cmbBuildingTabHours.setPreferredSize(new java.awt.Dimension(200, 20));
        cmbBuildingTabHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBuildingTabHoursActionPerformed(evt);
            }
        });

        jLabel28.setText("Salon");

        cmbRoomTabHours.setMaximumSize(new java.awt.Dimension(200, 20));
        cmbRoomTabHours.setMinimumSize(new java.awt.Dimension(200, 20));
        cmbRoomTabHours.setPreferredSize(new java.awt.Dimension(200, 20));

        btnAceptarHours.setText("ACEPTAR");
        btnAceptarHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarHoursActionPerformed(evt);
            }
        });

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
        cmbHorarioHora.setMaximumSize(new java.awt.Dimension(200, 20));
        cmbHorarioHora.setMinimumSize(new java.awt.Dimension(200, 20));
        cmbHorarioHora.setPreferredSize(new java.awt.Dimension(200, 20));

        jLabel29.setText("Hora");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbHorarioHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbFirstNameTabHours, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbBuildingTabHours, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbRoomTabHours, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAceptarHours, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chkbJueves)
                                .addComponent(chkbViernes)
                                .addComponent(chkbSabado)
                                .addComponent(chkbLunes)
                                .addComponent(chkbMartes)
                                .addComponent(chkbMiercoles)))
                        .addGap(156, 412, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel25)
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cmbFirstNameTabHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(cmbBuildingTabHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRoomTabHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbHorarioHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkbLunes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkbMartes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkbMiercoles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkbJueves)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkbViernes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkbSabado)
                .addGap(13, 13, 13)
                .addComponent(btnAceptarHours, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        TabMaster.addTab("Horarios", jPanel7);

        jPanel8.setBackground(new java.awt.Color(204, 0, 0));

        btnback.setBackground(new java.awt.Color(255, 255, 255));
        btnback.setForeground(new java.awt.Color(204, 0, 0));
        btnback.setText("◄ VOLVER");
        btnback.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 3));
        btnback.setMaximumSize(new java.awt.Dimension(80, 46));
        btnback.setMinimumSize(new java.awt.Dimension(80, 46));
        btnback.setPreferredSize(new java.awt.Dimension(80, 46));
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("CONTROL ADMINISTRATIVO");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TabMaster, javax.swing.GroupLayout.PREFERRED_SIZE, 1195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabMaster, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void cmbBuildingTabReservsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBuildingTabReservsActionPerformed
        // TODO add your handling code here:
        try {
            cargarRoomsCombBoxTabReservs();
        } catch (SQLException ex) {
            Logger.getLogger(AgregarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbBuildingTabReservsActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
     String formato = "yyyy-MM-dd";
     String formatoNombreDia = "E";
     String username = cmbUserTabReservs.getSelectedItem().toString();
     String room = cmbRoomTabReservs.getSelectedItem().toString();
     String userId = Conexion.getUserId(username);
     String roomId = Conexion.getRoomId(room);
      
        java.util.Date dateInsert = SelectorDia.getDate();
        java.util.Date date = SelectorDia.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        SimpleDateFormat sdf1 = new SimpleDateFormat(formatoNombreDia);
        String formatoMetodo = sdf1.format(date);
        String formatoDate = sdf.format(dateInsert);
        int Hora = Integer.parseInt(cmbHourTabReservs.getSelectedItem().toString());
        String formatoMetodoBien = String.valueOf(formatoMetodo.toUpperCase().charAt(0)) + formatoMetodo.charAt(1);
        String sout = "" + Hora;
        String cero = "0";
        String mix = "00";
        
         if(Hora <= 9){
            mix = cero + sout;
            int weekDayAndHourValue = Conexion.metodoDiaHoraToByte(formatoMetodoBien + mix);
            
//             System.out.println("userId = " + userId);
//             System.out.println("roomId = " + roomId);
//             System.out.println("Date = " + formatoDate);
//             System.out.println("Dia y Hora = " + weekDayAndHourValue);
//             System.out.println("Caso = " + Case);
             
             Conexion.addReservs(userId, roomId, formatoDate, weekDayAndHourValue, this);
             
         }else {
             int weekDayAndHourValue = Conexion.metodoDiaHoraToByte(formatoMetodoBien + sout);
//             System.out.println("userId = " + userId);
//             System.out.println("roomId = " + roomId);
//             System.out.println("Date = " + formatoDate);
//             System.out.println("Dia y Hora = " + weekDayAndHourValue);
//             System.out.println("Caso = " + Case);
             Conexion.addReservs(userId, roomId, formatoDate, weekDayAndHourValue, this);
         }
         setRowReservs();
        //lblTest.setText(sdf.format(date));
        //System.out.println(String.valueOf(formatoMetodo.toUpperCase().charAt(0)) + formatoMetodo.charAt(1));
       
        //Conexion.addReservs(, formato, formato, HAND_CURSOR, WIDTH)
        
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

    private void chkbSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbSabadoActionPerformed

    }//GEN-LAST:event_chkbSabadoActionPerformed

    private void btnAceptarHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarHoursActionPerformed
        String name = (String) cmbFirstNameTabHours.getSelectedItem();
        String build = (String) cmbBuildingTabHours.getSelectedItem();
        String room = (String) cmbRoomTabHours.getSelectedItem();
        String Status = "";
        boolean lunes=chkbLunes.isSelected();
        boolean martes=chkbMartes.isSelected();
        boolean miercoles=chkbMiercoles.isSelected();
        boolean jueves=chkbJueves.isSelected();
        boolean viernes=chkbViernes.isSelected();
        boolean sabado=chkbSabado.isSelected();
        int hora= Integer.parseInt(cmbHorarioHora.getSelectedItem().toString());
        String userId= Conexion.getUserId(name);
        String buildId= Conexion.getBuildId(build);
        String roomId = Conexion.getRoomId(room);
        
        
        
        String sout = "" + hora;
        String cero = "0";
        String mix = "00";

        if(lunes){
        Status = "Lu";
          if(hora<=9){
             mix = cero + sout;
             int weekDayAndHour = Conexion.metodoDiaHoraToByte(Status+mix);
             if(Conexion.verifyNoDoubleHour(room, weekDayAndHour)){
                 JOptionPane.showMessageDialog(rootPane, "El salon ya esta siendo usado a esa hora.");
              }else{
               Conexion.addHours(userId, roomId, weekDayAndHour);  
              } 
           }else{
              int weekDayAndHour = Conexion.metodoDiaHoraToByte(Status+hora);
               if(Conexion.verifyNoDoubleHour(room, weekDayAndHour)){
                JOptionPane.showMessageDialog(rootPane, "El salon ya esta siendo usado a esa hora.");  
               }else{
               Conexion.addHours(userId, roomId, weekDayAndHour); 
               JOptionPane.showMessageDialog(null,"Hora añadida con exito.");                  
               }
            }
        }
        if(martes){
            Status = "Ma";
            if(hora<=9){
                mix = cero + sout;
                int weekDayAndHour = Conexion.metodoDiaHoraToByte(Status+mix);
             if(Conexion.verifyNoDoubleHour(room, weekDayAndHour)){
                 JOptionPane.showMessageDialog(rootPane, "El salon ya esta siendo usado a esa hora.");
              }else{
               Conexion.addHours(userId, roomId, weekDayAndHour);  
              }
            }else{
                int weekDayAndHour = Conexion.metodoDiaHoraToByte(Status+hora);
               if(Conexion.verifyNoDoubleHour(room, weekDayAndHour)){
                JOptionPane.showMessageDialog(rootPane, "El salon ya esta siendo usado a esa hora.");  
               }else{
               Conexion.addHours(userId, roomId, weekDayAndHour); 
               JOptionPane.showMessageDialog(null,"Hora añadida con exito.");                  
               }
            }
        }
        if(miercoles){
          Status = "Mi";
            if(hora<=9){
                mix = cero + sout;
                int weekDayAndHour = Conexion.metodoDiaHoraToByte(Status+mix);
             if(Conexion.verifyNoDoubleHour(room, weekDayAndHour)){
                 JOptionPane.showMessageDialog(rootPane, "El salon ya esta siendo usado a esa hora.");
              }else{
               Conexion.addHours(userId, roomId, weekDayAndHour);  
              }
            }else{
                int weekDayAndHour = Conexion.metodoDiaHoraToByte(Status+hora);
               if(Conexion.verifyNoDoubleHour(room, weekDayAndHour)){
                JOptionPane.showMessageDialog(rootPane, "El salon ya esta siendo usado a esa hora.");  
               }else{
               Conexion.addHours(userId, roomId, weekDayAndHour); 
               JOptionPane.showMessageDialog(null,"Hora añadida con exito.");                  
               }
            }  
        }
        if(jueves){
           Status = "Ju";
            if(hora<=9){
                mix = cero + sout;
                int weekDayAndHour = Conexion.metodoDiaHoraToByte(Status+mix);
             if(Conexion.verifyNoDoubleHour(room, weekDayAndHour)){
                 JOptionPane.showMessageDialog(rootPane, "El salon ya esta siendo usado a esa hora.");
              }else{
               Conexion.addHours(userId, roomId, weekDayAndHour);  
              }
            }else{
                int weekDayAndHour = Conexion.metodoDiaHoraToByte(Status+hora);
               if(Conexion.verifyNoDoubleHour(room, weekDayAndHour)){
                JOptionPane.showMessageDialog(rootPane, "El salon ya esta siendo usado a esa hora.");  
               }else{
               Conexion.addHours(userId, roomId, weekDayAndHour); 
               JOptionPane.showMessageDialog(null,"Hora añadida con exito.");                  
               }
            }
        }
        if(viernes){
          Status = "Vi";
            if(hora<=9){
                mix = cero + sout;
                int weekDayAndHour = Conexion.metodoDiaHoraToByte(Status+mix);
             if(Conexion.verifyNoDoubleHour(room, weekDayAndHour)){
                 JOptionPane.showMessageDialog(rootPane, "El salon ya esta siendo usado a esa hora.");
             }else{
               Conexion.addHours(userId, roomId, weekDayAndHour);  
              }
            }else{
                int weekDayAndHour = Conexion.metodoDiaHoraToByte(Status+hora);
               if(Conexion.verifyNoDoubleHour(room, weekDayAndHour)){
                JOptionPane.showMessageDialog(rootPane, "El salon ya esta siendo usado a esa hora.");  
               }else{
               Conexion.addHours(userId, roomId, weekDayAndHour); 
               JOptionPane.showMessageDialog(null,"Hora añadida con exito.");                  
               }
            }
        }
        if(sabado){
          Status = "Sa";
            if(hora<=9){
                mix = cero + sout;
                int weekDayAndHour = Conexion.metodoDiaHoraToByte(Status+mix);
             if(Conexion.verifyNoDoubleHour(room, weekDayAndHour)){
                 JOptionPane.showMessageDialog(rootPane, "El salon ya esta siendo usado a esa hora.");
             }else{
               Conexion.addHours(userId, roomId, weekDayAndHour);  
              }
            }else{
                int weekDayAndHour = Conexion.metodoDiaHoraToByte(Status+hora);
               if(Conexion.verifyNoDoubleHour(room, weekDayAndHour)){
                JOptionPane.showMessageDialog(rootPane, "El salon ya esta siendo usado a esa hora.");  
               }else{
               Conexion.addHours(userId, roomId, weekDayAndHour); 
               JOptionPane.showMessageDialog(null,"Hora añadida con exito.");                  
               }
            }
        }
        setRowHours();
    }//GEN-LAST:event_btnAceptarHoursActionPerformed

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
    int fila = jTable7.getSelectedRow();
        if(fila>=0){

            lblUserIdRes.setText(jTable7.getValueAt(fila, 0).toString());
            lblRoomidRes.setText(jTable7.getValueAt(fila, 1).toString());
            lbldateRes.setText(jTable7.getValueAt(fila, 2).toString());
            lblwdhRes.setText(jTable7.getValueAt(fila, 3).toString());
            lblUserIdRes.setVisible(false);
            lblRoomidRes.setVisible(false);
            lbldateRes.setVisible(false);
            lblwdhRes.setVisible(false);
           
            }
            else{
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
    }//GEN-LAST:event_jTable7MouseClicked

    private void btnReservar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservar1ActionPerformed
        String idUser = lblUserIdRes.getText();
        String roomId = lblRoomidRes.getText();
        String date = lbldateRes.getText();
        String wdh = lblwdhRes.getText();
        
        
        Conexion.CancelRoom(idUser, roomId, date,  wdh, this);
        setRowReservs();
    }//GEN-LAST:event_btnReservar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
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
        }*/
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
    private com.toedter.calendar.JDateChooser SelectorDia;
    private javax.swing.JTabbedPane TabMaster;
    private javax.swing.JButton btnAceptarHours;
    private javax.swing.JButton btnAddBuild;
    private javax.swing.JButton btnAddClassRoom;
    private javax.swing.JButton btnAgregaUser;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnDeleteRoms;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnEncender;
    private javax.swing.JButton btnPasarDatos;
    private javax.swing.JButton btnReloadTables;
    private javax.swing.JButton btnReservar;
    private javax.swing.JButton btnReservar1;
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
    private javax.swing.JComboBox<String> cmbBuildingTabHours;
    private javax.swing.JComboBox<String> cmbBuildingTabReservs;
    private javax.swing.JComboBox<String> cmbFirstNameTabHours;
    private javax.swing.JComboBox<String> cmbHorarioHora;
    private javax.swing.JComboBox<String> cmbHourTabReservs;
    private javax.swing.JComboBox<String> cmbRoomTabHours;
    private javax.swing.JComboBox<String> cmbRoomTabReservs;
    private javax.swing.JComboBox<String> cmbUserTabReservs;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
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
    private javax.swing.JPanel jPanel8;
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
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JLabel lblHash;
    private javax.swing.JLabel lblLamp1;
    private javax.swing.JLabel lblLamp2;
    private javax.swing.JLabel lblRoomidRes;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUserIdRes;
    private javax.swing.JLabel lblUserid;
    private javax.swing.JLabel lblbuild;
    private javax.swing.JLabel lbldateRes;
    private javax.swing.JLabel lblroomid;
    private javax.swing.JLabel lblwdhRes;
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
