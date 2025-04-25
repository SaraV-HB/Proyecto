/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class DAO_Venta extends Conexion{
    public boolean insertar(DTO_Venta ve) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "INSERT INTO venta(idventa, fecha, serialm, cedulav, cedulac, idpventa) VALUE(?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(stm);
            pst.setInt(1, ve.getIdventa());
            pst.setString(2, ve.getFecha());
            pst.setString(3, ve.getSerialMoto());
            pst.setString(4, ve.getCedulave());
            pst.setString(5, ve.getCedulacl());
            pst.setInt(6, ve.getIdPunVen());
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

    public boolean consultar(DTO_Venta ve) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "SELECT * FROM venta WHERE idventa=?";
        ResultSet rst;
        try {
            pst = con.prepareStatement(stm);
            pst.setInt(1, ve.getIdventa());
            rst = (ResultSet)pst.executeQuery();
            if (rst.next()) {
                ve.setIdventa(rst.getInt("idventa"));
                ve.setFecha(rst.getString("fecha"));
                ve.setSerialMoto(rst.getString("serialm"));
                ve.setCedulave(rst.getString("cedulav"));
                ve.setCedulacl(rst.getString("cedulac"));
                ve.setIdPunVen(rst.getInt("idpventa"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            mensaje("Error al consultar");
            return false;
        }
    }
    
    ////////////////////////////////////////////////////////////////
    
     public boolean actualizar(DTO_Venta ve) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "UPDATE venta SET fecha=?, serialm=?, cedulav=?, cedulac=?, idpventa=? WHERE idventa=?";
        try {
            pst = con.prepareStatement(stm);
            pst.setInt(1, ve.getIdventa());
            pst.setString(2, ve.getFecha());
            pst.setString(3, ve.getSerialMoto());
            pst.setString(4, ve.getCedulave());
            pst.setString(5, ve.getCedulacl());
            pst.setInt(6, ve.getIdPunVen());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            mensaje("Error al actualizar");
            return false;
        }
    }
     
     ////////////////////////////////////////////////////
     
    public boolean eliminar(DTO_Venta ve) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "DELETE FROM venta WHERE idventa=?";
        try {
            pst = con.prepareStatement(stm);
            pst.setInt(1, ve.getIdventa());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            mensaje("Error al eliminar");
            return false;
        }
    }
}