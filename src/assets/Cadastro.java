package assets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cadastro extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    protected static final int EXIT_ON_CLOSE = 0;
    private JLabel lblTitulo;
    private JLabel imagemFundoLogin;
    private JTextField usuario;
    private JTextField novaSenha;
    private JTextField confirmaSenha;
    private JTextField email;
    private final Color COR_FUNDO = Color.decode("#f5ad69");
    private JButton btnCadastrar;
    private JLabel imagemLogo;

    public Cadastro() {
        setBackground(COR_FUNDO);
        setLayout(null);
        iniciarInterface();

    }
    
    private void iniciarInterface() {
        // Label Novo cadastro
        lblTitulo = new JLabel("Novo cadastro");
        lblTitulo.setBounds(70, 170, 260, 33);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 27));

        // adicionar campos de usuario e senha

        // usuario
        usuario = estiloCampo("Usuário", 230);
        // email
        email = estiloCampo("Email", 280);
        // senha
        novaSenha = estiloCampo("Digite sua senha", 330);
        // confirma senha
        confirmaSenha = estiloCampo("Confirme sua senha", 380);

        // Botao Cadastrar
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(this);

        btnCadastrar.setBounds(110, 430, 100, 35);
        btnCadastrar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)));
        btnCadastrar.setBackground(Color.decode("#eb8d3b"));
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 14));

        // Imagem da logo
        imagemLogo = new JLabel();
        ImageIcon logo = new ImageIcon(this.getClass().getResource("../imagens/logo3.png"));
        imagemLogo.setIcon(logo);
        imagemLogo.setBounds(30, 0, 300, 170);

        // Define a imagem de fundo da tela login
        imagemFundoLogin = new JLabel("");
        ImageIcon fundoLogin = new ImageIcon(this.getClass().getResource("../imagens/hamburguer.jpg"));
        imagemFundoLogin.setIcon(fundoLogin);
        imagemFundoLogin.setBounds(340, 0, 940, 528);

        // Adcionar na tela

        add(imagemLogo);
        add(imagemFundoLogin);
        add(usuario);
        add(email);
        add(novaSenha);
        add(confirmaSenha);
        add(lblTitulo);
        add(btnCadastrar);
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
            @Override
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

    // acao do botao Cadastrar
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnCadastrar) {

            try {

                if (novaSenha.getText().equals(getConfirmaSenha().getText()) && !email.getText().equals("Email")
                        && !usuario.getText().equals("Usuário")) {
                    JOptionPane.showMessageDialog(null, "Você foi cadastrado com sucesso", "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Preencha todos os dados!", "Alerta",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public JTextField getUsuario() {
        return usuario;
    }

    public void setUsuario(JTextField usuario) {
        this.usuario = usuario;
    }

    public JTextField getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(JTextField novaSenha) {
        this.novaSenha = novaSenha;
    }

    public JTextField getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(JTextField confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public JTextField getEmail() {
        return email;
    }

    public void setEmail(JTextField email) {
        this.email = email;
    }

    public void setDefaultCloseOperation(int disposeOnClose) {
    }

}
