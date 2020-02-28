package Utils;


import com.mysql.jdbc.Connection;

import java.sql.*;
import java.util.ArrayList;

public class IdsEntrenadores {
    private Connection conexion = null;

    public IdsEntrenadores() {
        conexion();
    }

    public Integer sacarId() {
        conexion();
        Integer id = null;
        String sql = "INSERT INTO `ids` VALUES ()";
        String sql2 = "SELECT * FROM ids id ORDER BY id.idEntrenador DESC LIMIT 1";
        ResultSet rs = null;
        try {
            Statement sta = conexion.createStatement();
            sta.executeUpdate(sql);

            rs = conexion.createStatement().executeQuery(sql2);
            if (rs.next()) {
                id = rs.getInt("idEntrenador");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void conexion() {
        try {
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/javafx", "admin", "admin");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
