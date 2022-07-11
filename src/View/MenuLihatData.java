/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import Controller.LihatDataController;
/**
 *
 * @author juand
 */
public class MenuLihatData {
    LihatDataController control = new LihatDataController();
    JFrame f = new JFrame("Menu Lihat Data");
    JTable tabel;
    public MenuLihatData(){
        String data[][] = control.lihatData();
        String[]kolom;
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Folder Importante\\KAMPUS\\ITHB\\Semester Pendek 2022\\PBO\\PBO_UAS\\project\\coc.jpg");
        f.setIconImage(icon);
        f.setSize(750, 550);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new MenuLihatData();
    }
}
