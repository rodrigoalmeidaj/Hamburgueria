package main;

import javax.swing.*;

import assets.Cadastro;
import assets.Dashboard;
import assets.Login;

public class Principal {
    public static void main(String[] args) {
        Login login = new Login();
        login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        login.setBounds(300, 100, 1080, 528);
        login.setVisible(true);
        
    }
}