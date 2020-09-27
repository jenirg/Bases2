
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConexionBD {
        public static Connection GetConnection()
    {
        Connection conexion=null;
      
        try
        {
           // jdbc:mysql://localhost:3306/bdhospital?zeroDateTimeBehavior=convertToNull
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost/conexion";
            String usuarioDB="root";
            String passwordDB="1234";
            conexion= DriverManager.getConnection(servidor,usuarioDB,passwordDB);
            conexion.setAutoCommit(false);
            //JOptionPane.showMessageDialog(null, "SI CONECTO");
            return conexion;
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        finally
        {
            return conexion;
        }
    }
    /*private static final String usuario_db = "root";
	private static final String contra_db = "1234";
	private static final String nombre_db = "conexion";
	
	private static Connection conexionBD = null;
	
	public static Connection getConexion(){
		if (conexionBD == null){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conexionBD = DriverManager.getConnection("jdbc:mysql://localhost/" + nombre_db, usuario_db, contra_db);
                                System.out.println("conexion exitosa ");
                        } catch (ClassNotFoundException ex) {
				Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
			} catch (SQLException ex) {
				Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return conexionBD;
	}
	
	public static void cerrar() throws SQLException {
		if (conexionBD != null)
			conexionBD.close();
	}*/
}
