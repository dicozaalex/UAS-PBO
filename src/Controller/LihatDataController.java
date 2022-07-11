/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juand
 */
public class LihatDataController {
    DatabaseHandler conn = new DatabaseHandler();
    String[][]data;
    public LihatDataController(){
        
    }
    public String[][] lihatData(){
        String query = "SELECT * FROM user";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        return data;
    }
}
