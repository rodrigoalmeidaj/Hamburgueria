package assets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {

    private JPanel panelLogin = new JPanel(), panelPrincipal = new JPanel();
    private CardLayout cardLayout = new CardLayout();

    private JLabel lblTitulo;
    private JLabel imagemFundoLogin;
    private JTextField usuario;
    private JTextField senha;
    private final Color COR_FUNDO = Color.decode("#f5ad69");
    private JButton btnLogar;
    private JButton btnCadastrar;
    public JButton btnVoltarCadastro;
    private JButton btnVoltarDashboard;
    private JLabel imagemLogo;

    public Login() {
        // Título da JFrame
        super("Lanches Bom Burguer");

        lblTitulo = new JLabel("Faça seu Login");
        lblTitulo.setBounds(70, 170, 260, 33);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 27));

        // Define a imagem da Logo na tela login
        imagemLogo = new JLabel();
        ImageIcon logo = new ImageIcon(this.getClass().getResource("../imagens//logo3.png"));
        imagemLogo.setIcon(logo);
        imagemLogo.setBounds(30, 0, 300, 170);

        // Define a imagem de fundo na tela login
        imagemFundoLogin = new JLabel("");
        ImageIcon fundoLogin = new ImageIcon(this.getClass().getResource("../imagens/hamburguer.jpg"));
        imagemFundoLogin.setIcon(fundoLogin);
        imagemFundoLogin.setBounds(340, 0, 940, 528);

        // Botões
        btnLogar = new JButton("Entrar");
        btnLogar.setBounds(125, 350, 75, 35);
        btnLogar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)));
        btnLogar.setBackground(Color.decode("#eb8d3b"));
        btnLogar.setFont(new Font("Arial", Font.BOLD, 14));

        btnCadastrar = new JButton("Cadastre-se");
        btnCadastrar.setBounds(95, 400, 125, 35);
        btnCadastrar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(8, 15, 15, 15)));
        btnCadastrar.setBackground(COR_FUNDO);
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 14));

        btnVoltarCadastro = new JButton("Voltar");
        btnVoltarCadastro.setBounds(0, 0, 50, 35);
        btnVoltarCadastro.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(4, 3, 7, 3)));
        btnVoltarCadastro.setBackground(Color.decode("#eb8d3b"));
        btnVoltarCadastro.setFont(new Font("Arial", Font.BOLD, 14));

        btnVoltarDashboard = new JButton("Voltar");
        btnVoltarDashboard.setBounds(1017, 0, 50, 35);
        btnVoltarDashboard.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(4, 3, 7, 3)));
        btnVoltarDashboard.setBackground(Color.decode("#eb8d3b"));
        btnVoltarDashboard.setFont(new Font("Arial", Font.BOLD, 14));

        // usuario
        usuario = estiloCampo("Usuário", 230);

        // senha
        senha = estiloCampo("Senha", 290);

        Cadastro cadastro = new Cadastro();
        cadastro.setVisible(true);

        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);

        acaoLogin acaoLogar = new acaoLogin();
        acaoCadastrar acaoCadastrar = new acaoCadastrar();
        acaoVoltarCadastro acaoVoltarCadastro = new acaoVoltarCadastro();
        acaoVoltarDashboard acaVoltarDashboard = new acaoVoltarDashboard();

        // Ações dos botões
        btnLogar.addActionListener(acaoLogar);
        btnCadastrar.addActionListener(acaoCadastrar);
        btnVoltarCadastro.addActionListener(acaoVoltarCadastro);
        btnVoltarDashboard.addActionListener(acaVoltarDashboard);

        // Adicionando panelLogin
        panelLogin.setLayout(null);
        panelLogin.setBackground(COR_FUNDO);
        panelLogin.add(lblTitulo);
        panelLogin.add(imagemFundoLogin);
        panelLogin.add(imagemLogo);
        panelLogin.add(btnLogar);
        panelLogin.add(usuario);
        panelLogin.add(senha);
        panelLogin.add(btnCadastrar);

        // Add na tela cadastro
        cadastro.add(btnVoltarCadastro);

        // add na tela dashboard
        dashboard.add(btnVoltarDashboard);

        panelPrincipal.setLayout(cardLayout);

        panelPrincipal.add(panelLogin, "panelLogin");
        panelPrincipal.add(cadastro, "cadastro");
        panelPrincipal.add(dashboard, "dashboard");

        this.setContentPane(panelPrincipal);

        cardLayout.show(panelPrincipal, "login");
    }

    private JTextField estiloCampo(String placeholder, int posicaoY) {

        // cria um textField temporario
        JTextField campo = new JTextField(placeholder);

        // define as dimensoes e posicoes
        campo.setBounds(70, posicaoY, 185, 35);

        // cor do fundo do campo
        campo.setBackground(Color.decode("#f5c495"));
        // borda e espçamento interno
        campo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)));
        // estilo da fonte
        campo.setFont(new Font("Tahoma", Font.BOLD, 12));

        // focar nos campos
        campo.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (campo.getText().equals(placeholder)) {
                    campo.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (campo.getText().isEmpty()) {
                    campo.setText(placeholder);
                }
            }

        });

        return campo;
    }

    // Ação dos botões
    public class acaoLogin implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            if (usuario.getText().equals("nelson")
                    || (usuario.getText().equals("rodrigo")) && (senha.getText().equals("123"))) {
                JOptionPane.showMessageDialog(null, "Você foi logado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                cardLayout.show(panelPrincipal, "dashboard");
            } else {
                JOptionPane.showMessageDialog(null, "Dados inválidos", "Alerta", JOptionPane.ERROR_MESSAGE);

            }

        }
    }

    public class acaoVoltarCadastro implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton voltar = (JButton) event.getSource();
            if (voltar.equals(btnVoltarCadastro))

                cardLayout.show(panelPrincipal, "panelLogin");

        }
    }

    public class acaoVoltarDashboard implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton voltar = (JButton) event.getSource();
            if (voltar.equals(btnVoltarDashboard))

                cardLayout.show(panelPrincipal, "panelLogin");

        }
    }

    public class acaoCadastrar implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton cadastrar = (JButton) event.getSource();
            if (cadastrar.equals(btnCadastrar))
                cardLayout.show(panelPrincipal, "cadastro");

        }
    }

    // Getters e Setters

    public JTextField getUsuario() {
        return usuario;
    }

    public void setUsuario(JTextField usuario) {
        this.usuario = usuario;
    }

    public JTextField getSenha() {
        return senha;
    }

    public void setSenha(JTextField senha) {
        this.senha = senha;
    }
}