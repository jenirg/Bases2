/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Bitacora.bitacora;
import conexion.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author dell
 */
public class CRUD {

    Connection miConexion = (Connection) ConexionBD.GetConnection();
    bitacora mibitacora = new bitacora();
    String correo;

    public void setUsuarioNew(String usuarioNew) {
        correo = usuarioNew;
    }

    public String getUsuarioNew() {
        return correo;
    }

    public void Insertar_entrega(String v_dispo, int v_cant, String v_persona) throws SQLException {

        try {
            try (Statement statement = (Statement) miConexion.createStatement()) {
                statement.execute("INSERT INTO entrega(dispositivo,cantidad,fecha,persona_entrega)  VALUES('" + v_dispo + "'," + v_cant + ",'2020-05-06','" + v_persona + "')");
                mibitacora.Guardar_Clasificación(correo, mibitacora.fechaactual(), mibitacora.horaactual(), "insertar en proceso", "de entrega");
                JOptionPane.showMessageDialog(null, "ENTREGA INGRESADA CON ÉXITO");
            }
            miConexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO GUARDO ENTREGA");
        }      // TODO 

    }

    public void Insertar_registro(String dispositivo, int cantidad, String marca, String modelo, String procedencia, String descripcion, float total_monetario, float precio_unitario, int serie_id) throws SQLException {
        //No se esta incluyendo la imagen
        try {
            try (Statement statement = (Statement) miConexion.createStatement()) {
                statement.execute("INSERT INTO registro(dispositivo,cantidad,marca,modelo,procedencia,descripcion,total_monetario,precio_unitario,serie_id)  VALUES('"
                        + dispositivo + "'," + cantidad + ",'" + marca + "','" + modelo + "','" + procedencia + "','" + descripcion + "'," + total_monetario + "," + precio_unitario + "," + serie_id + ")");
                mibitacora.Guardar_Clasificación(correo, mibitacora.fechaactual(), mibitacora.horaactual(), "insertar en proceso", "de registro");
                JOptionPane.showMessageDialog(null, "REGISTRO INGRESADO CON ÉXITO");
            }
            //miConexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO GUARDO EL REGISTRO");
        }      // TODO 
    }

    public void Insertar_serie(String no_serie) throws SQLException {

        try {
            try (Statement statement = (Statement) miConexion.createStatement()) {
                statement.execute("INSERT INTO serie(no_serie)  VALUES('" + no_serie + "')");
                mibitacora.Guardar_Clasificación(correo, mibitacora.fechaactual(), mibitacora.horaactual(), " insertar el cual esta en proceso", " de serie");
                JOptionPane.showMessageDialog(null, "SERIE INGRESADA CON ÉXITO");
            }
            //miConexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO GUARDO LA SERIE");
            System.out.println(e);
        }
    }

    public void Insertar_puesto(String el_puesto) throws SQLException {

        try {
            try (Statement statement = (Statement) miConexion.createStatement()) {
                statement.execute("INSERT INTO puesto(el_puesto)  VALUES('" + el_puesto + "')");
                mibitacora.Guardar_Clasificación(correo, mibitacora.fechaactual(), mibitacora.horaactual(), "insertar el cual esta en proceso", " de puesto");
                JOptionPane.showMessageDialog(null, "PUESTO INGRESADO CON ÉXITO");
            }
            miConexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO GUARDO LA PUESTO");
        }
    }

    public void Insertar_dependencia(String la_dependencia) throws SQLException {

        try {
            try (Statement statement = (Statement) miConexion.createStatement()) {
                statement.execute("INSERT INTO dependencia(la_dependencia)  VALUES('" + la_dependencia + "')");
                mibitacora.Guardar_Clasificación(correo, mibitacora.fechaactual(), mibitacora.horaactual(), " insertar el cual esta en proceso", " de dependencia");
                JOptionPane.showMessageDialog(null, "DEPENDENCIA INGRESADA CON ÉXITO");
            }
            miConexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO GUARDO LA DEPENDENCIA");
        }
    }

