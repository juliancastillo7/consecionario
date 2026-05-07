package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {


    private static final String URL =
            "jdbc:mysql://localhost:3307/concesionario?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

    private static final String USUARIO = "root";

    private static final String CONTRASENA = "123456";

    public static Connection obtenerConexion() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            System.out.println("CONEXION EXITOSA A MYSQL");

            return con;

        } catch (ClassNotFoundException e) {

            System.out.println("No se encontro el driver");

            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("ERROR EN LA CONEXION");

            e.printStackTrace();
        }

        return null;
    }
}
