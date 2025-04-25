/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO_PuntoVenta;
import Modelo.DTO_PuntoVenta;
import Vista.VPVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */

public class CtlPuntoV implements ActionListener{
    private final DTO_PuntoVenta mtx;
    private final DAO_PuntoVenta dmtx;
    private final VPVenta vtmx;

    public CtlPuntoV(DTO_PuntoVenta mtx, DAO_PuntoVenta dmtx, VPVenta vtmx) {
        this.mtx = mtx;
        this.dmtx = dmtx;
        this.vtmx = vtmx;
        this.vtmx.AgregarPV.addActionListener(this);
        this.vtmx.ConsultarPV.addActionListener(this);
        this.vtmx.ActualizarPV.addActionListener(this);
        this.vtmx.EliminarPV.addActionListener(this);
        this.vtmx.btnRegresar.addActionListener(this);
        this.vtmx.btnRefrescar.addActionListener(this);
        
    }
    public void mensaje(String ms, String ti){
        JOptionPane.showMessageDialog(null, ms, ti, 1);
    }
    
    public void limpiar(){
        vtmx.txtCodigo.setText(null);
        vtmx.txtDireccionPV.setText(null);
        vtmx.txtTelefonoPV.setText(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        DecimalFormat df=new DecimalFormat("###,###.##");
        if(evt.getSource().equals(vtmx.AgregarPV)){
            mtx.setIdpuntoventa(Integer.parseInt(vtmx.txtCodigo.getText()));
            mtx.setDireccion(vtmx.txtDireccionPV.getText());
            mtx.setTelefono(vtmx.txtTelefonoPV.getText());
            if(dmtx.insertar(mtx)){
                mensaje("Operacion exitosa...","Insertar");
            }
        }
        
        if(evt.getSource().equals(vtmx.ConsultarPV)){
            mtx.setIdpuntoventa(Integer.parseInt(vtmx.txtCodigo.getText()));
            if(dmtx.consultar(mtx)){
                vtmx.txtCodigo.setText(Integer.toString(mtx.getIdpuntoventa()));
                vtmx.txtDireccionPV.setText(mtx.getDireccion());
                vtmx.txtTelefonoPV.setText(mtx.getTelefono());
            }else{
                mensaje("Codigo no encontrado...","Consultar");
            }
        }
        
        if(evt.getSource().equals(vtmx.ActualizarPV)){
            mtx.setIdpuntoventa(Integer.parseInt(vtmx.txtCodigo.getText()));
            mtx.setDireccion(vtmx.txtDireccionPV.getText());
            mtx.setTelefono(vtmx.txtTelefonoPV.getText());
            if(dmtx.actualizar(mtx)){
                mensaje("Operacion exitosa...","Insertar");
            }
        }
        
        if(evt.getSource().equals(vtmx.EliminarPV)){
            mtx.setIdpuntoventa(Integer.parseInt(vtmx.txtCodigo.getText()));
            if(dmtx.eliminar(mtx)){
                mensaje("Operacion exitosa...","Eliminar");
            }else{
                mensaje("Codigo no encontrado...","Consultar");
            }
        }
        
        if(evt.getSource().equals(vtmx.btnRegresar)){
            vtmx.dispose();
        }
        
        if(evt.getSource().equals(vtmx.btnRefrescar)){
            limpiar();
        }
    }
    
}