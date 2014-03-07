/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skyline.cs;

import java.util.ArrayList;

/**
 *
 * @author RutJG
 */
public class DivideVenceras {
    
     public void Calcular (ArrayList <Rectangulo> ciudad, ArrayList <Contorno> skyline){
    
        //caso base el if
        if (ciudad.size()==1){
        
            Rectangulo r =ciudad.get(0);
            Contorno c1 = new Contorno (r.getCoordenada1(),r.getAlturaRec()); 
            Contorno c2 = new Contorno (r.getCoordenada2(),0);
            
            skyline.add(c1);
            skyline.add(c2);
        }
        //caso recursivo el else
        else{
        
            int mitad = ciudad.size()/2;
            ArrayList <Rectangulo> mitad1 = new ArrayList ();
            ArrayList <Rectangulo> mitad2 = new ArrayList ();
            for (int i=0; i<mitad; i++){
            
                mitad1.add(ciudad.get(i));
            }
            
            for (int i=mitad; i<ciudad.size(); i++){
            
                mitad2.add(ciudad.get(i));
            }
            ArrayList <Contorno> horizonte1 = new ArrayList ();
            ArrayList <Contorno> horizonte2 = new ArrayList ();
            
            Calcular (mitad1, horizonte1);
            Calcular (mitad2, horizonte2);
            
            UnionHorizontes (horizonte1, horizonte2, skyline);
        }    
    }
    
    
    public void UnionHorizontes (ArrayList <Contorno> horizonte1, ArrayList<Contorno> horizonte2, ArrayList<Contorno> skyline){
    
        int aux1 = -1;//guardara la altura del contorno 1 antes de pasar a la siguiente iteración
        int aux2 = -1;//guardara la altura del contorno 2 antes de pasar a la siguiente iteracion
        int aux3 = -1;//guardara la altura que va marcando el skyline
        Contorno contornoAux;//este será la que va añadiendo al ArrayList<Contorno> skyline 
        Contorno contorno1 = new Contorno();//va sacando los contornos de horizonte 1
        Contorno contorno2 = new Contorno ();//va sacando los contornos de horizonte 2
        
        while ((!horizonte1.isEmpty())&&(!horizonte2.isEmpty())){
        
            contornoAux = new Contorno ();
            contorno1 = horizonte1.get(0);
            contorno2 = horizonte2.get(0);
            
            if (contorno1.getCoordenada()<contorno2.getCoordenada()){
            
                contornoAux.setCoordenada(contorno1.getCoordenada());
                contornoAux.setAltura(Math.max(contorno1.getAltura(), aux2));
                
                if (contornoAux.getAltura()!=aux3){
                
                    skyline.add(contornoAux);
                    aux3 = contornoAux.getAltura();
                }
                
                aux1 = contorno1.getAltura();
                horizonte1.remove(0);
            }else if (contorno1.getCoordenada()>contorno2.getCoordenada()){
            
                contornoAux.setCoordenada(contorno2.getCoordenada());
                contornoAux.setAltura(Math.max(contorno2.getAltura(), aux1));
                
                if (contornoAux.getAltura()!=aux3){
                
                    skyline.add(contornoAux);
                    aux3 = contornoAux.getAltura();
                }
                
                aux2 = contorno2.getAltura();
                horizonte2.remove(0);
            }else{
            
                if((contorno1.getAltura()>contorno2.getAltura())&&(contorno1.getAltura()!=aux3)){
                
                    skyline.add(contorno1);
                    aux3 = contorno1.getAltura();
                }
                
                if((contorno1.getAltura()<= contorno2.getAltura())&&(contorno2.getAltura()!=aux3)){
                
                    skyline.add(contorno2);
                    aux3 = contorno2.getAltura();
                }
                
                aux1 = contorno1.getAltura();
                aux2 = contorno2.getAltura();
                
                horizonte1.remove(0);
                horizonte2.remove(0);  
            } 
        }
        while((!horizonte1.isEmpty())){
        
            contornoAux = horizonte1.get(0);
            
            if(contornoAux.getAltura()!= aux3){
            
                skyline.add(contornoAux);
                aux3 = contornoAux.getAltura();
            }
            
            horizonte1.remove(0);
        }
        while((!horizonte2.isEmpty())){
        
            contornoAux = horizonte2.get(0);
            
            if(contornoAux.getAltura()!= aux3){
            
                skyline.add(contornoAux);
                aux3 = contornoAux.getAltura();
            }
            
            horizonte2.remove(0);
        }
        
    }
}
