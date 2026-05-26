package controller;

import dao.UsuarioDAO;
import model.Perfil;
import model.Usuario;

import java.sql.SQLException;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public boolean cadastrarUsuario(String nome, String email, String cargo, String cpf, String login, String senha, String perfilStr) {
        try {
            Usuario u = new Usuario();
            u.setNome(nome);
            u.setEmail(email);
            u.setCargo(cargo);
            u.setCpf(cpf);
            u.setLogin(login);
            u.setPassword(senha);
            u.setPerfil(Perfil.fromString(perfilStr));
            
            usuarioDAO.create(u);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
