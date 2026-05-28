package view.menu;

import model.Usuario;
import view.project.ProjectManagementDashboard;
import view.project.ProjectRegistrationFrame;
import view.team.TeamRegistrationFrame;
import view.user.UserRegistrationFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuView extends JFrame {

    public MainMenuView(Usuario usuario) {
        setTitle("Sistema de Gerenciamento de Equipes - Menu Principal");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnUsuarios = new JButton("Cadastrar Usuários");
        JButton btnProjetos = new JButton("Cadastrar Projetos");
        JButton btnEquipes = new JButton("Cadastrar Equipes");
        JButton btnGestao = new JButton("Gestão de Projetos (Dashboard)");
        JButton btnSair = new JButton("Sair");

        panel.add(btnUsuarios);
        panel.add(btnProjetos);
        panel.add(btnEquipes);
        panel.add(btnGestao);
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

        btnGestao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProjectManagementDashboard().setVisible(true);
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
