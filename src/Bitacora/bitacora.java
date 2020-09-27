/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bitacora;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class bitacora {
      public void Guardar_Clasificación(String usuario,String fecha,String hora,String accion,String tabla){
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        try {
            w= new FileWriter("Bitacora de Transacciones",true);
            bw = new BufferedWriter(w); 
            wr= new PrintWriter(bw);
            wr.append("El usuario "+usuario+" en la fecha: "+fecha+" y hora: "+hora+"acciona en la tabla "+tabla+" generando un"+accion+"\n");
            wr.close();
            
            bw.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRRO"+e);
        }
    } 
    public String horaactual(){
        Calendar calendario = new GregorianCalendar();
        int hora, minutos, segundos;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        String lahora= hora + ":" + minutos + ":" + segundos;
        System.out.println(lahora);
        return lahora;
       
    }
    public String fechaactual(){
        java.util.Date Fechaactual = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-YYYY");
        System.out.println(formato.format(Fechaactual));
        String fecha = formato.format(Fechaactual);
        return fecha;
    }
}
