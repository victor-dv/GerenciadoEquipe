package view.team;

import controller.EquipeController;
import controller.UsuarioController;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TeamRegistrationFrame extends JFrame {

    private JTextField txtNomeEquipe;
    private JTextArea txtDescricao;
    private JList<Usuario> listUsuarios;
    private DefaultListModel<Usuario> listModel;
    private JButton btnCadastrar;
    private JButton btnCancelar;
    
    private EquipeController equipeController;
    private UsuarioController usuarioController;

    public TeamRegistrationFrame() {
        equipeController = new EquipeController();
        usuarioController = new UsuarioController();
        
        setTitle("Cadastro de Equipe");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        loadUsuarios();
    }

    private void loadUsuarios() {
        try {
            List<Usuario> usuarios = usuarioController.listarUsuarios();
            for (Usuario u : usuarios) {
                listModel.addElement(u);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar usuários: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Nome da Equipe
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nome da Equipe:"), gbc);
        gbc.gridx = 1;
        txtNomeEquipe = new JTextField(20);
        panel.add(txtNomeEquipe, gbc);

        // Descrição
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        panel.add(new JLabel("Descrição:"), gbc);
        gbc.gridx = 1;
        txtDescricao = new JTextArea(4, 20);
        txtDescricao.setLineWrap(true);
        txtDescricao.setWrapStyleWord(true);
        JScrollPane scrollDesc = new JScrollPane(txtDescricao);
        panel.add(scrollDesc, gbc);

        // Membros (Usuários)
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Vincular Membros:"), gbc);
        gbc.gridx = 1;
        
        listModel = new DefaultListModel<>();
        listUsuarios = new JList<>(listModel);
        listUsuarios.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollList = new JScrollPane(listUsuarios);
        scrollList.setPreferredSize(new Dimension(200, 150));
        panel.add(scrollList, gbc);

        // Dica de seleção
        gbc.gridx = 1; gbc.gridy = 3;
        JLabel lblHint = new JLabel("Use Ctrl para selecionar múltiplos");
        lblHint.setFont(new Font("Arial", Font.ITALIC, 10));
        panel.add(lblHint, gbc);

        // Botões
        JPanel buttonPanel = new JPanel();
        btnCadastrar = new JButton("Cadastrar");
        btnCancelar = new JButton("Cancelar");
        buttonPanel.add(btnCadastrar);
        buttonPanel.add(btnCancelar);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(buttonPanel, gbc);

        add(panel);

        // Action Listeners
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNomeEquipe.getText();
                String descricao = txtDescricao.getText();
                List<Usuario> selecionados = listUsuarios.getSelectedValuesList();

                if (nome.isEmpty()) {
                    JOptionPane.showMessageDialog(TeamRegistrationFrame.this, "Por favor, informe o nome da equipe.", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else if (selecionados.isEmpty()) {
                    JOptionPane.showMessageDialog(TeamRegistrationFrame.this, "Selecione ao menos um membro para a equipe.", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        equipeController.cadastrarEquipe(nome, descricao, selecionados);
                        JOptionPane.showMessageDialog(TeamRegistrationFrame.this, "Equipe cadastrada com sucesso!");
                        dispose();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(TeamRegistrationFrame.this, "Erro ao cadastrar equipe: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
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
