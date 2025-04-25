/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    private String url = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String DB = "bdakt", USR = "root", KEY = "280602", HST = "localhost", URL = "jdbc:mysql://" + HST + ":3306/" + DB + url;
    Connection con = null;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.URL, this.USR, this.KEY);

        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Error al establecer Conexión con la base de datos ", "Conexión", 1);
        }
        return con;
    }
}
