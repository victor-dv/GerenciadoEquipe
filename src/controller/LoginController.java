package controller;

import dao.UsuarioDAO;
import model.Usuario;
import util.PasswordUtils;

import java.sql.SQLException;

public class LoginController {
    private UsuarioDAO usuarioDAO;

    public LoginController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public Usuario autenticar(String login, String senha) throws SQLException {
        String senhaHash = PasswordUtils.hashPassword(senha);
        return usuarioDAO.findByLoginAndPassword(login, senhaHash);
    }
}
