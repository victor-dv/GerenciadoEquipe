package dao;

import model.Perfil;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public void create(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO users (name, email, cargo, cpf, login, password, perfil) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getCargo());
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, usuario.getLogin());
            stmt.setString(6, usuario.getPassword());
            stmt.setString(7, usuario.getPerfil().getDescricao());
            stmt.executeUpdate();
        }
    }

    public List<Usuario> findAll() throws SQLException {
        String sql = "SELECT * FROM users";
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setCargo(rs.getString("cargo"));
                u.setCpf(rs.getString("cpf"));
                u.setLogin(rs.getString("login"));
                u.setPassword(rs.getString("password"));
                u.setPerfil(Perfil.fromString(rs.getString("perfil")));
                u.setDataCadastro(rs.getTimestamp("data_cadastro").toLocalDateTime());
                usuarios.add(u);
            }
        }
        return usuarios;
    }

    public Usuario findByLoginAndPassword(String login, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE login = ? AND password = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setNome(rs.getString("name"));
                    u.setPerfil(Perfil.fromString(rs.getString("perfil")));
                    return u;
                }
            }
        }
        return null;
    }
}
