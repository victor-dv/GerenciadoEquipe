package model;

import java.time.LocalDateTime;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String cargo;
    private String cpf;
    private String login;
    private String password;
    private Perfil perfil;
    private LocalDateTime dataCadastro;

    public Usuario() {}

    public Usuario(int id, String nome, String email, String cargo, String cpf, String login, String password, Perfil perfil, LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.cpf = cpf;
        this.login = login;
        this.password = password;
        this.perfil = perfil;
        this.dataCadastro = dataCadastro;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Perfil getPerfil() { return perfil; }
    public void setPerfil(Perfil perfil) { this.perfil = perfil; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    @Override
    public String toString() {
        return nome;
    }
}
