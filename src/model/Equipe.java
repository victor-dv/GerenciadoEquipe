package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private int idEquipe;
    private String nome;
    private String descricao;
    private List<Usuario> membros;
    private LocalDateTime dataCadastro;

    public Equipe() {
        this.membros = new ArrayList<>();
    }

    public Equipe(int idEquipe, String nome, String descricao, LocalDateTime dataCadastro) {
        this.idEquipe = idEquipe;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.membros = new ArrayList<>();
    }

    // Getters and Setters
    public int getIdEquipe() { return idEquipe; }
    public void setIdEquipe(int idEquipe) { this.idEquipe = idEquipe; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public List<Usuario> getMembros() { return membros; }
    public void setMembros(List<Usuario> membros) { this.membros = membros; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    public void addMembro(Usuario usuario) {
        if (!this.membros.contains(usuario)) {
            this.membros.add(usuario);
        }
    }

    public void removeMembro(Usuario usuario) {
        this.membros.remove(usuario);
    }
}
