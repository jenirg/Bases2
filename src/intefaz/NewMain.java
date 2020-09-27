/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intefaz;

import Backup.backup;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;

/**
 *
 * @author USUARIO
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Calendar calendario = new GregorianCalendar();
        int hora, minutos, segundos;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        String lahora= hora + ":" + minutos + ":" + segundos;
        System.out.println(lahora);
        java.util.Date Fechaactual = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-YYYY");
        System.out.println(formato.format(Fechaactual));
        String fecha = formato.format(Fechaactual);

        //backup mibackup=new backup();
        //mibackup.generar_backup("");
        //\\servidor\\Users\\USUARIO\\Documents\\prueba.sql
      /*  try {
            Process p = Runtime.getRuntime().exec("mysqldump -u root -p1234 conexion2");
            InputStream is = p.getInputStream();
            FileOutputStream fos = new FileOutputStream("servidor\\Users\\USUARIO\\Documents\\prueba.sql");
            byte[] buffer = new byte[1000];
            int leido = is.read(buffer);
            while (leido > 0) {
                fos.write(buffer, 0, leido);
                leido = is.read(buffer);
            }
            System.out.println("BACKUP_REALIZADO");
            fos.close();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO" + ex);

        }*//*
       java.util.Date Fechaactual = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-YYYY");
        System.out.println(formato.format(Fechaactual));
        String fecha = formato.format(Fechaactual);
        java.util.Date date = new java.util.Date();

        /* DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Hora: " + hourFormat.format(date));
        String hora = hourFormat.format(date);
        System.out.println("hora: " + hora);*/
       /* Calendar calendario = new GregorianCalendar();
        int hora, minutos, segundos;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        String lahora = (hora + "hrs" + minutos + "min" + segundos+"seg");
        try {
            Process p = Runtime.getRuntime().exec("mysqldump -u root -p1234 conexion2");
            InputStream is = p.getInputStream();
            FileOutputStream fos = new FileOutputStream(fecha+"_"+ lahora + ".sql");
            byte[] buffer = new byte[1000];
            int leido = is.read(buffer);
            while (leido > 0) {
                fos.write(buffer, 0, leido);
                leido = is.read(buffer);
            }
            System.out.println("BACKUP_REALIZADO");
            fos.close();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO" + ex);

        }*/
       
    }

}
