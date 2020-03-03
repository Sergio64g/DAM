package Utils;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuarios {
    private Connection conexion = null;

    public Usuarios() {
        conexion();
    }

    public Usuario loginCorrecto(Usuario usuario) {
        for (Usuario u : list()) {
            if (u.getNombre().equals(usuario.getNombre()) &&
                    u.getPassword().equals(usuario.getPassword())) {
                return u;
            }
        }
        return null;
    }


    public ArrayList<Usuario> list() {

        conexion();
        ArrayList<Usuario> lista = new ArrayList();

        String sql = "SELECT * FROM usuarios";


        ResultSet rs = null;
        try {
            rs = conexion.createStatement().executeQuery(sql);

            while (rs.next()) {

                String nombre = rs.getString("nombre");
                String password = rs.getString("password");
                Usuario u = new Usuario(nombre, password);
                lista.add(u);
            }

            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void conexion() {
        try {
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/psp", "admin", "admin");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

}
