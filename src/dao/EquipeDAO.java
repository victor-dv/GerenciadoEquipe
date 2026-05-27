package dao;

import model.Equipe;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipeDAO {
    public void create(Equipe equipe) throws SQLException {
        String sqlEquipe = "INSERT INTO equipes (nome, descricao) VALUES (?, ?)";
        String sqlMembros = "INSERT INTO equipe_usuarios (equipe_id, usuario_id) VALUES (?, ?)";
        
        try (Connection conn = ConnectionFactory.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmtEquipe = conn.prepareStatement(sqlEquipe, Statement.RETURN_GENERATED_KEYS)) {
                stmtEquipe.setString(1, equipe.getNome());
                stmtEquipe.setString(2, equipe.getDescricao());
                stmtEquipe.executeUpdate();

                try (ResultSet generatedKeys = stmtEquipe.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        equipe.setIdEquipe(generatedKeys.getInt(1));
                    }
                }

                try (PreparedStatement stmtMembros = conn.prepareStatement(sqlMembros)) {
                    for (Usuario membro : equipe.getMembros()) {
                        stmtMembros.setInt(1, equipe.getIdEquipe());
                        stmtMembros.setInt(2, membro.getId());
                        stmtMembros.addBatch();
                    }
                    stmtMembros.executeBatch();
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
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
