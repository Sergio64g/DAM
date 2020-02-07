package Utils;


import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Personas {
    private Connection conexion = null;

    public Personas() {
        conexion();
    }

    public void addPersona(Persona p) {
        conexion();

        String sql = "INSERT INTO personas VALUES (?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);

            ps.setString(1, p.getDni());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getPassword());
            ps.setString(4, p.getPermisos());
            ps.executeUpdate();


            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Persona> list() {

        conexion();
        ArrayList<Persona> lista = new ArrayList();

        String sql = "SELECT * FROM personas";


        ResultSet rs = null;
        try {
            rs = conexion.createStatement().executeQuery(sql);


            while (rs.next()) {

                String id = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String password = rs.getString("password");
                String permisos = rs.getString("permisos");

                Persona p = new Persona(id, nombre, password, permisos);
                lista.add(p);
            }

            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean exists(Persona p) {
        ArrayList dnis = new ArrayList();
        for (Persona pe : list()) {
            dnis.add(pe.getDni());
            System.out.println(pe.getDni());
        }
        if (dnis.contains(p.getDni())) {
            return true;
        } else {
            return false;
        }
    }

    public Persona loginCorrecto(String user, String pass){
        for (Persona p:this.list()){
            if(p.getNombre().equals(user) && p.getPassword().equals(pass)){
                return p;
            }
        }
        return null;
    }

    public void conexion() {
        try {
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/javafx", "admin", "admin");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
