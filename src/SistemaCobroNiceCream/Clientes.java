/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacobronicecream;

import java.util.Scanner;

/**
 *
 * @author 58414
 */
public class Clientes {
    ColaClientes Clientes = new ColaClientes();
    Scanner data = new Scanner(System.in);
    int total = 0;
    
    public void aggCliente(String nombre, String apellido, String cedula, String direccion, String telefono,double saldo){
        Cliente NuevoCliente = new Cliente(nombre, apellido, cedula, direccion, telefono, saldo);
        Clientes.agregar(NuevoCliente);
    }
    
    public void atenderCliente(){
        System.out.println("Los clientes seran atendidos \n");
        PilaHelados infoHelados = new PilaHelados();
        for (int i = 0; i < this.Clientes.getTotalCola(); i++) {
            ColaClientes.NodoCola ClienteAux = this.Clientes.getNodeColaAt(i);
            System.out.println("Buen dia Sr(a): "+ClienteAux.dato.nombre+" "+ClienteAux.dato.apellido+"\n");
            System.out.println("Su saldo es de: $"+ClienteAux.dato.saldo+"\n");
            System.out.println("Por favor chequee nuestros precios: \n");
            
            System.out.println("Barquilla (c/u) 1 porcion de helado y 1 topping por tan solo $2 \n");
            System.out.println("Helado adicional (hasta 2 sabores adicionales) por tan solo $1 \n");
            System.out.println("Topping adicional (hasta 2 topping adicionales) por tan solo $1 \n");
            
            CaracteristicasHelados Heladeria = new CaracteristicasHelados();
           
            String opcion = "h";
            do {
                int n = 0;
                boolean validaTopping = false;
                for (int j = 0; j < 3; j++) {
                    System.out.println("Desea pedir un helado ? (s/n): \n");
                
                    opcion = this.data.nextLine();
                    if("s".equals(opcion)){
                        System.out.println("Paso por aqui \n");
                        if(ClienteAux.dato.saldo < 1){
                            System.out.println("Estimado cliente su saldo es insuficiente para realizar un pedido \n");
                            break;
                        }
                        
                        int opcion2=Heladeria.Sabores.length+2;
                        do {
                            System.out.println("Estas son nuestras opciones de sabores: \n");
                            System.out.println("Sabor de helado que desea pedir ?\n");

                            for (int k = 0; k < Heladeria.Sabores.length; k++) {
                                System.out.println("(" + (k+1) + ") " + Heladeria.Sabores[k]);
                            }

                            opcion2 = Integer.valueOf(this.data.nextLine());
                            if (n==0) {
                                Helados infoHeladoTemp = new Helados(Heladeria.Sabores[(opcion2-1)],ClienteAux.dato.cedula,2);
                                infoHelados.agregar(infoHeladoTemp);
                                ClienteAux.dato.saldo-=2;
                            }else{
                                Helados infoHeladoTemp = new Helados(Heladeria.Sabores[(opcion2-1)],ClienteAux.dato.cedula,1);
                                infoHelados.agregar(infoHeladoTemp);
                                ClienteAux.dato.saldo-=1;
                            }
                            
                        } while (opcion2>(Heladeria.Sabores.length+2));
                        
                        
                        String opcion3 = "s";
                        if(j > 0){
                            System.out.println("Desea añadirle algun topping adicional ? (s/n): \n");
                            opcion3 = this.data.nextLine();
                        }
                        
                        if("s".equals(opcion3)){
                            if(ClienteAux.dato.saldo < 1 && n == 0){
                                System.out.println("Estimado cliente su saldo es insuficiente para realizar un pedido \n");
                                break;
                            }
                            int opcion4=Heladeria.Toppings.length+2;
                            
                            do {
                                System.out.println("Estas son nuestras opciones de topping: \n");
                                for (int l = 0; l < Heladeria.Toppings.length; l++) {
                                    System.out.println("(" + (l+1) + ") " + Heladeria.Toppings[l]);
                                }

                                System.out.println("Sabor de topping que desea elegir ?\n");

                                opcion4 = Integer.valueOf(this.data.nextLine());
                                
                                if (j > 0) {
                                    Helados infoHeladoTemp = new Helados(Heladeria.Toppings[(opcion4-1)],ClienteAux.dato.cedula,1);
                                    infoHelados.agregar(infoHeladoTemp);
                                    ClienteAux.dato.saldo-=1;
                                }else{
                                    Helados infoHeladoTemp = new Helados(Heladeria.Toppings[(opcion4-1)],ClienteAux.dato.cedula,0);
                                    infoHelados.agregar(infoHeladoTemp);
                                }
                            } while (opcion4>(Heladeria.Toppings.length+2));
                            
                        }
                        
                        n++;
                    }else{
                        break;
                    }
                }
                
            } while (!"n".equals(opcion));
            
            this.Clientes.extraerPrimerEnCola();
        }
        
        System.out.println("Las ventas fueron las siguientes ?\n");
        infoHelados.mostrarVentas();
        infoHelados.generarArchivoDeVentas();
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
            System.out.println("Esto son los datos: "+this.nombre+" "+this.apellido+" "+this.cedula+" "+this.direccion+" "+this.telefono);
        }
    }
}
