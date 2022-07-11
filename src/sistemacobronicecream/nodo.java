/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacobronicecream;

/**
 *
 * @author Norelis Carolina
 */
public class nodo {
    
    String SabordeHelado;
    nodo sig;
    
    public nodo (String SabordeHelado, nodo sig){
        this.SabordeHelado = SabordeHelado;
        this.sig = sig;
    }
    
    public nodo (String SabordeHelado) {
        this.SabordeHelado = SabordeHelado;
    }
    
}
