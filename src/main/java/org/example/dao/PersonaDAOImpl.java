package org.example.dao;

import org.example.model.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAOImpl implements PersonaDAO {

    private Connection connection;

    public PersonaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertar(Persona persona) {

        String sql =
                "INSERT INTO Persona(nombre, apellido1, apellido2, dni) VALUES(?,?,?,?)";

        try {

            PreparedStatement stmt =
                    connection.prepareStatement(sql);

            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido1());
            stmt.setString(3, persona.getApellido2());
            stmt.setString(4, persona.getDni());

            stmt.executeUpdate();

            System.out.println("PERSONA AGREGADA");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public List<Persona> listar() {

        List<Persona> lista = new ArrayList<>();

        String sql = "SELECT * FROM Persona";

        try {

            Statement stmt =
                    connection.createStatement();

            ResultSet rs =
                    stmt.executeQuery(sql);

            while (rs.next()) {

                Persona p = new Persona();

                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido1(rs.getString("apellido1"));
                p.setApellido2(rs.getString("apellido2"));
                p.setDni(rs.getString("dni"));

                lista.add(p);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void eliminar(int id) {

        String sql =
                "DELETE FROM Persona WHERE id=?";

        try {

            PreparedStatement stmt =
                    connection.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("PERSONA ELIMINADA");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}