    public void Insertar_Forma57(String ref_f57, String persona_solicita, String persona_autoriza, String persona_entrega, String persona_recibe) throws SQLException {

        try {
            try (Statement statement = (Statement) miConexion.createStatement()) {
                statement.execute("INSERT INTO forma57 ( ref_f57,persona_solicita,persona_autoriza,persona_entrega,persona_recibe)  VALUES('"
                        + ref_f57 + "','" + persona_solicita + "','" + persona_autoriza + "','" + persona_entrega + "','" + persona_recibe + "')");

                JOptionPane.showMessageDialog(null, "FORMA57 INGRESADA CON ÉXITO");
            }
            miConexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO GUARDO LA FORMA57");
        }
    }

    public void Insertar_nombre_apellido(String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, int usuario_id) throws SQLException {

        try {
            try (Statement statement = (Statement) miConexion.createStatement()) {
                statement.execute("INSERT INTO nombre_apellido(primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,usuario_id)  VALUES('"
                        + primer_nombre + "','" + segundo_nombre + "','" + primer_apellido + "','" + segundo_apellido + "," + usuario_id + ")");
                mibitacora.Guardar_Clasificación(correo, mibitacora.fechaactual(), mibitacora.horaactual(), " insertar el cual esta en proceso", " de nombre y apellido");
                JOptionPane.showMessageDialog(null, "NOMBRE INGRESADO CON ÉXITO");
            }
            miConexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO GUARDO EL REGISTRO");
        }      // TODO 
    }

    public void Insertar_usuario(String cui, Date fecha_nacimiento, String correo, String contraseña, boolean super_usuario, int puesto_id, int dependencia_id) throws SQLException {

        try {
            try (Statement statement = (Statement) miConexion.createStatement()) {
                statement.execute("INSERT INTO usuario(cui,fecha_nacimiento,correo,contraseña,super_usuario,puesto_id,dependencia_id)  VALUES('"
                        + cui + "','" + fecha_nacimiento + "','" + correo + "','" + correo + "','" + contraseña + "','" + super_usuario + "'," + puesto_id + "," + dependencia_id + ")");
                mibitacora.Guardar_Clasificación(correo, mibitacora.fechaactual(), mibitacora.horaactual(), " insertar el cual esta en proceso", " de usuario");
                JOptionPane.showMessageDialog(null, "REGISTRO INGRESADO CON ÉXITO");
            }
            miConexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO GUARDO EL REGISTRO");
        }      // TODO 
    }

    public void getconexion() throws SQLException {
        miConexion.close();
    }

    public static void IngresarRegistro(Connection con, String dispositivo, int cantidad, String marca, String modelo, String procedencia, String descripcion, float total_monetario, float precio_unitario) throws SQLException {
        bitacora labitacora = new bitacora();
        try (CallableStatement cstmt = con.prepareCall("{call conexion.InsertarRegistro(?, ?, ? ,? ,?, ?, ? ,? )}");) {
            cstmt.setString(1, dispositivo);
            cstmt.setInt(2, cantidad);
            cstmt.setString(3, marca);
            cstmt.setString(4, modelo);
            cstmt.setString(5, procedencia);
            cstmt.setString(6, descripcion);
            cstmt.setFloat(7, total_monetario);
            cstmt.setFloat(8, precio_unitario);
            cstmt.execute();
            CRUD micrud = new CRUD();
            String c = micrud.getUsuarioNew();
            labitacora.Guardar_Clasificación(c, labitacora.fechaactual(), labitacora.horaactual(), " insertar el cual esta en proceso", " de registro");
            System.out.println("Ingreso correcto");
        }
    }

