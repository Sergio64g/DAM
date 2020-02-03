package examen3ªev_pr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cursos {

    private Connection conexion = null;

//Conexión a la base de Datos Academia
    public Cursos() throws SQLException {
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
    public Curso read(String idCursos) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "academia", "academia");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        Curso resultado = null;
        Profesor pro = null;

        String sql = "SELECT * FROM cursos C JOIN profesores P ON C.idProfesor=P.idProfesor WHERE C.idCurso = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, idCursos);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            pro = new Profesor(
                    rs.getInt("idProfesor"), rs.getString("Nombre"),
                    rs.getString("Apellidos"), rs.getString("email"));

            resultado = new Curso(rs.getInt("idCurso"),
                    rs.getString("NombreCurso"), rs.getInt("DuracionCurso"), rs.getInt("idProfesor"), rs.getString("FechaInicio"), rs.getString("FechaFin"), pro);
        }
        return resultado;
    }

    //Create
    public void create(Curso curso) throws SQLException {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "academia", "academia");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "INSERT INTO cursos VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, curso.getIdCurso());
        ps.setString(2, curso.getNombreCurso());
        ps.setInt(3, curso.getDuracionCurso());
        ps.setInt(4, curso.getIdProfesor());
        ps.setString(5, curso.getFechaInicio());
        ps.setString(6, curso.getFechaFin());

        int rs = ps.executeUpdate();
    }
    //Update

    public void update(Curso curso) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "academia", "academia");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "UPDATE cursos SET NombreCurso = ?, DuracionCurso = ?, idProfesor = ?, FechaInicio = ?, FechaFin = ? WHERE idCurso = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, curso.getNombreCurso());
        ps.setInt(2, curso.getDuracionCurso());
        ps.setInt(3, curso.getIdProfesor());
        ps.setString(4, curso.getFechaInicio());
        ps.setString(5, curso.getFechaFin());
        ps.setInt(6, curso.getIdCurso());

        int rs = ps.executeUpdate();
    }
    //Delete

    public void delete(String idCurso) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "academia", "academia");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "DELETE FROM cursos WHERE idCurso = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, idCurso);
        int rs = ps.executeUpdate();

    }

    //ArrayList
    public ArrayList<Curso> lista() throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/academia", "academia", "academia");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        ArrayList<Curso> lista = new ArrayList();
        Profesor pro = null;
        Curso cu = null;

        String sql = "SELECT * FROM cursos C JOIN profesores P ON C.idProfesor=P.idProfesor";

        ResultSet rs = conexion.createStatement().executeQuery(sql);

        while (rs.next()) {

            pro = new Profesor(
                    rs.getInt("idProfesor"), rs.getString("Nombre"),
                    rs.getString("Apellidos"), rs.getString("email"));

            Integer idCurso = rs.getInt("idcurso");
            String nombreCurso = rs.getString("NombreCurso");
            Integer duracionCurso = rs.getInt("DuracionCUrso");
            Integer idProfesor = rs.getInt("idProfesor");
            String FechaInicio = rs.getString("FechaInicio");
            String fechaFin = rs.getString("FechaFin");

            cu = new Curso(idCurso, nombreCurso, duracionCurso, idProfesor, FechaInicio, fechaFin, pro);
            lista.add(cu);

        }
        return lista;
    }

}
