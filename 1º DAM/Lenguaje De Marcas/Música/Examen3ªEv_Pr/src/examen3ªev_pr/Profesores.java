package examen3ªev_pr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Profesores {

    private Connection conexion = null;


//Conexión a la base de Datos Academia
    public Profesores() throws SQLException {
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
    public Profesor read(String idProfesor) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "academia", "academia");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        Profesor resultado = null;

        String sql = "SELECT * FROM profesores WHERE idProfesor = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, idProfesor);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            resultado = new Profesor(
                    rs.getInt("idProfesor"), rs.getString("Nombre"),
                    rs.getString("Apellidos"), rs.getString("email"));
        }
        return resultado;
    }

    //Create
    public void create(Profesor profesor) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "academia", "academia");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "INSERT INTO profesores VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, profesor.getIdProfesor());
        ps.setString(2, profesor.getNombre());
        ps.setString(3, profesor.getApellidos());
        ps.setString(4, profesor.getEmail());

        int rs = ps.executeUpdate();
    }
    //Update

    public void update(Profesor profesores) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "academia", "academia");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "UPDATE profesores SET Nombre = ?, Apellidos = ?, email = ? WHERE idProfesor = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, profesores.getNombre());
        ps.setString(2, profesores.getApellidos());
        ps.setString(3, profesores.getEmail());
        ps.setInt(4, profesores.getIdProfesor());

        int rs = ps.executeUpdate();
    }
    //Delete

    public void delete(String idProfesor) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "academia", "academia");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "DELETE FROM profesores WHERE idProfesor = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, idProfesor);
        int rs = ps.executeUpdate();

    }

    //ArrayList
    public ArrayList<Profesor> lista() throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "academia", "academia");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        ArrayList<Profesor> lista = new ArrayList();

        String sql = "SELECT * FROM profesores";

        ResultSet rs = conexion.createStatement().executeQuery(sql);

        while (rs.next()) {

        

            Integer idProfesor = rs.getInt("idProfesor");
            String nombre = rs.getString("Nombre");
            String apellidos = rs.getString("Apellidos");
            String email = rs.getString("email");

            Profesor pr = new Profesor(idProfesor, nombre, apellidos, email);
            
            lista.add(pr);

        }
        return lista;
    }

}


