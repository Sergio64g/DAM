package Utils;


import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Jugadores {
    private Connection conexion = null;
    private Entrenadores entrenadores;

    public Jugadores() {
        entrenadores = new Entrenadores();
        conexion();
    }


    public Jugador buscarJugadores(int idJugador) {
        conexion();

        Jugador jugador = null;


        String sql = "SELECT * FROM jugadores j WHERE j.idJugador = ?";
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);

            ps.setInt(1, idJugador);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                jugador = new Jugador(
                        rs.getInt("idJugador"),
                        rs.getString("dniJugador"),
                        rs.getString("nombreJugador"),
                        rs.getString("posicion"),
                        entrenadores.buscarEntrenador(rs.getInt("idEntrenador")));
            }

            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return jugador;
    }


    public ArrayList<Jugador> buscarJugadoresTabla(Entrenador entrenador) {
        conexion();


        ArrayList<Jugador> lista = new ArrayList();

        String sql = "SELECT * FROM jugadores j WHERE j.idEntrenador = ?";
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, entrenador.getIdEntrenador());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Jugador jugador = new Jugador(
                        rs.getInt("idJugador"),
                        rs.getString("dniJugador"),
                        rs.getString("nombreJugador"),
                        rs.getString("posicion"),
                        entrenadores.buscarEntrenador(rs.getInt("idEntrenador")));
                lista.add(jugador);
            }

            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    
    public void removeJugador(Jugador j) {
        conexion();
        String sql = "DELETE FROM jugadores WHERE idJugador = ?";
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);

            ps.setInt(1, j.getIdJugador());
            ps.executeUpdate();

            conexion.close();

        } catch (SQLException e) {
            System.err.println("No se ha podido borrar al jugador");
        }
    }

    public void addJugador(Jugador j) {
        conexion();

        String sql = "INSERT INTO `jugadores`( `dniJugador`, `nombreJugador`, `posicion`, `idEntrenador`) VALUES (?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);

            ps.setString(1, j.getDniJugador());
            ps.setString(2, j.getNombreJugador());
            ps.setString(3, j.getPosicion());
            ps.setInt(4, j.getEntrenador().getIdEntrenador());
            ps.executeUpdate();


            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Jugador> list() {

        conexion();
        ArrayList<Jugador> lista = new ArrayList();

        String sql = "SELECT * FROM jugadores";


        ResultSet rs = null;
        try {
            rs = conexion.createStatement().executeQuery(sql);

            while (rs.next()) {

                Integer idJugador = rs.getInt("idJugador");
                String dniJugador = rs.getString("dniJugador");
                String nombreJugador = rs.getString("nombreJugador");
                String posicion = rs.getString("posicion");
                Integer idEntrenador = rs.getInt("idEntrenador");
                Entrenador entrenador = entrenadores.buscarEntrenador(idEntrenador);
                Jugador j = new Jugador(idJugador, dniJugador, nombreJugador, posicion, entrenador);
                lista.add(j);
            }

            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
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


    public boolean existsJugador(Jugador j) {
        ArrayList ids = new ArrayList();
        for (Jugador ju : list()) {
            ids.add(ju.getIdJugador());
        }
        if (ids.contains(j.getIdJugador())) {
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
