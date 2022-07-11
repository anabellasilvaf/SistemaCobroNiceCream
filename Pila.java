/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacobronicecream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Norelis Carolina
 */
public class Pila {
    nodo ColaClientes; 
    PrintWriter pf;
    FileReader fr;
    int guardarPrecio;
    
    boolean pilaVacia(){
        return ColaClientes == null;
        
    }
    
    void agregarSabor (String sabor){
        ColaClientes = new nodo (sabor, ColaClientes);
        
    }
    
    void MostrarHelado() throws IOException {
        ColaClientes cola = new ColaClientes();
        SistemaCobroNiceCream c = new SistemaCobroNiceCream();
        if (!pilaVacia()) {
            System.err.println("No se encontraron helados registrados");
        
        } else if ("Cono".equals(ColaClientes.SabordeHelado)){
             System.out.println("No se ha ingresado ningun sabor");
             System.err.println("La compra no ha sido realizada");
         
        } else{ 
            pf = new PrintWriter (new FileWriter("Ventas.txt", true));
            nodo L = null;
            nodo aux = L; 
            pf.append("/nPedido de ");
            while (aux != null) {
                System.out.println(aux.SabordeHelado);
                pf.append("/n" + aux.SabordeHelado);
                aux = aux.sig;
            }
        pf.append("/nY su precio fue de: " + guardarPrecio + "$.");
        pf.append("/n");  
        pf.close();
        System.out.println("La compra fue realizada con exito.");
        guardarPrecio = 0;
        }
    }
    nodo quitarBola() {
       if (!pilaVacia()){
           nodo aux = new nodo (ColaClientes.SabordeHelado);
           if (ColaClientes == null){
               ColaClientes = null;
        } else {
               ColaClientes = ColaClientes.sig;
        }
        return aux;
       } else {
           System.out.println("La pila esta vacia");
           return null;
       } 
    }       
    void vaciarPila(){
        while (!pilaVacia()){
            quitarBola();
        }
    }
    
}
