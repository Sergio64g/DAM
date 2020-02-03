package examen3ªev_pr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Alumnos {

    private Connection conexion = null;
//Conexión a la base de Datos Academia

    public Alumnos() throws SQLException {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "academia", "academia");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
//Método para cerrar la conexión a la Base de Datos

    public void close() throws SQLException {
        conexion.close();
    }

    //Read
    public Alumno read(String idAlumno) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "academia", "academia");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        Alumno resultado = null;

        String sql = "SELECT * FROM alumnos WHERE idAlumno = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, idAlumno);
        ResultSet rs = ps.executeQuery();
        ArrayList<Alumno> lista = new ArrayList();
        if (rs.next()) {
            resultado = new Alumno(
                    rs.getInt("idAlumno"), rs.getString("Nombre"),
                    rs.getString("Apellidos"), rs.getString("email"),
                    rs.getString("FechaNacimiento"));

        }
        return resultado;
    }

    //Create
    public void create(Alumno alumno) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "academia", "academia");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "INSERT INTO alumnos VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, alumno.getIdAlumno());
        ps.setString(2, alumno.getNombre());
        ps.setString(3, alumno.getApellidos());
        ps.setString(4, alumno.getEmail());
        ps.setString(5, alumno.getFechaNacimiento());

        int rs = ps.executeUpdate();
    }
    //Update

    public void update(Alumno alumno) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "academia", "academia");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "UPDATE alumnos SET Nombre = ?, Apellidos = ?, email = ?, FechaNacimiento = ? WHERE idAlumno = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, alumno.getNombre());
        ps.setString(2, alumno.getApellidos());
        ps.setString(3, alumno.getEmail());
        ps.setString(4, alumno.getFechaNacimiento());
        ps.setInt(5, alumno.getIdAlumno());

        int rs = ps.executeUpdate();
    }
    //Delete

    public void delete(String idAlumno) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "academia", "academia");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "DELETE FROM alumnos WHERE idAlumno = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, idAlumno);
        ps.executeUpdate();

    }

    //ArrayList
    public ArrayList<Alumno> lista() throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "academia", "academia");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        ArrayList<Alumno> lista = new ArrayList();

        String sql = "SELECT * FROM alumnos";

        ResultSet rs = conexion.createStatement().executeQuery(sql);

        while (rs.next()) {

            Integer idAlumno = rs.getInt("idAlumno");
            String nombre = rs.getString("Nombre");
            String apellidos = rs.getString("Apellidos");
            String email = rs.getString("email");
            String fechaNacimiento = rs.getString("FechaNacimiento");

            Alumno al = new Alumno(idAlumno, nombre, apellidos, email, fechaNacimiento);
            lista.add(al);

        }
        return lista;
    }

}
