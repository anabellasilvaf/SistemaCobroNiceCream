/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacobronicecream;

/**
 *
 * @author 58414
 */
public class Clientes {
    ColaClientes Clientes = new ColaClientes();
    
    public void aggCliente(String nombre, String apellido, String cedula, String direccion, String telefono,double saldo){
        Cliente NuevoCliente = new Cliente(nombre, apellido, cedula, direccion, telefono, saldo);
        Clientes.agregar(NuevoCliente);
    }
    
    
    public class Cliente {
        String nombre;
        String apellido;
        String cedula;
        String direccion;
        String telefono;
        double saldo;
        
        Cliente(String nombre, String apellido, String cedula, String direccion, String telefono,double saldo){
            
            this.nombre=nombre;
            this.apellido=apellido;
            this.cedula=cedula;
            this.direccion=direccion;
            this.telefono=telefono;
            this.saldo=saldo;
        }
        
        public void restarSaldo(double monto){
            this.saldo=this.saldo-monto; 
        }
        
        public void imprimirDatos(){
            System.out.println("Esto son los datos"+this.nombre+" "+this.apellido+" "+this.cedula+" "+this.direccion+" "+this.telefono);
        }
    }
}
