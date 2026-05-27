package view.project;

import controller.ProjetoController;
import controller.UsuarioController;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProjectRegistrationFrame extends JFrame {

    private JTextField txtNomeProjeto;
    private JTextArea txtDescricao;
    private JTextField txtDataInicio;
    private JTextField txtDataTermino;
    private JComboBox<String> comboStatus;
    private JComboBox<Usuario> comboGerenteResponsavel;
    private JButton btnCadastrar;
    private JButton btnCancelar;
    
    private ProjetoController projetoController;
    private UsuarioController usuarioController;

    public ProjectRegistrationFrame() {
        projetoController = new ProjetoController();
        usuarioController = new UsuarioController();
        
        setTitle("Cadastro de Projeto");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        loadGerentes();
    }

    private void loadGerentes() {
        try {
            List<Usuario> usuarios = usuarioController.listarUsuarios();
            comboGerenteResponsavel.addItem(null); // Para o "Selecione..."
            for (Usuario u : usuarios) {
                // Poderíamos filtrar por perfil aqui se desejado
                comboGerenteResponsavel.addItem(u);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar gerentes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Nome do Projeto
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nome do Projeto:"), gbc);
        gbc.gridx = 1;
        txtNomeProjeto = new JTextField(20);
        panel.add(txtNomeProjeto, gbc);

        // Descrição
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        panel.add(new JLabel("Descrição:"), gbc);
        gbc.gridx = 1;
        txtDescricao = new JTextArea(5, 20);
        txtDescricao.setLineWrap(true);
        txtDescricao.setWrapStyleWord(true);
        JScrollPane scrollDesc = new JScrollPane(txtDescricao);
        panel.add(scrollDesc, gbc);

        // Data de Início
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Data de Início (dd/mm/aaaa):"), gbc);
        gbc.gridx = 1;
        txtDataInicio = new JTextField(10);
        panel.add(txtDataInicio, gbc);

        // Data de Término Prevista
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Término Previsto (dd/mm/aaaa):"), gbc);
        gbc.gridx = 1;
        txtDataTermino = new JTextField(10);
        panel.add(txtDataTermino, gbc);

        // Status
        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(new JLabel("Status:"), gbc);
        gbc.gridx = 1;
        String[] statusOpcoes = {"Planejado", "Em_Andamento", "Concluido", "Cancelado"};
        comboStatus = new JComboBox<>(statusOpcoes);
        panel.add(comboStatus, gbc);

        // Gerente Responsável
        gbc.gridx = 0; gbc.gridy = 5;
        panel.add(new JLabel("Gerente Responsável:"), gbc);
        gbc.gridx = 1;
        comboGerenteResponsavel = new JComboBox<>();
        panel.add(comboGerenteResponsavel, gbc);

        // Botões
        JPanel buttonPanel = new JPanel();
        btnCadastrar = new JButton("Cadastrar");
        btnCancelar = new JButton("Cancelar");
        buttonPanel.add(btnCadastrar);
        buttonPanel.add(btnCancelar);

        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(buttonPanel, gbc);

        add(panel);

        // Action Listeners
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNomeProjeto.getText();
                String descricao = txtDescricao.getText();
                String dataInicio = txtDataInicio.getText();
                String dataFim = txtDataTermino.getText();
                String status = (String) comboStatus.getSelectedItem();
                Usuario gerente = (Usuario) comboGerenteResponsavel.getSelectedItem();

                if (nome.isEmpty() || gerente == null) {
                    JOptionPane.showMessageDialog(ProjectRegistrationFrame.this, "Por favor, preencha o nome do projeto e selecione um gerente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        projetoController.cadastrarProjeto(nome, descricao, dataInicio, dataFim, status, gerente);
                        JOptionPane.showMessageDialog(ProjectRegistrationFrame.this, "Projeto cadastrado com sucesso!");
                        dispose();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(ProjectRegistrationFrame.this, "Erro ao cadastrar projeto: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
