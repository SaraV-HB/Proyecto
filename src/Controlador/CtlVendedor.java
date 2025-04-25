/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.DAO_Vendedor;
import Modelo.DTO_Vendedor;
import Vista.VVendedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class CtlVendedor implements ActionListener{
    private final DTO_Vendedor mtx;
    private final DAO_Vendedor dmtx;
    private final VVendedor vtmx;

    public CtlVendedor(DTO_Vendedor mtx, DAO_Vendedor dmtx, VVendedor vtmx) {
        this.mtx = mtx;
        this.dmtx = dmtx;
        this.vtmx = vtmx;
        this.vtmx.AgregarVe.addActionListener(this);
        this.vtmx.ConsultarVe.addActionListener(this);
        this.vtmx.ActualizarVe.addActionListener(this);
        this.vtmx.EliminarVe.addActionListener(this);
        this.vtmx.btnRegresar.addActionListener(this);
        this.vtmx.btnRefrescar.addActionListener(this);
        
    }
    public void mensaje(String ms, String ti){
        JOptionPane.showMessageDialog(null, ms, ti, 1);
    }
    
    public void limpiar(){
        vtmx.CedulaVe.setText(null);
        vtmx.NombreVe.setText(null);
        vtmx.ApellidoVe.setText(null);
        vtmx.GeneroVe.setText(null);
        vtmx.FechaVe.setText(null);
        vtmx.DireccionVe.setText(null);
        vtmx.TelefonoVe.setText(null);  
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        DecimalFormat df=new DecimalFormat("###,###.##");
        if(evt.getSource().equals(vtmx.AgregarVe)){
            mtx.setCedula(vtmx.CedulaVe.getText());
            mtx.setNombre(vtmx.NombreVe.getText());
            mtx.setApellido(vtmx.ApellidoVe.getText());
            mtx.setGenero(vtmx.GeneroVe.getText());
            mtx.setEdad(Integer.parseInt(vtmx.FechaVe.getText()));
            mtx.setDireccion(vtmx.DireccionVe.getText());
            mtx.setTelefono(vtmx.TelefonoVe.getText());
            if(dmtx.insertar(mtx)){
                mensaje("Operacion exitosa...","Insertar");
            }
        }
        
        if(evt.getSource().equals(vtmx.ConsultarVe)){
            mtx.setCedula(vtmx.CedulaVe.getText());
            if(dmtx.consultar(mtx)){
                vtmx.CedulaVe.setText(mtx.getCedula());
                vtmx.NombreVe.setText(mtx.getNombre());
                vtmx.ApellidoVe.setText(mtx.getApellido());
                vtmx.GeneroVe.setText(mtx.getGenero());
                vtmx.FechaVe.setText(Integer.toString(mtx.getEdad()));
                vtmx.DireccionVe.setText(mtx.getDireccion());
                vtmx.TelefonoVe.setText(mtx.getTelefono());   
            }else{
                mensaje("Cedula no encontrada...","Consultar");
            }
        }
        
        if(evt.getSource().equals(vtmx.ActualizarVe)){
            mtx.setCedula(vtmx.CedulaVe.getText());
            mtx.setNombre(vtmx.NombreVe.getText());
            mtx.setApellido(vtmx.ApellidoVe.getText());
            mtx.setGenero(vtmx.GeneroVe.getText());
            mtx.setEdad(Integer.parseInt(vtmx.FechaVe.getText()));
            mtx.setDireccion(vtmx.DireccionVe.getText());
            mtx.setTelefono(vtmx.TelefonoVe.getText()); 
            if(dmtx.actualizar(mtx)){
                mensaje("Operacion exitosa...","Insertar");
            }
        }
        
        if(evt.getSource().equals(vtmx.EliminarVe)){
            mtx.setCedula(vtmx.CedulaVe.getText());
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
