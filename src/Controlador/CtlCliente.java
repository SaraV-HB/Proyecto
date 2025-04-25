/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.DAO_Cliente;
import Modelo.DTO_Cliente;
import Vista.VCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class CtlCliente implements ActionListener{
    private final DTO_Cliente mtx;
    private final DAO_Cliente dmtx;
    private final VCliente vtmx;

    public CtlCliente(DTO_Cliente mtx, DAO_Cliente dmtx, VCliente vtmx) {
        this.mtx = mtx;
        this.dmtx = dmtx;
        this.vtmx = vtmx;
        this.vtmx.AgregarCl.addActionListener(this);
        this.vtmx.ConsultarCl.addActionListener(this);
        this.vtmx.ActualizarCl.addActionListener(this);
        this.vtmx.EliminarCl.addActionListener(this);
        this.vtmx.btnRegresar.addActionListener(this);
        this.vtmx.btnRefrescar.addActionListener(this);
        
    }
    public void mensaje(String ms, String ti){
        JOptionPane.showMessageDialog(null, ms, ti, 1);
    }
    
    public void limpiar(){
        vtmx.CedulaCl.setText(null);
        vtmx.NombreCl.setText(null);
        vtmx.ApellidoCl.setText(null);
        vtmx.GeneroCl.setText(null);
        vtmx.TelefonoCl.setText(null);
        vtmx.DireccionCl.setText(null);
        vtmx.FechaCl.setText(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        DecimalFormat df=new DecimalFormat("###,###.##");
        if(evt.getSource().equals(vtmx.AgregarCl)){
            mtx.setCedula(vtmx.CedulaCl.getText());
            mtx.setNombre(vtmx.NombreCl.getText());
            mtx.setApellido(vtmx.ApellidoCl.getText());
            mtx.setGenero(vtmx.GeneroCl.getText());
            mtx.setEdad(Integer.parseInt(vtmx.FechaCl.getText()));
            mtx.setDireccion(vtmx.DireccionCl.getText());
            mtx.setTelefono(vtmx.TelefonoCl.getText());
            if(dmtx.insertar(mtx)){
                mensaje("Operacion exitosa...","Insertar");
            }
        }
        
        if(evt.getSource().equals(vtmx.ConsultarCl)){
            mtx.setCedula(vtmx.CedulaCl.getText());
            if(dmtx.consultar(mtx)){
                vtmx.CedulaCl.setText(mtx.getCedula());
                vtmx.NombreCl.setText(mtx.getNombre());
                vtmx.ApellidoCl.setText(mtx.getApellido());
                vtmx.GeneroCl.setText(mtx.getGenero());
                vtmx.FechaCl.setText(Integer.toString(mtx.getEdad()));
                vtmx.DireccionCl.setText(mtx.getDireccion());
                vtmx.TelefonoCl.setText(mtx.getTelefono());
            }else{
                mensaje("Cedula no encontrada...","Consultar");
            }
        }
        
        if(evt.getSource().equals(vtmx.ActualizarCl)){
            mtx.setCedula(vtmx.CedulaCl.getText());
            mtx.setNombre(vtmx.NombreCl.getText());
            mtx.setApellido(vtmx.ApellidoCl.getText());
            mtx.setGenero(vtmx.GeneroCl.getText());
            mtx.setEdad(Integer.parseInt(vtmx.FechaCl.getText()));
            mtx.setDireccion(vtmx.DireccionCl.getText());
            mtx.setTelefono(vtmx.TelefonoCl.getText());
            if(dmtx.actualizar(mtx)){
                mensaje("Operacion exitosa...","Insertar");
            }
        }
        
        if(evt.getSource().equals(vtmx.EliminarCl)){
            mtx.setCedula(vtmx.CedulaCl.getText());
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
