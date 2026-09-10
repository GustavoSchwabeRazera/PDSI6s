package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO {
    // =========================================================
    // LISTAR TODOS
    // =========================================================

    public List<Usuario> listar() throws SQLException {

        String sql = "SELECT id, nome, email, senha, idade "
                   + "FROM usuario ORDER BY id DESC";

        List<Usuario> lista = new ArrayList<>();

        try (
            Connection con = Conexao.abrir();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                lista.add(new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getInt("idade")
                ));
            }
        }

        return lista;
    }


    // =========================================================
    // BUSCAR POR NOME
    // =========================================================

    public List<Usuario> buscarPorNome(String trecho)
            throws SQLException {

        String sql = "SELECT id, nome, email, senha, idade "
                   + "FROM usuario "
                   + "WHERE nome LIKE ? "
                   + "ORDER BY id DESC";

        List<Usuario> lista = new ArrayList<>();

        try (
            Connection con = Conexao.abrir();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, "%" + trecho + "%");

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    lista.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getInt("idade")
                    ));
                }
            }
        }

        return lista;
    }


    // =========================================================
    // INSERIR
    // =========================================================

    public void inserir(Usuario u) throws SQLException {

        String sql = "INSERT INTO usuario "+ "(nome, email, senha, idade) " + "VALUES (?, ?, ?, ?)";

        try (
            Connection con = Conexao.abrir();

            PreparedStatement ps =
                con.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
                )
        ) {

            ps.setString(1, u.getNome());

            ps.setString(2, u.getEmail());

            ps.setString(3, u.getSenha());

            ps.setInt(4, u.getIdade());

            ps.executeUpdate();


            // Pegar o ID gerado pelo MySQL

            try (ResultSet chaves = ps.getGeneratedKeys()) {

                if (chaves.next()) {

                    u.setId(chaves.getInt(1));
                }
            }
        }
    }


    // =========================================================
    // ALTERAR
    // =========================================================

    public boolean alterar(Usuario u) throws SQLException {

        String sql = "UPDATE usuario SET "
                   + "nome = ?, "
                   + "email = ?, "
                   + "senha = ?, "
                   + "idade = ? "
                   + "WHERE id = ?";

        try (
            Connection con = Conexao.abrir();

            PreparedStatement ps =
                con.prepareStatement(sql)
        ) {

            ps.setString(1, u.getNome());

            ps.setString(2, u.getEmail());

            ps.setString(3, u.getSenha());

            ps.setInt(4, u.getIdade());

            ps.setInt(5, u.getId());

            return ps.executeUpdate() > 0;
        }
    }


    // =========================================================
    // EXCLUIR
    // =========================================================

    public boolean excluir(int id) throws SQLException {

        String sql =
            "DELETE FROM usuario WHERE id = ?";

        try (
            Connection con = Conexao.abrir();

            PreparedStatement ps =
                con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        }
    }


    // =========================================================
    // BUSCAR POR EMAIL
    // =========================================================

    public Usuario buscarPorEmail(String email)
            throws SQLException {

        String sql = "SELECT id, nome, email, senha, idade "
                   + "FROM usuario "
                   + "WHERE email = ?";

        try (
            Connection con = Conexao.abrir();

            PreparedStatement ps =
                con.prepareStatement(sql)
        ) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getInt("idade")
                    );
                }
            }
        }

        return null;
    }
}