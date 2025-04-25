/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class DAO_Cliente extends Conexion{
    public boolean insertar(DTO_Cliente cli) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "INSERT INTO cliente(cedula,nombre,apellido,genero,edad,direccion,telefono) VALUE(?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(stm);
            pst.setString(1, cli.getCedula());
            pst.setString(2, cli.getNombre());
            pst.setString(3, cli.getApellido());
            pst.setString(4, cli.getGenero());
            pst.setInt(5, cli.getEdad());
            pst.setString(6, cli.getDireccion());
            pst.setString(7, cli.getTelefono());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            mensaje("Error");
            return false;
        }
    }
    
    public void mensaje(String ti) {
        JOptionPane.showMessageDialog(null, ti);
    }
    
    ////////////////////////////////////////////////////////////////
    
    public boolean consultar(DTO_Cliente cli) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "SELECT * FROM cliente WHERE cedula=?";
        ResultSet rst;
        try {
            pst = con.prepareStatement(stm);
            pst.setString(1, cli.getCedula());
            rst = (ResultSet)pst.executeQuery();
            if (rst.next()) {
                cli.setCedula(rst.getString("cedula"));
                cli.setNombre(rst.getString("nombre"));
                cli.setApellido(rst.getString("apellido"));
                cli.setGenero(rst.getString("genero"));
                cli.setEdad(rst.getInt("edad"));
                cli.setDireccion(rst.getString("direccion"));
                cli.setTelefono(rst.getString("telefono"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            mensaje("Error al consultar");
            return false;
        }
    }
    
    ////////////////////////////////////////////////////////////////
    
     public boolean actualizar(DTO_Cliente cli) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "UPDATE cliente SET nombre=?,apellido=?,genero=?,edad=?,direccion=?,telefono=? WHERE cedula=?";
        try {
            pst = con.prepareStatement(stm);
            pst.setString(1, cli.getCedula());
            pst.setString(2, cli.getNombre());
            pst.setString(3, cli.getApellido());
            pst.setString(4, cli.getGenero());
            pst.setInt(5, cli.getEdad());
            pst.setString(6, cli.getDireccion());
            pst.setString(7, cli.getTelefono());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            mensaje("Error al actualizar");
            return false;
        }
    }
     
     ////////////////////////////////////////////////////
     
    public boolean eliminar(DTO_Cliente cli) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "DELETE FROM cliente WHERE cedula=?";
        try {
            pst = con.prepareStatement(stm);
            pst.setString(1, cli.getCedula());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            mensaje("Error al eliminar");
            return false;
        }
    }
}
