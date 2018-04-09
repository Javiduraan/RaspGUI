
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.swing.JOptionPane;
import sun.misc.BASE64Encoder;


public class Conexion {
   public static Connection cone = null;
   public static Connection conectorGetinf = null;
   public static Connection crear() throws SQLException, ClassNotFoundException { //Metodo para crear la conexion con la base de datos del Raspbrry
    if (cone == null) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Buscamos el driver que vamos a utilizar
            cone = DriverManager.getConnection("jdbc:mysql://localhost/javard-sl--master","JAVARD-SL--MASTERUSER","clave");
          // cone = DriverManager.getConnection("jdbc:mysql://192.168.137.243:3306/Prototipo","lolo","tec2.123"); //Buscamos la base de datos con el usuario y pass para crear la conexion exitosa.
            } catch (SQLException ex){ //Si no se consigue la conexion se el programa lanzara un error
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
    }
    return cone;
   }
   public static Connection crearConexionGetInf() throws SQLException, ClassNotFoundException {
       if (conectorGetinf == null){
           try {
               Class.forName("com.mysql.jdbc.Driver");
               conectorGetinf = DriverManager.getConnection("jdbc:mysql://localhost/javard-sl--getinf","JAVARD-SL--MASTERUSER","clave");
           } catch (SQLException ex){
               throw new SQLException(ex);
           } catch (ClassNotFoundException ex){
               throw new ClassCastException(ex.getMessage());
           }
       }
      return conectorGetinf;
   }
   public static void cerrar() throws SQLException { //metodo para cerrar la conexion 
       if (cone != null) {
           cone.close();
           cone = null;
       }
   }
   public static boolean lamparas(int vLamp, int lamp){
    Statement query;
       try{
         query = cone.createStatement();
       }catch (SQLException ex){
           return false;
       }
       //Update 
       String str = "UPDATE units SET value=" + vLamp+ " WHERE unitId=" + lamp + ";";
       try{
           query.executeUpdate(str);
       }catch (SQLException ex){
           return false;
       }
       
    return true;   
   } //Rehacer esta parte para la nueva BD 
   public static boolean usuarioNuevo(String username, String passwd, String firstName, String LastName, int accesslvl, String eMail, String Phone ){
       Statement query;
       try{
           query = cone.createStatement();
       }catch (SQLException ex){
           
           System.out.println("error al crear el query!!");
           return false;
       }
       String stat = "INSERT INTO users (username, password, firstName, lastName, accessLevel, mail, phone) VALUES ('"+username+"', '"+passwd+"', '"+firstName+"', '"+LastName+"', "+accesslvl+", '"+eMail+"', '"+Phone+"');";
       try{
           query.execute(stat);
       }catch (SQLException ex){
           ex.toString();
           System.out.println(ex);
           return false;
       }
       return true;
   } //Esta parte no se Rehace 
   public static boolean DeleteUser(String userId ){
       Statement query;
       try{
           query = cone.createStatement();
       }catch (SQLException ex){
           
           System.out.println("error al crear el query!!");
           return false;
       }
       String stat1 = "DELETE from Reservs WHERE userId = "+userId+";";
       String stat2 = "DELETE from Hours WHERE userId = "+userId+";";
       String stat3 = "DELETE from FailAccessLogs WHERE userId = "+userId+";";
       String stat4 = "DELETE from OkAccessLogs WHERE userId = "+userId+";";
       String stat5 = "DELETE from users WHERE userId = "+userId+";";
       try{
           query.execute(stat1);
           query.execute(stat2);
           query.execute(stat3);
           query.execute(stat4);
           query.execute(stat5);
       }catch (SQLException ex){
           ex.toString();
           System.out.println(ex);
           return false;
       }
       return true;
   }
   public static boolean EditUser(String id, String username, String passwd, String firstName, String LastName, int accesslvl, String eMail, String Phone ){
       Statement query;
       try{
           query = cone.createStatement();
       }catch (SQLException ex){
           
           System.out.println("error al crear el query!!");
           return false;
       }
       String stat = "UPDATE Users SET username='"+username+"', password='"+passwd+"', firstName='"+firstName+"', lastName='"+LastName+"', accessLevel="+accesslvl+", mail='"+eMail+"', phone='"+Phone+"' WHERE userId = "+id+";";
       try{
           query.execute(stat);
       }catch (SQLException ex){
           ex.toString();
           System.out.println(ex);
           return false;
       }
       return true;
   }
   
   public static boolean edificioNuevo(String edificio){
       Statement query; 
       try{
           query = cone.createStatement();
       }catch(SQLException ex){
           return false; 
       }
       String insert = "INSERT INTO buildings(name) Values ('" +edificio+"');";
       try{
           query.execute(insert);
       }catch(SQLException ex){
           return false;
       }
       return true;
   } //Esta parte tampoco se Rehace
   public static boolean newClassRoom (String BuildId, String classRoom){
       Statement query; 
       try{
           query = cone.createStatement();
       }catch(SQLException ex){
           return false; 
       }
       String insert = "INSERT INTO Rooms(buildingId, name) Values ('"+BuildId+"', '"+classRoom+"');";
       try{
           query.execute(insert);
       }catch(SQLException ex){
           System.out.println(ex);
           return false;
       }
       return true;
       
   } //Esta PARTE SI SE REHACE, GRACIAS DANIEL.
   public static String getBuildId(String name){ 
       Statement query;
       int resultado;
       String resul = "";
       try {
           query = cone.createStatement();
       } catch (Exception ex) {
           return "error";
       }
       String select = "SELECT buildingId FROM Buildings WHERE name='"+name+"';";
       try{
          ResultSet rs = query.executeQuery(select);
          if(rs.next()){
            resultado = rs.getInt("buildingId"); 
            resul = Integer.toString(resultado);
          }
       }catch(SQLException ex){
           System.out.println(ex.toString());
           
           return "catch 2";
           //s
       }
       return resul;
   } //Esto no se Rehace
   public static String encriptar(String usuario, String passwd){
      String passEncr="";
      while(usuario.length() < 8){
          usuario += usuario;
      }
        try{
            SecretKeyFactory key = SecretKeyFactory.getInstance("DES");
            DESKeySpec kspec = new DESKeySpec(usuario.getBytes());
            SecretKey ks = key.generateSecret(kspec);
            try{
                Cipher cifrado = Cipher.getInstance("DES/ECB/PKCS5Padding");
                cifrado.init(Cipher.ENCRYPT_MODE,ks);
                byte[] cadbyte = passwd.getBytes();
                byte[] cadena = cifrado.doFinal(cadbyte);
                String passwdEncrypt = new BASE64Encoder().encode(cadena);
                passEncr = passwdEncrypt;
            }catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}catch(NoSuchPaddingException e){
			e.printStackTrace();
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}catch(IllegalBlockSizeException e){
			e.printStackTrace();
		}catch(BadPaddingException e){
			e.printStackTrace();
		}
        }catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}catch(InvalidKeyException e){
			e.printStackTrace();
		} catch (InvalidKeySpecException ex) {
                      ex.printStackTrace();
        }
       
       return passEncr;
   } //Esto no se Rehace 
   public static int validarUser(String user, String pass){
       Statement consulta;
       //String user = LogIn.txtUsuario.getText();
       //String pass = LogIn.txtPass.getText();
       String passEncrypted = Conexion.encriptar(user, pass);
       int resultado=0;
       
       
         try{
             consulta = cone.createStatement();
         }catch(SQLException e){
             System.out.println(e.toString());
             return resultado;
         }
         String SQL = "SELECT * FROM users WHERE username='"+user+"' AND password='"+passEncrypted+"';";
         try{
             ResultSet rs = consulta.executeQuery(SQL);
             if(rs.next()){
                 resultado=1;
             }
         }catch (SQLException ex){
             System.out.println(ex.toString());
             return resultado;
         }
         
    return resultado;
    
   } //Esto tampoco se Rehace 
   public static String getUserId (String username){
       Statement consulta;
        int resultado;
       String resul= "";
       try{
         consulta = cone.createStatement();
       }catch(SQLException ex){
           return "Error creando statement";
       }
       String SQL = "SELECT userId FROM users WHERE username='"+username+"';";
       try{
          ResultSet rs = consulta.executeQuery(SQL);
          if(rs.next()){
            resultado = rs.getInt("userId"); 
           resul = Integer.toString(resultado);
          }
       }catch(SQLException ex){
           System.out.println(ex.toString());
           return "Error al hacer la consulta";
       }
       return resul;
   } //TAMPOCO 
   public static String getAccesslevel(String username){ //Metodo GET que devuelve el nivel de acceso de un usuario basado en su nombre de usuario.
       Statement consulta;
       int resultado;
       String resul= "";
       try{
         consulta = cone.createStatement();
       }catch(SQLException ex){
           return "null";
       }
       String SQL = "SELECT accessLevel FROM users WHERE username='"+username+"';";
       try{
          ResultSet rs = consulta.executeQuery(SQL);
          if(rs.next()){
            resultado = rs.getInt("accessLevel"); 
           resul = Integer.toString(resultado);
          }
       }catch(SQLException ex){
           System.out.println(ex.toString());
           return "null";
       }
       return resul;
   } 
   public static boolean accessLogFail(String userId, String date, String time, String details){
       Statement consulta;
       try{
         consulta = cone.createStatement();
       }catch(SQLException ex){
           System.out.println(ex.toString());
           return false;
       }
       String SQL = "INSERT INTO failaccesslogs (userId, date, time, details) VALUES ("+userId+", '"+date+"', '"+time+"', '"+details+"');";
       try{
          consulta.execute(SQL);
       }catch(SQLException ex){
           System.out.println(ex.toString());
           return false;
       }
       return true;
   } //Esto tampoco se Rehace 
   public static boolean okAccessLog(String userId, String date, String time, String details){
       Statement consulta;
       try{
         consulta = cone.createStatement();
       }catch(SQLException ex){
           System.out.println(ex.toString());
           return false;
       }
       String SQL = "INSERT INTO okaccesslogs (userId, date, time, details) VALUES ("+userId+", '"+date+"', '"+time+"', '"+details+"');";
       try{
          consulta.execute(SQL);
       }catch(SQLException ex){
           System.out.println(ex.toString());
           return false;
       }
       return true;
   } //Esto tampoco se cambia esta chido
   public static int verifyAccessSBP(){ //Verificar tabla access en base de datos javard-sl--getinf esta vacia.
       Statement consulta;
       int resultado = 0;
       try{
         consulta = conectorGetinf.createStatement();
       }catch(SQLException ex){
           return resultado; 
       }
       String SQL = "SELECT * FROM access WHERE  accessId= '1';";
       try{
           ResultSet rs = consulta.executeQuery(SQL);
           if(rs.next()){
               return resultado + 1;
           }
       }catch(SQLException ex){
           return resultado; 
       }
       return resultado;
   }
   public static boolean comparacionTablaGetInf(){
       Statement consulta, consulta2; 
       try{
          consulta = conectorGetinf.createStatement();
          consulta2 = cone.createStatement();
       }catch(SQLException ex){
           System.out.println(ex.toString());
           return false; 
       }
       String SQL = "SELECT * FROM access WHERE A = 'JAVARD-SL--RBP3001' AND B = 'clave' AND C = 'localhost' AND D = 'JAVARD-SL--Master';";
       String SQL2 = "SELECT * FROM singleboardspc WHERE username ='JAVARD-SL--RBP3001' AND password = 'clave' AND hostname = 'localhost' AND singleboardspc.database = 'JAVARD-SL--Master';";
       try{
        ResultSet rs = consulta.executeQuery(SQL);  
        ResultSet rs2 = consulta2.executeQuery(SQL2);
        if(rs.next() && rs2.next()){
            return true;
        }else{
            return false;
        }
       }catch(SQLException ex){
           System.out.println(ex.toString());
           return false;
           
       }       
   }
   public static boolean pasarDatosEntreTablas(){
       Statement consulta; 
       String resul = "";
       try{
           consulta = cone.createStatement(); 
       }catch(SQLException ex){
           return false;
       }
       String SQL = "SELECT * FROM singleboardspc WHERE SingleBoardsPcId = 1; " ; 
       try{
           ResultSet rs = consulta.executeQuery(SQL);
           if(rs.next()){
             resul = rs.getString("username");
           }
       }catch(SQLException ex){
           
       }
   }   
}
