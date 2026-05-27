package controller;

import dao.UsuarioDAO;
import model.Perfil;
import model.Usuario;
import util.PasswordUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrarUsuario(String nome, String email, String cargo, String cpf, String login, String senha, String perfilStr) throws SQLException {
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        u.setCargo(cargo);
        u.setCpf(cpf);
        u.setLogin(login);
        u.setPassword(PasswordUtils.hashPassword(senha));
        u.setPerfil(Perfil.fromString(perfilStr));
        
        usuarioDAO.create(u);
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        return usuarioDAO.findAll();
    }
}
