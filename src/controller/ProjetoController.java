package controller;

import dao.ProjetoDAO;
import model.Projeto;
import model.StatusProjeto;
import model.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProjetoController {
    private ProjetoDAO projetoDAO;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ProjetoController() {
        this.projetoDAO = new ProjetoDAO();
    }

    public void cadastrarProjeto(String nome, String descricao, String dataInicioStr, String dataFimStr, String statusStr, Usuario gerente) throws Exception {
        Projeto p = new Projeto();
        p.setNome(nome);
        p.setDescricao(descricao);
        p.setDataInicio(LocalDate.parse(dataInicioStr, formatter));
        if (dataFimStr != null && !dataFimStr.isEmpty()) {
            p.setDataFinalPrevisto(LocalDate.parse(dataFimStr, formatter));
        }
        p.setStatus(StatusProjeto.fromString(statusStr));
        p.setGerente(gerente);
        
        projetoDAO.create(p);
    }
}
