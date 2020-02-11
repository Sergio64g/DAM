package Utils;


import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Equipos {
    private Connection conexion = null;

    public Equipos() {
        conexion();
    }

    public Equipo buscarEquipo(int idEquipo) {
        conexion();

        Equipo equipo = null;


        String sql = "SELECT * FROM equipos e WHERE e.idEquipo = ?";
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);

            ps.setInt(1, idEquipo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                equipo = new Equipo(
                        rs.getInt("idEquipo"),
                        rs.getString("nombreEquipo"),
                        rs.getString("ciudadEquipo"),
                        rs.getString("imagenEquipo"));
            }
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return equipo;
    }

    public void addEquipo(Equipo e) {
        conexion();

        String sql = "INSERT INTO personas VALUES (?, ?, ?, ?, )";
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);

            ps.setInt(1, e.getIdEquipo());
            ps.setString(2, e.getNombreEquipo());
            ps.setString(3, e.getCiudadEquipo());
            ps.setString(4, e.getImagenEquipo());

            ps.executeUpdate();


            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**/

    public ArrayList<Equipo> list() {

        conexion();
        ArrayList<Equipo> lista = new ArrayList();

        String sql = "SELECT * FROM equipos";


        ResultSet rs = null;
        try {
            rs = conexion.createStatement().executeQuery(sql);


            while (rs.next()) {

                Integer idEquipo = rs.getInt("idEquipo");
                String nombreEquipo = rs.getString("nombreEquipo");
                String ciudadEquipo = rs.getString("ciudadEquipo");
                String imagenEquipo = rs.getString("imagenEquipo");

                Equipo e = new Equipo(idEquipo, nombreEquipo, ciudadEquipo, imagenEquipo);
                lista.add(e);
            }

            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    /*public void update(Persona p) {

        conexion();
        String sql = "UPDATE personas SET nombre = ?, apellidos = ?, edad = ?,calle = ?, numero = ?, codigoPostal = ? WHERE id = ?";
        String sql2 = "UPDATE `personas` SET `id`=[value-1],`nombre`=[value-2],`apellidos`=[value-3],`edad`=[value-4],`calle`=[value-5],`numero`=[value-6],`codigoPostal`=[value-7] WHERE 1";
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
    }*/

    public boolean exists(Equipo e) {
        ArrayList ids = new ArrayList();
        for (Equipo eq : list()) {
            ids.add(eq.getIdEquipo());
        }
        if (ids.contains(e.getIdEquipo())) {
            return true;
        } else {
            return false;
        }
    }

    public void conexion() {
        try {
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/javafx", "admin", "admin");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
