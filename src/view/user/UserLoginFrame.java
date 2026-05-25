package view.user;

import view.menu.MainMenuView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginFrame extends JFrame {

    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private JButton btnCancelar;

    public UserLoginFrame() {
        setTitle("Login de Usuário");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Login
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Login:"), gbc);
        gbc.gridx = 1;
        txtLogin = new JTextField(15);
        panel.add(txtLogin, gbc);

        // Senha
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Senha:"), gbc);
        gbc.gridx = 1;
        txtSenha = new JPasswordField(15);
        panel.add(txtSenha, gbc);

        // Botões
        JPanel buttonPanel = new JPanel();
        btnEntrar = new JButton("Entrar");
        btnCancelar = new JButton("Cancelar");
        buttonPanel.add(btnEntrar);
        buttonPanel.add(btnCancelar);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(buttonPanel, gbc);

        add(panel);

        // Action Listeners
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = txtLogin.getText();
                String senha = new String(txtSenha.getPassword());

                if (login.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(UserLoginFrame.this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(UserLoginFrame.this, "Login realizado com sucesso!");
                    new MainMenuView().setVisible(true);
                    dispose();
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}