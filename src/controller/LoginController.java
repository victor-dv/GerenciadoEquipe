package controller;

import dao.UsuarioDAO;
import model.Usuario;

import java.sql.SQLException;

public class LoginController {
    private UsuarioDAO usuarioDAO;

    public LoginController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public Usuario autenticar(String login, String senha) {
        try {
            return usuarioDAO.findByLoginAndPassword(login, senha);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
