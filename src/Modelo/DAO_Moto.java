/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class DAO_Moto extends Conexion{
    public boolean insertar(DTO_Moto mtx) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "INSERT INTO moto(serial,modelo,cilindrada,idcolor,idtipo,valor) VALUE(?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(stm);
            pst.setString(1, mtx.getSerial());
            pst.setString(2, mtx.getModelo());
            pst.setInt(3, mtx.getCilindrada());
            pst.setInt(4, mtx.getColor());
            pst.setInt(5, mtx.getTipo());
            pst.setDouble(6, mtx.getValor());
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
    //serial,modelo,cilindrada,color,tipo,valor
    public boolean consultar(DTO_Moto mtx) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "SELECT * FROM moto WHERE serial=?";
        ResultSet rst;
        try {
            pst = con.prepareStatement(stm);
            pst.setString(1, mtx.getSerial());
            rst = (ResultSet)pst.executeQuery();
            if (rst.next()) {
                mtx.setSerial(rst.getString("serial"));
                mtx.setModelo(rst.getString("modelo"));
                mtx.setCilindrada(rst.getInt("cilindrada"));
                mtx.setColor(rst.getInt("idcolor"));
                mtx.setTipo(rst.getInt("idtipo"));
                mtx.setValor(rst.getDouble("valor"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            mensaje("Error al consultar");
            return false;
        }
    }
    
    ////////////////////////////////////////////////////////////////
    
    public boolean actualizar(DTO_Moto mtx) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "UPDATE moto SET modelo=?,cilindrada=?,idcolor=?,idtipo=?,valor=? WHERE serial=?";
        try {
            pst = con.prepareStatement(stm);
            pst.setString(1, mtx.getSerial());
            pst.setString(2, mtx.getModelo());
            pst.setInt(3, mtx.getCilindrada());
            pst.setInt(4, mtx.getColor());
            pst.setInt(5, mtx.getTipo());
            pst.setDouble(6, mtx.getValor());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            mensaje("Error al actualizar");
            return false;
        }
    }
     
     ////////////////////////////////////////////////////
     
    public boolean eliminar(DTO_Moto mtx) {
        Connection con = getConnection();
        PreparedStatement pst;
        String stm = "DELETE FROM moto WHERE serial=?";
        try {
            pst = con.prepareStatement(stm);
            pst.setString(1, mtx.getSerial());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            mensaje("Error al eliminar");
            return false;
        }
    }
}
