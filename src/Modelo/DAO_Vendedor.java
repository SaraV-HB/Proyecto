/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class DAO_Vendedor extends Conexion{
    public boolean insertar(DTO_Vendedor ven) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "INSERT INTO vendedor(cedula,nombre,apellido,genero,edad,direccion,telefono) VALUE(?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(stm);
            pst.setString(1, ven.getCedula());
            pst.setString(2, ven.getNombre());
            pst.setString(3, ven.getApellido());
            pst.setString(4, ven.getGenero());
            pst.setInt(5, ven.getEdad());
            pst.setString(6, ven.getDireccion());
            pst.setString(7, ven.getTelefono());
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
    //cedula,nombre,apellido,genero,telefono,direccion,FeNacimie
    public boolean consultar(DTO_Vendedor ven) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "SELECT * FROM vendedor WHERE cedula=?";
        ResultSet rst;
        try {
            pst = con.prepareStatement(stm);
            pst.setString(1, ven.getCedula());
            rst = (ResultSet)pst.executeQuery();
            if (rst.next()) {
                ven.setCedula(rst.getString("cedula"));
                ven.setNombre(rst.getString("nombre"));
                ven.setApellido(rst.getString("apellido"));
                ven.setGenero(rst.getString("genero"));
                ven.setEdad(rst.getInt("edad"));
                ven.setDireccion(rst.getString("direccion"));
                ven.setTelefono(rst.getString("telefono"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            mensaje("Error al consultar");
            return false;
        }
    }
    
    ////////////////////////////////////////////////////////////////
    
     public boolean actualizar(DTO_Vendedor ven) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "UPDATE vendedor SET nombre=?,apellido=?,genero=?,edad=?,direccion=?,telefono=? WHERE cedula=?";
        try {
            pst = con.prepareStatement(stm);
            pst.setString(1, ven.getCedula());
            pst.setString(2, ven.getNombre());
            pst.setString(3, ven.getApellido());
            pst.setString(4, ven.getGenero());
            pst.setInt(5, ven.getEdad());
            pst.setString(6, ven.getDireccion());
            pst.setString(7, ven.getTelefono());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            mensaje("Error al actualizar");
            return false;
        }
    }
     
     ////////////////////////////////////////////////////
     
    public boolean eliminar(DTO_Vendedor ven) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "DELETE FROM vendedor WHERE cedula=?";
        try {
            pst = con.prepareStatement(stm);
            pst.setString(1, ven.getCedula());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            mensaje("Error al eliminar");
            return false;
        }
    }
}
