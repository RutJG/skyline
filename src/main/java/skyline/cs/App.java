package skyline.cs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
        public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        ArrayList <Rectangulo> ciudad = new ArrayList ();
        ArrayList <Contorno> skyline = new ArrayList ();
        
       //introduce por teclado el numero de edificios de la ciudad
        // variable intro me da la posibiblidad de introducir por tecldo
        
        Scanner intro = new Scanner (System.in);
        
        System.out.println("Dame numero de rectangulos que forma la ciudad");
        //la variable cadena recoge lo introducido por teclado hasta pulsar intro
        String cadena = intro.nextLine();
        
        //pasa a int la cademna de caracteres recogida en variable cadena
        int numRectangulos = Integer.parseInt(cadena);
        
        System.out.println("contruimos los edificion");
        
        for (int i=0; i<numRectangulos;i++){
            System.out.println("Edificio "+ i +" : ");
            cadena = intro.nextLine();
            String [] varRectangulo  = cadena.split (" ");
            Rectangulo r = new Rectangulo (Integer.parseInt(varRectangulo[0]),
                                            Integer.parseInt(varRectangulo[1]),
                                            Integer.parseInt(varRectangulo[2]));
            ciudad.add(r);
        }
        System.out.println("fin contruccion edificion");
        
        DivideVenceras dv = new DivideVenceras();
        dv.Calcular (ciudad,skyline);  
        
        for (int i=0; i<skyline.size();i++){
        
            Contorno c = skyline.get(i);
            System.out.println(c.getCoordenada()+" "+c.getAltura());
        }
    
        int opcion=1;
        switch(opcion)

        {

           
           case 9:Rectangulo.copypaste5();break;
            case 10:Rectangulo.saltos();break;
            case 11:Contorno.saltos();break;
            default:Rectangulo.saltos();


        }; 
}

}
