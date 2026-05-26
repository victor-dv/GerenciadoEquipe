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

    public boolean cadastrarEquipe(String nome, String descricao, List<Usuario> membros) {
        try {
            Equipe e = new Equipe();
            e.setNome(nome);
            e.setDescricao(descricao);
            e.setMembros(membros);
            
            equipeDAO.create(e);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
