/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacobronicecream;
/**
 *
 * @author 58414
 */
public class ColaClientes {
    
    NodoCola inicio;
    NodoCola fin;
    int total;
    
    public ColaClientes(){
        this.inicio=null;
        this.fin=null;
        this.total=0;
    }
    
    public boolean esVacio(){
        return inicio == null;
    }
    
    public void agregar(Clientes.Cliente element){
        NodoCola aux = new NodoCola(element);
        if(this.esVacio()){
            this.inicio = aux;
        }else{ 
            this.fin.siguiente = aux;
        }
        
        this.fin = aux;
        total++;
    }
    
    public Clientes.Cliente extraerPrimerEnCola(){
        Clientes.Cliente aux = this.inicio.dato;
        this.inicio=inicio.siguiente;
        this.total--;
        return aux;
    }
    
    public Clientes.Cliente getPrimeroEnCola(){
        return this.inicio.dato;
    }
    
    public int getTotalCola(){
        return this.total;
    }
    
    public NodoCola getNodeColaAt(int pos){
        
        NodoCola nodeAux =this.inicio;
        if(this.esVacio() == false){
            for (int i = 0; i < this.total; i++) {
                if(i==pos){
                    return nodeAux;
                }else{
                    nodeAux = nodeAux.siguiente;
                }
            }
        }
        return null;
    }
    
    public class NodoCola {
        Clientes.Cliente dato;
        NodoCola siguiente;

        public NodoCola(Clientes.Cliente dato){
            this.dato=dato;
            this.siguiente=null;
        }
    }
    
}
