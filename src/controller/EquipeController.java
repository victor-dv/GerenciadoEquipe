package controller;

import dao.EquipeDAO;
import model.Equipe;
import model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class EquipeController {
    private EquipeDAO equipeDAO;

    public EquipeController() {
        this.equipeDAO = new EquipeDAO();
    }

    public void cadastrarEquipe(String nome, String descricao, List<Usuario> membros) throws SQLException {
        Equipe e = new Equipe();
        e.setNome(nome);
        e.setDescricao(descricao);
        e.setMembros(membros);
        
        equipeDAO.create(e);
    }
}
