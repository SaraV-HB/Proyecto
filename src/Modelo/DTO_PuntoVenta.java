/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class DTO_PuntoVenta {
    private String Telefono, direccion;
    private int idpuntoventa;

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdpuntoventa() {
        return idpuntoventa;
    }

    public void setIdpuntoventa(int idPuntoventa) {
        this.idpuntoventa = idPuntoventa;
    }
 
}
