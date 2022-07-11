/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Model.*;

/**
 *
 * @author juand
 */
public class RegistrasiController {

    DatabaseHandler conn = new DatabaseHandler();
    int jmlIndex = 0;
    int temp = 0;
    String[] listCategory;
    int[] listIdCategory;

    public RegistrasiController() {

    }

    public String[] cekKategori() {
        String query = "SELECT * FROM categoryuser";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                jmlIndex++;
            }
            listCategory = new String[jmlIndex];
            listIdCategory = new int[jmlIndex];
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                listCategory[temp] = rs.getString("name");
                listIdCategory[temp] = rs.getInt("id");
                temp++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        return listCategory;
    }

    public int[] cekIdKategori() {
        return listIdCategory;
    }

    public void registrasi(User user) {
        conn.connect();
        String query = "INSERT INTO user(name, email, password, idCategory, photo)"
                + "VALUES('" + user.getName() + "','" + user.getEmail() + "','"
                + user.getPassword() + "','" + user.getIdCategory() + "','"
                + user.getPhoto() + "')";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
    }
}
