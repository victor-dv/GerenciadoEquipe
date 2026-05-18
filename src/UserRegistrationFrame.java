import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegistrationFrame extends JFrame {

    private JTextField txtNomeCompleto;
    private JTextField txtCPF;
    private JTextField txtEmail;
    private JTextField txtCargo;
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JComboBox<String> comboTipoUsuario;
    private JButton btnCadastrar;
    private JButton btnCancelar;

    public UserRegistrationFrame() {
        setTitle("Cadastro de Usuário");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Nome Completo
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nome Completo:"), gbc);
        gbc.gridx = 1;
        txtNomeCompleto = new JTextField(20);
        panel.add(txtNomeCompleto, gbc);

        // CPF
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("CPF:"), gbc);
        gbc.gridx = 1;
        txtCPF = new JTextField(20);
        panel.add(txtCPF, gbc);

        // Email
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        txtEmail = new JTextField(20);
        panel.add(txtEmail, gbc);

        // Cargo
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Cargo:"), gbc);
        gbc.gridx = 1;
        txtCargo = new JTextField(20);
        panel.add(txtCargo, gbc);

        // Login
        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(new JLabel("Login:"), gbc);
        gbc.gridx = 1;
        txtLogin = new JTextField(20);
        panel.add(txtLogin, gbc);

        // Senha
        gbc.gridx = 0; gbc.gridy = 5;
        panel.add(new JLabel("Senha:"), gbc);
        gbc.gridx = 1;
        txtSenha = new JPasswordField(20);
        panel.add(txtSenha, gbc);

        // Tipo de Usuário
        gbc.gridx = 0; gbc.gridy = 6;
        panel.add(new JLabel("Tipo de Usuário:"), gbc);
        gbc.gridx = 1;
        String[] tipos = {"Administrador", "Gerente", "Colaborador"};
        comboTipoUsuario = new JComboBox<>(tipos);
        panel.add(comboTipoUsuario, gbc);

        // Botões
        JPanel buttonPanel = new JPanel();
        btnCadastrar = new JButton("Cadastrar");
        btnCancelar = new JButton("Cancelar");
        buttonPanel.add(btnCadastrar);
        buttonPanel.add(btnCancelar);

        gbc.gridx = 0; gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(buttonPanel, gbc);

        add(panel);

        // Action Listeners básicos
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(UserRegistrationFrame.this, "Usuário cadastrado com sucesso! (Simulação)");
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
