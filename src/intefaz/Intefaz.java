package intefaz;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;
import Clases.*;
import Usuario.Compresor;
import com.itextpdf.text.log.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author dell
 */
public class Intefaz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
  java.util.Date Fechaactual = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-YYYY");
        System.out.println(formato.format(Fechaactual));
        java.util.Date date = new java.util.Date();

  
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
      System.out.println("Hora: " + hourFormat.format(date));
        String hora=hourFormat.format(date);
        System.out.println("hora: "+ hora);
        try {
            Process p = Runtime.getRuntime().exec("mysqldump -u root -p1234 conexion2");
            InputStream is = p.getInputStream();
            FileOutputStream fos = new FileOutputStream("Backup_" + formato.format(Fechaactual) + ".sql");
            byte[] buffer = new byte[1000];
            int leido = is.read(buffer);
            while (leido > 0) {
                fos.write(buffer, 0, leido);
                leido = is.read(buffer);
            }
            System.out.println("BACKUP_REALIZADO");
            fos.close();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Menu .class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO"+ex);

        }

       /* Compresor compresor = new Compresor();
        String Cadena_en_binario = compresor.CodigoAscii_a_binario("prueba");
        String cadena_simple = compresor.cadena_RLE(Cadena_en_binario);
        String ultima_cadena = compresor.rle_a_Ascii(cadena_simple);
        System.out.println("final    " + ultima_cadena);*/
      //  System.out.println("holaaaaaaaaaaaaaaaaa");
        //CRUD miCrud = new CRUD();
        //Date fechaDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse("2020-05-06");
        //miCrud.Insertar("compu",4, "Lucas");
        //miCrud.Insertar_serie("ghi789");    
        //miCrud.Insertar_registro("telefono", 2, "zt","saber","claro","ruta_imagen", 1200, 600, 4);

        //miCrud.Insertar_dependencia("Administrativa");
        //miCrud.Insertar_puesto("Gerente");
        // TODO code application logic here
        //for (int i=1950; i<=2020;i++){
        //   System.out.println(i);
        //}
        /* Menu xx = new Menu();
        xx.show(true);*/
 /*Connection miConexion = (Connection) ConexionBD.GetConnection();

        // Connection conexion = ConexionBD.GetConnection();
        java.util.Date fechaActual = new java.util.Date();
        System.out.println(fechaActual);
        try {
             try (Statement statement = (Statement) miConexion.createStatement()) {
                statement.execute("INSERT INTO entrega(dispositivo,cantidad,fecha,persona_entrega)  VALUES('prueba10',8,'2020-05-03','maría')");
            //VALUES('prueba5',4,'2020-05-01','luis')
              System.out.println("PRUEBA ingresada");
            }
            miConexion.close();
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO GUARDO");
        }*/
 /*Date d = new Date();  // Crea el objeto Date
            Calendar calendar = Calendar.getInstance(); // Obtiene una instancia de Calendar
            calendar.setTime(d); // Asigna la fecha al Calendar
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);*/
 /* PreparedStatement pst = miConexion.prepareStatement("INSERT INTO entrega(dispositivo,cantidad,fecha,persona_entrega) VALUES(?,?,?,?)");
            pst.setString(1, "otra prueba");
            pst.setInt(2, 7);
            pst.setDate(3, fecha);
            pst.setString(4, "Andrea");
            pst.execute();
            pst.close();*/

 /*int a = pst.executeUpdate();
            if (a > 0) {
                JOptionPane.showMessageDialog(null, "Registro exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar");
            }*/
        // TODO */
 
    }
       public void generarReporte() throws net.sf.jasperreports.engine.JRException, FileNotFoundException{
    
    InputStream inputStream = null;
     try {
          inputStream  = new FileInputStream("src/interfaz/newReport.jrxml");
          
        } catch (FileNotFoundException ex) {
           // Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
           
        }
     Map parameters= new HashMap();
     JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
    JasperPrint jasperPrint =JasperFillManager.fillReport(jasperReport, parameters);
    JasperExportManager.exportReportToHtmlFile(jasperPrint, "src/interfaz/newReport.pdf");
}
}
