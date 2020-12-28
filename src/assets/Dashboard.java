package assets;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JPanel {

    private JLabel lblTitulo;
    private JTable tabela;
    private final Color COR_FUNDO = Color.decode("#e6cfa5");
    private final Color COR_TABELA = Color.decode("#deb783");
    private JLabel imagemLogo;
    private final String colunas[] = { "Categoria:", "Nome", "Conteudo:", "Preço:" };
    private final String dados[][] = { { "Hamburguer", "goku", "Pão, ovo, hamburguer", "R$10,00" },
            { "Hamburguer", "vegita", "Pão, hambúrguer,Cheddar", "R$12,50" },
            { "Hamburguer", "picolo", "Pão, hamburguer 180g, alface, tomate", "R$15,00" },
            { "Hamburguer", "gohan", "Pão, ovo, hamburguer,salsicha,bacon e cheddar", "R$18,00" },
            { "Hamburguer", "naruto", "Pão, ovo, hamburguer, alface, muçarela", "R$13,00" },
            { "Hamburguer", "chapolin", "Pão, calabresa, bacon, catupiry, hamburguer", "R$20,00" } };

    public Dashboard() {
        setBackground(COR_FUNDO);
        setLayout(null);
        iniciarInterface();
    }

    private void iniciarInterface() {

        tabela = new JTable(dados, colunas);
        tabela.setBounds(70, 170, 920, 300);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(400);
        tabela.setBackground(COR_TABELA);
        tabela.setPreferredScrollableViewportSize(new Dimension(400, 100));
        tabela.setFillsViewportHeight(true);
        add(tabela);

        lblTitulo = new JLabel("Cardápio do Dia");
        lblTitulo.setBounds(405, 50, 400, 75);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 50));

        // imagem da logo

        imagemLogo = new JLabel();
        ImageIcon logo = new ImageIcon(this.getClass().getResource("../imagens/logo3.png"));
        imagemLogo.setIcon(logo);
        imagemLogo.setBounds(30, 0, 300, 170);

        // adcionar na tela
        add(lblTitulo);
        add(imagemLogo);
    }

}