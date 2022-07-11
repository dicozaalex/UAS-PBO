/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author juand
 */
public class LoginController {
    DatabaseHandler conn = new DatabaseHandler();
    boolean berhasil = false;
    public LoginController(){
        
    }
    public boolean cekLogin(String inputEmail, String inputPw){
        String query = "SELECT * FROM user";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (inputEmail.equals(rs.getString("email"))) {
                    if (inputPw.equals(rs.getString("password"))) {
                        berhasil = true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        return berhasil;
    }
}
