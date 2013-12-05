/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBMS;

import Clases.persona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luismiranda
 */
public class DBMS {
    
    private static Connection conexion;
    
    protected DBMS() {
    }
    private static DBMS instance = null;

    public static DBMS getInstance() {
        if (null == DBMS.instance) {
            DBMS.instance = new DBMS();
        }
        DBMS.conectar();
        return DBMS.instance;
    }

    public static boolean conectar() {
        try {
            
            Class.forName("org.postgresql.Driver");
//            La forma de esto debe ser la siguiente:
//                     conexion = DriverManager.getConnection(
//                    "jdbc:postgresql://localhost:5432/<database>",
//                    "<nombre de usuario psql>",
//                    "<clave de usuario psql>");
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/dbprueba",
                    "luismiranda",
                    "qwerty");
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean agregarDatos(persona u) {

        PreparedStatement psAgregar = null;
        try {

            psAgregar = conexion.prepareStatement("INSERT INTO people VALUES (?,?)");
            
            psAgregar.setInt(1, u.getCodigo());
            psAgregar.setString(2, u.getNombre());
            System.out.println(psAgregar.toString());

            Integer i = psAgregar.executeUpdate();

            return i > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
 
    public ArrayList<persona> listarPersonas(){
        
        ArrayList<persona> personas = new ArrayList<persona>();
        PreparedStatement ps = null;
        try{
            ps = conexion.prepareStatement("SELECT * FROM people");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                persona p = new persona();
                p.setCodigo(rs.getInt("ci"));
                p.setNombre(rs.getString("nombre"));
                personas.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return personas;
    } 
    
    public boolean consultarDatos(persona u) {

        PreparedStatement psConsultar = null;
        try {

            psConsultar = conexion.prepareStatement("SELECT * FROM people WHERE codigo = ?");
            
            psConsultar.setInt(1, u.getCodigo());
            System.out.println(psConsultar.toString());

            ResultSet Rs = psConsultar.executeQuery();
            
            while (Rs.next()) {
                if((Rs.getString("nombre")).equals("SFAFA"))
                return true;
            }
            
            return false;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarDatos(persona u) {
        PreparedStatement psEliminar = null;
        try {

            psEliminar = conexion.prepareStatement("DELETE FROM people WHERE ci=(?)");
            
            psEliminar.setInt(1, u.getCodigo());

            System.out.println(psEliminar.toString());

            Integer i = psEliminar.executeUpdate();

            return i > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

