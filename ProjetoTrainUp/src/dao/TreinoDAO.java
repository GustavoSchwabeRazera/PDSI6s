package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Treino;

public class TreinoDAO {


    // =============================================
    // INSERIR TREINO
    // =============================================

    public void inserir(Treino treino)
            throws SQLException {

        String sql =
                "INSERT INTO treino "
                + "(nome, usuario_id) "
                + "VALUES (?, ?)";


        try (
                Connection con = Conexao.abrir();

                PreparedStatement ps =
                        con.prepareStatement(
                                sql,
                                Statement.RETURN_GENERATED_KEYS
                        )
        ) {

            ps.setString(
                    1,
                    treino.getNome()
            );

            ps.setInt(
                    2,
                    treino.getUsuarioId()
            );


            ps.executeUpdate();


            // PEGAR ID GERADO

            try (
                    ResultSet chaves =
                            ps.getGeneratedKeys()
            ) {

                if (chaves.next()) {

                    treino.setId(
                            chaves.getInt(1)
                    );
                }
            }
        }
    }


    // =============================================
    // LISTAR TREINOS DO USUÁRIO
    // =============================================

    public List<Treino> listarPorUsuario(
            int usuarioId
    ) throws SQLException {

        String sql =
                "SELECT id, nome, usuario_id "
                + "FROM treino "
                + "WHERE usuario_id = ? "
                + "ORDER BY id DESC";


        List<Treino> lista =
                new ArrayList<>();


        try (
                Connection con =
                        Conexao.abrir();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setInt(
                    1,
                    usuarioId
            );


            try (
                    ResultSet rs =
                            ps.executeQuery()
            ) {

                while (rs.next()) {

                    Treino treino =
                            new Treino(
                                    rs.getInt("id"),
                                    rs.getString("nome"),
                                    rs.getInt("usuario_id")
                            );


                    lista.add(treino);
                }
            }
        }


        return lista;
    }


    // =============================================
    // BUSCAR PELO ID
    // =============================================

    public Treino buscarPorId(
            int id
    ) throws SQLException {

        String sql =
                "SELECT id, nome, usuario_id "
                + "FROM treino "
                + "WHERE id = ?";


        try (
                Connection con =
                        Conexao.abrir();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);


            try (
                    ResultSet rs =
                            ps.executeQuery()
            ) {

                if (rs.next()) {

                    return new Treino(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getInt("usuario_id")
                    );
                }
            }
        }


        return null;
    }


    // =============================================
    // ALTERAR TREINO
    // =============================================

    public boolean alterar(
            Treino treino
    ) throws SQLException {

        String sql =
                "UPDATE treino "
                + "SET nome = ? "
                + "WHERE id = ?";


        try (
                Connection con =
                        Conexao.abrir();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setString(
                    1,
                    treino.getNome()
            );

            ps.setInt(
                    2,
                    treino.getId()
            );


            return ps.executeUpdate() > 0;
        }
    }


    // =============================================
    // EXCLUIR TREINO
    // =============================================

    public boolean excluir(
            int id
    ) throws SQLException {

        String sql =
                "DELETE FROM treino "
                + "WHERE id = ?";


        try (
                Connection con =
                        Conexao.abrir();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);


            return ps.executeUpdate() > 0;
        }
    }
}