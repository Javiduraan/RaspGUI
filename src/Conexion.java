
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
import sun.misc.BASE64Encoder;


public class Conexion {
    public static Connection cone = null;
   public static Connection crear() throws SQLException, ClassNotFoundException { //Metodo para crear la conexion con la base de datos del Raspbrry
    if (cone == null) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Buscamos el driver que vamos a utilizar
            cone = DriverManager.getConnection("jdbc:mysql://localhost/javard-sl--masterrev1","JAVARD-SL--MASTER","clave");
          //  cone = DriverManager.getConnection("jdbc:mysql://192.168.137.129:3306/Prototipo","lolo","tec2.123"); //Buscamos la base de datos con el usuario y pass para crear la conexion exitosa.
            } catch (SQLException ex){ //Si no se consigue la conexion se el programa lanzara un error
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
    }
    return cone;
   }
   public static void cerrar() throws SQLException { //metodo para cerrar la conexion 
       if (cone != null) {
           cone.close();
           cone = null;
       }
   }
   public static boolean lamparas(int i, int lamp){
    Statement query;
       try{
         query = cone.createStatement();
       }catch (SQLException ex){
           return false;
       }
       //Update 
       String str = "UPDATE lamparas SET status=" + i + " WHERE idLamp=" + lamp + ";";
       try{
           query.executeUpdate(str);
       }catch (SQLException ex){
           //System.out.println(ex.toString());
           return false;
       }
       
    return true;   
   }
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
   }
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
   }
   public static int validarUser(){
       Statement consulta;
       String user = LogIn.txtUsuario.getText();
       String pass = LogIn.txtPass.getText();
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
    
   }
   public static boolean logAccessFail(String userId, String date, String time, String details){
       Statement consulta; 
       try{
           consulta = cone.createStatement();
       }catch(SQLException ex){
           return false;
       }
       String getUserId = "SELECT userId FROM users WHERE "
   }
}
