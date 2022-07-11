/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import Controller.LoginController;
/**
 *
 * @author juand
 */
public class MenuLogin implements ActionListener {
    LoginController control = new LoginController();
    JFrame f;
    JLabel judul, lEmail, lPw;
    JTextField email;
    JPasswordField pw;
    JButton login, back;

    public MenuLogin() {
        f = new JFrame("Menu Login");
        judul = new JLabel("Silahkan Input Data Dibawah Untuk Login...");
        judul.setBounds(270, 0, 300, 100);
        f.add(judul);
        lEmail = new JLabel("Input Email: ");
        lEmail.setBounds(150, 100, 300, 30);
        f.add(lEmail);
        email = new JTextField();
        email.setBounds(250, 100, 200, 30);
        f.add(email);
        lPw = new JLabel("Input Password: ");
        lPw.setBounds(150, 150, 300, 30);
        f.add(lPw);
        pw = new JPasswordField();
        pw.setBounds(250, 150, 200, 30);
        f.add(pw);
        login = new JButton("LOGIN");
        login.setBounds(280, 200, 100, 50);
        f.add(login);
        login.addActionListener(this);
        back = new JButton("back");
        back.setBounds(150, 270, 100, 50);
        f.add(back);
        back.addActionListener(this);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Folder Importante\\KAMPUS\\ITHB\\Semester Pendek 2022\\PBO\\PBO_UAS\\project\\coc.jpg");
        f.setIconImage(icon);
        f.setSize(750, 550);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MenuLogin();
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        String com = evt.getActionCommand();
        f.dispose();
        switch (com) {
            case "LOGIN":
                String inputEmail = email.getText();
                String inputPw = pw.getText();
                boolean berhasil = control.cekLogin(inputEmail, inputPw);
                if (berhasil) {
                    new MenuLihatData();
                }else{
                    JOptionPane.showMessageDialog(null, "Input Anda SALAH!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    new MenuLogin();
                }
                break;
            case "back":
                new MainMenu();
                break;
        }
    }
}
