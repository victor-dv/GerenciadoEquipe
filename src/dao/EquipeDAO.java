package dao;

import model.Equipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipeDAO {
    public void create(Equipe equipe) throws SQLException {
        String sql = "INSERT INTO equipes (nome, descricao) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, equipe.getNome());
            stmt.setString(2, equipe.getDescricao());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    equipe.setIdEquipe(generatedKeys.getInt(1));
                }
            }
        }
        // Nota: A vinculação de membros exigiria uma tabela associativa não presente no SQL original.
    }

    public List<Equipe> findAll() throws SQLException {
        String sql = "SELECT * FROM equipes";
        List<Equipe> equipes = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Equipe e = new Equipe();
                e.setIdEquipe(rs.getInt("id_equipe"));
                e.setNome(rs.getString("nome"));
                e.setDescricao(rs.getString("descricao"));
                e.setDataCadastro(rs.getTimestamp("data_cadastro").toLocalDateTime());
                equipes.add(e);
            }
        }
        return equipes;
    }
}
