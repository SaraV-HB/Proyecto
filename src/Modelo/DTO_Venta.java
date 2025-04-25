/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

public class DTO_Venta {
    private int idventa, idPunVen;
    private String serialMoto, cedulave, cedulacl, fecha;

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public String getSerialMoto() {
        return serialMoto;
    }

    public void setSerialMoto(String serialMoto) {
        this.serialMoto = serialMoto;
    }

    public String getCedulave() {
        return cedulave;
    }

    public void setCedulave(String cedulave) {
        this.cedulave = cedulave;
    }

    public String getCedulacl() {
        return cedulacl;
    }

    public void setCedulacl(String cedulacl) {
        this.cedulacl = cedulacl;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdPunVen() {
        return idPunVen;
    }

    public void setIdPunVen(int idPunVen) {
        this.idPunVen = idPunVen;
    }
       
}
