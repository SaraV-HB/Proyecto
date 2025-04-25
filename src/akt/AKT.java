/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package akt;

import Controlador.CtlCliente;
import Controlador.CtlMoto;
import Controlador.CtlPuntoV;
import Controlador.CtlRegistrar;
import Controlador.CtlVendedor;
import Controlador.CtlVista;
import Modelo.DAO_Cliente;
import Modelo.DAO_Moto;
import Modelo.DAO_PuntoVenta;
import Modelo.DAO_Vendedor;
import Modelo.DAO_Venta;
import Modelo.DTO_Cliente;
import Modelo.DTO_Moto;
import Modelo.DTO_PuntoVenta;
import Modelo.DTO_Vendedor;
import Modelo.DTO_Venta;
import Vista.VAnuales;
import Vista.VCliente;
import Vista.VDiariosPV;
import Vista.VDiariosVendedor;
import Vista.VMoto;
import Vista.VPVenta;
import Vista.VRegistrar;
import Vista.VVendedor;
import Vista.vista;

public class AKT {

    public static void main(String[] args) {
        
        DTO_Moto a=new DTO_Moto();
        DAO_Moto b=new DAO_Moto();
        VMoto c=new VMoto();
        CtlMoto d=new CtlMoto(a,b,c);
        DTO_Cliente e=new DTO_Cliente();
        DAO_Cliente f=new DAO_Cliente();
        VCliente g=new VCliente();
        CtlCliente cmtsm = new CtlCliente(e,f,g);
        DTO_PuntoVenta h=new DTO_PuntoVenta();
        DAO_PuntoVenta i=new DAO_PuntoVenta();
        VPVenta j=new VPVenta();
        CtlPuntoV k=new CtlPuntoV(h,i,j);
        DTO_Vendedor ka=new DTO_Vendedor();
        DAO_Vendedor m=new DAO_Vendedor();
        VVendedor n=new VVendedor();
        CtlVendedor o=new CtlVendedor(ka,m,n);
        DTO_Venta sa=new DTO_Venta();
        DAO_Venta ca=new DAO_Venta();
        VRegistrar p=new VRegistrar();
        CtlRegistrar ra = new CtlRegistrar(sa,ca,p);
        VAnuales r=new VAnuales();
        VDiariosVendedor s=new VDiariosVendedor();
        VDiariosPV t=new VDiariosPV();
        vista vpri=new vista();
        CtlVista zy=new CtlVista(vpri, c, g, j, n, p, r, s, t);
        vpri.setVisible(true);
    }   
}
