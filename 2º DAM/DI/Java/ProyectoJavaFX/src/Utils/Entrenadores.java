package Utils;


import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Entrenadores {
    private Connection conexion = null;
    private Equipos equipos;

    public Entrenadores() {
        equipos = new Equipos();
        conexion();
    }


    public Entrenador buscarEntrenador(int idEntrenador) {
        conexion();

        Entrenador entrenador = null;


        String sql = "SELECT * FROM entrenadores e WHERE e.idEntrenador = ?";
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);

            ps.setInt(1, idEntrenador);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                entrenador = new Entrenador(
                        rs.getInt("idEntrenador"),
                        rs.getString("nombreEntrenador"),
                        rs.getString("dniEntrenador"),
                        equipos.buscarEquipo(rs.getInt("idEquipo")),
                        rs.getString("passwordEntrenador"));
            }

            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return entrenador;
    }

    public void addEntrenador(Entrenador e) {
        conexion();

        String sql = "INSERT INTO entrenadores VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);

            ps.setInt(1, e.getIdEntrenador());
            ps.setString(2, e.getNombreEntrenador());
            ps.setString(3, e.getDniEntrenador());
            ps.setInt(4, e.getEquipo().getIdEquipo());
            ps.setString(5, e.getPasswordEntrenador());
            ps.executeUpdate();


            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*public void removeEntrenador(Entrenador e) {
        conexion();
        String sql = "DELETE FROM entrenadores WHERE id = ?";
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);

            ps.setInt(1, e.getIdEntrenador());
            ps.executeUpdate();

            conexion.close();

        } catch (SQLException ex) {
            System.err.println("No se ha podido borrar a la persona");
        }
    }*/

    public ArrayList<Entrenador> list() {

        conexion();
        ArrayList<Entrenador> lista = new ArrayList();

        String sql = "SELECT * FROM entrenadores";


        ResultSet rs = null;
        try {
            rs = conexion.createStatement().executeQuery(sql);

            while (rs.next()) {

                Integer idEntrenador = rs.getInt("idEntrenador");
                String nombreEntrenador = rs.getString("nombreEntrenador");
                String dniEntrenador = rs.getString("dniEntrenador");
                Integer idEquipo = rs.getInt("idEquipo");
                String passwordEntrenador = rs.getString("passwordEntrenador");
                Equipo equipo = equipos.buscarEquipo(idEquipo);
                Entrenador e = new Entrenador(idEntrenador, nombreEntrenador, dniEntrenador, equipo, passwordEntrenador);
                lista.add(e);
            }

            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Entrenador loginCorrecto(Entrenador entrenador) {
        for (Entrenador e : list()) {
            if (e.getNombreEntrenador().equals(entrenador.getNombreEntrenador()) &&
                    e.getPasswordEntrenador().equals(entrenador.getPasswordEntrenador())) {
                return e;
            }
        }
        return null;
    }

    public boolean existsEntrenador(Entrenador e) {
        ArrayList username = new ArrayList();
        for (Entrenador en : list()) {
            username.add(en.getNombreEntrenador());
        }
        if (username.contains(e.getNombreEntrenador())) {
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
