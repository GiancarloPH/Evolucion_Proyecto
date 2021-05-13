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
public class LoginFactory {
    
    ILogin login;

    public LoginFactory(ILogin login) {
        this.login = login;
    }
    
    public void loginNuevo(String usu,String contra){
        login.login(usu, contra);
    }
    
}
