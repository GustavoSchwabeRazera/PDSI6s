package dao;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
	public List<Usuario> listar() throws SQLException {
		String sql = "SELECT id, nome, email, idade FROM usuario ORDER BY id DESC";
		List<Usuario> lista = new ArrayList<>();
		try (Connection con = Conexao.abrir();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery()) {

		while (rs.next()) {
		lista.add(new Usuario(
		rs.getInt("id"),
		rs.getString("nome"),
		rs.getString("email"),
		rs.getInt("idade")));
		}
		
		}
		return lista;
		}
	
	public List<Usuario> buscarPorNome(String trecho) throws SQLException {
		String sql = "SELECT id, nome, email, idade FROM usuario "
		+ "WHERE nome LIKE ? ORDER BY id DESC";
		List<Usuario> lista = new ArrayList<>();
		try (Connection con = Conexao.abrir();
		PreparedStatement ps = con.prepareStatement(sql)) {
		ps.setString(1, "%" + trecho + "%");
		try (ResultSet rs = ps.executeQuery()) {
		while (rs.next()) {
		lista.add(new Usuario(
		rs.getInt("id"),
		rs.getString("nome"),
		rs.getString("curso"),
		rs.getInt("idade")));
		}
		}
		}
		return lista;
		}
	
	public void inserir(Usuario u) throws SQLException {
		String sql = "INSERT INTO usuario (nome, email, idade) VALUES (?, ?, ?)";
		try (Connection con = Conexao.abrir();
		PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		ps.setString(1, u.getNome());
		ps.setString(2, u.getEmail());
		ps.setDouble(3, u.getIdade());
		ps.executeUpdate();

		try (ResultSet chaves = ps.getGeneratedKeys()) {
		if (chaves.next()) {
		u.setId(chaves.getInt(1));
		}
		}
		}
		}
	
	public boolean alterar(Usuario u) throws SQLException {
		String sql = "UPDATE usuario SET nome = ?, email = ?, idade = ? WHERE id = ?";
		try (Connection con = Conexao.abrir();
		PreparedStatement ps = con.prepareStatement(sql)) {
		ps.setString(1, u.getNome());
		ps.setString(2, u.getEmail());
		ps.setDouble(3, u.getIdade());
		ps.setInt(4, u.getId()); // o quarto ? e o do WHERE

		return ps.executeUpdate() > 0;

		}
		}
		public boolean excluir(int id) throws SQLException {
		String sql = "DELETE FROM usuario WHERE id = ?";
		try (Connection con = Conexao.abrir();
		PreparedStatement ps = con.prepareStatement(sql)) {
		ps.setInt(1, id);

		return ps.executeUpdate() > 0;

		}
		}
		}
