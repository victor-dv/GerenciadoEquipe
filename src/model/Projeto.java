package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Projeto {
    private int idProjeto;
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFinalPrevisto;
    private StatusProjeto status;
    private Usuario gerente;
    private LocalDateTime dataCadastro;

    public Projeto() {}

    public Projeto(int idProjeto, String nome, String descricao, LocalDate dataInicio, LocalDate dataFinalPrevisto, StatusProjeto status, Usuario gerente, LocalDateTime dataCadastro) {
        this.idProjeto = idProjeto;
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFinalPrevisto = dataFinalPrevisto;
        this.status = status;
        this.gerente = gerente;
        this.dataCadastro = dataCadastro;
    }

    // Getters and Setters
    public int getIdProjeto() { return idProjeto; }
    public void setIdProjeto(int idProjeto) { this.idProjeto = idProjeto; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataFinalPrevisto() { return dataFinalPrevisto; }
    public void setDataFinalPrevisto(LocalDate dataFinalPrevisto) { this.dataFinalPrevisto = dataFinalPrevisto; }

    public StatusProjeto getStatus() { return status; }
    public void setStatus(StatusProjeto status) { this.status = status; }

    public Usuario getGerente() { return gerente; }
    public void setGerente(Usuario gerente) { this.gerente = gerente; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    @Override
    public String toString() {
        return nome;
    }
}
