/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CtlVista implements ActionListener {    
    private final vista vpri;
    private final VMoto vmto;
    private final VCliente vcli;
    private final VPVenta Vpv;
    private final VVendedor Ven;
    private final VRegistrar Vreg;
    private final VAnuales Van;
    private final VDiariosVendedor Vdv;
    private final VDiariosPV Vdpv;

    public CtlVista(vista vpri, VMoto vmto, VCliente vcli, VPVenta Vpv, VVendedor Ven, VRegistrar Vreg, VAnuales Van, VDiariosVendedor Vdv, VDiariosPV Vdpv) {
        this.vpri = vpri;
        this.vmto = vmto;
        this.vcli =vcli;
        this.Ven = Ven;
        this.Vreg = Vreg;
        this.Vpv = Vpv;
        this.Van = Van;
        this.Vdv = Vdv;
        this.Vdpv = Vdpv;
        
        this.vpri.MenuCliente.addActionListener(this);
        this.vpri.MenuPuntoVenta.addActionListener(this);
        this.vpri.MenuMoto.addActionListener(this);
        this.vpri.MenuVendedor.addActionListener(this);
        this.vpri.MenuRegistrar.addActionListener(this);
        this.vpri.MenuAnuales.addActionListener(this);
        this.vpri.MenuPV.addActionListener(this);
        this.vpri.MenuV.addActionListener(this);
        this.vpri.MnuSalir.addActionListener(this);
    }
    
    /**
     *
     * @param evt
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        
        if(evt.getSource().equals(vpri.MenuCliente)){
            vcli.setVisible(true);
        }
        
        if(evt.getSource().equals(vpri.MenuPuntoVenta)){
            Vpv.setVisible(true);
        }
        
        if(evt.getSource().equals(vpri.MenuVendedor)){
            Ven.setVisible(true);
        }
        
        if(evt.getSource().equals(vpri.MenuRegistrar)){
            Vreg.setVisible(true);
        }
        
        if(evt.getSource().equals(vpri.MenuAnuales)){
            Van.setVisible(true);
        }
        
        if(evt.getSource().equals(vpri.MenuPV)){
            Vdpv.setVisible(true);
        }
        
        if(evt.getSource().equals(vpri.MenuV)){
            Vdv.setVisible(true);
        }
        
        if(evt.getSource().equals(vpri.MenuMoto)){
            vmto.setVisible(true);
        }
        
        if(evt.getSource().equals(vpri.MnuSalir)){
            System.exit(0);
        }
    
    }
    
}
