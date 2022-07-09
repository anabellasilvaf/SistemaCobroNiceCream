/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemacobronicecream;

import sistemacobronicecream.ColaClientes.NodoCola;

/**
 *
 * @author 58414
 */
public class SistemaCobroNiceCream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Clientes ColaClientes = new Clientes();
        
        ColaClientes.aggCliente("Ana", "Silva", "22098123", "La asuncion", "04141237890", 0);
        
        for (int i = 0; i < ColaClientes.Clientes.getTotalCola(); i++) {
            NodoCola ClienteAux = ColaClientes.Clientes.getNodeColaAt(i);
            System.out.println("Datos del cliente en la pos: "+(i+1)+" "+ClienteAux.dato.nombre+" "+ClienteAux.dato.cedula);
        }
        
    }
    
}
