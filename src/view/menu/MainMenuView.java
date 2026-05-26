package view.menu;

import view.project.ProjectRegistrationFrame;
import view.team.TeamRegistrationFrame;
import view.user.UserRegistrationFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuView extends JFrame {

    public MainMenuView() {
        setTitle("Sistema de Gerenciamento de Equipes - Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnUsuarios = new JButton("Cadastrar Usuários");
        JButton btnProjetos = new JButton("Cadastrar Projetos");
        JButton btnEquipes = new JButton("Cadastrar Equipes");
        JButton btnSair = new JButton("Sair");

        panel.add(btnUsuarios);
        panel.add(btnProjetos);
        panel.add(btnEquipes);
        panel.add(btnSair);

        add(panel);

        // Ações dos botões
        btnUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserRegistrationFrame().setVisible(true);
            }
        });

        btnProjetos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProjectRegistrationFrame().setVisible(true);
            }
        });

        btnEquipes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TeamRegistrationFrame().setVisible(true);
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(MainMenuView.this, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}
