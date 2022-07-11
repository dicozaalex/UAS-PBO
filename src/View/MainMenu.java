/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author juand
 */
public class MainMenu implements ActionListener {

    JFrame f = new JFrame("Main Menu");
    JLabel judul;
    JButton login, registrasi, lihatData;

    public MainMenu() {
        judul = new JLabel("Silahkan pilih menu yang anda inginkan...");
        judul.setBounds(250, 0, 300, 100);
        f.add(judul);
        login = new JButton("LOGIN");
        login.setBounds(250, 100, 200, 50);
        f.add(login);
        login.addActionListener(this);
        registrasi = new JButton("REGISTRASI");
        registrasi.setBounds(250, 200, 200, 50);
        f.add(registrasi);
        registrasi.addActionListener(this);
        lihatData = new JButton("Lihat Data Pengguna");
        lihatData.setBounds(250, 300, 200, 50);
        lihatData.addActionListener(this);
        f.add(lihatData);
        f.setSize(700, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String com = evt.getActionCommand();
        f.dispose();
        switch(com){
            case "LOGIN":
                new MenuLogin();
                break;
            case "REGISTRASI":
                new MenuRegistrasi();
                break;
            case "Lihat Data Pengguna":
                break;
        }
    }
}
