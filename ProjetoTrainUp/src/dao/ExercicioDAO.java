package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Exercicio;

public class ExercicioDAO {


    // =============================================
    // INSERIR
    // =============================================

    public void inserir(
            Exercicio exercicio
    ) throws SQLException {

        String sql =
                "INSERT INTO exercicio "
                + "(nome, series, repeticoes, treino_id) "
                + "VALUES (?, ?, ?, ?)";


        try (
                Connection con =
                        Conexao.abrir();

                PreparedStatement ps =
                        con.prepareStatement(
                                sql,
                                Statement.RETURN_GENERATED_KEYS
                        )
        ) {

            ps.setString(
                    1,
                    exercicio.getNome()
            );

            ps.setInt(
                    2,
                    exercicio.getSeries()
            );

            ps.setInt(
                    3,
                    exercicio.getRepeticoes()
            );

            ps.setInt(
                    4,
                    exercicio.getTreinoId()
            );


            ps.executeUpdate();


            try (
                    ResultSet chaves =
                            ps.getGeneratedKeys()
            ) {

                if (chaves.next()) {

                    exercicio.setId(
                            chaves.getInt(1)
                    );
                }
            }
        }
    }


    // =============================================
    // LISTAR EXERCÍCIOS DO TREINO
    // =============================================

    public List<Exercicio> listarPorTreino(
            int treinoId
    ) throws SQLException {

        String sql =
                "SELECT id, nome, series, repeticoes, treino_id "
                + "FROM exercicio "
                + "WHERE treino_id = ? "
                + "ORDER BY id";


        List<Exercicio> lista =
                new ArrayList<>();


        try (
                Connection con =
                        Conexao.abrir();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setInt(
                    1,
                    treinoId
            );


            try (
                    ResultSet rs =
                            ps.executeQuery()
            ) {

                while (rs.next()) {

                    Exercicio exercicio =
                            new Exercicio(
                                    rs.getInt("id"),
                                    rs.getString("nome"),
                                    rs.getInt("series"),
                                    rs.getInt("repeticoes"),
                                    rs.getInt("treino_id")
                            );


                    lista.add(
                            exercicio
                    );
                }
            }
        }


        return lista;
    }


    // =============================================
    // BUSCAR POR ID
    // =============================================

    public Exercicio buscarPorId(
            int id
    ) throws SQLException {

        String sql =
                "SELECT id, nome, series, repeticoes, treino_id "
                + "FROM exercicio "
                + "WHERE id = ?";


        try (
                Connection con =
                        Conexao.abrir();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setInt(
                    1,
                    id
            );


            try (
                    ResultSet rs =
                            ps.executeQuery()
            ) {

                if (rs.next()) {

                    return new Exercicio(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getInt("series"),
                            rs.getInt("repeticoes"),
                            rs.getInt("treino_id")
                    );
                }
            }
        }


        return null;
    }


    // =============================================
    // ALTERAR
    // =============================================

    public boolean alterar(
            Exercicio exercicio
    ) throws SQLException {

        String sql =
                "UPDATE exercicio "
                + "SET nome = ?, series = ?, repeticoes = ? "
                + "WHERE id = ?";


        try (
                Connection con =
                        Conexao.abrir();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setString(
                    1,
                    exercicio.getNome()
            );

            ps.setInt(
                    2,
                    exercicio.getSeries()
            );

            ps.setInt(
                    3,
                    exercicio.getRepeticoes()
            );

            ps.setInt(
                    4,
                    exercicio.getId()
            );


            return ps.executeUpdate() > 0;
        }
    }


    // =============================================
    // EXCLUIR
    // =============================================

    public boolean excluir(
            int id
    ) throws SQLException {

        String sql =
                "DELETE FROM exercicio "
                + "WHERE id = ?";


        try (
                Connection con =
                        Conexao.abrir();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setInt(
                    1,
                    id
            );


            return ps.executeUpdate() > 0;
        }
    }
}