    public static void IngresarEntrega(Connection con, String dispositivo, int cantidad, String serie, String persona_entrega, String NoS, String persona_recibe, String persona_instala, String dependencia, String ubicacion) throws SQLException {
        bitacora labitacora = new bitacora();
        try (CallableStatement cstmt = con.prepareCall("{call conexion.InsertarEntrega(?, ?, ? ,? ,? ,?, ?, ?, ? )}");) {
            cstmt.setString(1, dispositivo);
            cstmt.setInt(2, cantidad);
            cstmt.setString(3, serie);
            cstmt.setString(4, persona_entrega);
            cstmt.setString(5, NoS);
            cstmt.setString(6, persona_recibe);
            cstmt.setString(7, persona_instala);
            cstmt.setString(8, dependencia);
            cstmt.setString(9, ubicacion);
            cstmt.execute();
            CRUD micrud = new CRUD();
            String c = micrud.getUsuarioNew();
            labitacora.Guardar_Clasificación(c, labitacora.fechaactual(), labitacora.horaactual(), " insertar el cual esta en proceso", " de registro");
            JOptionPane.showMessageDialog(null, "ENTREGA CORRECTA");

        }

    }

    public void ConsultaPorNoSerie(int serie, JTextField dispositivo, JTextField modelo, JTextField marca) {
        try {
            //Connection miConexion=(Connection) Conexion.GetConnection();

            Statement s = miConexion.createStatement();
            ResultSet clr = s.executeQuery("select * from registro where serie_id=" + serie);
            while (clr.next()) {
                dispositivo.setText((clr.getString("dispositivo")));
                modelo.setText((clr.getString("modelo")));
                marca.setText((clr.getString("marca")));
            }         // return cte;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int BuscarElIDSerie(String serie) {
        int IDSerie = 0;
        try {
            //Connection miConexion=(Connection) Conexion.GetConnection();

            Statement s = miConexion.createStatement();
            ResultSet clr = s.executeQuery("select id from serie where no_serie='" + serie + "'");
            while (clr.next()) {
                IDSerie = clr.getInt("id");
                //System.out.println("EL ID DE LA SERIE ENCONTRADA"+ clr.getInt("id") );
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return IDSerie;
    }

    public boolean ConsultaDeExistencias(int serie, int cantidad) {
        int CANTIDAD = 0;
        boolean x = true;
        try {
            //Connection miConexion=(Connection) Conexion.GetConnection();

            Statement s = miConexion.createStatement();
            ResultSet clr = s.executeQuery("select cantidad from registro where serie_id=" + serie);
            while (clr.next()) {
                CANTIDAD = clr.getInt("cantidad");
                if (CANTIDAD < cantidad) {
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE REALIZAR LA ENTREGA, NO HAY SUFICIENTES EXISTENCIAS");
                    x = false;
                }

                //System.out.println("EL ID DE LA SERIE ENCONTRADA"+ clr.getInt("id") );
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return x;
    }

    public static void InsertarUsuario(Connection con, String correosp, String contraseniasp, String correo, String contraseña, boolean super_usuario, String dependencia_id, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido) throws SQLException {
        bitacora labitacora = new bitacora();
        try (CallableStatement cstmt = con.prepareCall("{call conexion.InsertarUsuario(?, ?, ? ,?,?,?,?,?,?,?)}");) {
            cstmt.setString(1, correosp);
            cstmt.setString(2, contraseniasp);
            cstmt.setString(3, correo);
            cstmt.setString(4, contraseña);
            cstmt.setBoolean(5, super_usuario);
            cstmt.setString(6, dependencia_id);
            cstmt.setString(7, primer_nombre);
            cstmt.setString(8, segundo_nombre);
            cstmt.setString(9, primer_apellido);
            cstmt.setString(10, segundo_apellido);
            cstmt.execute();
            CRUD micrud = new CRUD();
            String c = micrud.getUsuarioNew();
            labitacora.Guardar_Clasificación(c, labitacora.fechaactual(), labitacora.horaactual(), " insertar el cual esta en proceso", " de usuario");

            JOptionPane.showMessageDialog(null, "Ingreso correcto");

        }
    }

    public static void InsertarColaborador(Connection con, String primernom, String segundonom, String primerape, String segundoape, String dependenciaid, String puestoid) throws SQLException {
        bitacora labitacora = new bitacora();
        try (CallableStatement cstmt = con.prepareCall("{call conexion.InsertarColaborador(?, ?, ? ,?,?,?)}");) {
            cstmt.setString(1, primernom);
            cstmt.setString(2, segundonom);
            cstmt.setString(3, primerape);
            cstmt.setString(4, segundoape);
            cstmt.setString(5, dependenciaid);
            cstmt.setString(6, puestoid);
            cstmt.execute();
            CRUD micrud = new CRUD();
            String c = micrud.getUsuarioNew();
            labitacora.Guardar_Clasificación(c, labitacora.fechaactual(), labitacora.horaactual(), "insertar el cual esta en proceso", " de colaborador");

            JOptionPane.showMessageDialog(null, "Ingreso correcto");

        }
    }

    public static void ActualizarContraseña(Connection con, String correo, String contraseña) throws SQLException {
        bitacora labitacora = new bitacora();
        try (CallableStatement cstmt = con.prepareCall("{call conexion.ActualizarContraseña(?, ?)}");) {
            cstmt.setString(1, correo);
            cstmt.setString(2, contraseña);
            cstmt.execute();
            CRUD micrud = new CRUD();
            String c = micrud.getUsuarioNew();
            labitacora.Guardar_Clasificación(c, labitacora.fechaactual(), labitacora.horaactual(), "a actualizaciòn de cotraseña la cual esta en proceso", " usuario");

            JOptionPane.showMessageDialog(null, "Actualizo de forma correcta");

        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    public boolean BusquedaDeSuperUsuario(String correo, String contraseña) {
        String CORREO, CONTRASEÑA;
        boolean x = true;
        try {
            //Connection miConexion=(Connection) Conexion.GetConnection();

            Statement s = miConexion.createStatement();
            ResultSet clr = s.executeQuery("select correo, contraseña from usuario where super_usuario=true");

            while (clr.next()) {
                CORREO = clr.getString("correo");
                CONTRASEÑA = clr.getString("contraseña");
                int compatibleU = CORREO.compareTo(correo);
                int compatibleC = CONTRASEÑA.compareTo(contraseña);

                if (compatibleU < 0 || compatibleU > 0) {
                    JOptionPane.showMessageDialog(null, "USUARIO INCORRECTO");
                    x = false;
                } else if (compatibleC < 0 || compatibleC > 0) {
                    JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA");
                    x = false;
                }

                //System.out.println("EL ID DE LA SERIE ENCONTRADA"+ clr.getInt("id") );
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return x;
    }

    public void BusquedaDeUsuarioPorCorreo(String elcorreo, String fecha, JTextField correoT, JTextField prinom, JTextField segnom, JTextField priap, JTextField segap, JComboBox dep, JRadioButton superU) {

        try {
            //Connection miConexion=(Connection) Conexion.GetConnection();

            Statement s = miConexion.createStatement();
            ResultSet clr = s.executeQuery("select u.super_usuario,u.correo,u.primer_nombre,u.segundo_nombre,u.primer_apellido,u.segundo_apellido, dp.la_dependencia from usuario u inner join dependencia dp on u.dependencia_id=dp.id where u.id=" + 21);

            while (clr.next()) {
                boolean sp = clr.getBoolean("u.super_usuario");
                String correo2 = clr.getString("u.correo");
                String primernombre2 = clr.getString("u.primer_nombre");
                String segundonombre2 = clr.getString("u.segundo_nombre");
                String primerapellido2 = clr.getString("u.primer_apellido");
                String segundoapellido2 = clr.getString("u.segundo_apellido");
                String dependencia = clr.getString("dp.la_dependencia");
                superU.setSelected(sp);
                correoT.setText(correo2);
                prinom.setText(primernombre2);
                segnom.setText(segundonombre2);
                priap.setText(primerapellido2);
                segap.setText(segundoapellido2);
                dep.setActionCommand(dependencia);

                //System.out.println("EL ID DE LA SERIE ENCONTRADA"+ clr.getInt("id") );
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    public static void ActualizarSuperUsuario(Connection con, String correo, String contraseña, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido) throws SQLException {
        bitacora labitacora = new bitacora();
        try (CallableStatement cstmt = con.prepareCall("{call conexion.ActualizarSuperUsuario(?, ?, ?,?,?,?)}");) {
            cstmt.setString(1, correo);
            cstmt.setString(2, contraseña);
            cstmt.setString(3, primer_nombre);
            cstmt.setString(4, segundo_nombre);
            cstmt.setString(5, primer_apellido);
            cstmt.setString(6, segundo_apellido);
            cstmt.execute();
            CRUD micrud = new CRUD();
            String c = micrud.getUsuarioNew();
            labitacora.Guardar_Clasificación(c, labitacora.fechaactual(), labitacora.horaactual(), "a actualizacion de datos del super usuario la cual esta proceso", "  usuario");
            JOptionPane.showMessageDialog(null, "ACUTALIZACIÓN DE SUPER USUARIO EXITOSA");

        }
    }

    public static void ActualizarUsuario(Connection con, String correo, String contraseña, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido) throws SQLException {
        bitacora labitacora = new bitacora();
        try (CallableStatement cstmt = con.prepareCall("{call conexion.ActualizarUsuario(?, ?, ?,?,?,?)}");) {
            cstmt.setString(1, correo);
            cstmt.setString(2, contraseña);
            cstmt.setString(3, primer_nombre);
            cstmt.setString(4, segundo_nombre);
            cstmt.setString(5, primer_apellido);
            cstmt.setString(6, segundo_apellido);
            cstmt.execute();
            CRUD micrud = new CRUD();
            String c = micrud.getUsuarioNew();
            labitacora.Guardar_Clasificación(c, labitacora.fechaactual(), labitacora.horaactual(), "a actualizacion de datos del usuario la cual esta proceso", "  usuario");
            JOptionPane.showMessageDialog(null, "ACUTALIZACIÓN DE USUARIO EXITOSA");

        }
    }

    public void ConsultaDeEmpleados(JComboBox solicitado, JComboBox autorizado, JComboBox entregado, JComboBox recibido) {
        String nombrecompleto = "";
        String pn, sn, pa, sa;
        String espacio = " ";
        boolean superusuario;
        try {
            //Connection miConexion=(Connection) Conexion.GetConnection();

            Statement s = miConexion.createStatement();
            ResultSet clr = s.executeQuery("select primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,super_usuario from usuario");
            while (clr.next()) {
                pn = clr.getString("primer_nombre");
                sn = clr.getString("segundo_nombre");
                pa = clr.getString("primer_apellido");
                sa = clr.getString("segundo_apellido");
                superusuario = clr.getBoolean("super_usuario");
                System.out.println("SUPER USUARIO" + superusuario);
                if (superusuario == false) {
                    nombrecompleto = pn + espacio + sn + espacio + pa + espacio + sa;
                    solicitado.addItem(nombrecompleto);
                    entregado.addItem(nombrecompleto);
                    recibido.addItem(nombrecompleto);
                } else if (superusuario == true) {
                    nombrecompleto = pn + espacio + sn + espacio + pa + espacio + sa;
                    autorizado.addItem(nombrecompleto);
                }

                //System.out.println("EL ID DE LA SERIE ENCONTRADA"+ clr.getInt("id") );
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    public boolean accesoUsuario(String correo, String contraseña) {
        String usuario2, contraseña2;
        boolean x = false;
        try {
            Statement s = miConexion.createStatement();
            ResultSet clr = s.executeQuery("select correo, contraseña from usuario");
            while (clr.next()) {
                usuario2 = clr.getString("correo");
                contraseña2 = clr.getString("contraseña");

                System.out.println("usuario2" + usuario2);
                System.out.println("contraseña2" + contraseña2);

                int compatibleU = usuario2.compareTo(correo);
                int compatibleC = contraseña2.compareTo(contraseña);

                /* if (compatibleC == 0 && compatibleU == 0) {
                   // JOptionPane.showMessageDialog(null, "CONTRASEÑA ENCONTRADO");
                    x = true;
                    System.out.println("entraaaaaaaaaaa");
                 }
                
                else if (compatibleC < 0 || compatibleC >0){
                    System.out.println("Entra entra entra");
                }
                if (usuario2.equals(correo)&& contraseña2.equals(contraseña)){
                    x=true;
                    System.out.println("Aqui si entra");
                    
                }*/
                if ((compatibleU > 0 || compatibleU > 0)) {

                    //JOptionPane.showMessageDialog(null, "USUARIO ENCONTRADO");
                    x = true;
                } else if (compatibleC > 0 || compatibleC > 0) {
                    // JOptionPane.showMessageDialog(null, "CONTRASEÑA ENCONTRADO");
                    x = true;
                } else if (compatibleC < 0 || compatibleC > 0) {
                    // JOptionPane.showMessageDialog(null, "CONTRASEÑA ENCONTRADO");
                    x = false;
                } else if (compatibleC < 0 || compatibleC > 0) {
                    // JOptionPane.showMessageDialog(null, "CONTRASEÑA ENCONTRADO");
                    x = false;
                }

                //System.out.println("EL ID DE LA SERIE ENCONTRADA"+ clr.getInt("id") );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return x;
    }

    public void ConsultaDeColaborador(JComboBox recibido) {
        String nombrecompleto = "";
        String pn, sn, pa, sa;
        String espacio = " ";
        boolean superusuario;
        try {
            //Connection miConexion=(Connection) Conexion.GetConnection();

            Statement s = miConexion.createStatement();
            ResultSet clr = s.executeQuery("select primer_nombre,segundo_nombre,primer_apellido,segundo_apellido from colaborador");
            while (clr.next()) {
                pn = clr.getString("primer_nombre");
                sn = clr.getString("segundo_nombre");
                pa = clr.getString("primer_apellido");
                sa = clr.getString("segundo_apellido");

                nombrecompleto = pn + espacio + sn + espacio + pa + espacio + sa;
                recibido.addItem(nombrecompleto);

                //System.out.println("EL ID DE LA SERIE ENCONTRADA"+ clr.getInt("id") );
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    public void ConsultaDePuestos(JComboBox recibido) {
        String puesto = "";
        try {
            //Connection miConexion=(Connection) Conexion.GetConnection();

            Statement s = miConexion.createStatement();
            ResultSet clr = s.executeQuery("select el_puesto from puesto");
            while (clr.next()) {
                puesto = clr.getString("el_puesto");
                recibido.addItem(puesto);

                //System.out.println("EL ID DE LA SERIE ENCONTRADA"+ clr.getInt("id") );
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    public void ConsultaDeDependencia(JComboBox recibido) {
        String dep = "";
        try {
            //Connection miConexion=(Connection) Conexion.GetConnection();

            Statement s = miConexion.createStatement();
            ResultSet clr = s.executeQuery("select la_dependencia from dependencia");
            while (clr.next()) {
                dep = clr.getString("la_dependencia");
                recibido.addItem(dep);

                //System.out.println("EL ID DE LA SERIE ENCONTRADA"+ clr.getInt("id") );
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    public void rollback() {
        rollback();
    }

    public void commit() {
        //mibitacora.Guardar_Clasificación(correo, mibitacora.fechaactual(), mibitacora.horaactual(), "commit", "usuario");

        commit();
    }

}
