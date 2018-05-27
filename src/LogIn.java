
import java.awt.Color;
//import java.awt.Image;
//import java.awt.Toolkit;
import java.awt.event.KeyEvent;
//import javax.swing.JOptionPane;
//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.io.*;
//import javax.crypto.*;
//import javax.crypto.spec.DESKeySpec;
//import java.security.*;
//import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.time.LocalTime;
//import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.crypto.spec.SecretKeySpec;
//import javax.swing.BorderFactory;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JPanel;
import javax.swing.UIManager;
//import javax.swing.border.Border;
//import javax.swing.border.LineBorder;
//import sun.misc.BASE64Encoder;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MSI
 */
public class LogIn extends javax.swing.JFrame {
 Conexion cone = new Conexion();
 LocalDate date = LocalDate.now();
 LocalTime time = LocalTime.now();


    public LogIn() {
        initComponents();
        setLocationRelativeTo(null);
        ServerStatus();
    }
    
    public void ServerStatus(){
        if(Conexion.cone != null){
            lblEdoServer.setText("● Conectado");
            lblEdoServer.setForeground(Color.green);
        }else{
            lblEdoServer.setText("● Desconectado");
            lblEdoServer.setForeground(Color.red);
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

        jPanel1 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        lblEdoServer = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        logoJavard1 = new customComponents.logoJavard();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control Global");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(300, 400));
        setMinimumSize(new java.awt.Dimension(300, 400));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(300, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 400));

        txtUsuario.setMaximumSize(new java.awt.Dimension(140, 25));
        txtUsuario.setMinimumSize(new java.awt.Dimension(140, 25));
        txtUsuario.setPreferredSize(new java.awt.Dimension(140, 25));
        txtUsuario.setSelectionColor(new java.awt.Color(204, 0, 0));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        txtPass.setMaximumSize(new java.awt.Dimension(140, 25));
        txtPass.setMinimumSize(new java.awt.Dimension(140, 25));
        txtPass.setPreferredSize(new java.awt.Dimension(140, 25));
        txtPass.setSelectionColor(new java.awt.Color(204, 0, 0));
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 0, 11)); // NOI18N
        jLabel1.setText("USUARIO");
        jLabel1.setMaximumSize(new java.awt.Dimension(90, 14));
        jLabel1.setMinimumSize(new java.awt.Dimension(90, 14));
        jLabel1.setPreferredSize(new java.awt.Dimension(90, 14));

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 11)); // NOI18N
        jLabel2.setText("CONTRASEÑA");
        jLabel2.setMaximumSize(new java.awt.Dimension(90, 14));
        jLabel2.setMinimumSize(new java.awt.Dimension(90, 14));
        jLabel2.setPreferredSize(new java.awt.Dimension(90, 14));

        btnAceptar.setBackground(new java.awt.Color(204, 0, 0));
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("INICIAR SESION");
        btnAceptar.setMaximumSize(new java.awt.Dimension(210, 25));
        btnAceptar.setMinimumSize(new java.awt.Dimension(210, 25));
        btnAceptar.setPreferredSize(new java.awt.Dimension(210, 25));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAceptarKeyPressed(evt);
            }
        });

        lblEdoServer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEdoServer.setText("Conectado");

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BIENVENIDOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel3)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(10, 10, 10))
        );

        logoJavard1.setOpaque(false);

        javax.swing.GroupLayout logoJavard1Layout = new javax.swing.GroupLayout(logoJavard1);
        logoJavard1.setLayout(logoJavard1Layout);
        logoJavard1Layout.setHorizontalGroup(
            logoJavard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );
        logoJavard1Layout.setVerticalGroup(
            logoJavard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEdoServer, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(logoJavard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logoJavard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEdoServer, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String user = txtUsuario.getText();
            String pass = txtPass.getText();
            AdminVen ventanaAdmin = new AdminVen();
            SecFrameLamp ventanaLamp = new SecFrameLamp();
            String userId =  Conexion.getUserId(user); // El metodo devuelve el id de usuario en String y lo pone en la variable userId
            String accessLevel = Conexion.getAccesslevel(user);
            if(userId.contentEquals("")){ //Si el Id de usuario no devuelve ningun valor se le asigna un 0 a userId, que en la base de datos es un usuario NULL.
                userId = "0";
            }

            if(Conexion.cone == null){ //Si no existe la conexion llama al metodo crear que hace la conexion.
                try {
                    Conexion.crear();
                } catch (SQLException ex) {
                    Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if(Conexion.validarUser(user, pass)== 1){   //El metodo validar devuelve un 1 si el usuario existe en la base de datos Si no, pues no existe.
                switch (accessLevel) {
                    case "0":
                    {
                        //Si el nivel de usuario es 0 el usuario es un Administrador o un desarrollador.
                        String detail = "Acceso administrativo/Dev"; //El detalle que ira en el campo detail de la tabla bitacora OkAccessLog
                        Conexion.okAccessLog(userId, date.toString(), time.toString(), detail); //Llama al metodo okAccessLog que inserta en la bitacora los detalles de el usuario.
                        ventanaAdmin.setVisible(true); //Muestra la ventana de administrador.
                        this.dispose(); //Cierra esta ventana
                        break;
                    }
                    case "1":
                    {
                        // Si el nivel de usuario es 1 significa que es un usuario de control de horarios.
                        String detail = "Acceso de control de horas autorizado";
                        Conexion.okAccessLog(userId, date.toString(), time.toString(), detail);
                        ventanaAdmin.setVisible(true);
                        this.dispose();
                        break;
                    }
                    case "2":
                    {
                        //Si el nivel de usuario es 2 significa que es un usuario de control de unidades (Luces, A/C).
                        String detail = "Acceso de control de unidades autorizado";
                        Conexion.okAccessLog(userId, date.toString(), time.toString(), detail);
                        ventanaAdmin.setVisible(true);
                        this.dispose();
                        break;
                    }
                    case "3":
                    {
                        //Si el nivel de usuario es 3 significa que es un simple mortal que solo quiere llorar. :)
                    String detail = "Acceso de usuario mortal autorizado";
                    Conexion.okAccessLog(userId, date.toString(), time.toString(), detail);
                    ventanaAdmin.setVisible(true);
                    this.dispose();
                    break;
                }
                default:
                break;
            }
        }else{  //Si no se valida el usuario, este genera un registro en la tabla de failaccesslog con el userId inexistente.
            String detail = "usuario o contraseña incorrecta"; //En esta parte no abre ninguna ventana solo muestra un mensaje de error.
            Conexion.accessLogFail(userId, date.toString(), time.toString(), detail);
            JOptionPane.showMessageDialog(null, detail);
        }
        }
    }//GEN-LAST:event_btnAceptarKeyPressed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        String user = txtUsuario.getText();
        String pass = txtPass.getText();
        AdminVen ventanaAdmin = new AdminVen();
        SecFrameLamp ventanaLamp = new SecFrameLamp();
        String userId =  Conexion.getUserId(user); // El metodo devuelve el id de usuario en String y lo pone en la variable userId
        String accessLevel = Conexion.getAccesslevel(user);
        if(userId.contentEquals("")){ //Si el Id de usuario no devuelve ningun valor se le asigna un 0 a userId, que en la base de datos es un usuario NULL.
            userId = "0";
        }

        if(Conexion.cone == null){ //Si no existe la conexion llama al metodo crear que hace la conexion.
            try {
                Conexion.crear();
            } catch (SQLException ex) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if(Conexion.validarUser(user, pass)== 1){   //El metodo validar devuelve un 1 si el usuario existe en la base de datos Si no, pues no existe.
            switch (accessLevel) {
                case "0":
                {
                    //Si el nivel de usuario es 0 el usuario es un Administrador o un desarrollador.
                    String detail = "Acceso administrativo/Dev"; //El detalle que ira en el campo detail de la tabla bitacora OkAccessLog
                    Conexion.okAccessLog(userId, date.toString(), time.toString(), detail); //Llama al metodo okAccessLog que inserta en la bitacora los detalles de el usuario.
                    ventanaAdmin.setVisible(true); //Muestra la ventana de administrador.
                    this.dispose(); //Cierra esta ventana
                    break;
                }
                case "1":
                {
                    // Si el nivel de usuario es 1 significa que es un usuario de control de horarios.
                    String detail = "Acceso de control de horas autorizado";
                    Conexion.okAccessLog(userId, date.toString(), time.toString(), detail);
                    ventanaAdmin.setVisible(true);
                    this.dispose();
                    break;
                }
                case "2":
                {
                    //Si el nivel de usuario es 2 significa que es un usuario de control de unidades (Luces, A/C).
                    String detail = "Acceso de control de unidades autorizado";
                    Conexion.okAccessLog(userId, date.toString(), time.toString(), detail);
                    ventanaAdmin.setVisible(true);
                    this.dispose();
                    break;
                }
                case "3":
                {
                    //Si el nivel de usuario es 3 significa que es un simple mortal que solo quiere llorar. :)
                String detail = "Acceso de usuario mortal autorizado";
                Conexion.okAccessLog(userId, date.toString(), time.toString(), detail);
                ventanaAdmin.setVisible(true);
                this.dispose();
                break;
            }
            default:
            break;
        }
        }else{  //Si no se valida el usuario, este genera un registro en la tabla de failaccesslog con el userId inexistente.
            String detail = "usuario o contraseña incorrecta"; //En esta parte no abre ninguna ventana solo muestra un mensaje de error.
            Conexion.accessLogFail(userId, date.toString(), time.toString(), detail);
            JOptionPane.showMessageDialog(null, detail);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String user = txtUsuario.getText();
            String pass = txtPass.getText();
            AdminVen ventanaAdmin = new AdminVen();
            SecFrameLamp ventanaLamp = new SecFrameLamp();
            String userId =  Conexion.getUserId(user); // El metodo devuelve el id de usuario en String y lo pone en la variable userId
            String accessLevel = Conexion.getAccesslevel(user);
            if(userId.contentEquals("")){ //Si el Id de usuario no devuelve ningun valor se le asigna un 0 a userId, que en la base de datos es un usuario NULL.
                userId = "0";
            }

            if(Conexion.cone == null){ //Si no existe la conexion llama al metodo crear que hace la conexion.
                try {
                    Conexion.crear();
                } catch (SQLException ex) {
                    Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if(Conexion.validarUser(user, pass)== 1){   //El metodo validar devuelve un 1 si el usuario existe en la base de datos Si no, pues no existe.
                switch (accessLevel) {
                    case "0":
                    {
                        //Si el nivel de usuario es 0 el usuario es un Administrador o un desarrollador.
                        String detail = "Acceso administrativo/Dev"; //El detalle que ira en el campo detail de la tabla bitacora OkAccessLog
                        Conexion.okAccessLog(userId, date.toString(), time.toString(), detail); //Llama al metodo okAccessLog que inserta en la bitacora los detalles de el usuario.
                        ventanaAdmin.setVisible(true); //Muestra la ventana de administrador.
                        this.dispose(); //Cierra esta ventana
                        break;
                    }
                    case "1":
                    {
                        // Si el nivel de usuario es 1 significa que es un usuario de control de horarios.
                        String detail = "Acceso de control de horas autorizado";
                        Conexion.okAccessLog(userId, date.toString(), time.toString(), detail);
                        ventanaAdmin.setVisible(true);
                        this.dispose();
                        break;
                    }
                    case "2":
                    {
                        //Si el nivel de usuario es 2 significa que es un usuario de control de unidades (Luces, A/C).
                        String detail = "Acceso de control de unidades autorizado";
                        Conexion.okAccessLog(userId, date.toString(), time.toString(), detail);
                        ventanaAdmin.setVisible(true);
                        this.dispose();
                        break;
                    }
                    case "3":
                    {
                        //Si el nivel de usuario es 3 significa que es un simple mortal que solo quiere llorar. :)
                    String detail = "Acceso de usuario mortal autorizado";
                    Conexion.okAccessLog(userId, date.toString(), time.toString(), detail);
                    ventanaAdmin.setVisible(true);
                    this.dispose();
                    break;
                }
                default:
                break;
            }
        }else{  //Si no se valida el usuario, este genera un registro en la tabla de failaccesslog con el userId inexistente.
            String detail = "usuario o contraseña incorrecta"; //En esta parte no abre ninguna ventana solo muestra un mensaje de error.
            Conexion.accessLogFail(userId, date.toString(), time.toString(), detail);
            JOptionPane.showMessageDialog(null, detail);
        }
        }
    }//GEN-LAST:event_txtPassKeyPressed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed

    }//GEN-LAST:event_txtUsuarioActionPerformed

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
            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Red", "INSERT YOUR LICENSE KEY HERE", "Company");
            //JFrame.setDefaultLookAndFeelDecorated(true);
            //ubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.CremeSkin");
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (Exception e) {
        }
        //</editor-fold>

      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
        try {
            Conexion.crear();
        } catch (SQLException ex) {
            Logger.getLogger(AdminVen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminVen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblEdoServer;
    private customComponents.logoJavard logoJavard1;
    public static javax.swing.JPasswordField txtPass;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
