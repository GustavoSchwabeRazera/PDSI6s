package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Registro;

public class RegistroDAO {

    private static boolean tabelaCriada = false;


    // =============================================
    // CRIAR TABELA (se ainda não existir no banco)
    // =============================================

    private static void criarTabela(
            Connection con
    ) throws SQLException {

        if (tabelaCriada) {
            return;
        }


        String sql =
                "CREATE TABLE IF NOT EXISTS registro_treino ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "treino_id INT NOT NULL, "
                + "data DATETIME NOT NULL, "
                + "CONSTRAINT fk_registro_treino "
                + "FOREIGN KEY (treino_id) "
                + "REFERENCES treino(id) "
                + "ON DELETE CASCADE)";


        try (
                Statement st =
                        con.createStatement()
        ) {

            st.executeUpdate(sql);
        }


        tabelaCriada = true;
    }


    // =============================================
    // INSERIR
    // =============================================

    public void inserir(
            Registro registro
    ) throws SQLException {

        String sql =
                "INSERT INTO registro_treino "
                + "(treino_id, data) "
                + "VALUES (?, ?)";


        try (
                Connection con =
                        Conexao.abrir()
        ) {

            criarTabela(con);


            try (
                    PreparedStatement ps =
                            con.prepareStatement(
                                    sql,
                                    Statement.RETURN_GENERATED_KEYS
                            )
            ) {

                ps.setInt(
                        1,
                        registro.getTreinoId()
                );

                ps.setTimestamp(
                        2,
                        Timestamp.valueOf(
                                registro.getData()
                        )
                );


                ps.executeUpdate();


                try (
                        ResultSet chaves =
                                ps.getGeneratedKeys()
                ) {

                    if (chaves.next()) {

                        registro.setId(
                                chaves.getInt(1)
                        );
                    }
                }
            }
        }
    }


    // =============================================
    // LISTAR REGISTROS DO USUÁRIO (mais recentes primeiro)
    // =============================================

    public List<Registro> listarPorUsuario(
            int usuarioId
    ) throws SQLException {

        String sql =
                "SELECT r.id, r.treino_id, r.data, t.nome "
                + "FROM registro_treino r "
                + "JOIN treino t ON t.id = r.treino_id "
                + "WHERE t.usuario_id = ? "
                + "ORDER BY r.data DESC";


        List<Registro> lista =
                new ArrayList<>();


        try (
                Connection con =
                        Conexao.abrir()
        ) {

            criarTabela(con);


            try (
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

                        lista.add(
                                new Registro(
                                        rs.getInt("id"),
                                        rs.getInt("treino_id"),
                                        rs.getString("nome"),
                                        rs.getTimestamp("data")
                                                .toLocalDateTime()
                                )
                        );
                    }
                }
            }
        }


        return lista;
    }
}
