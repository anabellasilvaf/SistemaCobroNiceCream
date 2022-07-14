/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemacobronicecream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
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
        int opcion = 99;
        System.out.println("Sistema de cobro heladeria Nice Cream\n");
        System.out.println("Los clientes seran cargados\n");
        
        Clientes ColaClientes = new Clientes();
        
        //Leemos el archivo Clientes.ini con la informacion de los clientes
        String rutaProyecto = (new File(".")).getAbsolutePath();
        String[] arregloTemporal = leerArchivo(rutaProyecto + "/src/sistemacobronicecream/Clientes.in").split("@");

        // Recorremos la informacion de los clientes 
        // para llenar la cola con su informacion
        for (String string : arregloTemporal) {
            String[] datosClientes = string.split(",");
            ColaClientes.aggCliente(
                datosClientes[0], datosClientes[1], 
                datosClientes[2], datosClientes[3],
                datosClientes[4], Integer.valueOf(datosClientes[5])
            );
            ColaClientes.total++;
        }
        
        for (int i = 0; i < ColaClientes.Clientes.getTotalCola(); i++) {
            NodoCola ClienteAux = ColaClientes.Clientes.getNodeColaAt(i);
            ClienteAux.dato.imprimirDatos();
        }
        
        do{
            menu();
            Scanner data = new Scanner(System.in);
            opcion = Integer.valueOf(data.nextLine());
            try {
                
                if(opcion == 4){
                    System.out.println("Saliendo del sistema");
                    break;
                }
                
                switch (opcion) {
                    case 1:
                        ColaClientes.atenderCliente();
                    break;
                    case 2:
                        
                    break;
                    case 3:
                        
                    break;
                    default:
                            System.out.println("Opcion ingresada es invalida");;
                    break;
                }
                
            } catch (Exception e){
                System.out.println("Ingreso un dato invalido");
                e.printStackTrace();
            }
            
        } while (opcion != 4);
        

        
        
    }
    
    public static void escribirArchivo(String[] lineas, String ruta) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(ruta);
            pw = new PrintWriter(fichero);

            for (String string : lineas) {
                pw.println(string);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
        
    public static String leerArchivo(String ruta) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        String data = "";

        try {
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null)
                data = data + linea + "@";
        } catch (IOException e) {
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
            }
        }

        return data;
    }
    
    public static void menu(){
        System.out.println(
                "Las opciones del sistema son las siguientes\n");
        System.out.println(
                "(1) Atender clientes\n");
        System.out.println(
                "(2) Reporte de ventas\n");
        System.out.println(
                "(3) Ranking de ventas\n");
        System.out.println(
                "(4) Salir\n");
    }
    
}
