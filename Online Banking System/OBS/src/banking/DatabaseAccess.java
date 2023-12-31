/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseAccess {
    public static void main(String[] args) {
        Login frm = new Login();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(DatabaseConfig.CONNECTION_STRING, "sa", "sa");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions properly
            return null;
        }
    }
}
