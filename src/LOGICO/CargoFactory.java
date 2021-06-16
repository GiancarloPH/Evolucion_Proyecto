/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICO;

/**
 *
 * @author Crist
 */
public class CargoFactory {
    
    ICargo cargo;

    public CargoFactory (ICargo cargo) {
        this.cargo= cargo;
    }
    
    public void consultarCargoNuevo (){
        cargo.consultarcargo();
    }
    
}
