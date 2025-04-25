/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.DAO_Venta;
import Modelo.DTO_Venta;
import Vista.VRegistrar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class CtlRegistrar implements ActionListener{
    private final DTO_Venta mtx;
    private final DAO_Venta dmtx;
    private final VRegistrar vtmx;

    public CtlRegistrar(DTO_Venta mtx, DAO_Venta dmtx, VRegistrar vtmx) {
        this.mtx = mtx;
        this.dmtx = dmtx;
        this.vtmx = vtmx;
        this.vtmx.btnRegistrar.addActionListener(this);
        this.vtmx.btnConsultar.addActionListener(this);
        this.vtmx.btnActualizar.addActionListener(this);
        this.vtmx.btnEliminar.addActionListener(this);
        this.vtmx.btnRefrescar.addActionListener(this);
        this.vtmx.btnRegresar.addActionListener(this);  
    }
    public void mensaje(String ms, String ti){
        JOptionPane.showMessageDialog(null, ms, ti, 1);
    }
    
    public void limpiar(){
        vtmx.txtCod.setText(null);
        vtmx.txtSer.setText(null);
        vtmx.txtCoPV.setText(null);
        vtmx.txtCeVe.setText(null);
        vtmx.txtFechVen.setText(null);
        vtmx.txtCeVe.setText(null);
        vtmx.txtCeCl.setText(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        
        DecimalFormat df=new DecimalFormat("###,###.##");
        if(evt.getSource().equals(vtmx.btnRegistrar)){
            mtx.setIdventa(Integer.parseInt(vtmx.txtCod.getText()));
            mtx.setFecha(vtmx.txtFechVen.getText());
            mtx.setSerialMoto(vtmx.txtSer.getText());
            mtx.setCedulave(vtmx.txtCeVe.getText());
            mtx.setCedulacl(vtmx.txtCeCl.getText());
            mtx.setIdPunVen(Integer.parseInt(vtmx.txtCoPV.getText()));
            //mtx.setFeNacimie(Date.parse(vtmx.FechaCl.getText()));
            if(dmtx.insertar(mtx)){
                mensaje("Operacion exitosa...","Insertar");
            }else{
                System. out. println("no se envio ome");
            }
        }
        
        if(evt.getSource().equals(vtmx.btnConsultar)){
            mtx.setIdventa(Integer.parseInt(vtmx.txtCod.getText()));
            if(dmtx.consultar(mtx)){
                vtmx.txtCod.setText(Integer.toString(mtx.getIdventa()));
                vtmx.txtFechVen.setText(mtx.getFecha());
                vtmx.txtSer.setText(mtx.getSerialMoto());
                vtmx.txtSer.setText(mtx.getSerialMoto());
                vtmx.txtCeVe.setText(mtx.getCedulave());
                vtmx.txtCeCl.setText(mtx.getCedulacl());
                vtmx.txtCoPV.setText(Integer.toString(mtx.getIdPunVen()));
            }else{
                mensaje("Cedula no encontrada...","Consultar");
            }
        }
        
        if(evt.getSource().equals(vtmx.btnActualizar)){
            mtx.setIdventa(Integer.parseInt(vtmx.txtCod.getText()));
            mtx.setFecha(vtmx.txtFechVen.getText());
            mtx.setSerialMoto(vtmx.txtSer.getText());
            mtx.setCedulave(vtmx.txtCeVe.getText());
            mtx.setCedulacl(vtmx.txtCeCl.getText());
            mtx.setIdPunVen(Integer.parseInt(vtmx.txtCoPV.getText()));
            if(dmtx.actualizar(mtx)){
                mensaje("Operacion exitosa...","Insertar");
            }
        }
        
        if(evt.getSource().equals(vtmx.btnEliminar)){
            mtx.setIdventa(Integer.parseInt(vtmx.txtCod.getText()));
            if(dmtx.eliminar(mtx)){
                mensaje("Operacion exitosa...","Eliminar");
            }else{
                mensaje("Cedula no encontrada...","Consultar");
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
