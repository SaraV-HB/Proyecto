/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO_Moto;
import Modelo.DTO_Moto;
import Vista.VMoto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class CtlMoto implements ActionListener{
    private DTO_Moto mtx;
    private DAO_Moto dmtx;
    private VMoto vtmx;

    public CtlMoto(DTO_Moto mtx, DAO_Moto dmtx, VMoto vtmx) {
        this.mtx = mtx;
        this.dmtx = dmtx;
        this.vtmx = vtmx;
        this.vtmx.AgregarM.addActionListener(this);
        this.vtmx.ConsultarM.addActionListener(this);
        this.vtmx.ActualizarM.addActionListener(this);
        this.vtmx.EliminarM.addActionListener(this);
        this.vtmx.RegresarM.addActionListener(this);
        this.vtmx.RefrescarM.addActionListener(this);
        
    }
    public void mensaje(String ms, String ti){
        JOptionPane.showMessageDialog(null, ms, ti, 1);
    }
    
    public void limpiar(){
        vtmx.txtSerial.setText(null);
        vtmx.txtModelo.setText(null);
        vtmx.txtCilindrada.setText(null);
        vtmx.txtColor.setText(null);
        vtmx.txtTipo.setText(null);
        vtmx.txtPrecio.setText(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        DecimalFormat df=new DecimalFormat("###,###.##");
        if(evt.getSource().equals(vtmx.AgregarM)){
            mtx.setSerial(vtmx.txtSerial.getText());
            mtx.setModelo(vtmx.txtModelo.getText());
            mtx.setCilindrada(Integer.parseInt(vtmx.txtCilindrada.getText()));
            mtx.setColor(Integer.parseInt(vtmx.txtColor.getText()));
            mtx.setTipo(Integer.parseInt(vtmx.txtTipo.getText()));
            mtx.setValor(Double.parseDouble(vtmx.txtPrecio.getText()));
            if(dmtx.insertar(mtx)){
                mensaje("Operacion exitosa...","Insertar");
            }
        }
        
        if(evt.getSource().equals(vtmx.ConsultarM)){
            mtx.setSerial(vtmx.txtSerial.getText());
            if(dmtx.consultar(mtx)){
                vtmx.txtSerial.setText(mtx.getSerial());
                vtmx.txtModelo.setText(mtx.getModelo());
                vtmx.txtCilindrada.setText(Integer.toString(mtx.getCilindrada()));
                vtmx.txtColor.setText(Integer.toString(mtx.getColor()));
                vtmx.txtTipo.setText(Integer.toString(mtx.getTipo()));
                vtmx.txtPrecio.setText(Double.toString(mtx.getValor()));
            }else{
                mensaje("Serial no encontrado...","Consultar");
            }
        }
        
        if(evt.getSource().equals(vtmx.ActualizarM)){
            mtx.setSerial(vtmx.txtSerial.getText());
            mtx.setModelo(vtmx.txtModelo.getText());
            mtx.setCilindrada(Integer.parseInt(vtmx.txtCilindrada.getText()));
            mtx.setColor(Integer.parseInt(vtmx.txtColor.getText()));
            mtx.setTipo(Integer.parseInt(vtmx.txtTipo.getText()));
            mtx.setValor(Double.parseDouble(vtmx.txtPrecio.getText()));
            if(dmtx.actualizar(mtx)){
                mensaje("Operacion exitosa...","Insertar");
            }
        }
        
        if(evt.getSource().equals(vtmx.EliminarM)){
            mtx.setSerial(vtmx.txtSerial.getText());
            if(dmtx.eliminar(mtx)){
                mensaje("Operacion exitosa...","Eliminar");
            }else{
                mensaje("Cedula no encontrada...","Consultar");
            }
        }
        
        if(evt.getSource().equals(vtmx.RegresarM)){
            vtmx.dispose();
        }
        
        if(evt.getSource().equals(vtmx.RefrescarM)){
            limpiar();
        }
    }
    
}
