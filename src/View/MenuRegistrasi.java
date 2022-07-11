/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.filechooser.FileSystemView;
import Controller.RegistrasiController;
import java.io.File;
import Model.*;
import java.util.ArrayList;
/**
 *
 * @author juand
 */
public class MenuRegistrasi implements ActionListener {
    ArrayList<String>listInput = new ArrayList<>();
    JFrame f;
    JLabel judul, lEmail, lPw, lNama, lFoto, hasilFoto, lKategori;
    JTextField email, nama;
    JPasswordField pw;
    JButton openFoto;
    JFileChooser foto;
    JComboBox kategori;
    JButton registrasi, back;
    RegistrasiController control = new RegistrasiController();

    public MenuRegistrasi() {
        f = new JFrame("Menu Registrasi");
        judul = new JLabel("Silahkan Input Data Dibawah Untuk Registrasi...");
        judul.setBounds(270, 0, 300, 100);
        f.add(judul);
        lNama = new JLabel("Input Nama: ");
        lNama.setBounds(150, 100, 200, 30);
        f.add(lNama);
        nama = new JTextField();
        nama.setBounds(250, 100, 200, 30);
        f.add(nama);
        lEmail = new JLabel("Input Email: ");
        lEmail.setBounds(150, 150, 200, 30);
        f.add(lEmail);
        email = new JTextField();
        email.setBounds(250, 150, 200, 30);
        f.add(email);
        lPw = new JLabel("Input Password: ");
        lPw.setBounds(150, 200, 200, 30);
        f.add(lPw);
        pw = new JPasswordField();
        pw.setBounds(250, 200, 200, 30);
        f.add(pw);
        lFoto = new JLabel("Input Foto: ");
        lFoto.setBounds(150, 250, 200, 30);
        f.add(lFoto);
        openFoto = new JButton("OPEN FOTO");
        openFoto.setBounds(250, 250, 100, 30);
        f.add(openFoto);
        openFoto.addActionListener(this);
        hasilFoto = new JLabel("No File Selected");
        hasilFoto.setBounds(380, 250, 200, 30);
        f.add(hasilFoto);
        lKategori = new JLabel("Input Kategori: ");
        lKategori.setBounds(150, 300, 100, 30);
        f.add(lKategori);

        // combo box
        String[] arrKategori = control.cekKategori();
        int[]arrIdKategori = control.cekIdKategori();
        kategori = new JComboBox(arrKategori);
        kategori.setBounds(250, 300, 200, 30);
        f.add(kategori);

        registrasi = new JButton("REGISTRASI");
        registrasi.setBounds(280, 350, 150, 50);
        f.add(registrasi);
        registrasi.addActionListener(this);
        back = new JButton("back");
        back.setBounds(150, 400, 100, 50);
        f.add(back);
        back.addActionListener(this);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Folder Importante\\KAMPUS\\ITHB\\Semester Pendek 2022\\PBO\\PBO_UAS\\project\\coc.jpg");
        f.setIconImage(icon);
        f.setSize(750, 550);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String com = evt.getActionCommand();
        switch (com) {
            case "OPEN FOTO":
                File file = new File("C:\\Folder Importante\\KAMPUS\\ITHB\\Semester Pendek 2022\\PBO\\PBO_UAS\\project");
                JFileChooser jFile = new JFileChooser(file, FileSystemView.getFileSystemView());
                int r = jFile.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    hasilFoto.setText(jFile.getSelectedFile().getAbsolutePath());
                } else {
                    hasilFoto.setText("The user cancelled the operation");
                }
                break;
            case "REGISTRASI":
                User user = new User();
                user.setName(nama.getText());
                user.setEmail(email.getText());
                user.setPassword(pw.getText());
                user.setIdCategory(kategori.getSelectedIndex());
                user.setPhoto(hasilFoto.getText());
                f.dispose();
                control.registrasi(user);
                JOptionPane.showMessageDialog(null, "Insert Database Berhasil");
                new MainMenu();
                break;
            case "back":
                f.dispose();
                new MainMenu();
                break;
        }
    }
}
