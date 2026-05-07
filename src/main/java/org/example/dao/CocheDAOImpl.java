package org.example.dao;

import org.example.model.Coche;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CocheDAOImpl implements CocheDAO {

    private Connection connection;

    public CocheDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertar(Coche coche) {

        String sql =
                "INSERT INTO Coche VALUES(?,?,?,?,?)";

        try {

            PreparedStatement stmt =
                    connection.prepareStatement(sql);

            stmt.setString(1, coche.getMatricula());
            stmt.setString(2, coche.getMarca());
            stmt.setString(3, coche.getModelo());
            stmt.setInt(4, coche.getCaballos());
            stmt.setInt(5, coche.getPersonaId());

            stmt.executeUpdate();

            System.out.println("Coche agregado");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public List<Coche> listar() {

        List<Coche> lista = new ArrayList<>();

        String sql = "SELECT * FROM Coche";

        try {

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Coche c = new Coche();

                c.setMatricula(rs.getString("matricula"));
                c.setMarca(rs.getString("marca"));
                c.setModelo(rs.getString("modelo"));
                c.setCaballos(rs.getInt("caballos"));
                c.setPersonaId(rs.getInt("persona_id"));

                lista.add(c);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return lista;
    }
}

