/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacobronicecream;

import java.io.File;
import static sistemacobronicecream.SistemaCobroNiceCream.leerArchivo;

/**
 *
 * @author pedrom
 */
public class CaracteristicasHelados {
    String[] Sabores;
    String[] Toppings;
    
    CaracteristicasHelados(){
        //Leemos el archivo SaboresyToppings.ini con la informacion de los helados
        String rutaProyecto = (new File(".")).getAbsolutePath();
        String[] arregloTemporal = leerArchivo(rutaProyecto + "/src/sistemacobronicecream/SaboresyToppings.in").split("@");

        // Recorremos la informacion de los helados 
        // para llenar su informacion
        this.Sabores = arregloTemporal[0].split(",");
        this.Toppings = arregloTemporal[1].split(",");
    }
}
