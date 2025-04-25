/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class DAO_PuntoVenta extends Conexion{
    public boolean insertar(DTO_PuntoVenta pv) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "INSERT INTO puntoventa(idPuntoVenta,direccion,telefono) VALUE(?,?,?)";
        try {
            pst = con.prepareStatement(stm);
            pst.setInt(1, pv.getIdpuntoventa());
            pst.setString(2, pv.getDireccion());
            pst.setString(3, pv.getTelefono());
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
    //idpuntoventa,direccion,telefono
    public boolean consultar(DTO_PuntoVenta pv) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "SELECT * FROM puntoventa WHERE idPuntoVenta=?";
        ResultSet rst;
        try {
            pst = con.prepareStatement(stm);
            pst.setInt(1, pv.getIdpuntoventa());
            rst = (ResultSet)pst.executeQuery();
            if (rst.next()) {
                pv.setIdpuntoventa(rst.getInt("idPuntoVenta"));
                pv.setDireccion(rst.getString("direccion"));
                pv.setTelefono(rst.getString("telefono"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            mensaje("Error al consultar");
            return false;
        }
    }
    
    ////////////////////////////////////////////////////////////////
    
     public boolean actualizar(DTO_PuntoVenta pv) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "UPDATE puntoventa SET direccion=?,telefono=? WHERE idPuntoVenta=?";
        try {
            pst = con.prepareStatement(stm);
            pst.setInt(1, pv.getIdpuntoventa());
            pst.setString(2, pv.getDireccion());
            pst.setString(3, pv.getTelefono());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            mensaje("Error al actualizar");
            return false;
        }
    }
     
     ////////////////////////////////////////////////////
     
    public boolean eliminar(DTO_PuntoVenta pv) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "DELETE FROM puntoventa WHERE idPuntoVenta=?";
        try {
            pst = con.prepareStatement(stm);
            pst.setInt(1, pv.getIdpuntoventa());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            mensaje("Error al eliminar");
            return false;
        }
    }

}
