/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skyline.cs;

/**
 *
 * @author RutJG
 */
public class Rectangulo {
    
    private int coordenada1;
    private int coordenada2;
    private int alturaRec;
    
    public Rectangulo (){
    
        this.coordenada1 = 0;
        this.coordenada2 = 0;
        this.alturaRec = 0;
    }
    
    public Rectangulo(int c1, int c2, int h){
    
        this.alturaRec = h;
        this.coordenada1 = c1;
        this.coordenada2 = c2;
    } 

    public int getCoordenada1() {
        return coordenada1;
    }

    public void setCoordenada1(int coordenada1) {
        this.coordenada1 = coordenada1;
    }

    public int getCoordenada2() {
        return coordenada2;
    }

    public void setCoordenada2(int coordenada2) {
        this.coordenada2 = coordenada2;
    }

    public int getAlturaRec() {
        return alturaRec;
    }

    public void setAlturaRec(int alturaRec) {
        this.alturaRec = alturaRec;
    }
    
     public int getAlturaRec2() {
        return alturaRec;
    }

    public void setAlturaRec2(int alturaRec) {
        this.alturaRec = alturaRec;
    }
    
     public int getAlturaRec3() {
        return alturaRec;
    }

    public void setAlturaRec3(int alturaRec) {
        this.alturaRec = alturaRec;
    }
    
   
    
}
