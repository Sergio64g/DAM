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

        String sql = "INSERT INTO personas VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);

            ps.setString(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getApellidos());
            ps.setInt(4, p.getEdad());
            ps.setString(5, p.getCalle());
            ps.setInt(6, p.getNumero());
            ps.setInt(7, p.getCodigoPostal());
            ps.executeUpdate();


            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removePersona(Persona p) {
        conexion();
        String sql = "DELETE FROM personas WHERE id = ?";
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);

            ps.setString(1, p.getId());
            ps.executeUpdate();

            conexion.close();

        } catch (SQLException e) {
            System.err.println("No se ha podido borrar a la persona");
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

                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                int edad = rs.getInt("edad");
                String calle = rs.getString("calle");
                int numero = rs.getInt("numero");
                int codigoPostal = rs.getInt("codigoPostal");
                Persona p = new Persona(id, nombre, apellidos, edad, calle, numero, codigoPostal);
                lista.add(p);
            }

            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void update(Persona p) {

        conexion();
        String sql = "UPDATE personas SET nombre = ?, apellidos = ?, edad = ?,calle = ?, numero = ?, codigoPostal = ? WHERE id = ?";
String sql2="UPDATE `personas` SET `id`=[value-1],`nombre`=[value-2],`apellidos`=[value-3],`edad`=[value-4],`calle`=[value-5],`numero`=[value-6],`codigoPostal`=[value-7] WHERE 1";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellidos());
            ps.setInt(3, p.getEdad());
            ps.setString(4, p.getCalle());
            ps.setInt(5, p.getNumero());
            ps.setInt(6, p.getCodigoPostal());
            ps.setString(7, p.getId());
            ps.executeUpdate();

            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean exists(Persona p) {
        ArrayList ids = new ArrayList();
        for (Persona pe : list()) {
            ids.add(pe.getId());
        }
        if (ids.contains(p.id)) {
            return true;
        } else {
            return false;
        }
    }

    public void conexion() {
        try {
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tablas", "admin", "admin");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
