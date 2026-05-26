package dao;

import model.Projeto;
import model.StatusProjeto;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {
    public void create(Projeto projeto) throws SQLException {
        String sql = "INSERT INTO projetos (nome, descricao, data_inicio, data_final_previsto, status, gerente_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDescricao());
            stmt.setDate(3, Date.valueOf(projeto.getDataInicio()));
            stmt.setDate(4, projeto.getDataFinalPrevisto() != null ? Date.valueOf(projeto.getDataFinalPrevisto()) : null);
            stmt.setString(5, projeto.getStatus().getDescricao());
            stmt.setInt(6, projeto.getGerente().getId());
            stmt.executeUpdate();
        }
    }

    public List<Projeto> findAll() throws SQLException {
        String sql = "SELECT p.*, u.name as gerente_nome FROM projetos p JOIN users u ON p.gerente_id = u.id";
        List<Projeto> projetos = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Projeto p = new Projeto();
                p.setIdProjeto(rs.getInt("id_projeto"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                Date dataFim = rs.getDate("data_final_previsto");
                if (dataFim != null) p.setDataFinalPrevisto(dataFim.toLocalDate());
                p.setStatus(StatusProjeto.fromString(rs.getString("status")));
                
                Usuario gerente = new Usuario();
                gerente.setId(rs.getInt("gerente_id"));
                gerente.setNome(rs.getString("gerente_nome"));
                p.setGerente(gerente);
                
                p.setDataCadastro(rs.getTimestamp("data_cadastro").toLocalDateTime());
                projetos.add(p);
            }
        }
        return projetos;
    }
}
