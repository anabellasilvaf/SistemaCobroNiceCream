/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacobronicecream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author pedrom
 */
public class PilaHelados {
    private NodoPila cima;
    private int total;
    
    public PilaHelados(){
        this.cima = null;
    }
    
    public void agregar(Helados dato){
        NodoPila nuevo = new NodoPila(dato);
        nuevo.setSgte(cima);
        cima = nuevo;
        this.total++;    
    }
    
    public void quitar() {
        if(esVacio())
            System.out.println("Pila vacia, no se puede extraer."); 
        else{
            this.cima = cima.getSgte();
            this.total--;
        }
    }
    
    public Helados cimaPila() {
        if(esVacio())
            System.out.println("Pila vacia, no se puede mostrar.");
        else
            return this.cima.getDato();
        return null;
    }
    
    public int limpiarPila(){
        if(esVacio()){
            System.out.println("La pila ya esta vacia...");
            return -1;
        }
        else{
            System.out.println("Limpiando pila...");
            while(!esVacio()){
                this.cima = this.cima.getSgte();
                this.total--;
            }
        }
        return 0;    
    }
    
    public void mostrarPila(){
        if(esVacio()){
            System.out.println("Pila vacia, no se puede mostrar.");
        }
        else{
            NodoPila tmp = this.cima;
            while(tmp!=null){
                System.out.println(tmp.getDato());
                tmp = tmp.getSgte();
            }
        }
    }
    
    public void mostrarVentas(){
        if(esVacio()){
            System.out.println("No se registro ninguna venta.");
        }
        else{
            NodoPila tmp = this.cima;
            while(tmp!=null){
                System.out.println("Producto vendido: "+tmp.getDato().dato+" por un monot de $"+tmp.getDato().montoVenta+" al cliente "+tmp.getDato().cliente);
                tmp = tmp.getSgte();
            }
        }
    }
    
    public void generarArchivoDeVentas(){
        if(esVacio()){
            System.out.println("No se registro ninguna venta por lo tanto el archivo 'ventas.txt' no fue actualizado.");
        }
        else{
            NodoPila tmp = this.cima;
            while(tmp!=null){
                
                
                String rutaProyecto = (new File(".")).getAbsolutePath();
                String line = "Producto vendido: "+tmp.getDato().dato
                        +" por un monto de $"+tmp.getDato().montoVenta
                        +" al cliente "+tmp.getDato().cliente 
                        + ", " + DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
                try {
                    FileWriter fw = new FileWriter(rutaProyecto + "/src/sistemacobronicecream/ventas.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw);
                    out.println(line);
                    out.close();
                } catch (IOException e) {
                    // TODO: handle exception
                }
                tmp = tmp.getSgte();
            }
        }
    }

    public int getTotalPila() {
        return total;
    }
    
    public boolean esVacio(){
        return cima == null;
    }
    
    public class NodoPila {

        private Helados dato;
        private NodoPila siguiente;

        public NodoPila(Helados dato) {       
            this.dato = dato;
            this.siguiente = null;
        }

        public Helados getDato() {
            return this.dato;
        }

        public NodoPila getSgte() {
            return this.siguiente;
        }

        public void setDato(Helados dato) {
            this.dato = dato;
        }

        public void setSgte(NodoPila siguiente) {
            this.siguiente = siguiente;
        }   
    }
}
